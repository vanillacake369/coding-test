"""
Follow up: Could you solve it without converting the integer to a string?
"""


class Solution(object):
    def isPalindrome(self, x):
        # initial check : negative cannot be palindrome
        if (x <0):
            return False
        reversedX = 0
        temp = x

        # make reversed number of x, using loop by // 10
        while(temp != 0):
            digit = temp % 10
            reversedX = reversedX * 10 + digit
            print("digit : " + str(digit))
            print("reversedX : " + str(reversedX))
            temp = temp // 10
            print("temp : "+str(temp))

        # check reversedXX 
        return (reversedX == x)

solution_instance = Solution()

result = solution_instance.isPalindrome(1001)  # Example input value
# result = solution_instance.isPalindrome(10)  # Example input value
# result = solution_instance.isPalindrome(12321)  # Example input value

print(result)
