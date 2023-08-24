def solution(my_string, overwrite_string, s):
    answer = my_string[:s] + overwrite_string + my_string[s+len(overwrite_string):]
    return answer

my_string = input()
overwrite_string = input()
s = int(input())

print(solution(my_string,overwrite_string,s))