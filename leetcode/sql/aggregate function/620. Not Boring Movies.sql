SELECT
    *
FROM
    Cinema
WHERE
    id % 2 = 1
    And
    description NOT LIKE 'boring'
ORDER BY
    rating DESC
