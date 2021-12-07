## Vaatimusmäärittely

## Sovelluksen tarkoitus

Tällä sovelluksella käyttäjät voivat pelata 'Pong' -videopeliä. Tämä peli on pöytätenniksen tapainen kaksinpeli, johon tarvitsee kaksi pelaajaa. Peliin mahdollisesti tulee myös sisältymään mahdollisuus tietokonetta vastaan pelaamiseen, jos resurssit riittää. 


## Käyttöliittymäluonnos
<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/5be0e73879f20b9a7a443c59c075d37190eb3dbd/dokumentaatio/images/luonnos.jpg" width="750">
Peli aukeaa päävalikkonäkymään, josta voi siirtyä pelinäkymään, asetusnäkymään tai poistua pelistä.

## Perusversion tarjoama toiminnallisuus

### Valikkonäkymä

- sisältää pelin logon <em>tehty</em>
- tästä pääsee pelinäkymään, asetusnäkymään tai poistumaan sovelluksesta <em>tehty</em>

### Pelinäkymä

- pelissä kaksi pelaajaa käyttää kahta näppäintä kontrolloidakseen hahmoaan, siirtämällä tätä ylös tai alas <em>tehty</em>
- pelin pallo lähtee keskeltä sattumanvaraiseen suuntaan, vasemmalle tai oikealle <em>tehty</em>
- pelin pallon osuessa näkymän vasempaan tai oikeaan reunaan vastapuolella oleva hahmo saa pisteen <em>tehty</em>
- pelaajan osuessa hahmollaan palloon, pallo kiihtyy vastakkaiseen suuntaan vihollista kohti <em>tehty</em>
- pisteet kirjataan yläreunaan <em>tehty</em>
- pääsee takaisin valikkoon ESC-napista <em>tehty</em>

### Asetusnäkymä

- asetusnäkymässä pelaaja voi muuttaa pelin vaikeustasoa, joka määrittelee pallon nopeuden
- voi valita pelin äänet päälle/pois
- pääsee takaisin päävalikkoon napista <em>tehty</em>
- asetuksiin voisi tehdä lisämahdollisuuksia kustomisoida peliä, esim. valita pelin taustavärin tai koon

## Jatkokehitysideoita

- peli voisi mahdollisesti sisältää pelialustalla ilmestyvän esineen, johon osuessa saat hetkellisesti hahmosi reunat kasvamaan pitemmiksi, antaen etulyöntiaseman
- tietokantaan/tiedostoon tallennetaan asetusnäkymästä asetukset, jotka ladataan pelin käynnistyessä
