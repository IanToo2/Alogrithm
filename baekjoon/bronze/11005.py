import string

N, B = map(int, input().split())

answer = string.digits+string.ascii_uppercase

def convert(N, M) :
    data, result = divmod(N, M)
    if data == 0 :
        return answer[result] 
    else :
        return convert(data, M) + answer[result]

print(convert(N,B))