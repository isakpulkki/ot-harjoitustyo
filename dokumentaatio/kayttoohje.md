# Käyttöohje

Lataa tiedosto [pong_3.0.jar](https://github.com/isakpulkki/ot-harjoitustyo/releases/tag/loppupalautus)

## Ohjelman käynnistäminen

Ohjelma käynnistetään seuraavalla komennolla

```
java -jar pong3.0.jar
```

## Päävalikko

Peliä pääsee pelaamaan painamalla valikossa 'Pelaa' -nappia, pelin asetuksia pääsee säätämään painamalla 'Asetukset' -nappia ja pelistä voi poistua painamalla 'Poistu' -nappia.

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/menu.png" width="400">

## Pelinäkymä

Painettuasi 'Pelaa' -nappia pitäisi avautua vastaava näkymä

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/start.png" width="400">

Peliä pelaa siis kaksi henkilöä, kontrolloiden pelaajansa ruudulla näkyvillä näppäimillä, osuessa palloon pelaajalla pallo kimpoaa vastakkaiseen suuntaan riippuen pelaajan kulmasta palloa kohden.

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/paused.png" width="400">

Jomman kumman pelaajan tehdessä pisteen peli keskeytyy kunnes jotain näppäintä painetaan, peli pelataan oletuksena kymmeneen pisteeseen, mutta tätä voi muuttaa config.properties -tiedostosta.

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/win.png" width="400">

Pelaajan saavuttaessa pisterajan pelaaja voittaa, pelaajien pisteet nollautuu ja peli palaa aloitusnäkymää. Vaihtoehtoisesti päävalikkoon voi palata ESC-näppäimestä.

## Asetusnäkymä

'Asetukset' -nappia painettuasi vastaavan näkymän pitäisi avautua

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/settings.png" width="400">

Asetuksissa voi säätää kuvassa näkyviä asetuksia, jotka myös tallentuvat tietokantaan jolloin asetukset säilyvät myös pelin sammutettuasi.

