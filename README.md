<h1>Ohjelmistotekniikka, harjoitustyö</h1>

### Pong Game

Tässä sovelluksessa voi pelata suosittua pöytätenniksen kaltaista kaksinpeliä, Pongia. Projekti on luotu Javan versiolla 11, käyttäen JavaFX:ää. Projektin pom.xml:ssä on määritelty Mavenin käyttävän version 1.8 kääntäjää.

<h2>Dokumentaatio</h2>

[Pong 1.0](https://github.com/isakpulkki/ot-harjoitustyo/releases/tag/viikko5)

[Vaatimusmäärittely](https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)


<h2>Komentorivitoiminnot</h2>

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```
### Ohjelman suoritus
Ohjelman pystyy suorittamaan komennolla

```
mvn compile exec:java -Dexec.mainClass=pong.Main
```
### Checkstyle

Checkstyle -tarkistukset suoritetaan komennolla


```
 mvn jxr:jxr checkstyle:checkstyle
```


