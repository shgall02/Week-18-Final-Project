drop database IT_Inventory;
create database if not exists IT_Inventory;

use IT_Inventory;
drop table if exists Requests;
drop table if exists Computers;
drop table if exists Peripherals;
drop table if exists UserData;
drop table if exists RequestType;


create table UserData(
userId int unsigned not null auto_increment,
firstName varchar(20) not null,
lastName varchar(20) not null,
location varchar(20),
primary key (userId)
);

create table Computers(
compId int unsigned not null auto_increment,
userId int unsigned not null,
serviceTag varchar(30) not null,
make varchar(20) not null,
model varchar(30) not null,
expiration date not null,
primary key (compid),
foreign key (userId) references userData(userId) on delete cascade
);

create table Peripherals(
periphId int unsigned not null auto_increment,
userId int unsigned not null,
device varchar(20) not null,
make varchar(20) not null,
model varchar(30) not null,
primary key (periphId),
foreign key (userId) references userData(userId) on delete cascade
);

create table RequestType(
typeId int unsigned not null auto_increment,
typeName varchar(30) not null,
primary key(typeId) 
); 

create table Requests(
requestId int unsigned not null auto_increment,
userId int unsigned not null,
typeId int unsigned not null,
quantity int not null,
shipDate date not null,
receiveDate date null,
returnDate date null,
primary key (requestId),
foreign key (userId) references userData(userId) on delete cascade,
foreign key (typeId) references RequestType(typeId) on delete cascade
);

