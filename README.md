# Selenium-Playwright-automation-tests

## Język/Language:
[Polski](#polski)
[English](#english)

# Polski

## Spis treści:
[Opis](#opis)
[Scenariusze-testowe](#scenariusze-testowe)
[Wymagania](#wymagania)
[Uruchomienie testów](#uruchomienie-testów)
[Integracja CI/CD](#integracja-cicd)

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
### Klasa testowa: `ChangingPasswordTest`

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

# Integracja CI/CD:

Dla przedstawionych projektów został przygotowany pipeline przy użyciu narzędzia GitHub Actions, który jest uruchamiany manualnie. 

Pipeline posiada dwa parametry:
- Framework (wybierany jest projekt na którym mają zostać uruchomione testy automatyczne),
- Browser (wybierana jest przeglądarka na której mają zostać uruchomione testy automatyczne).

Kod źródłowy pipeline jest umieszczony tutaj [LINK](https://github.com/sirmikolai/Selenium-Playwright-automation-tests/blob/main/.github/workflows/manual.yml)

Po wykonaniu testów, generowany jest raport przy użyciu biblioteki Allure-testng i jest udostępniany na stronie [LINK](https://sirmikolai.github.io/Selenium-Playwright-automation-tests/)

# English

## Table of Contents:
[Description](#description)
[Test Scenarios](#test-scenarios)
[Requirements](#requirements)
[How to run tests](#how-to-run-tests)
[CI/CD Integration](#cicd-integration)

## Description

Selenium-Playwright-automation-tests is a repository containing end-to-end (E2E) automated tests prepared for two different frameworks: Selenium and Playwright. The repository served me for conducting necessary research in my master's thesis titled "The comparative analysis of selected frameworks for automatic testing of web applications using Java programming language".

The automated tests verify my custom web application Car-info-app, which is accessible at LINK (sometimes you may need to wait a moment after entering the site for the server to start, usually taking about a minute).

Test automation for the Selenium framework uses the following libraries:
```
- Selenium v.4.15.0,
- TestNG v.7.8.0,
- Allure-testng v.2.24.0,
- Logback 1.4.11.
```

Test automation for the Playwright framework uses the following libraries:
```
- Playwright v.1.39.0,
- TestNG v.7.8.0,
- Allure-testng v.2.24.0,
- Logback 1.4.11.
```

The Page Object Model pattern was used during the implementation of automated tests.

# Test Scenarios:

## User Registration
### Test Class: `RegistrationTest`

<table><tr><th colspan="2" valign="top"><p><b>TEST SCENARIO #1</b></p><p><b>User Registration.</b></p></th></tr>
<tr><td colspan="1" valign="top"><b>Type:</b></td><td colspan="1" valign="top">Functional Test.</td></tr>
<tr><td colspan="1" valign="top"><b>Purpose:</b></td><td colspan="1" valign="top">Verify the user registration functionality in the system.</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #1</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User successfully registers for the application.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>No user is logged in.</p><p>No user with the given email address exists.</p></td></tr>
<tr><td colspan="1" rowspan="9" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Sign up" button.</td></tr>
<tr><td colspan="1" valign="top">3. Enter the email address in the "Email" field.</td></tr>
<tr><td colspan="1" valign="top">4. Enter the password in the "Password" field.</td></tr>
<tr><td colspan="1" valign="top">5. Enter the password in the "Confirm password" field.</td></tr>
<tr><td colspan="1" valign="top">6. Check the "Agree to terms and conditions" checkbox.</td></tr>
<tr><td colspan="1" valign="top">7. Click the "Sign up" button.</td></tr>
<tr><td colspan="1" valign="top">8. Go to the mailbox with the provided registration email address.</td></tr>
<tr><td colspan="1" valign="top">9. Open the email with the subject "Please confirm your account" and click the "Click here" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>User has been successfully registered.</p><p>In the web application, a message appears: "Success! Your account has been activated! Now, you can sign in."</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">None</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #2</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User tries to register with an email address that already exists in the system.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>No user is logged in.</p><p>Have the email address of a registered user.</p></td></tr>
<tr><td colspan="1" rowspan="7" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Sign up" button.</td></tr>
<tr><td colspan="1" valign="top">3. Enter the email address in the "Email" field.</td></tr>
<tr><td colspan="1" valign="top">4. Enter the password in the "Password" field.</td></tr>
<tr><td colspan="1" valign="top">5. Enter the password in the "Confirm password" field.</td></tr>
<tr><td colspan="1" valign="top">6. Check the "Agree to terms and conditions" checkbox.</td></tr>
<tr><td colspan="1" valign="top">7. Click the "Sign up" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>User is not registered.</p><p>An error message appears: "Error! There is already a registered user with that email!"</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">None</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #3</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User tries to register with different passwords.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>No user is logged in.</p><p>No user exists with the provided email address.</p></td></tr>
<tr><td colspan="1" rowspan="7" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Sign up" button.</td></tr>
<tr><td colspan="1" valign="top">3. Enter the email address in the "Email" field.</td></tr>
<tr><td colspan="1" valign="top">4. Enter the password in the "Password" field.</td></tr>
<tr><td colspan="1" valign="top">5. Enter a different password in the "Confirm password" field.</td></tr>
<tr><td colspan="1" valign="top">8. Check the "Agree to terms and conditions" checkbox.</td></tr>
<tr><td colspan="1" valign="top">9. Click the "Sign up" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>User is not registered.</p><p>The "Confirm password" field is highlighted in red.</p><p>Below that field, there is a message: "Please provide password confirmation."</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">None</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #4</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User tries to register without checking the "Agree to terms and conditions" checkbox.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>No user is logged in.</p><p>No user exists with the provided email address.</p></td></tr>
<tr><td colspan="1" rowspan="7" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Sign up" button.</td></tr>
<tr><td colspan="1" valign="top">3. Enter the email address in the "Email" field.</td></tr>
<tr><td colspan="1" valign="top">4. Enter the password in the "Password" field.</td></tr>
<tr><td colspan="1" valign="top">5. Enter the password in the "Confirm password" field.</td></tr>
<tr><td colspan="1" valign="top">6. Uncheck the "Agree to terms and conditions" checkbox.</td></tr>
<tr><td colspan="1" valign="top">7. Click the "Sign up" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>User is not registered.</p><p>The "Agree to terms and conditions" checkbox is highlighted in red.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">None</td></tr>
</table>

## User Login
### Test Class: `LoginTest`

<table><tr><th colspan="2" valign="top"><p><b>TEST SCENARIO #2</b></p><p><b>User Login.</b></p></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User login scenarios.</td></tr>
<tr><td colspan="1" valign="top"><b>Type:</b></td><td colspan="1" valign="top">Functional test.</td></tr>
<tr><td colspan="1" valign="top"><b>Purpose:</b></td><td colspan="1" valign="top">Check the functionality of user login to the system.</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #1</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User successfully logs in to the application.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>No user is logged in.</p><p>User has an account in the application.</p></td></tr>
<tr><td colspan="1" rowspan="5" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Sign in" button.</td></tr>
<tr><td colspan="1" valign="top">3. Enter the email address in the "Email" field.</td></tr>
<tr><td colspan="1" valign="top">4. Enter the password in the "Password" field.</td></tr>
<tr><td colspan="1" valign="top">5. Click the "Sign in" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>User is logged in.</p><p>The "Log out" button appears.</p><p>The message "Success! You have been signed in correctly." appears.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">User logout.</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #2</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User attempts to log in with a non-existent email address.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top">No user is logged in.</td></tr>
<tr><td colspan="1" rowspan="5" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Sign in" button.</td></tr>
<tr><td colspan="1" valign="top">3. Enter an incorrect email address in the "Email" field.</td></tr>
<tr><td colspan="1" valign="top">4. Enter the password in the "Password" field.</td></tr>
<tr><td colspan="1" valign="top">5. Click the "Sign in" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>User is not logged in.</p><p>The message "Error! Invalid credentials." appears.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">None</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #3</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User attempts to log in with an incorrect user password.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>No user is logged in.</p><p>User has an account in the application.</p></td></tr>
<tr><td colspan="1" rowspan="5" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Sign in" button.</td></tr>
<tr><td colspan="1" valign="top">3. Enter the email address in the "Email" field.</td></tr>
<tr><td colspan="1" valign="top">4. Enter an incorrect password in the "Password" field.</td></tr>
<tr><td colspan="1" valign="top">5. Click the "Sign in" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>User is not logged in.</p><p>The message "Error! Invalid credentials." appears.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">None</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #4</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User attempts to log in without providing any data.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top">No user is logged in.</td></tr>
<tr><td colspan="1" rowspan="3" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Sign in" button.</td></tr>
<tr><td colspan="1" valign="top">3. Click the "Sign in" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>The "Email" and "Password" fields are highlighted in red.</p><p>Below the "Email" field, the message "Please provide your email address." appears.</p><p>Below the "Password" field, the message "Please provide password." appears.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">None</td></tr>
</table>

## Changing password
### Test Class: `ChangingPasswordTest`

<table><tr><th colspan="2" valign="top"><b>TEST SCENARIO #3</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User password change scenarios.</td></tr>
<tr><td colspan="1" valign="top"><b>Type:</b></td><td colspan="1" valign="top">Functional test.</td></tr>
<tr><td colspan="1" valign="top"><b>Purpose:</b></td><td colspan="1" valign="top">Check the functionality of user password change.</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #1</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User successfully performs actions to change the password of their account.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top">User is logged into the system.</td></tr>
<tr><td colspan="1" rowspan="6" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Change password" button.</td></tr>
<tr><td colspan="1" valign="top">3. Enter the current user password in the "Current password" field.</td></tr>
<tr><td colspan="1" valign="top">4. Enter the new password in the "New password" field.</td></tr>
<tr><td colspan="1" valign="top">5. Enter the new password again in the "Confirm new password" field.</td></tr>
<tr><td colspan="1" valign="top">6. Click the "Confirm" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>Password has been changed.</p><p>The message "Success! Your password has been changed." appears.</p><p>User can log into the system with the new password.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">None</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #2</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User changes the password of their account, providing incorrect data in the "Confirm new password" field.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top">User is logged into the system.</td></tr>
<tr><td colspan="1" rowspan="6" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Change password" button.</td></tr>
<tr><td colspan="1" valign="top">3. Enter the current user password in the "Current password" field.</td></tr>
<tr><td colspan="1" valign="top">4. Enter the new password in the "New password" field.</td></tr>
<tr><td colspan="1" valign="top">5. Enter a different password in the "Confirm new password" field.</td></tr>
<tr><td colspan="1" valign="top">6. Click the "Confirm" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>Password is not changed.</p><p>The "Confirm new password" field is highlighted in red.</p><p>Below the "Confirm new password" field, the message "Please provide password confirmation." appears.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">None</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #3</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User changes the password of their account, providing incorrect data in the "Current password" field.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top">User is logged into the system.</td></tr>
<tr><td colspan="1" rowspan="6" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Change password" button.</td></tr>
<tr><td colspan="1" valign="top">3. Enter an incorrect current user password in the "Current password" field.</td></tr>
<tr><td colspan="1" valign="top">4. Enter the new password in the "New password" field.</td></tr>
<tr><td colspan="1" valign="top">5. Enter the new password again in the "Confirm new password" field.</td></tr>
<tr><td colspan="1" valign="top">6. Click the "Confirm" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>Password is not changed.</p><p>The message "Error! Incorrect current password!" appears.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">None</td></tr>
</table>

## User management
### Test Class: `AdminPanelTest`

<table>
 <tr><th colspan="2" valign="top"><b>TEST CASE #4</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User management through the administrator panel.</td></tr>
<tr><td colspan="1" valign="top"><b>Type:</b></td><td colspan="1" valign="top">Functional test.</td></tr>
<tr><td colspan="1" valign="top"><b>Purpose:</b></td><td colspan="1" valign="top">Check the functionality of user management through the administrator panel.</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #1</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">Administrator changes the role of a new user from USER to ADMIN.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>User with ADMIN or SUPERADMIN role is logged into the system.</p><p>There is a user with USER role.</p></td></tr>
<tr><td colspan="1" rowspan="3" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Admin panel" button.</td></tr>
<tr><td colspan="1" valign="top">3. Click the "Promote to Admin role" button next to the row with the email address of the user with USER role.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>The user's role has been changed.</p><p>The message "Success! User with email {{userEmailAddress}} has been promoted to ADMIN role." appears.</p><p>The user whose role has been changed can access the administrator panel after logging in.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">None</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #2</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">Administrator changes the role of a new user from ADMIN to USER.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>User with ADMIN or SUPERADMIN role is logged into the system.</p><p>There is another user with ADMIN role.</p></td></tr>
<tr><td colspan="1" rowspan="3" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Admin panel" button.</td></tr>
<tr><td colspan="1" valign="top">3. Click the "Demote to User role" button next to the row with the email address of the user with ADMIN role.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>The user's role has been changed.</p><p>The message "Success! User with email {{userEmailAddress}} has been demoted to USER role." appears.</p><p>The user whose role has been changed cannot access the administrator panel after logging in.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">None</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #3</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">Administrator deletes a user from the system.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>User with ADMIN or SUPERADMIN role is logged into the system.</p><p>There is a user with USER role.</p></td></tr>
<tr><td colspan="1" rowspan="3" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Admin panel" button.</td></tr>
<tr><td colspan="1" valign="top">3. Click the "Delete user" button next to the row with the email address of the user with USER role.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected result:</b></td><td colspan="1" valign="top"><p>The message "Success! User has been removed." appears.</p><p>The user who has been removed cannot log in to the system.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final actions:</b></td><td colspan="1" valign="top">None</td></tr>
</table>

## Adding, editing, deleting Car Brands
### Test Class: `CarBrandTest`

<table><tr><th colspan="2" valign="top"><p><b>TEST SCENARIO #5</b></p><p><b>Adding, editing, deleting Car Brands.</b></p></th></tr>
<tr><td colspan="1" valign="top"><b>Type:</b></td><td colspan="1" valign="top">Functional Test.</td></tr>
<tr><td colspan="1" valign="top"><b>Purpose:</b></td><td colspan="1" valign="top">Checking the functionality of adding, editing, and deleting car brands.</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #1</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User adds a car brand to the system.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top">User is logged into the system.</td></tr>
<tr><td colspan="1" rowspan="4" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Add car brand" button.</td></tr>
<tr><td colspan="1" valign="top">3. Fill in the fields in the form using test data.</td></tr>
<tr><td colspan="1" valign="top">4. Click the "Add car brand" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected Result:</b></td><td colspan="1" valign="top"><p>A new car brand has been added.</p><p>The message "Success! Car brand has been added." appears.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final Actions:</b></td><td colspan="1" valign="top">None</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #2</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User edits an added car brand in the system.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>User is logged into the system.</p><p>A car brand exists.</p></td></tr>
<tr><td colspan="1" rowspan="4" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Edit car brand" button next to the existing car brand.</td></tr>
<tr><td colspan="1" valign="top">3. Fill in the fields in the form using different test data.</td></tr>
<tr><td colspan="1" valign="top">4. Click the "Save changes" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected Result:</b></td><td colspan="1" valign="top"><p>Data of the existing car brand has been modified according to the data provided in the form.</p><p>The message "Success! Car brand has been updated." appears.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final Actions:</b></td><td colspan="1" valign="top">None</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #3</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User deletes an added car brand in the system.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>User is logged into the system.</p><p>A car brand exists.</p></td></tr>
<tr><td colspan="1" rowspan="3" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "Delete car brand" button next to the existing car brand.</td></tr>
<tr><td colspan="1" valign="top">3. Confirm the alert.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected Result:</b></td><td colspan="1" valign="top"><p>The car brand has been removed and is not visible on the list.</p><p>The message "Success! Car brand has been removed." appears.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final Actions:</b></td><td colspan="1" valign="top">None</td></tr>
</table>

## Adding, editing, deleting Car Models
### Test Class: `CarModelTest`

<table><tr><th colspan="2" valign="top"><p><b>TEST SCENARIO #6</b></p><p><b>Adding, editing, deleting Car Models.</b></p></th></tr>
<tr><td colspan="1" valign="top"><b>Type:</b></td><td colspan="1" valign="top">Functional Test.</td></tr>
<tr><td colspan="1" valign="top"><b>Purpose:</b></td><td colspan="1" valign="top">Checking the functionality of adding, editing, and deleting car models.</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #1</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User adds a car model to the system.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>User is logged into the system.</p><p>A car brand exists.</p></td></tr>
<tr><td colspan="1" rowspan="5" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "View car models" button next to an existing brand.</td></tr>
<tr><td colspan="1" valign="top">3. Click the "Add car model" button.</td></tr>
<tr><td colspan="1" valign="top">4. Fill in the fields in the form using test data.</td></tr>
<tr><td colspan="1" valign="top">5. Click the "Add car model" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected Result:</b></td><td colspan="1" valign="top"><p>A new car model has been added.</p><p>The message "Success! Car model has been added." appears.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final Actions:</b></td><td colspan="1" valign="top">None</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #2</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User edits an added car model in the system.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>User is logged into the system.</p><p>A car brand exists.</p><p>A car model of the brand exists.</p></td></tr>
<tr><td colspan="1" rowspan="5" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "View car models" button next to an existing brand.</td></tr>
<tr><td colspan="1" valign="top">3. Click the "Edit car model" button next to an existing car model.</td></tr>
<tr><td colspan="1" valign="top">4. Fill in the fields in the form using different test data.</td></tr>
<tr><td colspan="1" valign="top">5. Click the "Save changes" button.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected Result:</b></td><td colspan="1" valign="top"><p>Data of the existing car model has been modified according to the data provided in the form.</p><p>The message "Success! Car model has been updated." appears.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final Actions:</b></td><td colspan="1" valign="top">None</td></tr>
<tr><th colspan="2" valign="top"><b>TEST CASE #3</b></th></tr>
<tr><td colspan="1" valign="top"><b>Description:</b></td><td colspan="1" valign="top">User deletes an added car model in the system.</td></tr>
<tr><td colspan="1" valign="top"><b>Preconditions:</b></td><td colspan="1" valign="top"><p>User is logged into the system.</p><p>A car brand exists.</p><p>A car model of the brand exists.</p></td></tr>
<tr><td colspan="1" rowspan="4" valign="top"><b>Steps:</b></td><td colspan="1" valign="top">1. Open the web application.</td></tr>
<tr><td colspan="1" valign="top">2. Click the "View car models" button next to an existing brand.</td></tr>
<tr><td colspan="1" valign="top">3. Click the "Delete car model" button next to an existing car model.</td></tr>
<tr><td colspan="1" valign="top">4. Confirm the alert.</td></tr>
<tr><td colspan="1" valign="top"><b>Expected Result:</b></td><td colspan="1" valign="top"><p>The car model has been removed and is not visible on the list.</p><p>The message "Success! Car model has been removed." appears.</p></td></tr>
<tr><td colspan="1" valign="top"><b>Final Actions:</b></td><td colspan="1" valign="top">None</td></tr>
</table>

# Requirements:
JDK17, maven.
 
# How to run tests:

To build the project, use the following commands:
```
mvn clean install -DskipTests --file ./SeleniumProject/pom.xml
mvn clean install -DskipTests --file ./PlaywrightProject/pom.xml
```
 
To run automated tests, use the following command:
```
mvn test --file ./SeleniumProject/pom.xml
mvn test --file ./SeleniumProject/pom.xml -DsuiteFile=testsuite.xml -Dbrowser=chrome
mvn test --file ./SeleniumProject/pom.xml -DsuiteFile=testsuite.xml -Dbrowser=firefox
mvn test --file ./SeleniumProject/pom.xml -DsuiteFile=testsuite.xml -Dbrowser=edge
mvn test --file ./PlaywrightProject/pom.xml
mvn test --file ./PlaywrightProject/pom.xml -DsuiteFile=testsuite.xml -Dbrowser=chrome
mvn test --file ./PlaywrightProject/pom.xml -DsuiteFile=testsuite.xml -Dbrowser=firefox
mvn test --file ./PlaywrightProject/pom.xml -DsuiteFile=testsuite.xml -Dbrowser=edge
```

# CI/CD Integration:

For the presented projects, a pipeline has been prepared using GitHub Actions, which is triggered manually.

The pipeline has two parameters:
- Framework (selects the project on which automated tests should be run),
- Browser (selects the browser on which automated tests should be run).

The source code of the pipeline is located here [LINK](https://github.com/sirmikolai/Selenium-Playwright-automation-tests/blob/main/.github/workflows/manual.yml)

After the tests are executed, a report is generated using the Allure-testng library and is available on the following page [LINK](https://sirmikolai.github.io/Selenium-Playwright-automation-tests/)
