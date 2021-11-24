CREATE TABLE  "LOGO" 
   (	"SZIN" VARCHAR2(20), 
	"KESZITESIDATUM" DATE, 
	"STILUS" VARCHAR2(10), 
	"TERVEZO" VARCHAR2(50), 
	"CID" NUMBER(*,0)
   )

CREATE TABLE  "CEG" 
   (	"CID" NUMBER(*,0), 
	"TULAJDONOS" VARCHAR2(50), 
	"ALAPITASIDATUM" DATE, 
	"ELERHETOSEG" VARCHAR2(50), 
	"TELEPHELY" VARCHAR2(20), 
	 PRIMARY KEY ("CID")
  USING INDEX  ENABLE
   )

CREATE TABLE  "DIAK" 
   (	"IGAZOLVANYSZAM" NUMBER(*,0), 
	"NEME" NUMBER(1,0), 
	"HOBBY" VARCHAR2(20), 
	 PRIMARY KEY ("IGAZOLVANYSZAM")
  USING INDEX  ENABLE
   )

CREATE TABLE  "DIAKIGAZOLVANY" 
   (	"NEV" VARCHAR2(50), 
	"SZULETESIDATUM" DATE, 
	"MUNKAREND" VARCHAR2(15), 
	"KARTYASZAM" NUMBER(*,0), 
	"INTEZMENY" VARCHAR2(50), 
	"IGAZOLVANYSZAM" NUMBER(*,0)
   )

CREATE TABLE  "DSZ" 
   (	"ROKON" VARCHAR2(10), 
	"DIAKIGAZOLVANY" NUMBER(*,0), 
	"SZID" NUMBER(*,0)
   )

CREATE TABLE  "ESZKOZ" 
   (	"EID" NUMBER(*,0), 
	"GARANCIADATUM" DATE, 
	"MENNYISEG" NUMBER(*,0), 
	"AR" NUMBER(*,0), 
	"KIADASIDATUM" DATE, 
	 PRIMARY KEY ("EID")
  USING INDEX  ENABLE
   )

CREATE TABLE  "ORA" 
   (	"FOGLALKOZAS" VARCHAR2(20), 
	"KEZDETIDATUM" DATE, 
	"VEGZESIDATUM" DATE, 
	"TID" NUMBER(*,0), 
	"SZID" NUMBER(*,0), 
	"EID" NUMBER(*,0)
   )

CREATE TABLE  "SZERZODES" 
   (	"ALAIRASDATUM" DATE, 
	"LEJARTIDATUM" DATE, 
	"SZID" NUMBER(*,0), 
	"TID" NUMBER(*,0), 
	"CID" NUMBER(*,0)
   )

CREATE TABLE  "SZULO" 
   (	"SZID" NUMBER(*,0), 
	"IRSZ" NUMBER(*,0), 
	"VAROS" VARCHAR2(20), 
	"UTCA" VARCHAR2(30), 
	"HAZSZAM" VARCHAR2(5), 
	 PRIMARY KEY ("SZID")
  USING INDEX  ENABLE
   )

CREATE TABLE  "TANAR" 
   (	"TID" NUMBER(*,0), 
	"NEV" VARCHAR2(50), 
	"VEGZETTSEG" VARCHAR2(15), 
	"ADOSZAM" NUMBER(*,0), 
	"KOR" NUMBER(*,0), 
	 PRIMARY KEY ("TID")
  USING INDEX  ENABLE
   )

CREATE TABLE  "TULAJDONOS" 
   (	"TKOD" NUMBER(*,0), 
	"NEV" VARCHAR2(20) NOT NULL ENABLE, 
	"VAROS" CHAR(20), 
	 PRIMARY KEY ("TKOD")
  USING INDEX  ENABLE
   )

