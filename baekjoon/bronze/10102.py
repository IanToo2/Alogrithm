V = int(input())
투표 = str(input())
투표리스트 = list(투표)

count_a = 0
count_b = 0

for i in range(len(투표리스트)):
    if(투표리스트[i] == "A"):
        count_a+=1
    else:
        count_b+=1

if(count_a > count_b):
    print("A")
elif(count_a<count_b):
    print("B")
else:
    print("Tie")