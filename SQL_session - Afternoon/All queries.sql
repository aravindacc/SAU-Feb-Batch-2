# Creating tables

create table salesExecutive(
ID int not null auto_increment,
Name varchar(40) not null,
MobileNo int(10),
Gender varchar (20),
DOB date,
primary key(ID));



create table customers(
ID int not null auto_increment,
Name varchar(40) not null,
MobileNo int(10),
Gender varchar (20),
DOB date,
Location_code varchar(20),
primary key(ID));


create table products(
Code int not null,
Name varchar(40) not null,
PricePerUnit float,
ProductCategoryCode varchar (20),
primary key(Code));


create table location(
Code varchar(20) not null,
Name varchar(40) not null,
primary key(Code));


create table productCategory(
Code varchar(20) not null,
Name varchar(40) not null,
primary key(Code));


create table sells(
ProductCode int not null,
SalesExecutiveId int not null
);

create table soldAt(
ProductCode int not null,
LocationCode varchar(20) not null
);


create table sellsTo(
CustomerID int not null,
SalesExecutiveID int not null
);



create table sellsAt(
SalesExecutiveId int not null,
LocationCode varchar(20) not null
);

create table Buys(
ProductCode int not null,
CustomerID int not null,
No_of_Units int default 0,
Date_of_Purchase date
);


# Inserting into tables

insert into sellsto (CustomerID, SalesExecutiveID)
values
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(2, 1),
(2, 2),
(3, 5),
(3, 6),
(9, 1),
(10, 1),
(4, 1),
(5, 1),
(8, 1),
(4, 3),
(2, 6),
(5, 5),
(3, 6),
(10, 6),
(8, 5),
(3, 4),
(5, 4),
(10, 4),
(8, 4);


insert into buys (ProductCode, CustomerID, No_of_Units, Date_of_Purchase)
values
(1, 1, 4, '2021-02-01'),
(2, 1, 8, '2021-02-01'),
(13, 1, 2, '2021-02-03'),
(3, 4, 6, '2021-02-08'),
(3, 5, 4, '2021-02-03'),
(12, 10, 4, '2021-02-08'),
(13, 2, 4, '2021-01-22'),
(2, 5, 6, '2021-02-08'),
(1, 1, 4, '2021-02-08'),
(3, 3, 3, '2021-01-13'),
(1, 1, 4, '2021-02-06'),
(1, 1, 4, '2021-02-07'),
(2, 6, 6, '2021-02-09'),
(1, 1, 4, '2021-02-10'),
(4, 7, 8, '2021-02-05'),
(7, 3, 9, '2021-02-02'),
(5, 6, 4, '2021-01-06'),
(5, 2, 8, '2021-01-07'),
(1, 1, 2, '2021-01-01'),
(3, 10, 4, '2021-01-02'),
(4, 3, 1, '2021-01-09'),
(7, 9, 2, '2021-01-10'),
(9, 8, 8, '2021-01-07'),
(12, 5, 20, '2021-01-07');


insert into soldat (ProductCode, LocationCode)
values 
(1, 'BLR'),
(2, 'BLR'),
(12, 'BLR'),
(5, 'BLR'),
(9, 'BLR'),
(3, 'MUM'),
(2, 'MUM'),
(12, 'MUM'),
(13, 'MUM'),
(8, 'KP'),
(7, 'KP'),
(6, 'KP'),
(4, 'KP'),
(10, 'DLI'),
(12, 'DLI'),
(11, 'DLI'),
(2, 'DLI'),
(12, 'LKO'),
(13, 'LKO'),
(9, 'LKO'),
(10, 'LKO'),
(11, 'LKO'),
(3, 'LKO'),
(4, 'LKO'),
(5, 'LKO');



insert into sellsat (SalesExecutiveId, LocationCode)
values 
(1, 'BLR'),
(1, 'HYD'),
(2, 'DLI'),
(2, 'KP'),
(2, 'LKO'),
(3, 'MUM'),
(3, 'KP'),
(4, 'BLR'),
(4, 'MUM'),
(4, 'DLI'),
(5, 'KP'),
(5, 'DLI'),
(5, 'LKO'),
(6, 'MUM');

