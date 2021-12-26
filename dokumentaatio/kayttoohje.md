# Käyttöohje

Lataa tiedosto [pong_3.0.jar](https://github.com/isakpulkki/ot-harjoitustyo/releases/tag/loppupalautus)

## Ohjelman käynnistäminen

Ohjelma käynnistetään seuraavalla komennolla

```
java -jar pong3.0.jar
```

## Päävalikko

Peliä pääsee pelaamaan painamalla valikossa 'Pelaa' -nappia, pelin asetuksia pääsee säätämään painamalla 'Asetukset' -nappia ja pelistä voi poistua painamalla 'Poistu' -nappia.

<img align="center" src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/menu.png" width="400">

## Pelinäkymä

Painettuasi 'Pelaa' -nappia pitäisi avautua vastaava näkymä

![Start](https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/start.png)

Peliä pelaa siis kaksi henkilöä, kontrolloiden pelaajansa ruudulla näkyvillä näppäimillä, osuessa palloon pelaajalla pallo kimpoaa vastakkaiseen suuntaan riippuen pelaajan kulmasta palloa kohden

![Start](https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/pause.png)

Jomman kumman pelaajan tehdessä pisteen peli keskeytyy kunnes jotain näppäintä painetaan, peli pelataan oletuksena kymmeneen pisteeseen, mutta tätä voi muuttaa config.properties -tiedostosta

![Win](https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/win.png)

Pelaajan saavuttaessa pisterajan pelaaja voittaa, pelaajien pisteet nollautuu ja peli palaa aloitusnäkymään
## Sulkeminen

'Poistu' -napista voi sulkea pelin, tai vaihtoehtoisesti ruksia painamalla.

