def solution(array):
    answer = 0
    sorted_arr = sorted(array)
    answer=sorted_arr[int((len(array))/2)]
    return answer