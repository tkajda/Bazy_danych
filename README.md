# System biletowy dla kolei


### Projekt w ramach przedmiotu Bazy danych
#### Akademia Górniczo-Hutnicza im. Stanisława Staszica w Krakowie 
#### Wydział Informatyki, Elektroniki i Telekomunikacji
---
### `Autorzy:`
- Przymslaw Kociuba
- Tomasz Kajda
---
### `Funkcjonalność: `
- Możliwość wyszukania zaplanowanych połączeń pomiędzy wybranymi miastami
- Możliwość zakupu biletu przy uwzględnieniu rodzaju wagonu (przedziałowy/bez przedziałów)
- Możliwość rejestracji użytkownika, jak i zakupu bez rejestracji
- W przypadku rejestracji, możliwość wglądu w historię swoich biletów

---
### `Technologie:`
- Java Hibernate
- Spring Boot
- MongoDB
- PostgreSQL
- React

---
### `Architektura:`
- Relacyjna baza danych przechowująca dane o użytkownikach
- Dokumentowa baza danych przechowująca dane o trasach pociągów, miejscach i zakupionych biletach
- Zamodelowany obiektowo backend aplikacji, pośredniczący pomiędzy frontendem i obiema bazami
- Zamodelowany obiektowo frontend aplikacji

### `Typowe wykorzystanie`
Najczęściej użytkownicy będą wyszukiwać interesujące ich połączenia. Z tego powodu ta operacja musi być odpowiednio zoptymalizowana. Na drugim miejscu jest kupno biletów.

---
### `Struktura baz danych:`
### MongoDB:
   -   Kolekcja Routes:
         - `_id` - numer identyikacyjny
         - `trainStops` - tablica przechowująca obiekty, definiujące przystanki na trasie; każdy obiekt posiada następujące pola: 
            - `stationName` - nazwa Miasta
            - `arrivalTime` - czas przyjazdu na stację
            - `departureTime` - czas wyjazdu ze stacji
            - `compartmentSeats` - tablica zawierająca __zajęte__ przedziałowe miejsca na przystanku
            - `nonCompartmentSeats` - tablica zawierająca __zajęte__ bezprzedziałowe miejsca na przystanku
         - `Train` - obiekt reprezentujący pociąg; zawiera następujące pola:
            - `number` - numer pociągu
            - `compartmentSeats` - ilość `wszystkich` miejsc bezprzedziałowych w pociągu
            - `nonCompartmentSeats` - ilość `wszystkich` miejsc przedziałowych w pociągu
       ---
   - Kolekcja tickets:
      - `_id` - numer identyfikacyjny
      - `routeID` - numer identyfikacyjny trasy
      - `startingStation` - przystanek początkowy
      - `endingStation` - stacja końcowa
      - `discount` - obiekt reprezentujący zniżkę; zawiera następujące pola:
         - `discountName` - nazwa zniżki
         - `discountType` - typ zniżki
         - `discountValue` - wartość ułamkowa zniżki
       - `price` - cena biletu po zniżce
       - `travelerName` - imię właściciela biletu
       - `travelerSurname` - nazwisko właściciela biletu
       - `seatNo` - numer miejsca
       - `compartmentSeat` - typ miejsca
       - `travelerCountry` - kraj zamieszkania właściciela biletu
       - `travelerCity` - miasto zamieszkania właściciela biletu
       - `travelerZip` - kod pocztowy właściciela biletu
       - `travelerAddress` - adres zamieszkania właściciela biletu

### PostgreSQL

|  Users        | 
| ------------- |
|    userID     |
|     username  |
|     password  |
|     firstName |
|      lastName |
|         email | 
|          city |
|       country |
|           zip |
|       address |
---

