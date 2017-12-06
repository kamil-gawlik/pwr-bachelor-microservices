Instalacja rozwiązania
======================

Tworzenie własnych modułów funkcyjnych
--------------------------------------

Aby stworzyć własny moduł niezbędna jest specyfikacja REST Api, jakie
musi implementować serwis funkcyjny, oraz adres serwera Discovery
Service. Api jest wyspecyfikowanie w formacie wykorzystywanym przez
platformę Swagger i może zostać zaimplementowane na własną rękę albo za
pomocą edytora pozwalającego na jego konfigurację. W przypadku wybrania
drugiego rozwiązania wystarczy zaimportować dołączony do projektu plik
`swagger.json` (folder [service-generator/swagger\_definitions/]) do
edytora dostępnego pod adresem <https://editor.swagger.io> i w zakładce
`Generate Server` wybrać technologię w której chcemy stworzyć nasze
rozwiązane. Edytor wygeneruje na podstawie specyfikacji projekt
implementujący wymaganych endpointów.

Następnym krokiem jest implementacja docelowej funkcjonalności
tworzonego modułu oraz określenie formatu danych wejściowych i
wyjściowych naszego algorytmu. Te dane, w sposób zgodny ze specyfikacją
Api powinny być udostępniane z wykorzystaniem narzuconego interfejsu.

Ostatnim etapem jest integracja aplikacji z istniejąca infrastrukturą. W
tym celu należy stworzyć klienta serwisu Eureka. Dla większości
popularnych technologi takie implementacje są dostępne i łatwe w
uruchomieniu, w skrajnym przypadku można na tym samym hoście co
aplikacja odpalić dodatkową aplikację wykorzystująca wspomnianego
klienta i wskazującą na właściwy moduł. Klientowi Eureki należy podać
adres serwera Discovery Service, w przypadku aplikajcji wykorzystującej
platformę SpringBoot taka konfiguracja ma postać:
`eureka.client.service-url.defaultZone= https://discovery-service.herokuapp.com/eureka`
(adres url wskazuje na serwer wykorzystywany w testach rozwiązania).

Ostatecznym testem działania może być sprawdzenie, czy stworzona przez
nas aplikacja jest widoczna w głównym panelu Eureka Serwer, jeśli tak
jest ona gotowa do działania w ramach całego systemu i powinna być
dostępna z poziomu interfejsu użytkownika.

  [service-generator/swagger\_definitions/]: service-generator/swagger_definitions/
  
Uruchomienie aplikacji w środowisku lokalnym
============================================

Uruchomienie środowiska lokalnie wymaga przede wszystkim uruchomienia
kolejnych serwisów, większość z nich skonfigurowana jest w sposób
niewymagających żadnej innej ingerencji. Proces uruchamiania aplikacji
testowano na komputerach z systemem Linux, jednak system operacyjny nie
powinien mieć jednak wpływu na cały proces.

Programy niezbędne do uruchomienia rozwiązania:

-   Java 8

-   maven 3.3

-   node.js 8.9.1

-   npm 5.4.2

Kroki niezbędne do uruchomienia wszystkich elementów rozwiązania.
Komendy są wykonywane z poziomu głównego folderu rozwiązania.

1.  Uruchomienie Discovery Service - wywołanie polecenia
    `mvn spring-boot:run -f discovery-server/`

2.  Uruchomienie Task Excutora - wywołanie polecenia
    `mvn spring-boot:run -f task-api/`

3.  Uruchomienie przykładowego modułu funkcyjnego - wywołanie polecenia
    `mvn spring-boot:run -f service-generator/spring-server/`

4.  Uruchomienie interfejsu użytkownika:

    -   odkomentowanie konfiguracji Eureka client wskazującej na
        localhost w pliku `micro-frontend/server.js`

    -   wywołanie polecenia `npm install –prefix micro-frontend/`

    -   uruchomienie aplikacji poleceniem
        `npm start –prefix micro-frontend/`

Interfejs aplikacji powinien być dostępny pod adresem [localhost:8090].

  [localhost:8090]: localhost:8090
  
Uruchomienie aplikacji w sieci na przykładzie serwisu Heroku
============================================================

