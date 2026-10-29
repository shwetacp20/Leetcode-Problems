class Solution:
    def numIdenticalPairs(self, nums: list[int]) -> int:
        counts=Counter(nums)
        return sum(i*(i-1)//2 for i in counts.values())