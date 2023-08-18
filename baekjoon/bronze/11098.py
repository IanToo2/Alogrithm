n = int(input())
while n>0:
    maxcost = 0
    player = []
    p = int(input())
    
    for i in range(p):
        player.append(list(input().split()))
        if int(player[i][0]) > maxcost:
            maxcost = int(player[i][0])
    
    for i in range(p):
        if int(player[i][0]) == maxcost:
            print(player[i][1])
    
    n -=1