class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];

        // Store best index
        int index = -1;

        // Store shortest length
        int length = Integer.MAX_VALUE;
    }

    TrieNode root = new TrieNode();

    // Insert reversed word into trie
    private void insert(String word, int idx) {

        TrieNode node = root;

        int len = word.length();

        // Update root info
        if (len < node.length) {
            node.length = len;
            node.index = idx;
        }

        for (int i = len - 1; i >= 0; i--) {

            char ch = word.charAt(i);
            int c = ch - 'a';

            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }

            node = node.children[c];

            // Update best answer
            if (len < node.length) {
                node.length = len;
                node.index = idx;
            }
        }
    }

    // Search longest suffix match
    private int search(String word) {

        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {

            char ch = word.charAt(i);
            int c = ch - 'a';

            if (node.children[c] == null) {
                break;
            }

            node = node.children[c];
        }

        return node.index;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        // Build trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        // Process queries
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}