By udostępnić rozwiązanie w sieci wybrano serwis Heroku umożliwiający
darmowe uruchomienie w sieci do pięciu aplikacji. Aby skorzystać z tej
opcji należy założyć darmowe konto w serwisie i zainstalować narzędzie
`heroku-cli`. Następnie każda z aplikacji będzie kolejno odpalana w
ramach tego serwisu. Warto zauważyć, że używana usługa sama rozpoznaje
aplikacje wykorzystujące SringBoota i uruchamia je automatycznie,
podobnie dzieje się w przypadku odpowiednio skonfigurowanych aplikacji
wykorzystujących platformę node.js.

Kroki do uruchomienia całego rozwiązania w sieci:

1.  Logujemy się na nasze konto heroku komendą `heroku login`

2.  Uruchamiamy Discovery Service (wszystkie polecenia w folderze
    `discovery-server/`)

    -   Rejestrujemy aplikację na platformie heroku: uruchamiamy
        polecenie `heroku apps:create <app-name>` (gdzie app-name to
        wybrana przez nas nazwa). Adres naszej aplikacji w postaci
        [https://\<app-name\>.herokuapp.com/eureka] będzie adresem
        serwera Eureka, który będziemy podawać w każdej z rejestrowanych
        aplikacji.

    -   Podłączamy kod modułu do repozytorium git przypisanego do naszej
        aplikacji komendą `heroku git:remote -a <app-name>`. Możemy
        sprawdzić poleceniem `git remote -v` czy dodostępne jest zdalne
        repozytorium opisane jako `heroku`.

    -   Dostarczenie każdej kolejnej wersji aplikacji opiera się na
        udostępnieniu zmian wprowadzonych w module w zdalnym
        repozytorium, innymi słowy sprowadza się do wykonania kolejno
        komend:

        -   ` git add . `

        -   ` git commit -m "treść wiadomości" `

        -   ` git push heroku master `

3.  Uruchomienie pozostałych serwisów (Task Executor, Frontend i moduły
    funkcyjne)

    -   W konfiguracji klienta Eureka podajemy adres serwera w postaci
        [https://\<app-name\>.herokuapp.com/eureka].

    -   Tworzymy nową aplikacje i uruchamiamy w serwisie heroku w taki
        sam sposób jak Discovery Servive.

    Każdy z uruchomionych modułów dostępny będzie pod adresem
    [https://\<app-name\>.herokuapp.com/] , interfejs aplikacji
    udostępniany jest przez aplikację micro-frontend.

  [https://\<app-name\>.herokuapp.com/eureka]: https://<app-name>.herokuapp.com/eureka
  [https://\<app-name\>.herokuapp.com/]: https://<app-name>.herokuapp.com/
  
Testy aplikacji z wykorzystaniem przygotowanego środowiska produkcyjnego
========================================================================

W trakcie implementacji autor pracy przygotował i zainstalował całe
rozwiązanie w ramach platformy Heroku w sposób taki, jak to opisano w
sekcji [\[section:heroku\]]. Instalacja posiada tylko jeden załączony
moduł funkcyjny ze względu na ograniczenia istniejące w wykorzystywanym
na potrzeby projektu darmowej wersji usługi.

Aby uruchomić rozwiązanie należy wywołać każdy z wymienionych poniżej
adresów w oknie przeglądarki. Wywołania powinny występować w podanej
kolejności, po każdym każdorazowo czekając przed przejściem do kolejnego
punktu na pojawienie się jakiejkolwiek odpowiedzi wywoływanego serwisu.
Procedura ta wymuszona jest faktem, że serwis Heroku wyłącza nieaktywne
instancje aplikacji a ich ponowne uruchomienie zajmuje od kilkunastu do
kilkudziesięciu sekund.

1.  Discovery Service <https://discovery-service.herokuapp.com>

2.  Moduł funkcyjny
    <https://math-server.herokuapp.com/swagger-ui.html#/>

3.  Task Exevutor (wraz z listą zarejestrowanych modułów funkcyjnych)
    <https://micro-task-api.herokuapp.com/services>

4.  Frontend <https://micro-frontend.herokuapp.com>

  [\[section:heroku\]]: #section:heroku {reference-type="ref"
  reference="section:heroku"}