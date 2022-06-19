# Zadanie rekrutacyjne

Projekt to prosty CRUD do wstawiania dokumentów w Spring Boot. 

* języki programowania: Java 8+ lub Kotlin 1.4+,
* system budowania: Maven lub Gradle,
* kontrola wersji: Git.


## Endpointy HTTP

Endpointy implementowane za pomocą Spring MVC. Prosta dokumentacja endpointów w Swagger/Redoc (polecane adnotacje OpenAPI v3). DTO mają być poddane walidacji, najlepiej przez adnotacje. Jeżeli walidacja nie przechodzi, to zwracany jest błąd HTTP z grupy 400.

### POST */api/document*

DTO dokumentu:

* `title : String` - walidacja: niepusty, max. 100 znaków,
* `publicationDate : OffsetDateTime` - walidacja: data niepóźniejsza, niż moment wywołania requesta (nie wstawiamy dokumentów z przyszłości),
* `authorName : String` - walidacja: niepusty.


### GET */api/document*

Obsługuje *paging* ze Springa, przyjmuje `org.springframework.data.domain.Pageable` jako argument w kontrolerze. Zwraca obiekt typu `org.springframework.data.domain.Page`. Pola w DTO takie same, jak w *POST* + jeszcze `id : Long`.


### GET */api/author*

*Paging* identyczny, jak wyżej. Można zrobić sortowanie po `authorName`, alfabetyczne.

Pola w DTO:

* `id : Long`
* `authorName`
* `numberOfDocuments : Int` - ile dokumentów jest przypisane do autora.


## Persistence

* Zakładam, że dwa entity: `Document` i `Author`, adnotacje JPA,
* baza danych PostgreSQL lub H2,
* podejście *database first*, czyli najpierw kod SQL tabeli,
* podłączenie Liquibase lub Flyway - dobrze, jakby Spring sprawdzał przy uruchomieniu, czy ma dobrą wersję schematu w bazie.