-- Include table data insertion, updation, deletion and select scripts

USE truyum;

-- view menu item list admin

INSERT INTO `truyum`.`menu_item` VALUES 
(1,'Sandwich',99.00,'Yes','2017-03-15','Main Course','Yes'),
(2,'Burger',129.00,'Yes','2017-12-23','Main Course','No'),
(3,'Pizza','149.00','Yes','2017-08-21','Main Course','No'),
(4,'Freench Fries','57.00','No','2017-07-02','Starters','Yes'),
(5,'Chocolate Browine','32.00','Yes','2022-11-02','Dessert','Yes');

SELECT
`menu_item`.`me_id`,
`menu_item`.`me_name`,
`menu_item`.`me_price`,
`menu_item`.`me_active`,
`menu_item`.`me_date_of_launch`,
`menu_item`.`me_category`,
`menu_item`.`me_free_delivery`
FROM `truyum`.`menu_item`;


-- view menu item list customer

SELECT 
`menu_item`.`me_id`,
`menu_item`.`me_name`,
`menu_item`.`me_price`,
`menu_item`.`me_active`,
`menu_item`.`me_date_of_launch`,
`menu_item`.`me_category`,
`menu_item`.`me_free_delivery`
FROM `truyum`.`menu_item` 
WHERE me_date_of_launch <= curdate() 
AND me_active = 'Yes';


-- edit menu item

SELECT
`menu_item`.`me_id`,
`menu_item`.`me_name`,
`menu_item`.`me_price`,
`menu_item`.`me_active`,
`menu_item`.`me_date_of_launch`,
`menu_item`.`me_category`,
`menu_item`.`me_free_delivery`
FROM `truyum`.`menu_item`
WHERE me_id = 1;

UPDATE 
`truyum`.`menu_item`
SET
me_name = 'Spring roll', me_price = 149.00, 
me_active = 'Yes', me_date_of_launch = '2018-12-01', 
me_category = 'Main Course', me_free_delivery = 'Yes'
WHERE me_id = 1;


-- add to cart

INSERT INTO `truyum`.`user` 
VALUES (1,'Danny'),(2,'Conny');

SELECT * FROM `truyum`.`user`;

INSERT INTO `truyum`.`cart` 
VALUES (1,1,2),(2,1,4),(3,1,1);
INSERT INTO `truyum`.`cart`
(`ct_us_id`,
`ct_pr_id`)
VALUES
(1,2),(1,4),(1,1);


-- view cart

SELECT * FROM `truyum`.`cart`;

SELECT 
`menu_item`.`me_name`,
`menu_item`.`me_price`,
`menu_item`.`me_active`,
`menu_item`.`me_date_of_launch`,
`menu_item`.`me_category`,
`menu_item`.`me_free_delivery`
FROM `truyum`.`menu_item` 
JOIN `truyum`.`cart` c 
WHERE c.ct_pr_id = menu_item.me_id 
AND c.ct_us_id = 1;

SELECT sum(me_price) 
AS total 
FROM `truyum`.`menu_item` m 
JOIN `truyum`.`cart` c 
WHERE c.ct_pr_id = m.me_id 
AND c.ct_us_id = 1; 

-- remove item form cart

DELETE FROM `truyum`.`cart` 
WHERE ct_us_id = 1 
AND ct_pr_id = 2;


-- check


SELECT  `menu_item`.`me_name`, `menu_item`.`me_price`, `menu_item`.`me_active`, `menu_item`.`me_date_of_launch`, `menu_item`.`me_category`, `menu_item`.`me_free_delivery` 
FROM `truyum`.`menu_item` 
JOIN `truyum`.`cart`  
WHERE cart.ct_pr_id =`menu_item`.`me_id` AND cart.ct_us_id =1;

