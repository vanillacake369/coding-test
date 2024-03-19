class Solution(object):
    def isPalindrome(self, x):
        if x < 0:
            return False

        # make list from x, and pointer of front,back
        x_list = list(map(int, str(x)))
        pointerFront = (len(x_list) // 2) - 1
        pointerBack = 0

        # even length
        if len(x_list) % 2 == 0:
            pointerBack = len(x_list) // 2
        # odd length
        else:
            pointerBack = (len(x_list) // 2) + 1

        while pointerBack <= len(x_list) - 1 and pointerFront >= 0:
            if x_list[pointerFront] != x_list[pointerBack]:
                return False
            pointerBack += 1
            pointerFront -= 1

        return True


solution_instance = Solution()

result = solution_instance.isPalindrome(1001)  # Example input value
# result = solution_instance.isPalindrome(10)  # Example input value
# result = solution_instance.isPalindrome(12321)  # Example input value

print(result)
