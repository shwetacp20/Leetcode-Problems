class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        char[] ans = new char[n];

        // Try to make the prefix equal to target.
        for (int i = 0; i < n; i++) {
            int t = target.charAt(i) - 'a';

            if (cnt[t] > 0) {
                ans[i] = target.charAt(i);
                cnt[t]--;
            } else {
                // Cannot match target anymore.
                // Try a character greater than target[i].
                for (int c = t + 1; c < 26; c++) {
                    if (cnt[c] > 0) {
                        ans[i] = (char) ('a' + c);
                        cnt[c]--;

                        fill(ans, i + 1, cnt);
                        return new String(ans);
                    }
                }

                // Need to backtrack.
                return backtrack(ans, cnt, target, i);
            }
        }

        // s can make target exactly.
        // We need strictly greater, so backtrack.
        return backtrack(ans, cnt, target, n);
    }

    private String backtrack(
            char[] ans,
            int[] cnt,
            String target,
            int pos) {

        for (int i = pos - 1; i >= 0; i--) {

            // Restore the character used at this position.
            cnt[ans[i] - 'a']++;

            int t = target.charAt(i) - 'a';

            // Find the smallest character greater than target[i].
            for (int c = t + 1; c < 26; c++) {
                if (cnt[c] > 0) {
                    ans[i] = (char) ('a' + c);
                    cnt[c]--;

                    // Put remaining characters in sorted order.
                    fill(ans, i + 1, cnt);

                    return new String(ans);
                }
            }
        }

        return "";
    }

    private void fill(char[] ans, int start, int[] cnt) {
        int index = start;

        for (int c = 0; c < 26; c++) {
            while (cnt[c] > 0) {
                ans[index++] = (char) ('a' + c);
                cnt[c]--;
            }
        }
    }
}