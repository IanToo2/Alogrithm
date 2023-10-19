from collections import deque
n = int(input())

while n != 0:
    s = input()
    q = deque(s)

    # 초기 검사
    if len(q) % 2 != 0 or q[0] == ')' or q[-1] == '(':
        print("NO")
    else:
        # 데이터 확인
        left_count = right_count = 0
        result = 0
        while len(q) != 0:
            if q[0] == '(':
                q.popleft()
                left_count += 1
            else:
                q.popleft()
                right_count += 1

            if left_count < right_count:
                result = 0
                break

            result = 1

        if result == 1 and left_count == right_count:
            print("YES")
        else:
            print("NO")

    n -= 1
