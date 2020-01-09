create database IF NOT EXISTS localtest;

use localtest;

create table IF NOT EXISTS users
(
 id int auto_increment,
 primary key(id)
);