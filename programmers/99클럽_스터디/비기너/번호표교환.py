N, M = map(int, input().split(' '))
num_ticket = []
for i in range(N):
    num_ticket.append(int(input()))
for i in range(1, M + 1):
    for index in range(1, len(num_ticket)):
        if num_ticket[index - 1] % i > num_ticket[index] % i:
            num_ticket[index - 1], num_ticket[index] = num_ticket[index], num_ticket[index - 1]
for num in num_ticket:
    print(num)
