-- NORTHWIND

-- What are the categories of products in the database?
SELECT distinct category FROM products;

-- What products are made by Dell?
SELECT * FROM products WHERE product_name = 'Dell Inspirion';

-- List all the orders shipped to Pennsylvania.
SELECT * FROM orders WHERE ship_state = 'Pennsylvania';

-- List the first name and last name of all employees with last names that start with w.
SELECT first_name, last_name FROM employees WHERE last_name LIKE 'W%';

-- List all customers from zipcodes that start with 55
SELECT * FROM customers WHERE postal_code LIKE '55%';

-- List all customers from zipcodes that end with 0.
SELECT * FROM customers WHERE postal_code LIKE '%0';

-- List the first name, last name, and email for all customers with a .org email address
SELECT first_name, last_name, email FROM customers WHERE email LIKE '%.org';

-- List the first name, last name, and phone number for all customers from the 202 area code
SELECT first_name, last_name, phone FROM customers WHERE phone LIKE '%202%';

-- List the order id for each order placed by George Wilson
SELECT orders.id FROM orders 
INNER JOIN customers ON orders.customer_id = customers.id 
WHERE customers.last_name = 'WiLson' AND customers.first_name='George';

-- List all the products and quantities associated with order 4003
SELECT products.product_name, order_details.quantity FROM products 
INNER JOIN order_details ON order_details.product_id = products.id 
INNER JOIN orders ON order_details.order_id = orders.id
WHERE orders.id = 4003;


-- CAR_LOT

/*
Add the following cars to inventory:
	2012 Red Honda Accord
	2017 Black Chevy Impala
	2019 Siver Ford F-150
	2020 White Subaru Outback
	2015 Silver Ford Mustang
	2018 Blue Honda Ridgeline
	2017 Gray Chevy Silverado
*/

INSERT INTO car_lot.car(id, make, model, model_year, color) 
values(1, 'Honda', 'Accord', '2012', 'Red'),
(2, 'Chevy', 'Impala', '2017', 'Black'),
(3, 'Ford', 'F-150', '2019', 'Silver'),
(4, 'Subaru', 'Outback', '2020', 'White'),
(5, 'Ford', 'Mustand', '2015', 'Silver'),
(6, 'Honda', 'Ridgeline', '2018', 'Blue'),
(7, 'Chevy', 'Silverado', '2017', 'Grey');

-- Make the following updates to the database:

-- Change all Hondas to Black
update car_lot.car set model_year = '2019' where model_year = '2020';

-- Change 'Chevy' to 'Chevrolet'
update car set make = "Chevrolet" where make = "Chevy";

-- Change all 2020 model years to 2019
update car set color = 'Black' where make = 'Honda';

-- Delete all blue inventory
delete from car where color = 'blue';

-- Delete all Fords
delete from car where make = 'Ford';

-- Delete all cars from 2012 and 2017
delete from car where model_year = '2012' or model_year = '2017';

select * from car;
