class Solution {
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        
        while (l < r) {
            while (l < r && !vowel.contains(chars[l] + "")) {
                l++;
            }
            while (l < r && !vowel.contains(chars[r] + "")) {
                r--;
            }
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }
}