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
- Możliwość wyszukania najszybszego połączenia pomiędzy wybranymi miastami (z uwzględnieniem przesiadek)
- Możliwość zakupu biletu przy uwzględnieniu rodzaju wagonu (przedziałowy/bez przedziałów)
- Możliwość rejestracji użytkownika, jak i zakupu bez rejestracji
- W przypadku rejestracji, możliwość wglądu w historię swoich biletów
- Określa uprawnienia użytkowników (dodawanie/usuwanie przejazdów)
- Przechowuje historię logowań
---
### `Technologie:`
- Java
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
### `Rozwiązania: `
   Główne narzędzie dla przetwarzania zapytań z frontendu na serwerze stanowi Spring Boot. Przy konfiguracji go z bazami danych operacje dodawania __Route__ do kolekcji __Routes__, __ticket__ do kolekcji __tickets__ sprowadzają się do przemapowania ciał zapytań na obiekty oraz dodaniu ich jako nowe dokuemnty do MongoDB przy użyciu intefejsu `MongoRepositoy`. Analogicznie dodanie __user__ do tabeli __Users__ jest dodaniem rekordu korzystając z interfejsu `CrudRepository`.

Logowanie sprwodza się do sprawdzenia w Postgres, czy użytkownik o podanym loginie i haśle istnieje w bazie. Natomiast rejestracja to dodanie użytkownika do bazy.

Użytkownik może zobaczyć dostępne trasy dla wybranych dla siebie przystanków. Operacja to odbywa się przez wywołanie konkretnego `@Aggregation pipeline` na kolekcji Routes
//TODO

Użytkownik ma możliwość zakupu biletu na wybraną trasę, jezeli znajdują się na niej wolne miejsca, w wybranym przez użytkownika komforcie.
Funkcjonalność tę realizuje metoda `public boolean reserveTicket(Ticket ticket)` klasy `TicketLogic` przy pomocy narzędzia _MongoTemplate_. Pomyślna rezerwacja biletu jest jednoznacza ze zmniejszeniem ilości wolnych miejsc na trasie oraz dodaniem biletu do kolekcji __tickets__. W przypadku niepowodzenia miejsca są "dodawane" z powrotem, a bilet nie jest widoczny w bazie.
