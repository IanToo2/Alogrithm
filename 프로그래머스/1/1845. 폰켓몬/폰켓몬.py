def solution(nums):
    answer = 0
    num = len(set(nums))
    count = len(nums)//2
    
    answer = min(num,count)
            
    return answer