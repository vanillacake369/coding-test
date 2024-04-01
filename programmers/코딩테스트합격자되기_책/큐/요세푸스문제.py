n = int(input())
k = int(input())

perm = []
eliminated = []

now = 0
for i in range(n):
    count = 0
    while count < k:
        if not now in eliminated:
            count += 1
        if count < k:
            now = (now + 1) % n
    perm.append(now + 1)
    eliminated.append(now)

print(perm)