insert into sells (ProductCode, SalesExecutiveId)
values 
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(2, 1),
(2, 2),
(3, 5),
(3, 6),
(12, 1),
(11, 1),
(4, 1),
(5, 1),
(8, 1),
(12, 2),
(11, 2),
(10, 3),
(4, 3),
(12, 5),
(11, 6),
(2, 6),
(5, 5),
(3, 6),
(12, 6),
(10, 6),
(8, 5),
(3, 4),
(5, 4),
(12, 4),
(11, 4);



ALTER TABLE products 
ADD FOREIGN KEY (ProductCategoryCode) REFERENCES productcategory(Code);


insert into customers values (
1, 'Kishan', 836830155, 'Male', '1999-11-06', 'LKO');


insert into customers values (
10, 'Shobhit', 785169111, 'Male', '1998-07-16', 'MUM');




insert into salesexecutive (ID, Name, MobileNo, Gender, DOB)
values 
(1, 'Arjun', 151515511, 'Male', '1991-07-16'),
(2, 'Vishwas', 986532172, 'Male', '1990-05-12'),
(3, 'Rishabh', 789631453, 'Male', '1987-04-11'),
(4, 'Sonkar', 456987123, 'Male', '1992-02-08'),
(5, 'Tushar', 986532147, 'Male', '1996-06-19'),
(6, 'Lakshya', 741852963, 'Male', '1989-05-28');


insert into location (Code, Name)
values ('MUM', 'Mumbai'),
('BLR', 'Bangalore'),
('LKO', 'Lucknow'),
('KP', 'Kanpur'),
('HYD', 'Hyderabad'),
('DLI', 'Delhi');

insert into productcategory (Code, Name)
values ('PR01', 'Grain Products'),
('PR02', 'Bread'),
('PR03', 'Rolls'),
('PR04', 'Cakes'),
('PR05', 'Cookies');

insert into products (Code, Name, PricePerUnit, ProductCategoryCode)
values ('2', 'Rice', 60, 'PR01'),
('3', 'Oats', 30, 'PR01'),
('4', 'White Bread', 25, 'PR02'),
('5', 'Whole-Wheat Bread', 50, 'PR02'),
('6', 'sesame roll', 80, 'PR03'),
('7', 'cinnamon roll', 100, 'PR03'),
('8', 'hamburger bun', 90, 'PR03'),
('9', 'hot dog bun', 60, 'PR03'),
('10', 'chocolate cake', 660, 'PR04'),
('11', 'coffee cake', 800, 'PR04'),
('12', 'crackers', 60, 'PR05'),
('13', 'biscuits', 20, 'PR05');




# Query 2 : DISPLAYING THE MOST SOLD PRODUCT PER DAY IN THE LAST WEEK IN BANGALORE
# LOCATION CODE FOR BANGALORE IS BLR

select prod.Name as Most_Sold_Product, max(No_of_Units) as Number_of_Units, 
Date_of_Purchase, LocationCode from products prod
inner join buys b on prod.Code = b.ProductCode 
inner join soldat s on b.ProductCode = s.ProductCode 
where Date_of_Purchase between '2021-02-01' and '2021-02-07'
and LocationCode = 'BLR' group by Date_of_Purchase ;


#Query 3 : DISPLAYING THE LIST OF ALL SALESPERSON'S DETAILS ALONG WITH THE COUNT OF PRODUCTS SOLD BY THEM TILL DATE

select salesman.Name, salesman.ID, salesman.MobileNo, salesman.DOB, count(*) as No_of_products_sold from salesexecutive salesman
	inner join sells s on s.SalesExecutiveId = salesman.ID 
	inner join buys b on b.ProductCode = s.ProductCode 
	group by SalesExecutiveId ;
