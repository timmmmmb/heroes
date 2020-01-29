# Heroes - Team Tom
Unser Projekt für das Java Open Source Modul.

## Installationsanleitung lokal

### Importieren

Dies ist ein Mavenprojekt. Das Projekt muss als solches bei der IDE importiert werden.

### Kompilieren

In einer Shell oder einem Kommandofenster

>
> mvn clean compile
>

### Ausführen

Bei Allen Modulen die Starterklasse ausführen.
Im Browser auf <http://localhost:8080/> navigieren, da sich dort der Frontendservice befindet

## Services

| Service | Port | Beschreibung |
| --- | --- | --- |
| Registry | 1111 | Stellt Eureka zur verfügung|
| Camp | 2222 | Erstellt Heroes und Parties |
| Arena | 3333 | Führt die Kämpfe durch |
| Promoter | 4444 | Teilt die Resultate von Kämpfen mit |
| Shop | 5555 | Stellt Items zur Verfügung |
| History | 7777 | Speichert alle durchgeführeten Kämpfe |
| Frontend | 8080 | Frontend welches den Usern zugriff zum Spiel gewährt 

Microservice Architecture

<img src="./resources/Microservice Architecture.svg">

##Installation
Manuell ohne Docker
1. Das Projekt von unserem Github-Repository pullen (https://github.com/timmmmmb/heroes) und als Maven-Projekt importieren
2. Alle Dependencies laden: mvn clean install oder direkt über die IDE
3. Die Startklasse des Registry-Service starten
4. Die Startklassen der restlichen Services starten
5. Im Browser auf http://localhost:8080 navigieren

Mit Docker
1. Das Projekt von unserem Github-Repository pullen (https://github.com/timmmmmb/heroes) und als Maven-Projekt importieren
2. mvn clean install
3. docker-compose up
4. Zum Beenden docker-compose stop