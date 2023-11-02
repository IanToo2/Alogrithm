def two_recursive(two, n):
    if n%2 != 0 or n == 1:
        return two

    n = n//2
    two += 1
    return two_recursive(two, n)

def three_recursive(three, n):
    if n%3 != 0 or n == 1:
        return three

    n = n//3
    three += 1
    return three_recursive(three, n)

def five_recursive(five, n):
    if n%5 != 0 or n == 1:
        return five

    n = n//5
    five += 1
    return five_recursive(five, n)

def seven_recursive(seven, n):
    if n%7 != 0 or n == 1:
        return seven

    n = n//7
    seven += 1
    return seven_recursive(seven, n)

def ele_recursive(ele, n):
    if n%11 != 0 or n == 1:
        return ele

    n = n//11
    ele += 1
    return ele_recursive(ele, n)

T = int(input())
cnt = 0
while cnt < T:
    n = int(input())

    two = three = five = seven = ele = 0

    two = two_recursive(two, n)
    three = three_recursive(three, n)
    five = five_recursive(five, n)
    seven = seven_recursive(seven, n)
    ele = ele_recursive(ele, n)
    print("#{}".format(cnt+1), end = " ")
    print(two, three, five, seven, ele)

    cnt += 1
