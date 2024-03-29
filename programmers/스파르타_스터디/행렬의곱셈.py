def solution(arr1, arr2):
    r1, c1 = len(arr1), len(arr1[0])
    r2, c2 = len(arr2), len(arr2[0])

    result = [[0] * c2 for _ in range(0, r1)]

    # arr1 의 각 행과 arr2 의 각 열에 대해
    for i in range(0, r1):
        for j in range(0, c2):
            # 두 행렬의 데이터를 곱한 결과를 더해줌
            for k in range(0, c1):
                result[i][j] += arr1[i][k] * arr2[k][j]

    return result