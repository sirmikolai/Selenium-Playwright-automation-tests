# Selenium-Playwright-automation-tests

## Opis:

Selenium-Playwright-automation-tests jest to repozytorium z testami automatycznymi E2E przygotowanymi dla dwóch różnych frameworków `Selenium` oraz `Playwright`. Repozytorium posłużyło mi do przeprowadzenia niezbędnych badań w mojej pracy magisterskiej pt. `Analiza i porównanie wybranych frameworków do testowania automatycznego aplikacji przy użyciu języka Java`.

Zautomatyzowane testy sprawdzają moją autorską aplikacji internetową [Car-info-app](https://github.com/sirmikolai/Car-info-app), która jest dostępna pod adresem [LINK](https://car-info-app.onrender.com/) (czasami trzeba chwilę poczekać po wejściu na stronę zanim serwer się uruchomi, zwykle trwa to około minuty).

Testy automatyczne sprawdzają takie funkcjonalności jaK:
- funkcjonalność rejestracji użytkownika do systemu - [Opis scenariusza](#rejestracja-użytkownika),
- funkcjonalność logowania użytkownika do systemu - [Opis scenariusza](#logowanie-użytkownika),
- funkcjonalność zmiany hasła użytkownika - [Opis scenariusza](#zmiana-hasła-użytkownika),
- funkcjonalność zarządzania użytkownikami za pomocą panelu administratora - [Opis scenariusza](#zarządzanie-użytkownikami),
- funkcjonalność dodawania, edycji oraz usuwania marek samochodów - [Opis scenariusza](#dodawanie-edycja-usuwanie-marek-samochodów),
- funkcjonalnośc dodawania, edycji oraz usuwania modeli samochodów - [Opis scenariusza](#dodawanie-edycja-usuwanie-modeli-samochodów).

 
Testy automatyczne dla frameworka Selenium korzystają m.in. z poniższych bibliotek:
```
- Selenium v.4.15.0,
- TestNG v.7.8.0,
- Allure-testng v.2.24.0,
- Logback 1.4.11.
```

Testy automatyczne dla frameworka Playwright korzystają m.in. z poniższych bibliotek:
```
- Playwright v.1.39.0,
- TestNG v.7.8.0,
- Allure-testng v.2.24.0,
- Logback 1.4.11.
```

Podczas implementacji testów automatycznych został użyty wzorzec Page Object Model.

# Scenariusze testowe:

## Rejestracja użytkownika
### Klasa testowa: `RegistrationTest`

<table><tr><th colspan="2" valign="top"><p><b>SCENARIUSZ TESTOWY #1</b></p><p><b>Rejestracja użytkownika.</b></p></th></tr>
<tr><td colspan="1" valign="top"><b>Typ:</b></td><td colspan="1" valign="top">Test funkcjonalny.</td></tr>
<tr><td colspan="1" valign="top"><b>Cel:</b></td><td colspan="1" valign="top">Sprawdzenie funkcjonalności rejestracji użytkownika do systemu.</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #1</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik poprawnie rejestruje się do aplikacji.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Żaden użytkownik nie jest zalogowany.</p><p>Nie istnieje żaden użytkownik o podanym adresie mailowym.</p></td></tr>
<tr><td colspan="1" rowspan="9" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Sign up”.</td></tr>
<tr><td colspan="1" valign="top">3. Wprowadzenie adresu mailowego w polu „Email”.</td></tr>
<tr><td colspan="1" valign="top">4. Wprowadzenie hasła w polu „Password”.</td></tr>
<tr><td colspan="1" valign="top">5. Wprowadzenie hasła w polu „Confirm password”.</td></tr>
<tr><td colspan="1" valign="top">6. Zaznaczenie pola „Agree to terms and conditions”.</td></tr>
<tr><td colspan="1" valign="top">7. Kliknięcie przycisku „Sign up”.</td></tr>
<tr><td colspan="1" valign="top">8. Przejście do skrzynki pocztowej z podanym adresem mailowym przy rejestracji.</td></tr>
<tr><td colspan="1" valign="top">9. Otwarcie maila z tytułem „Please confirm your account” i kliknięcie przycisku „Click here”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Użytkownik został poprawnie zarejestrowany.</p><p>W aplikacji internetowej pojawia się komunikat „Success! Your account has been activated! Now, you can sign in.”.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #2</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik próbuje zarejestrować się, podając adres mailowy użytkownika, który istnieje w systemie.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Żaden użytkownik nie jest zalogowany.</p><p>Posiadanie adresu mailowego zarejestrowanego użytkownika.</p></td></tr>
<tr><td colspan="1" rowspan="7" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Sign up”.</td></tr>
<tr><td colspan="1" valign="top">3. Wprowadzenie adresu mailowego w polu „Email”.</td></tr>
<tr><td colspan="1" valign="top">4. Wprowadzenie hasła w polu „Password”.</td></tr>
<tr><td colspan="1" valign="top">5. Wprowadzenie hasła w polu „Confirm password”.</td></tr>
<tr><td colspan="1" valign="top">6. Zaznaczenie pola „Agree to terms and conditions”.</td></tr>
<tr><td colspan="1" valign="top">7. Kliknięcie przycisku „Sign up”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Użytkownik nie zostaje zarejestrowany.</p><p>Pojawia się komunikat „Error! There is already registered user with that email!”.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #3</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik próbuje zarejestrować się, podając różne hasła użytkownika.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Żaden użytkownik nie jest zalogowany.</p><p>Nie istnieje żaden użytkownik o podanym adresie mailowym.</p></td></tr>
<tr><td colspan="1" rowspan="7" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Sign up”.</td></tr>
<tr><td colspan="1" valign="top">3. Wprowadzenie adresu mailowego w polu „Email”.</td></tr>
<tr><td colspan="1" valign="top">4. Wprowadzenie hasła w polu „Password”.</td></tr>
<tr><td colspan="1" valign="top">5. Wprowadzenie innego hasła w polu „Confirm password”.</td></tr>
<tr><td colspan="1" valign="top">8. Zaznaczenie pola „Agree to terms and conditions”.</td></tr>
<tr><td colspan="1" valign="top">9. Kliknięcie przycisku „Sign up”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Użytkownik nie został zarejestrowany.</p><p>Pole „Confirm password” podświetla się na czerwono.</p><p>Poniżej tego pola pojawia się informacja „Please provide password confirmation.”.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #4</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik próbuje zarejestrować się, nie zaznaczając pola „Agree to terms and conditions”</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Żaden użytkownik nie jest zalogowany.</p><p>Nie istnieje żaden użytkownik o podanym adresie mailowym.</p></td></tr>
<tr><td colspan="1" rowspan="7" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Sign up”.</td></tr>
<tr><td colspan="1" valign="top">3. Wprowadzenie adresu mailowego w polu „Email”.</td></tr>
<tr><td colspan="1" valign="top">4. Wprowadzenie hasła w polu „Password”.</td></tr>
<tr><td colspan="1" valign="top">5. Wprowadzenie hasła w polu „Confirm password”.</td></tr>
<tr><td colspan="1" valign="top">6. Odznaczenie pola „Agree to terms and conditions”.</td></tr>
<tr><td colspan="1" valign="top">7. Kliknięcie przycisku „Sign up”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Użytkownik nie został zarejestrowany.</p><p>Pole „Agree to terms and conditions” podświetla się na czerwono.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
</table>

## Logowanie użytkownika
### Klasa testowa: `LoginTest`

<table><tr><th colspan="2" valign="top"><p><b>SCENARIUSZ TESTOWY #2</b></p><p><b>Logowania użytkownika.</b></p></th></tr>
<tr><td colspan="1" valign="top"><b>Typ:</b></td><td colspan="1" valign="top">Test funkcjonalny.</td></tr>
<tr><td colspan="1" valign="top"><b>Cel:</b></td><td colspan="1" valign="top">Sprawdzenie funkcjonalności logowania użytkownika do systemu.</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #1</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik poprawnie loguje się do aplikacji</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Żaden użytkownik nie jest zalogowany.</p><p>Użytkownik posiada konto w aplikacji.</p></td></tr>
<tr><td colspan="1" rowspan="5" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Sign in”.</td></tr>
<tr><td colspan="1" valign="top">3. Wprowadzenie adresu mailowego w polu „Email”.</td></tr>
<tr><td colspan="1" valign="top">4. Wprowadzenie hasła w polu „Password”.</td></tr>
<tr><td colspan="1" valign="top">5. Kliknięcie przycisku „Sign in”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Użytkownik został zalogowany. </p><p>Pojawia się przycisk „Wyloguj”.</p><p>Pojawia się komunikat „Success! You have been signed in correctly.”.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Wylogowanie użytkownika.</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #2</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik próbuje zalogować się, podając adres mailowy nieistniejącego użytkownika.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top">Żaden użytkownik nie jest zalogowany.</td></tr>
<tr><td colspan="1" rowspan="5" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Sign in”.</td></tr>
<tr><td colspan="1" valign="top">3. Wprowadzenie niepoprawnego adresu mailowego w polu „Email”.</td></tr>
<tr><td colspan="1" valign="top">4. Wprowadzenie hasła w polu „Password”.</td></tr>
<tr><td colspan="1" valign="top">5. Kliknięcie przycisku „Sign in”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Użytkownik nie został zalogowany. </p><p>Pojawia się komunikat „Error! Invalid credentials.”.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #3</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik próbuje zalogować się, podając nieprawidłowe hasło użytkownika.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Żaden użytkownik nie jest zalogowany.</p><p>Użytkownik posiada konto w aplikacji.</p></td></tr>
<tr><td colspan="1" rowspan="5" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Sign in”.</td></tr>
<tr><td colspan="1" valign="top">3. Wprowadzenie adresu mailowego w polu „Email”.</td></tr>
<tr><td colspan="1" valign="top">4. Wprowadzenie niepoprawnego hasła w polu „Password”.</td></tr>
<tr><td colspan="1" valign="top">5. Kliknięcie przycisku „Sign in”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Użytkownik nie został zalogowany. </p><p>Pojawia się komunikat „Error! Invalid credentials.”.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #4</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik próbuje zalogować się, nie podając żadnych danych.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top">Żaden użytkownik nie jest zalogowany.</td></tr>
<tr><td colspan="1" rowspan="3" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Sign in”.</td></tr>
<tr><td colspan="1" valign="top">3. Kliknięcie przycisku „Sign in”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Pola „Email” oraz „Password” podświetlają się na czerwono.</p><p>Poniżej pola „Email” pojawia się informacja „Please provide your email address.”.</p><p>Poniżej pola „Email” pojawia się informacja „Please provide password.”.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
</table>

## Zmiana hasła użytkownika
### Klasa testowa: `ResetPasswordTest`

<table><tr><th colspan="2" valign="top"><p><b>SCENARIUSZ TESTOWY #3</b></p><p><b>Zmiana hasła użytkownika.</b></p></th></tr>
<tr><td colspan="1" valign="top"><b>Typ:</b></td><td colspan="1" valign="top">Test funkcjonalny.</td></tr>
<tr><td colspan="1" valign="top"><b>Cel:</b></td><td colspan="1" valign="top">Sprawdzenie funkcjonalności zmiany hasła użytkownika.</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #1</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik poprawnie przeprowadza akcje zmiany hasła swojego konta.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top">Użytkownik jest zalogowany do systemu.</td></tr>
<tr><td colspan="1" rowspan="6" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Change password”.</td></tr>
<tr><td colspan="1" valign="top">3. Wprowadzenie obecnego hasła użytkownika w polu „Current password”.</td></tr>
<tr><td colspan="1" valign="top">4. Wprowadzenie nowego hasła w polu „New password”.</td></tr>
<tr><td colspan="1" valign="top">5. Wprowadzenie ponownie nowego hasła w polu „Confirm new password”.</td></tr>
<tr><td colspan="1" valign="top">6. Kliknięcie przycisku „Confirm”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Hasło zostało zmienione.</p><p>Pojawia się komunikat „Success! Your password has been changed.”</p><p>Użytkownik może zalogować się do systemu za pomocą nowego hasła.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #2</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik przeprowadza akcje zmiany hasła swojego konta, podając niepoprawne dane w polu „Confirm new password”.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top">Użytkownik jest zalogowany do systemu.</td></tr>
<tr><td colspan="1" rowspan="6" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Change password”.</td></tr>
<tr><td colspan="1" valign="top">3. Wprowadzenie obecnego hasła użytkownika w polu „Current password”.</td></tr>
<tr><td colspan="1" valign="top">4. Wprowadzenie nowego hasła w polu „New password”.</td></tr>
<tr><td colspan="1" valign="top">5. Wprowadzenie innego hasła w polu „Confirm new password”.</td></tr>
<tr><td colspan="1" valign="top">6. Kliknięcie przycisku „Confirm”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Hasło nie zostało zmienione.</p><p>Pole „Confim new password” podświetla się na czerwono.</p><p>Poniżej pola „Confirm new password” pojawia się informacja „Please provide password confirmation.”.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #3</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik przeprowadza akcje zmiany hasła swojego konta, podając niepoprawne dane w polu „Current password”.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top">Użytkownik jest zalogowany do systemu.</td></tr>
<tr><td colspan="1" rowspan="6" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Change password”.</td></tr>
<tr><td colspan="1" valign="top">3. Wprowadzenie niepoprawnego obecnego hasła użytkownika w polu „Current password”.</td></tr>
<tr><td colspan="1" valign="top">4. Wprowadzenie nowego hasła w polu „New password”.</td></tr>
<tr><td colspan="1" valign="top">5. Wprowadzenie ponownie nowego hasła w polu „Confirm new password”.</td></tr>
<tr><td colspan="1" valign="top">6. Kliknięcie przycisku „Confirm”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Hasło nie zostało zmienione.</p><p>Pojawia się komunikat „Error! Incorrect current password!”.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
</table>

## Zarządzanie użytkownikami
### Klasa testowa: `AdminPanelTest`

<table><tr><th colspan="2" valign="top"><p><b>SCENARIUSZ TESTOWY #4</b></p><p><b>Zarządzanie użytkownikami za pomocą panelu administratora.</b></p></th></tr>
<tr><td colspan="1" valign="top"><b>Typ:</b></td><td colspan="1" valign="top">Test funkcjonalny.</td></tr>
<tr><td colspan="1" valign="top"><b>Cel:</b></td><td colspan="1" valign="top">Sprawdzenie funkcjonalności zarządzania użytkownikami za pomocą panelu administratora.</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #1</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Administrator zmienia rolę nowego użytkownika z USER na ADMIN.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Użytkownik z rolą ADMIN lub SUPERADMIN jest zalogowany do systemu.</p><p>Istnieje użytkownik z rolą USER.</p></td></tr>
<tr><td colspan="1" rowspan="3" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Admin panel”.</td></tr>
<tr><td colspan="1" valign="top">3. Kliknięcie przycisku „Promote to Admin role” obok wiersza z adresem mailowym użytkownika z rolą USER.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Rola użytkownika została zmieniona.</p><p>Pojawia się komunikat „Success! User with email {{adresMailowyUżytkownika}} has been promoted to ADMIN role.”</p><p>Użytkownik, któremu została zmieniona rola, po zalogowaniu ma dostęp do panelu administratora.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #2</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Administrator zmienia rolę nowego użytkownika z ADMIN na USER.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Użytkownik z rolą ADMIN lub SUPERADMIN jest zalogowany do systemu.</p><p>Istnieje inny użytkownik z rolą ADMIN.</p></td></tr>
<tr><td colspan="1" rowspan="3" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Admin panel”.</td></tr>
<tr><td colspan="1" valign="top">3. Kliknięcie przycisku „Demote to User role” obok wiersza z adresem mailowym użytkownika z rolą ADMIN.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Rola użytkownika została zmieniona.</p><p>Pojawia się komunikat „Success! User with email {{adresMailowyUżytkownika}} has been demoted to USER role.”</p><p>Użytkownik, któremu została zmieniona rola, po zalogowaniu nie ma dostępu do panelu administratora.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #3</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Administrator usuwa użytkownika z systemu.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Użytkownik z rolą ADMIN lub SUPERADMIN jest zalogowany do systemu.</p><p>Istnieje użytkownik z rolą USER.</p></td></tr>
<tr><td colspan="1" rowspan="3" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Admin panel”.</td></tr>
<tr><td colspan="1" valign="top">3. Kliknięcie przycisku „Delete user” obok wiersza z adresem mailowym użytkownika z rolą USER..</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Pojawia się komunikat „Success! User has been removed.”</p><p>Użytkownik, który został usunięty, nie ma możliwości zalogowania się do systemu.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
</table>

## Dodawanie, edycja, usuwanie marek samochodów
### Klasa testowa: `CarBrandTest`

<table><tr><th colspan="2" valign="top"><p><b>SCENARIUSZ TESTOWY #5</b></p><p><b>Dodawanie, edycja i usuwanie marek samochodów.</b></p></th></tr>
<tr><td colspan="1" valign="top"><b>Typ:</b></td><td colspan="1" valign="top">Test funkcjonalny.</td></tr>
<tr><td colspan="1" valign="top"><b>Cel:</b></td><td colspan="1" valign="top">Sprawdzenie funkcjonalności dodawania, edycji oraz usuwania marek samochodów.</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #1</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik dodaje markę samochodu do systemu.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top">Użytkownik jest zalogowany do systemu.</td></tr>
<tr><td colspan="1" rowspan="4" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Add car brand”.</td></tr>
<tr><td colspan="1" valign="top">3. Wypełnienie pól w formularzu przy użyciu testowych danych.</td></tr>
<tr><td colspan="1" valign="top">4. Kliknięcie przycisku „Add car brand”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Nowa marka samochodu została dodana.</p><p>Pojawia się komunikat „Success! Car brand has been added.”</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #2</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik edytuje dodaną markę samochodu w systemie.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Użytkownik jest zalogowany do systemu.</p><p>Istnieje marka samochodu.</p></td></tr>
<tr><td colspan="1" rowspan="4" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Edit car brand” przy istniejącej marce samochodu.</td></tr>
<tr><td colspan="1" valign="top">3. Wypełnienie pól w formularzu przy użyciu innych testowych danych.</td></tr>
<tr><td colspan="1" valign="top">4. Kliknięcie przycisku „Save changes”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Dane istniejącej marki samochodu została zmodyfikowane zgodnie z danymi podanymi w formularzu.</p><p>Pojawia się komunikat „Success! Car brand has been updated.”</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #3</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik usuwa dodaną markę samochodu w systemie.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Użytkownik jest zalogowany do systemu.</p><p>Istnieje marka samochodu.</p></td></tr>
<tr><td colspan="1" rowspan="3" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „Delete car brand” przy istniejącej marce samochodu.</td></tr>
<tr><td colspan="1" valign="top">3. Potwierdzenie alertu.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Marka samochodu został usunięta i nie jest widoczna na liście.</p><p>Pojawia się komunikat „Success! Car brand has been removed.”.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
</table>

## Dodawanie, edycja, usuwanie modeli samochodów
### Klasa testowa: `CarModelTest`

<table><tr><th colspan="2" valign="top"><p><b>SCENARIUSZ TESTOWY #6</b></p><p><b>Dodawanie, edycja i usuwanie modeli samochodów.</b></p></th></tr>
<tr><td colspan="1" valign="top"><b>Typ:</b></td><td colspan="1" valign="top">Test funkcjonalny.</td></tr>
<tr><td colspan="1" valign="top"><b>Cel:</b></td><td colspan="1" valign="top">Sprawdzenie funkcjonalności dodawania, edycji oraz usuwania modeli samochodów.</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #1</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik dodaje model samochodu do systemu.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Użytkownik jest zalogowany do systemu.</p><p>Istnieje marka samochodu.</p></td></tr>
<tr><td colspan="1" rowspan="5" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „View car models” obok istniejącej marki.</td></tr>
<tr><td colspan="1" valign="top">3. Kliknięcie przycisku „Add car model”.</td></tr>
<tr><td colspan="1" valign="top">4. Wypełnienie pól w formularzu przy użyciu testowych danych.</td></tr>
<tr><td colspan="1" valign="top">5. Kliknięcie przycisku „Add car model”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Nowy model samochodu została dodany.</p><p>Pojawia się komunikat „Success! Car model has been added.”</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #2</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik edytuje dodany model samochodu w systemie.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Użytkownik jest zalogowany do systemu.</p><p>Istnieje marka samochodu.</p><p>Istnieje model samochodu danej marki.</p></td></tr>
<tr><td colspan="1" rowspan="5" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „View car models” obok istniejącej marki.</td></tr>
<tr><td colspan="1" valign="top">3. Kliknięcie przycisku „Edit car model” przy istniejącym modelu samochodu.</td></tr>
<tr><td colspan="1" valign="top">4. Wypełnienie pól w formularzu przy użyciu innych testowych danych.</td></tr>
<tr><td colspan="1" valign="top">5. Kliknięcie przycisku „Save changes”.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Dane istniejącego modelu samochodu zostały zmodyfikowane zgodnie z danymi podanymi w formularzu.</p><p>Pojawia się komunikat „Success! Car model has been updated.”</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
<tr><th colspan="2" valign="top"><b>PRZYPADEK TESTOWY #3</b></th></tr>
<tr><td colspan="1" valign="top"><b>Opis:</b></td><td colspan="1" valign="top">Użytkownik usuwa dodany model samochodu w systemie.</td></tr>
<tr><td colspan="1" valign="top"><b>Warunki wstępne:</b></td><td colspan="1" valign="top"><p>Użytkownik jest zalogowany do systemu.</p><p>Istnieje marka samochodu.</p><p>Istnieje model samochodu danej marki.</p></td></tr>
<tr><td colspan="1" rowspan="4" valign="top"><b>Kroki:</b></td><td colspan="1" valign="top">1. Otwarcie aplikacji internetowej.</td></tr>
<tr><td colspan="1" valign="top">2. Kliknięcie przycisku „View car models” obok istniejącej marki.</td></tr>
<tr><td colspan="1" valign="top">3. Kliknięcie przycisku „Delete car model” przy istniejącym modelu samochodu.</td></tr>
<tr><td colspan="1" valign="top">4. Potwierdzenie alertu.</td></tr>
<tr><td colspan="1" valign="top"><b>Oczekiwany rezultat:</b></td><td colspan="1" valign="top"><p>Model samochodu został usunięty i nie jest widoczny na liście.</p><p>Pojawia się komunikat „Success! Car model has been removed.”.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Czynności końcowe:</b></td><td colspan="1" valign="top">Brak</td></tr>
</table>

# Wymagania:
JDK17, maven.
 
# Uruchomienie testów:

Do zbudowania projektu należy użyc polecenia:
```
mvn clean install -DskipTests --file ./SeleniumProject/pom.xml
mvn clean install -DskipTests --file ./PlaywrightProject/pom.xml
```
 
Aby uruchomić wszystkie testy automatyczne należy użyc polecenia:
 ```
mvn test --file ./SeleniumProject/pom.xml
mvn test --file ./PlaywrightProject/pom.xml
```
