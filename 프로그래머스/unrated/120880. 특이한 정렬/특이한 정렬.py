def solution(numlist, n):
    answer = []
    result_dict = {num: num - n for num in numlist}

    # 절대값과 키 값 크기를 기준으로 딕셔너리를 정렬합니다.
    sorted_result = dict(sorted(result_dict.items(), key=lambda x: (abs(x[1]), -x[0])))

    for key in sorted_result:
        answer.append(key)
    return answer