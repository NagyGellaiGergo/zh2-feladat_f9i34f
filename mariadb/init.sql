CREATE DATABASE zh2_database;
GRANT ALL PRIVILEGES ON zh2_database.* to 'zh2_user';

CREATE TABLE zh2_database.food (
                     ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                     restaurant_name varchar(255),
                     food_name varchar(255),
                     price varchar(255)
);

CREATE TABLE zh2_database.user (
                      ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      username varchar(255) NOT NULL UNIQUE,
                      password varchar(100) NOT NULL
);

CREATE TABLE zh2_database.role (
                      ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      code varchar(255) NOT NULL UNIQUE,
                      description varchar(255)
);

create table zh2_database.user_role (
                           user_id int,
                           role_id int,
                           PRIMARY KEY (user_id, role_id),
                           FOREIGN KEY (user_id) REFERENCES user(id),
                           FOREIGN KEY (role_id) REFERENCES role(id)
);

insert into zh2_database.food (restaurant_name, food_name, price) values ("Finom étterem", "Rántott hús", "2500");
insert into zh2_database.food (restaurant_name, food_name, price) values ("Finom étterem", "Marhapörkölt", "3000");
insert into zh2_database.food (restaurant_name, food_name, price) values ("Finomabb étterem", "Húsleves", "1800");
insert into zh2_database.food (restaurant_name, food_name, price) values ("Finomabb étterem", "Lasagne", "3000");
insert into zh2_database.food (restaurant_name, food_name, price) values ("Gyors kajálda", "Hamburger", "2900");

insert into zh2_database.role (code, description) values ("user", "Use the web app.");
insert into zh2_database.role (code, description) values ("creator", "Has right to create new objects.");

insert into zh2_database.user (username, password) values ("user1", "$2a$06$qkg0bF5ZbgNHj/ichvlAWepmKgJjguwGq1E//xVIS5O687BxMh5T.");
insert into zh2_database.user (username, password) values ("user2", "$2a$06$qkg0bF5ZbgNHj/ichvlAWepmKgJjguwGq1E//xVIS5O687BxMh5T.");

insert into zh2_database.user_role (user_id, role_id) values ((select id from zh2_database.user where username = "user1"), (select id from zh2_database.role where code = "user"));
insert into zh2_database.user_role (user_id, role_id) values ((select id from zh2_database.user where username = "user2"), (select id from zh2_database.role where code = "user"));
insert into zh2_database.user_role (user_id, role_id) values ((select id from zh2_database.user where username = "user2"), (select id from zh2_database.role where code = "creator"));
