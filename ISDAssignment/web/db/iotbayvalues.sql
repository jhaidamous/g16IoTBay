/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  JHUTS
 * Created: 02/05/2022
 */

INSERT INTO iotadmin.catalog_item(item_name,item_price,item_stock,item_status,cost_per_item,item_category,item_image_path)
VALUES ('Open/Close Detection Door Sensor',149,10,'In Stock',70,'Sensors','images/items/doorsensor.png'),
       ('9-IN-1 Compact Weather Sensor',2499,10,'In Stock',1500,'Sensors','images/items/weathersensor.png'),
       ('Raspberry Pi 4 With Display Kit',349,10,'In Stock',200,'IOT Board','images/items/raspberrykit.png'),
       ('Industrial IOT Mini-Computer Based on Raspberry Pi 4',115,10,'In Stock',50,'IOT Board','images/items/industrialpi.png');

INSERT INTO iotadmin.USERS(FIRSTNAME, LASTNAME, MIDDLENAME, EMAILADDRESS, PHONE, DOB)
VALUES ('John','Smith','M','john.smith@uts.com','0499999999','01/01/1990');
INSERT INTO iotadmin.CUSTOMER_USER(CUSTID, PASSWORD, DISABLED)
VALUES ((SELECT USERID FROM iotadmin.USERS WHERE EMAILADDRESS = 'john.smith@uts.com'),'pass123',false);

INSERT INTO iotadmin.USERS(FIRSTNAME, LASTNAME, MIDDLENAME, EMAILADDRESS, PHONE, DOB)
VALUES ('David','Frisken','M','david.frisken@uts.com','0499999999','01/01/1990'),
       ('Jake','Doe','H','jake.doe@uts.com','0499999999','01/01/1990');
INSERT INTO iotadmin.STAFF_USER(STAFFID, PASSWORD, STAFF_ROLE)
VALUES ((SELECT USERID FROM iotadmin.USERS WHERE EMAILADDRESS = 'david.frisken@uts.com'),'12345','SYSTEM ADMIN'),
       ((SELECT USERID FROM iotadmin.USERS WHERE EMAILADDRESS = 'jake.doe@uts.com'),'12345','IoTBay Staff');

-- Building Dummy Carts for John Smith, adding items to 2 orders..
INSERT INTO iotadmin.cart(custID)
VALUES (1),
       (1);
INSERT INTO iotadmin.line_item(itemID, item_quantity, cartID)
VALUES (1, 2, 1),
       (2, 1, 1),
       (3, 1, 2),
       (4, 3, 2);
INSERT INTO iotadmin.ORDERS(order_date, order_status, custID, cartID)
VALUES ('2022-01-01', 'Completed', 1, 1),
       ('2022-05-01', 'Completed', 1, 2);
INSERT INTO iotadmin.payment_details(custID, cvc, cardnum, expirydate)
VALUES (1, 123, '5593898162202088','2024-05-01'),
       (1, 455, '5593898162202066','2026-05-01');
INSERT INTO iotadmin.payment(payment_error, payment_status, payment_date, pay_det_num, custID, orderID)
VALUES ('None', 'Successful', '2022-01-01', 1, 1, 1),
       ('Card Declined', 'Failed', '2022-05-01', 1, 1, 2),
       ('None', 'Successful', '2022-05-02', 2, 1, 2);

-- INSERT INTO iotadmin.USERS(FIRSTNAME, LASTNAME, MIDDLENAME, EMAILADDRESS, PHONE, DOB)
-- VALUES ;
-- INSERT INTO iotadmin.STAFF_USER(STAFFID, PASSWORD, STAFF_ROLE)
-- VALUES ;
