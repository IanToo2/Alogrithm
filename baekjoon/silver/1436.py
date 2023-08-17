n = int(input())
aa = '666'

for i in range(len(aa)-2):

    if aa[i] == '6' and aa[i] == aa[i+1] and aa[i+1] == aa[i+2]:
        print(aa)

