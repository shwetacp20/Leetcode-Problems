class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Step 1: Create a boolean array to track allowed characters (size 26 for lowercase English letters)
        boolean[] isAllowed = new boolean[26];
        
        // Mark the characters present in 'allowed' as true
        for (int i = 0; i < allowed.length(); i++) {
            isAllowed[allowed.charAt(i) - 'a'] = true;
        }
        
        int consistentCount = 0;
        
        // Step 2: Check each word in the words array
        for (String word : words) {
            boolean isConsistent = true;
            
            for (int i = 0; i < word.length(); i++) {
                // If a character is not in the allowed set, mark as inconsistent and break
                if (!isAllowed[word.charAt(i) - 'a']) {
                    isConsistent = false;
                    break;
                }
            }
            
            // If the word is entirely consistent, increment our counter
            if (isConsistent) {
                consistentCount++;
            }
        }
        
        // Step 3: Return the total count of consistent strings
        return consistentCount;
    }
}