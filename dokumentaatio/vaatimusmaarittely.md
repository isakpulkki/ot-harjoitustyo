## Vaatimusmäärittely

## Sovelluksen tarkoitus

Tällä sovelluksella käyttäjät voivat pelata 'Pong' -videopeliä. Tämä peli on pöytätenniksen tapainen kaksinpeli, johon tarvitsee kaksi pelaajaa. Peliin mahdollisesti tulee myös sisältymään mahdollisuus tietokonetta vastaan pelaamiseen, jos resurssit riittää. 


## Käyttöliittymäluonnos
<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/20211115_202200.jpg?raw=true" width="750">
Peli aukeaa päävalikkonäkymään, josta voi siirtyä pelinäkymään, asetusnäkymään tai poistua pelistä.

## Perusversion tarjoama toiminnallisuus

### Pelinäkymä

- pelissä kaksi pelaajaa käyttää kahta näppäintä kontrolloidakseen hahmoaan, siirtämällä tätä ylös tai alas 
- pelin pallo lähtee keskeltä sattumanvaraiseen suuntaan, vasemmalle tai oikealle
- pelin pallon osuessa näkymän vasempaan tai oikeaan reunaan vastapuolella oleva hahmo saa pisteen
- pelaajan osuessa hahmollaan palloon, pallo kiihtyy vastakkaiseen suuntaan vihollista kohti
- pisteet kirjataan yläreunaan

## Asetusnäkymä

- asetusnäkymässä pelaaja voi muuttaa pelin vaikeustasoa, joka määrittelee pallon nopeuden
- voi valita pelin äänet päälle/pois
- asetuksiin voisi tehdä lisämahdollisuuksia kustomisoida peliä, esim. valita pelin väriteeman

## Jatkokehitysideoita

- peli voisi mahdollisesti sisältää pelialustalla ilmestyvän esineen, johon osuessa saat hetkellisesti hahmosi reunat kasvamaan pitemmiksi, antaen etulyöntiaseman
- tietokantaan/tiedostoon tallennetaan asetusnäkymästä asetukset, jotka ladataan pelin käynnistyessä
