package com.srujith.fileindex;

import java.util.ArrayList;
import java.util.List;

/**
 * Trie has methods to insert words, to search for required word, to get all distinct words in stored tries.
 * It takes only characters other than these mentioned characters "[\s\ .,--?:")*(]"
 */
class Trie {
    private int curr;
    private List<Node> nodes = new ArrayList<Node>();
    private List<String> allDistinctWords;
    public final static int NULL = -1;

    /**
     * Initializes a new Node to the list of nodes.
     */
    public Trie() {
        nodes.add(new Node());
        curr = 1;
    }

    /**
     * To get the index of the character in the Trie
     * @param c character stored in the Trie
     * @return Index of the character
     */
    private int getIndex(char c) {
        return (int) (c);
    }

    /**
     * Its a recursive method to search for the current string in the trie
     * @param x index of the character in the Trie
     * @param currWord String to search in the Trie
     */
    private void depthSearchWord(int x, String currWord) {
        for (int i = 0; i < 255; i++) {
            int p = nodes.get(x).next[i];
            if (p != NULL) {
                String word = currWord + (char) (i);
                if (nodes.get(p).wordCount > 0) {
                    allDistinctWords.add(word);
                }
                depthSearchWord(p, word);
            }
        }
    }

    /**
     * To get all the distinct words in the indexed Trie
     * @return all the distinct words in the Trie as list
     */
    public List<String> getAllDistinctWords() {
        allDistinctWords = new ArrayList<String>();
        depthSearchWord(0, "");
        return allDistinctWords;
    }

    /**
     * This method checks whether the indexed Trie contains the string you are querying for. This search is limited
     * to only single words.
     * @param str String to query in the Trie
     * @return If the Trie contains the word it returns true else false
     */
    public boolean contains(String str) {
        int len = str.length();
        int p = 0;
        for (int i = 0; i < len; i++) {
            int j = getIndex(str.charAt(i));
            if (nodes.get(p).next[j] == NULL) {
                return false;
            }
            p = nodes.get(p).next[j];

        }
        return nodes.get(p).wordCount > 0;

    }

    /**
     * This method is for inserting strings splitted from line based on delimitters in to Trie
     * @param str string to insert in Trie
     */
    public void insert(String str) {
        int len = str.length();
        int p = 0;
        for (int i = 0; i < len; i++) {
            int j = getIndex(str.charAt(i));
            if (j != -1) {
                if (nodes.get(p).next[j] == NULL) {
                    nodes.add(curr, new Node());
                    nodes.get(p).next[j] = curr;
                    curr++;
                }
                p = nodes.get(p).next[j];

            }

        }
        nodes.get(p).wordCount++;
    }

}
