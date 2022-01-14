CREATE TABLE SystemAdmin(
    sysadmin_name varchar(20),
    sysadmin_pass varchar(20)
);
CREATE TABLE Kullanici(
    userID Integer,
    firstName varchar(20),
    lastName varchar(20),
    userPass varchar(20),
    userAdress varchar(50)
);
ALTER TABLE Kullanici ADD (
CONSTRAINT kullanici_pk PRIMARY KEY (userID));

create sequence kullanici_seq start with 1 increment by 1 nomaxvalue;
create trigger kullanici_trigger
before insert on kullanici
for each row
   begin
     select kullanici_seq.nextval into :new.userID from dual;
   end;
   
CREATE TABLE Dergi(
    dergiID Integer,
    dergiAdi varchar(20),
    dergiYayin varchar(20),
    dergiISSN varchar(20),
    dergiYayinAra varchar(10)
);
ALTER TABLE Dergi ADD (
CONSTRAINT dergi_pk PRIMARY KEY (dergiID));

create sequence dergi_seq start with 1 increment by 1 nomaxvalue;

create trigger dergi_trigger
before insert on dergi
for each row
   begin
     select dergi_seq.nextval into :new.dergiID from dual;
   end;


CREATE TABLE Gazete (
    gazeteID Integer,
    gazeteAd varchar(20),
    gazeteDil varchar(20),
    gazeteYayinAra varchar(20)
);

ALTER TABLE Gazete ADD (
CONSTRAINT gazete_pk PRIMARY KEY (gazeteID));

create sequence gazete_seq start with 1 increment by 1 nomaxvalue;

create trigger gazete_trigger
before insert on gazete
for each row
   begin
     select gazete_seq.nextval into :new.gazeteID from dual;
   end;

CREATE TABLE Abonelik (
    aboneNO Integer,
    kullaniciID Integer,
    dergiID Integer,
    GazeteID Integer,
    onay varchar(20)
);
ALTER TABLE Abonelik ADD(
CONSTRAINT abonelik_pk PRIMARY KEY (aboneNO));
create sequence abonelik_seq start with 1 incremeent by 1 nomaxvalue;

create trigger abonelik_trigger
before insert on Abonelik
for each row
	begin
		select abonelik_seq.nextval into :new.aboneNO from dual;
        end;