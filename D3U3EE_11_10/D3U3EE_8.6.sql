CREATE DATABASE D3U3EE;
USE D3U3EE;
CREATE TABLE auto (tkod INT(3) PRIMARY KEY, nev VARCHAR(20) NOT NULL, varos CHAR(20));
insert into TULAJDONOS Values(101,'Kis János','Miskolc');
insert into TULAJDONOS Values(102,'Kis Éva','Szerencs');
insert into TULAJDONOS Values(103,'Retek Ödön','Miskolc');
insert into TULAJDONOS Values(104,'Virág Zoltán','Nyék');
insert into TULAJDONOS Values(105,'Nagy Eszter','Nyék');
insert into TULAJDONOS Values(106,'Kovács Magor','Szerencs');
insert into TULAJDONOS Values(107,'Asztal Antal','Miskolc');


CREATE table auto(
rendszam CHAR(7) PRIMARY KEY,
tipus VARCHAR(25) NOT NULL,
szin VARCHAR(15), kor INT(2),
ar INT(8),
tulaj INT(3),
FOREIGN KEY(tulaj) references tulajdonos(tkod) );


insert into auto VALUES('FER-831','Opel Corsa','Piros',18,390,1001);
insert into auto VALUES('IXL-239','Suzuki Swift','Zöld',15,450,1005);
insert into auto VALUES('JAH-425','Skoda Fabia','Piros',13,620,1002);
insert into auto VALUES('MLM-211','Toyota Yaris','Fehér',3,1850,1005);
insert into auto VALUES('KFT-204','Opel Astra','Szürke',7,1250,1006);
insert into auto VALUES('JCD-443','Opel Astra','Fehér',12,990,1007);
insert into auto VALUES('KAP-290','BMW 316','Fekete',6,3250,1002);
insert into auto VALUES('GDF-525','Renault Twingo','Fekete',16,280,NULL);
insert into auto VALUES('HUB-936','Suzuki Swift','Fekete',16,500,NULL);

