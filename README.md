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
            - `compartmentSeats` - ilość `wolnych` miejsc w przedziałach pociągu na tym przystanku
            - `nonCompartmentSeats` - ilość `wolnych` miejsce w wagonach bezprzedziałowych na tym przystanku
         - `Train` - obiekt reprezentujący pociąg; zawiera następujące pola:
            - `number` - numer pociągu
            - `compartmentSeats` - ilość `wszystkich` miejsc bezprzedziałowych w pociągu
            - `nonCompartmentSeats` - ilość `wszystkich` miejsc przedziałowych w pociągu
         - `takenCompartmentSeats` - tablica zajętych miejsc w przedziałach
         - `takenNonCompartmentSeats` - tablica zajętych miejsc w wagonach bezprzedziałowych
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

