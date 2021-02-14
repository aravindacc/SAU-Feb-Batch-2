Use `Au Session`;

Show Tables
-- Executing Queries

-- Write a query to retrieve the most sold product per day in a specific location in the last week.
-- You can pick the location of your choice.

-- Find the last week, use where clause with location and purchased date within the last week,
-- group by products and count of products sold

Select DAYOFMONTH("2021-02-07");
-- 
-- SELECT
-- 	WEEK(date_of_purchase), WEEK(CURRENT_DATE) - 1
-- FROM
-- 	PurchaseSummary;

SELECT
	*
FROM
	PurchaseSummary
WHERE
	WEEK(date_of_purchase) = WEEK(NOW()) - 1;


SELECT
	pro.p_code,
	pro.p_name,
	joined.date_of_purchase,
	joined.total_units_sold,
	joined.total_times_sold,
	pro.category_assigned
FROM
	Product as pro
INNER JOIN (
	SELECT
		ps.product,
		ps.date_of_purchase,
		SUM(ps.no_of_units) as total_units_sold,
		Count(*) as total_times_sold,
		DENSE_RANK() OVER(PARTITION BY ps.date_of_purchase
	ORDER BY
		SUM(ps.no_of_units) DESC) d_rank
	FROM
		PurchaseSummary AS ps
	INNER JOIN SalesExecutive AS se ON
		se.employee_id = ps.sales_exec
	WHERE
		se.location = 1
		AND WEEK(ps.date_of_purchase) = WEEK(NOW()) - 1
	GROUP BY
		ps.product ,
		ps.date_of_purchase
	ORDER BY
		ps.date_of_purchase,
		SUM(ps.no_of_units) DESC) as joined ON
	joined.product = pro.p_code
where
	joined.d_rank = 1;


SELECT
	joined.date_of_purchase,
	Max(joined.total_units_sold)
FROM
	(
	SELECT
		ps.product,
		ps.date_of_purchase,
		SUM(ps.no_of_units) as total_units_sold,
		Count(*) as total_times_sold
	FROM
		PurchaseSummary AS ps
	INNER JOIN SalesExecutive AS se ON
		se.employee_id = ps.sales_exec
	WHERE
		se.location = 1
		AND WEEK(ps.date_of_purchase) = WEEK(NOW()) - 1
	GROUP BY
		ps.product ,
		ps.date_of_purchase
	ORDER BY
		ps.date_of_purchase,
		SUM(ps.no_of_units) DESC ) as joined
GROUP BY
	joined.date_of_purchase;




-- All Products Sold previous week at a particular location
SELECT
	*
FROM
	PurchaseSummary AS ps
INNER JOIN SalesExecutive AS se ON
	se.employee_id = ps.sales_exec
WHERE
	se.location = 1
	AND WEEK(ps.date_of_purchase) = WEEK(NOW()) - 1;


SELECT
	Count(*), Max(cumulative.no_od)
from
	(
	SELECT
		*
	FROM
		PurchaseSummary AS ps
	INNER JOIN SalesExecutive AS se ON
		se.employee_id = ps.sales_exec
	WHERE
		se.location = 1
		AND WEEK(ps.date_of_purchase) = WEEK(NOW()) - 1) as cumulative
GROUP BY cumulative.date_of_purchase, cumulative.product;
	

-- Main
SELECT
	ps.product, ps.date_of_purchase, SUM(ps.no_of_units) as total_units_sold, Count(*) as total_products_sold
FROM
	PurchaseSummary AS ps
INNER JOIN SalesExecutive AS se ON
	se.employee_id = ps.sales_exec
WHERE
	se.location = 1
	AND WEEK(ps.date_of_purchase) = WEEK(NOW()) - 1 
GROUP BY
	ps.product , ps.date_of_purchase;


-- Write a query to list all the salesperson's details along with the count
-- of products sold by them (if any) till the current date.

SELECT
	se.employee_id,
	se.name,
	se.gender,
	se.dob,
	se.mob_no,
	se.location,
	Count(ps.product) as total_product_sold
FROM
	SalesExecutive AS se
LEFT JOIN PurchaseSummary AS ps ON
	se.employee_id = ps.sales_exec
WHERE
	se.location = 1
GROUP BY
ps.product;






-- Write a query to list all the salesperson's details along with the count of products sold by them (if any) till the current date.

SELECT
	se2.employee_id,
	se2.name,
	se2.gender,
	se2.dob,
	se2.location,
	se2.mob_no,
	joined.total_products_sold
FROM
	SalesExecutive AS se2
INNER JOIN (
	SELECT
		se.employee_id,
		Count(*) AS total_products_sold
	FROM
		SalesExecutive AS se
	LEFT JOIN PurchaseSummary AS ps ON
		ps.sales_exec = se.employee_id
	GROUP BY
		se.employee_id) as joined ON
	se2.employee_id = joined.employee_id;



