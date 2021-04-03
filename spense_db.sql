CREATE TABLE users (
id integer primary key not null AUTO_INCREMENT,
first_name varchar(20) not null,
last_name varchar(20) not null,
email varchar(30) not null,
password text not null
);

CREATE TABLE categories (
id integer primary key not null AUTO_INCREMENT,
user_id integer not null,
title varchar(20) not null,
description text not null
);

ALTER TABLE categories ADD CONSTRAINT cat_users_fk
FOREIGN KEY (user_id) REFERENCES users(id);

CREATE TABLE transactions(
id integer primary key not null AUTO_INCREMENT,
category_id integer not null,
user_id integer not null,
amount numeric(10,2) not null,
note varchar(50) not null,
transaction_date bigint not null
);

ALTER TABLE transactions ADD CONSTRAINT trans_cat_fk
FOREIGN KEY (category_id) REFERENCES categories(id);

ALTER TABLE transactions ADD CONSTRAINT trans_users_fk
FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE users AUTO_INCREMENT = 100;
ALTER TABLE categories AUTO_INCREMENT = 1;
ALTER TABLE transactions AUTO_INCREMENT = 1000;