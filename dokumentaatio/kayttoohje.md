# Käyttöohje

Lataa tiedosto [pong_3.0.jar](https://github.com/isakpulkki/ot-harjoitustyo/releases/tag/loppupalautus)

## Ohjelman käynnistäminen

Suoritetaan Linuxissa komennolla
```
java -jar pong3.0_linux.jar
```
tai Windowsissa
```
java -jar pong3.0_windows.jar
```

Pelin konfiguraatiota voi muokata lähdekoodissa tiedostossa
```
\src\main\resources\config.properties
```

## Päävalikko

Peliä pääsee pelaamaan painamalla valikossa 'Pelaa' -nappia, pelin asetuksia pääsee säätämään painamalla 'Asetukset' -nappia ja pelistä voi poistua painamalla 'Poistu' -nappia.

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/menu.png" width="600">

## Pelinäkymä

Painettuasi 'Pelaa' -nappia pitäisi avautua vastaava näkymä

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/start.png" width="600">

Peliä pelaa siis kaksi henkilöä, kontrolloiden pelaajansa ruudulla näkyvillä näppäimillä, osuessa palloon pelaajalla pallo kimpoaa vastakkaiseen suuntaan riippuen pelaajan kulmasta palloa kohden.

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/paused.png" width="600">

Jomman kumman pelaajan tehdessä pisteen peli keskeytyy kunnes jotain näppäintä painetaan, peli pelataan oletuksena kymmeneen pisteeseen, mutta tätä voi muuttaa config.properties -tiedostosta.

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/win.png" width="600">

Pelaajan saavuttaessa pisterajan pelaaja voittaa, pelaajien pisteet nollautuu ja peli palaa aloitusnäkymää. Vaihtoehtoisesti päävalikkoon voi palata ESC-näppäimestä.

## Asetusnäkymä

'Asetukset' -nappia painettuasi vastaavan näkymän pitäisi avautua

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/settings.png" width="600">

Asetuksissa voi säätää kuvassa näkyviä asetuksia, jotka myös tallentuvat tietokantaan jolloin asetukset säilyvät myös pelin sammutettuasi.

