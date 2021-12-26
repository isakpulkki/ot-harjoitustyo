<h1>Arkkitehtuuri</h2>
### Rakenne

Sovelluksen pakkausrakenne on seuraava

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/5be0e73879f20b9a7a443c59c075d37190eb3dbd/dokumentaatio/images/packages.png" width="600">

Sovellus on jaettu omiin pakkauksiin tietokantaa ja konfiguraatiota säätelevään pakkaukseen, pelilogiikan pakkauksen, asetuslogiikan pakkaukseen, käyttöliittymän pakkaukseen ja utiliteettien pakkaukseen.

### Luokkakaavio
Tässä sovelluksen toimintaa kuvaava luokkakaavio

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/5be0e73879f20b9a7a443c59c075d37190eb3dbd/dokumentaatio/images/uml.png" width="600">

Luokkakaaviosta näkee, että kaikki luokat ovat riippuvaisia Config-luokasta. Config-luokka määrittelee jokaisen näkymän leveyden, korkeuden ja muita ominaisuuksia. Käyttöliittymäluokkien väliset riippuvuudet kuvaa eri näkymistä siirtymistä toisiin näkymiin. Asetuslogiikka päivittää tietokantaa. Pelin grafiikka ja logiikka ovat riippuvaisia toisistaan, sillä logiikka kertoo grafiikalle mitä piirtää.

### Sekvenssikaavio

Tämä sekvenssikaavio kuvaa ohjelman toimintaa käyttäjän syötteiden käsittelyyn

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/sekvenssikaavio.png" width="750">

