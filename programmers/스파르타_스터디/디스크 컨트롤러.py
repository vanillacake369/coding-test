def solution(jobs):
    answer = 0
    sortedJobs = sorted(jobs, key=lambda x: x[1])
    jobsLength = len(jobs)

    now = 0
    while sortedJobs:
        for j in jobs:
            if j[0] <= now:
                now += j[1]
                answer += now - j[0]
                sortedJobs.pop()
                break
            else:
                now += 1

    return answer // jobsLength


jobs = [[0, 3], [1, 9], [2, 6]]
result = solution(jobs)
print(result)
