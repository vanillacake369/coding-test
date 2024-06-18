## 1) DATE_ADD
SELECT today.id
FROM Weather AS today
    INNER JOIN Weather AS yesterday
                ON DATE_ADD(yesterday.recordDate, INTERVAL 1 DAY) = today.recordDate
WHERE today.temperature > yesterday.temperature;

## 2) LAG() && CTE
/*
We use a Lag() function to access previous rows data as per defined offset value.
It is a window function available from SQL Server 2012 onwards.

eg
SELECT *,
       Lag(JoiningDate, 1) OVER(.
       ORDER BY JoiningDate ASC) AS EndDate
FROM @Employee;
*/
WITH PreviousWeatherData AS
(
    SELECT
        id,
        recordDate,
        temperature,
        LAG(temperature, 1) OVER (ORDER BY recordDate) AS PreviousTemperature,
        LAG(recordDate, 1) OVER (ORDER BY recordDate) AS PreviousRecordDate
    FROM
        Weather
)
SELECT
    id
FROM
    PreviousWeatherData
WHERE
    temperature > PreviousTemperature
AND
    recordDate = DATE_ADD(PreviousRecordDate, INTERVAL 1 DAY);

## 3) Subquery
SELECT
    w1.id
FROM
    Weather w1
WHERE
    w1.temperature > (
        SELECT
            w2.temperature
        FROM
            Weather w2
        WHERE
            w2.recordDate = DATE_SUB(w1.recordDate, INTERVAL 1 DAY)
    );

## 4) Using Cartesian Product and WHERE Clause
SELECT
    w2.id
FROM
    Weather w1, Weather w2
WHERE
    DATEDIFF(w2.recordDate, w1.recordDate) = 1
AND
    w2.temperature > w1.temperature;