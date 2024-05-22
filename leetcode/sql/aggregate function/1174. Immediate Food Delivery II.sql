select round(avg(order_date = customer_pref_delivery_date) * 100, 2) AS immediate_percentage
from Delivery
         join
     (select customer_id, MIN(order_date) AS order_date
      from Delivery
      group by customer_id) a
     using
         (customer_id, order_date);