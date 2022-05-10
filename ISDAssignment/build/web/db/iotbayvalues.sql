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
VALUES ('David','Frisken','M','david.frisken@uts.com','0499999999','01/01/1990');
INSERT INTO iotadmin.STAFF_USER(STAFFID, PASSWORD, STAFF_ROLE)
VALUES ((SELECT USERID FROM iotadmin.USERS WHERE EMAILADDRESS = 'david.frisken@uts.com'),'12345','SYSTEM ADMIN');
-- INSERT INTO iotadmin.ORDERS(tracking_number, arrival_date, order_date, order_status)
-- VALUES ('123','01/01/1990','01/01/1990','01/01/1990', 'Yes');

