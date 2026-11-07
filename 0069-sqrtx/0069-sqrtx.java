class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        int left = 1, right = x;
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Use long to prevent integer overflow during multiplication
            long square = (long) mid * mid;
            
            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;         // Save the valid lower bound
                left = mid + 1;    // Try looking for a larger valid integer
            } else {
                right = mid - 1;   // Too big, look in the lower half
            }
        }
        
        return ans;
    }
}