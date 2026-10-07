class Solution {
    public long sumAndMultiply(int n) {
       String s = String.valueOf(n);
        long x = 0;
        long sum = 0;

        for (char ch : s.toCharArray()) {
            if (ch != '0') {
                int digit = ch - '0';
                x = x * 10 + digit;
                sum += digit;
            }}
        return x * sum;
    }
}