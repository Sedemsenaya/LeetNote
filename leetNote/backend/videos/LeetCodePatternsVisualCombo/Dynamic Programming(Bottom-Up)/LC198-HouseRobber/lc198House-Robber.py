# LeetCode 198: House Robber
from snoop import snoop

@snoop(out='lc198_house_robber.log',
       watch=('nums', 'n', 'dp', 'i'))
def rob(nums) -> int:
    n = len(nums)
    if n == 0:
        return 0
    if n == 1:
        return nums[0]

    dp = [0] * n
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])

    for i in range(2, n):
        dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

    return dp[n - 1]


if __name__ == "__main__":
    print(rob([1,2,3,1]))      # 4
    print(rob([2,7,9,3,1]))    # 12
