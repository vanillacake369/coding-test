def solution(priorities, location):
    answer = 0
    priorities_location = {idx: p for idx, p in enumerate(priorities)}
    sorted_priorities_location = dict(
        sorted(
            priorities_location.items(),
            key=lambda x: (x[1], list(priorities_location.keys()).index(x[0])),
            reverse=True,
        )
    )
    print(sorted_priorities_location)
    print(list(sorted_priorities_location.keys()))
    answer = list(sorted_priorities_location.keys()).index(location) + 1
    return answer


# ---
# p = [2, 1, 3, 2]
# l = 2
p = [1, 1, 9, 1, 1, 1]
l = 0
result = solution(p, l)
print(result)
