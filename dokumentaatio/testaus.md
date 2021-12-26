## Testausdokumentti

Sovelluksen testaus tapahtuu automatisoiduin yksikkö- ja integraatiotestein JUnit -kirjastoa hyödyntäen. Testit eivät ole riippuvaisia JavaFX:stä.

## Yksikkö- ja integraatiotestaus

Testit ovat luokiteltu samannimisiin paketteihin ja luokkiin kuin sovellus.

### Pelilogiikka

Pelilogiikkaa testaavat integraatiotestit *GameLogicTest* ja *BallTest* Joiden testitapaukset testaavat laajasti logiikkaa, mm. pelaajan liikkumista, pisteiden keräämistä ja pallon toimintaa osuessaan reunoihin.
Asetuslogiikkaa testaa *SettingsLogicTest*. Logiikan testit testaavat samalla myös tietokannan toimintaa, jonka johdosta tietokannalle ei luotu erillisiä testejä.

### Testauskattavuus
Kaikkia luokkia jotka eivät ole riippuvaisia JavaFX:stä on testattu, eli kaikki käyttöliittymästä poisluetut luokat on testattu. Testien rivikattavuus on 81%.

<img src="https://github.com/isakpulkki/ot-harjoitustyo/blob/master/dokumentaatio/images/tests.png" width=400>

## Järjestelmätestaus

Peliä on testattu Windows 11:ssa, Cubblissa ja Ubuntussa, ja sovellus toimii kaikissa käyttöjärjestelmissä. Peliä testatessa törmäsin ongelmiin mp3 -tiedostojen soittamisessa Cubblissa, 
josta ilmeisesti puuttuu koodekkeja joita JavaFX:n mediasoitin tarvitsee. Kokeiltu myös päivittää JavaFX:n versiota ilman muutosta tuohon, ja lopulta päädyin vain poistamaan tuon soittimen.

## Sovellukseen jääneet laatuongelmat
Sovellus toimii täydellisesti Windowsissa, mutta Cubblissa ja Ubuntussa ajaessa sovelluksessa pieni bugi, missä asetusvalikon viimeisen liukusäätimen viimeinen nimike puuttuu.
