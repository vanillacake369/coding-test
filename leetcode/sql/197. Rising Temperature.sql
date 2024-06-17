## 1) DATE_ADD
SELECT today.id
FROM Weather AS today
    INNER JOIN Weather AS yesterday
                ON DATE_ADD(yesterday.recordDate, INTERVAL 1 DAY) = today.recordDate
WHERE today.temperature > yesterday.temperature;

## 2) ON yesterday.id + 1 = today.id
# SELECT today.id AS today_id,
#        today.recordDate AS today_recordDate,
#        today.Temperature AS today_Temperature,
#        yesterday.id AS yesterday_id,
#        yesterday.recordDate AS yesterday_recordDate,
#        yesterday.Temperature AS yesterday_Temperature
#
# FROM Weather AS today
#             INNER JOIN Weather AS yesterday ON yesterday.id + 1 = today.id