<h1>Ohjelmistotekniikka, harjoitustyö</h1>

### Pong Game

Tässä sovelluksessa voi pelata suosittua pöytätenniksen kaltaista kaksinpeliä, Pongia. Projekti on luotu Javan versiolla 11, käyttäen JavaFX:ää. Projektin pom.xml:ssä on määritelty Mavenin käyttävän version 1.8 kääntäjää.

<h2>Dokumentaatio</h2>

[Pong 2.0](https://github.com/isakpulkki/ot-harjoitustyo/releases/tag/viikko6)

[Vaatimusmäärittely](https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)


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
Ohjelman pystyy suorittamaan juurikansiossa komennolla

```
mvn compile exec:java -Dexec.mainClass=pong.Main
```
tai vaihtoehtoisesti ohjelmasta voi luoda .jar -tiedoston komennolla
```
mvn package
```

### Checkstyle

Checkstyle -tarkistukset suoritetaan komennolla


```
 mvn jxr:jxr checkstyle:checkstyle
```

### JavaDoc

JavaDoc saadaan generoitua komennolla

```
mvn javadoc:javadoc
```

