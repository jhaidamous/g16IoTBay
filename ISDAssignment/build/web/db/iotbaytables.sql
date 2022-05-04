/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  navid
 * Created: 19/04/2022
--  */
create table users (
    userID integer primary key not null generated always as identity(start with 1, increment by 1),
    firstname varchar(20) not null,
    lastname varchar(20) not null, 
    middlename varchar(20),
    emailadress varchar(80) unique not null,
    phone varchar(20) not null,
    dob date not null,
    username varchar(15)
);

create table customer_user(
    custID integer primary key not null,
    password varchar(30) not null,
    disabled boolean,
    foreign key (custID) references users(userID)
);

create table payment_details (
    custID integer not null,
    pay_det_num integer not null,
    cvc integer not null,
    cardnum varchar(16) not null,
    expirydate date not null, 
    foreign key (custID) references customer_user(custID),
    primary key(custID, pay_det_num)
);

create table shipment_details (
    custID integer primary key not null,
    streetnum varchar(10),
    streetname varchar(30),
    suburb varchar(50),
    postcode varchar(6),
    states varchar(10),
    country varchar(20),
    foreign key (custID) references customer_user(custID)
);


create table staff_user (
    userID integer primary key not null,
    staff_role varchar(20) not null,
    password varchar(30) not null,
    foreign key (userID) references users(userID)
);

create table user_zlogs (
    userID integer not null,
    logDate date not null,
    logTime time not null,
    message varchar(100),
    primary key(userID, logDate, logTime)
);


-- create table guest_user (
--     userID integer primary key not null,
--     guest_address varchar(100),
--     guest_street_number varchar(10),
--     guest_street_name varchar(30),
--     guest_suburb varchar(50),
--     guest_post_code varchar(6),
--     guest_state varchar(10),
--     guest_country varchar(20),
--     foreign key (userID) references users(userID)
-- );

create table cart (
    cartID integer primary key not null generated always as identity(start with 1, increment by 1),
    total_items float,
    shipping_price float,
    custID integer not null,
    foreign key (custID) references customer_user(custID)
);

create table orders (
    orderID integer primary key not null generated always as identity(start with 1, increment by 1),
    tracking_number integer,
    arrival_date date,
    order_date date,
    order_status varchar(15),
    custID integer not null,
    cartID integer not null,
    foreign key (custID) references customer_user(custID),
    foreign key (cartID) references cart(cartID)
);

create table notification (
    notificationID integer primary key not null generated always as identity(start with 1, increment by 1),
    notif_type varchar(25),
    notif_status varchar(15),
    orderID integer not null,
    foreign key (orderID) references orders(orderID)
);

create table catalog_item (
    itemID integer primary key not null generated always as identity(start with 1, increment by 1),
    item_name varchar(150) not null,
    item_price float,
    item_stock integer,
    item_status varchar(20),
    cost_per_item float,
    item_category varchar(20),
    item_image_path varchar(100)
);

create table payment (
    paymentID integer primary key not null generated always as identity(start with 1, increment by 1),
    payment_error varchar(20),
    payment_status varchar(20),
    paymentDate date,
    orderID integer not null,
    foreign key (orderID) references orders(orderID)
);

create table line_item (
    lineID integer primary key not null generated always as identity(start with 1, increment by 1),
    itemID integer not null,
    item_quantity integer,
    cartID integer not null,
    foreign key (itemID) references catalog_item(itemID),
    foreign key (cartID) references cart(cartID)
);
