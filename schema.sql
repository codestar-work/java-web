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

create table topic(
  id       serial,
  user     bigint,
  title    varchar(1000),
  detail   varchar(10000),
  photo    varchar(1000)
);

-- alter table topic add photo varchar(1000);
