class Solution {
    public boolean check(int[] nums) {

        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            // Compare current with next element
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        // Valid only if count <= 1
        return count <= 1;
    }
}