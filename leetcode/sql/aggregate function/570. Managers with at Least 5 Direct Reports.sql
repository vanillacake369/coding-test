SELECT a.name
FROM employee as a
         JOIN (SELECT managerId, COUNT(1) as cnt
               FROM employee
               GROUP BY managerid) AS b
              ON a.id = b.managerId
WHERE b.cnt >= 5