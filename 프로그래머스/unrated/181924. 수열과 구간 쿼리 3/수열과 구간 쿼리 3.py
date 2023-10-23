def solution(arr, queries):
    answer = []
    print(arr)
    for i in queries:
        
#         start = arr.index(i[0])
#         end = arr.index(i[1])
#         print("queries : {}".format(i))
#         print("start : {} end: {}".format(start,end))
#         arr[start], arr[end] =arr[end], arr[start]
#         print(arr)
        arr[i[0]] , arr[i[1]] = arr[i[1]] , arr[i[0]]
    answer = arr
    return answer