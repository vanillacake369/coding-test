"""
Follow up: Could you solve it without converting the integer to a string?
"""


class Solution(object):
    def isPalindrome(self, x):
        # initial check : negative, single digit
        if x < 0 or (x != 0 and x % 10 == 0):
            return False

        reversedX = 0
        temp = x

        # make reversed number of x, using loop by // 10
        while x > reversedX:
            reversedX = reversedX * 10 + temp % 10
            print("temp % 10 : " + str(temp % 10))
            print("reversedX : " + str(reversedX))
            temp = temp // 10
            print("temp : " + str(temp))

        # check reversedX
        return reversedX == x


solution_instance = Solution()

result = solution_instance.isPalindrome(121)  # Example input value
# result = solution_instance.isPalindrome(1001)  # Example input value
# result = solution_instance.isPalindrome(10)  # Example input value
# result = solution_instance.isPalindrome(12321)  # Example input value

print(result)
