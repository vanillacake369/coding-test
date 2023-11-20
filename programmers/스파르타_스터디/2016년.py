def solution(a, b):
    cal = [31,29,31,30,31,30,31,31,30,31,30,31]
    date = ["THU","FRI","SAT","SUN","MON","TUE","WED"]
    days = 0
    for i in range(0,a-1):
        days += cal[i]
    return date[(days + b) % 7]
    

a = 5
b = 24
print(solution(a,b))