class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            int sum = 0;

            // Find sum of digits
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            // Update minimum
            min = Math.min(min, sum);
        }

        return min;
    }
}