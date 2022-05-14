**HealthCare
Egy program mely a páciensek adatait tárolja és végzi el a felhasználó által kért változtatásokat.
Mik ezek?
- A páciens felvétele az adatbázisba
- A páciens törlése az adatlistából
- A páciens már meglévő adatainak módosítás

Mindezen funckiók elérésére a grafikus felületünkön keresztűl van mód. 

Fontos(!!!): A "Test" file futtatása ( hiszen ebből fogja betölteni/létrehozni az xml fileunkat), aztán pedig a HealthCare file futtatása, ami megnyitja a grafikus felületet


Maga a grafikus panel magyarázata:
Egy előre meghatározott, a kipróbálást megkönnyítő XML fájlunk betöltése (load XML), melyben 3 előre elkészített tesztpáciens található.
A betöltés után a legördülő panellel válthatunk a különböző adatok között.
A save XML file gomb a kódban található patient.xml fájlba elmenti az adatokat.
A következő rész a páciens adatai: ehhez tartozik egy ID (alapramértezett helyzetben ez egy 9 számból álló kombináció, a TAJ kártyákhoz hasonló elképzelés szüleménye)
A kereszt- és a vezetéknév, születésének időpontja, magassága,vércsoportja és jelenlegi státusza ( aktív beteg, nem aktív beteg). Az alatta lévő Note ablakba pedig speciális adatokat adhatunk meg.
Jobb oldalon a funkciók fentről lefelé a következők: új páciens megadása, meglévő páciens adatainak átírása, páciens törlése az adatbázisból,a páciens adatainak törlése.
Alul a message rublika pedig kiírja az aktuális folyamatot, ezzel is könnyítve a program használatát. Amint rámegyünk a save xml gombra, az adatokat elmentjük a fent már előre meghatározott xml fájlba. 



(Alul a listázásra kattintva pedig a páciensek adatait tekinthetjük meg lebontva, a fenti kritériumoknak megfelelően. - legalábbis ez lett volna az elképzelés, de sajnos a megjelenítés nem működött megfelelően, ugyanis csak az alap 3 páciensüket sorolta fel. )  
