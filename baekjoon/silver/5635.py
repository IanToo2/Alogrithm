n = int(input())
students = []

for _ in range(n):
    name, day, month, year = input().split()
    students.append((name, int(day), int(month), int(year)))

students.sort(key=lambda x: (x[3], x[2], x[1]))

oldest = students[0][0]
youngest = students[-1][0]

print(youngest)
print(oldest)
