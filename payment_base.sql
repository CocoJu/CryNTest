CREATE TABLE houses (
  id_house INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  house_adress VARCHAR(50)  NULL    ,
PRIMARY KEY(id_house));



CREATE TABLE users (
  id_user INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  user_name VARCHAR(20)  NULL  ,
  passwd VARCHAR(20)  NULL    ,
PRIMARY KEY(id_user));



CREATE TABLE flats (
  id_flat INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  houses_id_house INTEGER UNSIGNED  NOT NULL  ,
  flat_adress INTEGER UNSIGNED  NULL  ,
  electrisity_balance INTEGER UNSIGNED  NULL  ,
  water_balance INTEGER UNSIGNED  NULL    ,
PRIMARY KEY(id_flat)  ,
INDEX flats_FKIndex1(houses_id_house),
  FOREIGN KEY(houses_id_house)
    REFERENCES houses(id_house)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE payments (
  id payment INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  flats_id_flat INTEGER UNSIGNED  NOT NULL  ,
  date DATE  NULL  ,
  electrisity_pay INTEGER UNSIGNED  NULL  ,
  water_pay INTEGER UNSIGNED  NULL    ,
PRIMARY KEY(id payment)  ,
INDEX payments_FKIndex1(flats_id_flat),
  FOREIGN KEY(flats_id_flat)
    REFERENCES flats(id_flat)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE reciepts (
  id_reciept INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  flats_id_flat INTEGER UNSIGNED  NOT NULL  ,
  date DATE  NULL  ,
  electricity_sum INTEGER UNSIGNED  NULL  ,
  water_sum INTEGER UNSIGNED  NULL    ,
PRIMARY KEY(id_reciept)  ,
INDEX reciepts_FKIndex1(flats_id_flat),
  FOREIGN KEY(flats_id_flat)
    REFERENCES flats(id_flat)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE people (
  id_people INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  flats_id_flat INTEGER UNSIGNED  NOT NULL  ,
  name_surname VARCHAR(100)  NULL    ,
PRIMARY KEY(id_people)  ,
INDEX people_FKIndex1(flats_id_flat),
  FOREIGN KEY(flats_id_flat)
    REFERENCES flats(id_flat)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);




