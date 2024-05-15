class Solution:
    def minPartitions(self, n: str) -> int:
        # get max from each digit
        maxDigit = int(max(n))
        return maxDigit


print(Solution.minPartitions(Solution, "82734"))
print(Solution.minPartitions(Solution, "27346209830709182346"))
