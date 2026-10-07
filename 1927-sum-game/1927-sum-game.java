class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int diff = 0;
        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                leftQ++;
            } else {
                diff += c - '0';
            }
        }

        for (int i = half; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                rightQ++;
            } else {
                diff -= c - '0';
            }
        }

        // Odd number of '?' -> Alice can always force inequality
        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        // After accounting for the maximum possible contribution
        // of the extra '?'s.
        diff += 9 * (leftQ - rightQ) / 2;

        return diff != 0;
    }
}