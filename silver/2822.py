a = []

for i in range(8):
    a.append(int(input()))

sumvalue = 0
asorted = sorted(a)
aindex = []
for i in range(len(a)-1, len(a)-6,-1):
    sumvalue += asorted[i]
    aindex.append(a.index(asorted[i])+1)

print(sumvalue)
print(*sorted(aindex))