### `FrontEnd`
Front-end (React)
6 podstron – strona główna, formularz rejestracji, formularz logowania, formularz wyszukiwania połączenia, historia biletów, Strona wprowadzenia danych pasażera podczas zakupu biletu
Strona główna zawiera odnośniki do formularza rejestracji, logowania, zakupu biletu
Formularz rejestracji pobiera wszystkie dane opisane w tabeli Users
Formularz logowania pobiera login i hasło
Formularz wyszukiwania połączenia zawiera:
- Stację początkową
- Stację końcową
- Opcje wyszukiwania (brak przesiadek)
- Datę wyjazdu
Po wypełnieniu formularza i otrzymaniu odpowiedzi z backendu z listą proponowanych połączeń, użytkownik wybiera jedno z nich (o ile istnieje). Po wybraniu wypełnia dane (imię, nazwisko, email) lub się loguje. Wypełnienie tych pól (lub zalogowanie się) potwierdza rezerwację biletu.
Strona historii biletów (dostępna tylko dla zalogowanych użytkowników).
Po otrzymaniu odpowiedzi z backendu listuje wszystkie bilety:
- Id biletu
- Stację początkową
- Stację końcową
- Datę wyjazdu
- Numer miejsca
- Cenę biletu
- Informację o typie miejsca (w wagonie przedziałowym/bezprzedziałowym)

---
### `Rozwiązania: `
   Główne narzędzie dla przetwarzania zapytań z frontendu na serwerze stanowi Spring Boot. Przy konfiguracji go z bazami danych operacje dodawania __Route__ do kolekcji __Routes__ i __ticket__ do kolekcji __tickets__ sprowadzają się do przemapowania *body* zapytań na obiekty oraz dodaniu ich jako nowe dokuemnty do MongoDB przy użyciu intefejsu `MongoRepositoy`. Analogicznie dodanie __user__ do tabeli __Users__ jest dodaniem rekordu korzystając z interfejsu `CrudRepository`.

Logowanie sprwodza się do sprawdzenia w Postgres, czy użytkownik o podanym loginie i haśle istnieje w bazie. Natomiast rejestracja to dodanie użytkownika do bazy.

Użytkownik może zobaczyć dostępne trasy dla wybranych dla siebie przystanków. Operacja to odbywa się przez wywołanie konkretnego `@Aggregation pipeline` na kolekcji Routes zwracjającego trasy dopasowane pod względem czasu oraz przystanków końcowych.
```Java
@Aggregation(pipeline={
            "{$match:{'travelDate':?3}}",
            "{$unwind:'$trainStops'}",
            "{$match:{'trainStops.stationName':{$in:[?0,?1]}}}",
            "{$group:{_id:'$_id', firstStation:{$first:'$trainStops.stationName'},lastStation:{$last:'$trainStops.stationName'},departureTime:{$first:'$trainStops.departureTime'},arrivalTime:{$last:'$trainStops.arrivalTime'}}}",
            "{$match:{'firstStation':?0}}",
            "{$match:{'lastStation':?1}}",
            "{$match:{'$expr':{'$gt':['$departureTime',?2]}}}"
    })
 List<RouteFinderParams> getRoutes(String startingCity, String endingCity, String departureTime, String travelDate);
```


Użytkownik ma możliwość zakupu biletu na wybraną trasę, jezeli znajdują się na niej wolne miejsca, w wybranym przez użytkownika komforcie.
Funkcjonalność tę realizuje metoda `public boolean reserveTicket(Ticket ticket)` klasy `TicketLogic` przy pomocy narzędzia _MongoTemplate_. Pomyślna rezerwacja biletu jest jednoznacza z dodaniem zajętego miejsca do przystanków na trasie oraz dodaniem biletu do kolekcji __tickets__. W przypadku niepowodzenia miejsce nie jest dodawane oraz bilet nie jest widoczny w bazie.

---
### `Endpoint'y`
 - __/register/submit__ *(POST)* - zapis użytkownika w bazie, zwraca status
 - __/routes/find__ *(GET)* - wyszukiwanie połączeń w danym dniu po godzinie zawartej w departureTime,  zwraca liste obiektów JSON postaci
 - __/routes/add__ *(POST)* - dodaje opisaną trasę
 - __/routes/tickets__ *(GET)* - zwraca listę obiektów typu ticket osoby o danym userID
 - __/routes/ticket__ *(POST)* - dodaje bilet, aktualizuje wolne miejsca w trasach, wyznacza cene biletu
