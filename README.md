# Heroes - Team Tom
Unser Projekt für das Java Open Source Modul.

## Schwierigkeiten

Viele Klassen der Dependencies die im Aufgabenteil erwähnt wurden waren
bereits veraltet und konnten nicht verwendet werden. Aus diesem Grund musste
man zuerst herausfinden wie die aktuellen Klassen heissen, die für unseren Zweck
geeignet waren.

## Erweiterungen

## Schlussstand des Projekts

## Installationsanleitung lokal

### Importieren

Dies ist ein Mavenprojekt. Das Projekt muss als solches bei der IDE importiert werden.

### Compilieren

In einer Shell oder einem Kommandofenster

>
> mvn clean compile
>

### Ausführen

Bei Allen Modulen die Starterklasse ausführen.
Im Browser auf <http://localhost:8080/> navigieren, da sich dort der Frontendservice befindet

## Gebrauchsanleitung

| Service | Port | Beschreibung |
| --- | --- | --- |
| Registry | 1111 | Stellt Eureka zur verfügung|
| Camp | 2222 | Erstellt Heroes und Parties |
| Arena | 3333 | Führt die Kämpfe durch |
| Promoter | 4444 | Teilt die Resultate von Kämpfen mit |
| Shop | 5555 | Stellt Items zur Verfügung |
| Frontend | 8080 | Frontend welches den Usern zugriff zum Spiel gewährt |

Microservice Architecture

<img src="./resources/Microservice Architecture.svg">