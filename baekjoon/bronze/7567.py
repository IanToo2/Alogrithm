높이 = 0

그릇모양 = list(input())
for i in range(len(그릇모양)):
    if i == 0:
        높이 += 10
    else:
        if 그릇모양[i-1] == 그릇모양[i]:
            높이 += 5
        else:
            높이 += 10
print(높이)