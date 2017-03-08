package com.srujith.fileindex;

/**
 * Node in a Trie
 */
class Node {
    public final static int NULL = -1;
    public int[] next = new int[255];
    public int wordCount;

    public Node() {
        for (int i = 0; i < 255; i++) {
            next[i] = NULL;
        }
        wordCount = 0;
    }
}
