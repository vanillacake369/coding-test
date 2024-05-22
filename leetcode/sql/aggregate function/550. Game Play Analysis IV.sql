WITH cte_login AS (SELECT player_id
                        , DATEDIFF(event_date, MIN(event_date) OVER (PARTITION BY player_id)) = 1 as login
                   FROM activity) -- 1
SELECT ROUND(SUM(login) / COUNT(DISTINCT player_id), 2) as fraction
FROM cte_login
-- 2

# 1. INNER QUERY
# : 최초 로그인한 날 MIN(event_date) 과 다음 로그인 한 날이 연속으로 있는지를 알아보기 두 날짜의 차이가 1인 행을 찾아야한다. (DATEDIFF)
# 2. OUTER QUERY
# : player_id별로 로그인 여부를 파악해야 하므로 PARTITION BY를 사용해준다. (GROUP BY를 해버리면 최초 또는 최대의 날짜밖에 구하지 못한다)