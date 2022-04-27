/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  navid
 * Created: 19/04/2022
--  */
begin;

create table users (
    userID integer primary key not null generated always as identity(start with 1, increment by 1),
    firstname varchar(20) not null,
    lastname varchar(20) not null, 
    middlename varchar(20),
    emailadress varchar(80) not null,
    phone varchar(20) not null,
    dob date not null,
    username varchar(15)
);


create table customer_user(
    userID integer primary key,
    streetnum varchar(10),
    streetname varchar(30),
    suburb varchar(50),
    postcode varchar(6),
    states varchar(10),
    country varchar(20),
    cvc integer,
    cardnum varchar(16),
    expirydate date, 
    password varchar(30) not null,
    disabled boolean,
    foreign key (userID) references users(userID)
    
);

create table staff_user (
    userID integer primary key not null,
    role varchar(20) not null,
    password varchar(30) not null,
    foreign key (userID) references users(userID)
);




commit;