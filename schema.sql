create database imarket default charset='utf8';
create user imarket@'%' identified by 'imarket365';
grant all on imarket.* to imarket@'%';

use imarket;
create table member(
  id       serial,
  name     varchar(100),
  email    varchar(100) unique not null,
  password varchar(2048) not null
);
