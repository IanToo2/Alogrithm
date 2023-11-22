t = int(input())

for i in range(t):

    main_cost = int(input())

    option_cnt = int(input())

    for i in range(option_cnt):
        cnt, cost = map(int, input().split())
        main_cost += cnt * cost
    print(main_cost)

