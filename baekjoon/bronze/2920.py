a = list(map(int, input().split()))
answer = ""
for i in range(len(a)):
    if i == 0 and 2<a[0]<7:
        answer = "mixed"
        break
    elif i > 0:
        if a[i-1] == a[i] +1:
            answer = "descending"
        elif a[i-1] == a[i]-1:
            answer = "ascending"
        else:
            answer = "mixed"
            break

print(answer)