## Vaatimusmäärittely

## Sovelluksen tarkoitus

Tällä sovelluksella käyttäjät voivat pelata 'Pong' -videopeliä. Tämä peli on pöytätenniksen tapainen kaksinpeli, johon tarvitsee kaksi pelaajaa. Peliin mahdollisesti tulee myös sisältymään mahdollisuus tietokonetta vastaan pelaamiseen, jos resurssit riittää. 


## Käyttöliittymäluonnos
<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/5be0e73879f20b9a7a443c59c075d37190eb3dbd/dokumentaatio/images/luonnos.jpg" width="600">

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
- pelin voittaa tietyssä pistemäärässä <em>tehty</em>
- pelissä omat näkymät aloitukselle, pisteen saamiselle ja voittamiselle <em>tehty</em>
- pallo kimpoaa loogisesti pallon ja pelaajan sijaintien mukaan <em>tehty</em>
- pääsee takaisin valikkoon ESC-napista <em>tehty</em>

### Asetusnäkymä

- asetusnäkymässä pelaaja voi muuttaa pallon kokoa <em>tehty</em>
- asetusnäkymässä pelaaja voi muuttaa pelin vaikeustasoa, joka määrittelee pallon nopeuden <em>tehty</em>
- asetusnäkymässä pelaaja voi muuttaa pelaajan leveyttä <em>tehty</em>
- pääsee takaisin päävalikkoon napista <em>tehty</em>
- asetukset tallenetaan tietokantaan jolloin ne pysyy myös seuraavalla pelikerralla <em>tehty</em>

