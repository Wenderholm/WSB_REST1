## Zadania

Uruchom aplikację Postman (z poziomu przeglądarki - można się zalogować przy pomocy Gmaila) lub pobierz wersję desktopową.

Zadanie będzie polegało na przygotowaniu requestów do testowej aplikacji.

Aplikacja testowa znajduje się pod adresem *TODO*.

### Zadanie 1 - i18n

1. Wyślij zapytanie GET pod endpoint `/languages`. W odpowiedzi powinna przyjść lista języków wspieranych przez aplikację.

2. Wyślij zapytanie GET pod endpoint `/hello`. Ustaw w nagłówku `Accept-Language` któryś ze wspieranych języków, pobranych w punkcie 1. Zobacz, jak różni się uzyskana odpowiedź zależnie od ustawionego języka.

3. To samo zachowanie można sprowokować z poziomu przeglądarki. Wpisz w pasku przeglądarki adres serwera i endpoint `/hello`. Zmień język przeglądarki na któryś ze wspieranych języków i odśwież stronę.

### Zadanie 2 - autoryzacja

Uwaga! Postman zawiera trochę bardziej złożone mechanizmy do obsługi autoryzacji. W zakładce `Authorization` proszę ustawić `No Auth`, a autoryzację proszę obsługiwać dodając nagłówek `Authorization` w zakładce `Headers`.

1. Sprawdź typ autoryzacji obsługiwany przez aplikację - endpoint `auth`, metoda GET.

2. Uzyskaj token - wyślij żądanie POST pod endpoint `auth`. W odpowiedzi uzyskasz wskazówki, co należy dodać do tego żądania, aby wygenerować token. Po uzupełnieniu wymaganych informacji w odpowiedzi powinien zostać odesłany token.

3. Spróbuj wysłać żądanie GET pod endpoint `/restrictedAccess` - powinna przyjść odpowiedź ze statusem 422.

4. Spróbuj ponownie wysłać żądanie z punktu 3, jednak dodaj nagłówek `Authorization`, wykorzystując typ autoryzacji uzyskany w punkcie 1 i token uzyskany w punkcie 2.

### Zadanie 3 - manipulacja obiektami



### Zadanie 4 - ciastka

### Zadanie 5 - przekierowanie 