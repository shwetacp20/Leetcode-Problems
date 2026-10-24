class Solution {
    public int removeDuplicates(int[] nums) {

        int i = 0; // first element is always unique

        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1; // number of unique elements
    }
}