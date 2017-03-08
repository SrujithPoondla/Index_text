package com.srujith.fileindex;

import java.util.ArrayList;
import java.util.List;

/**
 * Trie has methods to insert words, to search for required word, to get all distinct words in stored tries.
 * It takes only characters other than these mentioned characters "[\s\ .,--?:")*(]"
 */
class Trie {
    private int currIndex;
    private List<Node> trieNodes = new ArrayList<Node>();
    public final static int NULL = -1;

    /**
     * Initializes a new Node to the list of trieNodes.
     */
    public Trie() {
        trieNodes.add(new Node());
        currIndex = 1;
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
            if (trieNodes.get(p).next[j] == NULL) {
                return false;
            }
            p = trieNodes.get(p).next[j];
        }
        return trieNodes.get(p).wordCount > 0;

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
                if (trieNodes.get(p).next[j] == NULL) {
                    trieNodes.add(currIndex, new Node());
                    trieNodes.get(p).next[j] = currIndex;
                    currIndex++;
                }
                p = trieNodes.get(p).next[j];
            }
        }
        trieNodes.get(p).wordCount++;
    }

}
