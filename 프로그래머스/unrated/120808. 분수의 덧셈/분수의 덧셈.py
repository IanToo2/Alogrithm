def find_gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def solution(numer1, denom1, numer2, denom2):
    # 분모를 통일하기 위해 최소공배수(LCM)를 계산
    lcm = (denom1 * denom2) // find_gcd(denom1, denom2)
    
    # 두 분수를 통일된 분모로 변환
    new_numer1 = numer1 * (lcm // denom1)
    new_numer2 = numer2 * (lcm // denom2)
    
    # 분자를 더하고 분모는 그대로 사용
    result_numer = new_numer1 + new_numer2
    result_denom = lcm
    
    # 결과의 분자와 분모의 최대공약수를 구하고, 기약 분수로 만듭니다.
    common_factor = find_gcd(result_numer, result_denom)
    result_numer //= common_factor
    result_denom //= common_factor
    
    return [result_numer, result_denom]
