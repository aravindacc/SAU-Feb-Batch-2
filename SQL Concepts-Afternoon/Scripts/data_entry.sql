Use `Au Session`;

-- Inserting into tables

-- Categories
 INSERT
	INTO
	Category (c_name)
VALUES 
	("Home Appliances"),
	("Office Goods"),
	("Kitchen"),
	("Sports");


-- Products
 INSERT
	INTO
	Product (p_name, unit_price, category_assigned)
VALUES 
	("Heater", 900.00, 1),
	("Table", 20900.45, 1),
	("Laptop", 300.56, 2),
	("Mouse", 890, 2),
	("Utencils", 1200.00, 3),
	("Gas Stove", 2200.45, 3),
	("Bat", 3300.56, 4),
	("Football", 8490, 4);


-- Location
 INSERT
	INTO
	Location (loc_name)
VALUES 
	("India"),
	("USA"),
	("Canada"),
	("Ontario"),
	("Indiana"),
	("America"),
	("Netherland"),
	("Morocco");


-- SalesExecutive
 INSERT
	INTO
	SalesExecutive (name, dob, gender, mob_no, location)
VALUES 
	("Abhik", "1998-07-07", "M", 7909948987, 1),
	("Ana", "1998-07-07", "F", 7909949834, 2),
	("Ishaan", "1998-07-07", "M", 7909944587, 3),
	("Lee", "1998-07-07", "F", 7909944387, 8),
	("Muskan", "1998-07-07", "F", 7909338987, 5),
	("Kiran", "1998-07-07", "M", 7909933987, 6),
	("Kishan", "1998-07-07", "M", 7909945687, 7),
	("Dinesh", "1998-07-07", "M", 7909942487, 2);


-- Customer
 INSERT
	INTO
	Customer (name, dob, gender, mob_no)
VALUES 
	("Abhikansh", "1998-07-07", "M", 9909948987),
	("Anamika", "1998-08-07", "F", 9909949834),
	("Haanik", "1998-08-07", "M", 9909944587),
	("Leela", "1998-01-07", "F", 9909944387),
	("Nivedita", "1995-07-07", "F", 9909338987),
	("Anant", "1998-05-07", "M", 9909933987),
	("Ajitesh", "1928-07-07", "M", 9909945687),
	("Ritwik", "1993-07-07", "M", 9909942487);


-- PurchaseSummary
 INSERT
	INTO
	PurchaseSummary (sales_exec, product, customer, date_of_purchase, no_of_units)
VALUES
	(3, 2, 2, "2021-02-06", 990329),
	(3, 2, 1, "2021-02-06", 992049),
	(3, 2, 2, "2021-02-06", 992309),
	(3, 1, 1, "2021-02-07", 9909),
	(3, 1, 2, "2021-02-07", 9909),
	(3, 2, 1, "2021-02-07", 99209),
	(3, 2, 2, "2021-02-07", 990329),
	(3, 2, 1, "2021-02-07", 992049),
	(3, 2, 2, "2021-02-07", 992309),
	(2, 2, 1, "2021-01-01",4587),
	(3, 3, 2, "2021-01-01", 4387),
	(4, 4, 3, "2021-02-01", 87),
	(5, 5, 4, "2021-02-02", 7),
	(5, 6, 5, "2021-02-02", 87),
	(6, 4, 6, "2021-02-02", 87),
	(7, 5, 1, "2021-01-01", 687),
	(8, 2, 7, "2021-01-01", 487),
	(7, 7, 8, "2021-02-01", 99),
	(8, 8, 1, "2021-01-01", 990);

