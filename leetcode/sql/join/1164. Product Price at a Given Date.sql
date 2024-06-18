## 1) UNION ALL Divided case
SELECT
  product_id,
  10 AS price
FROM
  Products
GROUP BY
  product_id
HAVING
  MIN(change_date) > '2019-08-16'
UNION ALL
SELECT
  product_id,
  new_price AS price
FROM
  Products
WHERE
  (product_id, change_date) IN (
    SELECT
      product_id,
      MAX(change_date)
    FROM
      Products
    WHERE
      change_date <= '2019-08-16'
    GROUP BY
      product_id
  );

## JOIN ON -> DISTINCT FIRST_VALUE() OVER(,,,) :: Last changed rows before the given date
SELECT
  product_id,
  IFNULL (price, 10) AS price
FROM
  (
    SELECT DISTINCT
      product_id
    FROM
      Products
  ) AS UniqueProducts
  LEFT JOIN (
    SELECT DISTINCT
      product_id,
      FIRST_VALUE (new_price) OVER (
        PARTITION BY
          product_id
        ORDER BY
          change_date DESC
      ) AS price
    FROM
      Products
    WHERE
      change_date <= '2019-08-16'
  ) AS LastChangedPrice USING (product_id);

## Subquery -> ROW_NUMBER() OVER (,,,)
with interim as (
    select product_id,
    new_price as price,
    row_number() over (partition by product_id order by change_date desc) as row_num
    from products
    where change_date <= '2019-08-16'
)

select product_id,
price
from interim
where row_num = 1
UNION
select product_id, 10 as price
from products
where product_id not in (select distinct product_id from interim)
