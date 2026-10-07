class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallestOdd = Integer.MAX_VALUE;
        boolean hasOdd = false;
        boolean hasEven = false;

        for (int num : nums1) {
            if (num % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
                smallestOdd = Math.min(smallestOdd, num);
            }
        }
        if (!hasOdd || !hasEven) {
            return true;
        }
        for (int num : nums1) {
            if (num % 2 == 0 && num < smallestOdd) {
                return false;
            }
        }

        return true;
    }
}