class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            long sum = 0;

            for (char c : word.toCharArray()) {
                sum += weights[c - 'a'];
            }

            int mod = (int)(sum % 26);

            ans.append((char)('z' - mod));
        }

        return ans.toString();
    }
}