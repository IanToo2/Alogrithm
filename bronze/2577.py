a = int(input())
b = int(input())
c = int(input())
abc = list(str(a*b*c))
listabc = [0 for x in range(10)]
for i in range(len(abc)):
    listabc[int(abc[i])] +=1

print(*listabc, sep="\n")