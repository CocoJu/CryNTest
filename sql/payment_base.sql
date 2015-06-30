CREATE TABLE flats (
  id_flat INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  houses_id_house INTEGER UNSIGNED  NOT NULL  ,
  flat_adress INTEGER UNSIGNED  NULL  ,
  electrisity_balance INTEGER UNSIGNED  NULL  ,
  water_balance INTEGER UNSIGNED  NULL    ,
PRIMARY KEY(id_flat));



CREATE TABLE houses (
  id_house INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  adress VARCHAR(50)  NULL  ,
  count_floors INTEGER UNSIGNED  NULL    ,
PRIMARY KEY(id_house));



CREATE TABLE payments (
  id_payment INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  flats_id_flat INTEGER UNSIGNED  NOT NULL  ,
  date DATE  NOT NULL  ,
  electrisity_pay INTEGER UNSIGNED  NULL  ,
  water_pay INTEGER UNSIGNED  NULL    ,
PRIMARY KEY(id_payment));



CREATE TABLE people (
  id_people INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  flats_id_flat INTEGER UNSIGNED  NOT NULL  ,
  name_surname VARCHAR(100)  NULL    ,
PRIMARY KEY(id_people));



CREATE TABLE reciepts (
  id_reciept INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  flats_id_flat INTEGER UNSIGNED  NOT NULL  ,
  date DATE  NOT NULL  ,
  electricity_sum INTEGER UNSIGNED  NULL  ,
  water_sum INTEGER UNSIGNED  NULL    ,
PRIMARY KEY(id_reciept));



CREATE TABLE users (
  id_user INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  user_name VARCHAR(20)  NOT NULL  ,
  passwd VARCHAR(20)  NULL  ,
  role INTEGER UNSIGNED  NULL    ,
PRIMARY KEY(id_user));




