class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t = "1" + s + "1";

        int n = t.length();
        int ones = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        int ans = ones;
        int i = 0;

        while (i < n) {
            if (t.charAt(i) == '0') {
                int z1 = 0;
                while (i < n && t.charAt(i) == '0') {
                    z1++;
                    i++;
                }

                int j = i;
                int one = 0;
                while (j < n && t.charAt(j) == '1') {
                    one++;
                    j++;
                }

                if (one > 0 && j < n && t.charAt(j) == '0') {
                    int z2 = 0;
                    int k = j;
                    while (k < n && t.charAt(k) == '0') {
                        z2++;
                        k++;
                    }

                    ans = Math.max(ans, ones + z1 + z2);
                }

                i = j;
            } else {
                i++;
            }
        }

        return ans;
    }
}