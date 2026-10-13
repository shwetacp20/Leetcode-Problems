class Solution {
    public int[] leftRightDifference(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        int totalSum = 0;

        // Find total sum
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {

            totalSum -= nums[i]; // now totalSum becomes rightSum

            int rightSum = totalSum;

            answer[i] = Math.abs(leftSum - rightSum);

            leftSum += nums[i];
        }

        return answer;
    }
}