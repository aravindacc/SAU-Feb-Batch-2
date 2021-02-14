Use `Au Session`;

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
	
