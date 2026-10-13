class Solution {
    public String longestPalindrome(String s) {

        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            String p1 = check(s, i, i);

            // Even length palindrome
            String p2 = check(s, i, i + 1);

            // Store longest
            if (p1.length() > ans.length()) {
                ans = p1;
            }

            if (p2.length() > ans.length()) {
                ans = p2;
            }
        }

        return ans;
    }

    public String check(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}