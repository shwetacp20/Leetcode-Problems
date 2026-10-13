import java.util.*;

public class Solution {
    public boolean isGood(int[] nums) {
        
        int n = 0;

        // Find maximum element
        for (int x : nums) {
            n = Math.max(n, x);
        }

        // Length must be n + 1
        if (nums.length != n + 1) {
            return false;
        }

        int[] freq = new int[n + 1];

        // Count frequency
        for (int x : nums) {

            // Invalid number
            if (x > n || x < 1) {
                return false;
            }

            freq[x]++;
        }

        // Check 1 to n-1 appear once
        for (int i = 1; i < n; i++) {
            if (freq[i] != 1) {
                return false;
            }
        }

        // Check n appears twice
        return freq[n] == 2;
    }
}