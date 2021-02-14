Use `Au Session`;

-- Executing Queries
-- Write a query to retrieve the most sold product per day in a specific location in the last week.

-- You can pick the location of your choice.

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

