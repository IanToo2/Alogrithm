import sys
# 1km = 1L

# 변수 선언
city_count = int(input())
city_len = list(map(int, input().split()))
city_oil_cost = list(map(int, input().split()))
answer = 0

# 모든 도시의 오일 값이 동일한 경우
if sum(city_oil_cost) == city_count:
    answer += sum(city_len)
    print(answer)
    sys.exit()
    # 코드 종료 지점
# 1번 도시의 오일 값이 가장 저렴한 경우
if city_oil_cost[0] == min(city_oil_cost):
    answer += city_oil_cost[0]*sum(city_len)
    print(answer)
    sys.exit()
# 이중 배열로 데이터 정리
# list_city = []
# for i in range(city_count-1):
#     list_city.append([city_oil_cost[i],city_len[i] ])

check = 0
def del_data(city_oil_cost, city_len):

    del city_oil_cost[check]
    del city_len[check]

    return city_len, city_oil_cost

while True:
    # print("len count :",len(city_len))
    # print("answer :",answer)
    # print("now city_len :",city_len[check])
    if len(city_len) == 1:
        answer += city_oil_cost[check]*city_len[check]
        break
    else:
        if city_oil_cost[check] > city_oil_cost[check+1]:
            answer += city_oil_cost[check]*city_len[check]
            del_data(city_oil_cost, city_len)

        elif city_oil_cost[check] == city_oil_cost[check+1]:
            city_len[check] += city_len[check+1]
            del city_oil_cost[check+1]
            del city_len[check+1]

        elif city_oil_cost[check] < city_oil_cost[check+1]:
            city_len[check] += city_len[check+1]
            del city_oil_cost[check+1]
            del city_len[check+1]
print(answer)
# print("total answer :",answer)