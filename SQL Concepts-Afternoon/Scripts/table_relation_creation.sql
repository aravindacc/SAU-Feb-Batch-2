Use `Au Session`;

-- CREATION OF TABLES

-- Creating Category Table
CREATE table IF NOT EXISTS Category(
	c_code INT NOT NULL AUTO_INCREMENT,
	c_name VARCHAR(100) default NULL,
	PRIMARY KEY (c_code)
);

-- Creating Product table
CREATE table IF NOT EXISTS Product(
	p_code INT NOT NULL AUTO_INCREMENT,
	p_name VARCHAR(100) default NULL,
	unit_price DOUBLE(12,2) default 0.0,
	category_assigned INT Not Null,
	PRIMARY KEY (p_code),
	FOREIGN KEY (category_assigned) REFERENCES Category(c_code)
);

-- Creating Location
CREATE table IF NOT EXISTS Location(
	loc_code INT NOT NULL AUTO_INCREMENT,
	loc_name VARCHAR(100) default NULL,
	PRIMARY KEY (loc_code)
);

-- Creating SalesExecutive
CREATE table IF NOT EXISTS SalesExecutive(
	employee_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) default NULL,
	dob DATE NOT NULL,
	gender VARCHAR(20) NOT NULL,
	CHECK (gender IN('M', 'F', 'OTHERS')),
	mob_no BIGINT(10) NOT NULL,
	location INT NOT NULL,
	PRIMARY KEY (employee_id),
	FOREIGN KEY (location) REFERENCES Location(loc_code)
);

-- Creating Customer
CREATE table IF NOT EXISTS Customer(
	c_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) default NULL,
	dob DATE NOT NULL,
	gender VARCHAR(20) NOT NULL,
	CHECK (gender IN('M', 'F', 'OTHERS')),
	mob_no BIGINT(10) NOT NULL,
	PRIMARY KEY (c_id)
);

-- Creating PurchaseSummary
CREATE table IF NOT EXISTS PurchaseSummary(
	purchase_id INT NOT NULL AUTO_INCREMENT,
	sales_exec INT NOT NULL,
	product INT NOT NULL,
	customer INT NOT NULL,
	date_of_purchase DATE NOT NULL,
	no_of_units BIGINT NOT NULL,
	PRIMARY KEY (purchase_id),
	FOREIGN KEY (sales_exec) REFERENCES SalesExecutive(employee_id),
	FOREIGN KEY (product) REFERENCES Product(p_code),
	FOREIGN KEY (customer) REFERENCES Customer(c_id)
);
