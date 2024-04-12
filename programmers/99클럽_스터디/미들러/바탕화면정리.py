def solution(wallpaper):
    answer = []
    minRow = len(wallpaper)
    minColumn = len(wallpaper[0])
    maxRow = 0
    maxColumn = 0

    for i in range(len(wallpaper)):  # row
        for j in range(len(wallpaper[i])):  # column
            if (wallpaper[i][j] == '#'):
                minRow = min(minRow, i)
                minColumn = min(minColumn, j)
                maxRow = max(maxRow, i)
                maxColumn = max(maxColumn, j)
    maxRow += 1
    maxColumn += 1
    return [minRow, minColumn, maxRow, maxColumn]


# print(solution([".#...", "..#..", "...#."]))
# print(solution(["..........", ".....#....", "......##..", "...##.....", "....#....."]))
# print(solution([".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."]))
print(solution(["..", "#."]))
