# 핵심 포인트 : In-Place alg 사용!
# 투 포인터를 사용
# -> 각 원소 포인터(for loop 의 i), 중복제거 수의 위치 포인터(j)
class Solution(object):
    def removeDuplicates(self, nums):
        j = 0
        for i in range(1, len(nums)):
            if nums[j] != nums[i]:
                j += 1
                nums[j] = nums[i]
        return j + 1

        # 2) Two pointers with detail
        # slow, fast = 0, 1
        # while fast in range(len(nums)):
        # 	if nums[slow] == nums[fast]:
        # 		fast += 1
        # 	else:
        # 		nums[slow+1] = nums[fast]
        # 		fast += 1
        # 		slow += 1
        # return slow + 1

        # 3) Using pop()
        # i = 1
        # while i < len(nums):
        # 	if nums[i] == nums[i - 1]:
        # 		nums.pop(i)
        # 	else:
        # 		i += 1
        # return len(nums)


Solution().removeDuplicates([1, 2, 3, 4, 4, 3, 2, 1])
