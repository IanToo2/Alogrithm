T = int(input())
Yes=0
No=0
for i in range(T):
   test = int(input())
   if(test == 0):
    No+=1
   elif(test == 1):
    Yes+=1
if No>Yes:
  print("Junhee is not cute!")
elif Yes>No:
  print("Junhee is cute!")