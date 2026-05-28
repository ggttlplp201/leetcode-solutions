package leetcode.trie;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int index = -1;
    int minLen = Integer.MAX_VALUE;
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word, int index) {
        TrieNode curr = root;
        update(curr, word.length(), index);
        for (int i = word.length() - 1; i >= 0; i--) {
            int charIndex = word.charAt(i) - 'a';
            if (curr.children[charIndex] == null) {
                curr.children[charIndex] = new TrieNode();
            }
            curr = curr.children[charIndex];
            update(curr, word.length(), index);
        }
    }

    public void update(TrieNode node, int wordLength, int index) {
        if (wordLength < node.minLen) {
            node.minLen = wordLength;
            node.index = index;
        }
    }

    public int query(String word) {
        TrieNode curr = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                break;
            }
            curr = curr.children[index];
        }
        return curr.index;
    }
}

class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie trie = new Trie();
        for (int i = 0; i < wordsContainer.length; i++) {
            trie.insert(wordsContainer[i], i);
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = trie.query(wordsQuery[i]);
        }
        return ans;
    }
}