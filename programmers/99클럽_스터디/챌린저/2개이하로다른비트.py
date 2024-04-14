# 직접 변환해보며 짝수와 홀수에 대한 패턴을 찾아보면 풀 수 있는 문제,,,

def solution(numbers):
    answer = []
    for number in numbers:
        bin_number = list('0' + bin(number)[2:])
        idx = ''.join(bin_number).rfind('0')
        bin_number[idx] = '1'

        if number % 2 == 1:
            bin_number[idx + 1] = '0'

        answer.append(int(''.join(bin_number), 2))
    return answer


print(solution(numbers=[2, 7]))
