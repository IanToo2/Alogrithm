t = int(input())

a = 0

for i in range(t):
    school, apple = map(int, input().split())
    a += apple%school
print(a)
