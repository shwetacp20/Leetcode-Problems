class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {

            int lastLower = word.lastIndexOf(ch);
            int firstUpper = word.indexOf(Character.toUpperCase(ch));

            // check if both exist
            if (lastLower != -1 && firstUpper != -1) {

                // all lowercase must come before uppercase
                if (lastLower < firstUpper) {
                    count++;
                }
            }
        }

        return count;
    }
}