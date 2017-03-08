package com.srujith.fileindex;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by srujithpoondla on 3/8/17.
 */
public class NodeTest {
    Node n;
    @Before
    public void setUp() throws Exception {
        n = new Node();

    }

    @Test
    public void isWordCountZero(){
        int actual =n.wordCount;
        assertEquals(0,actual);
    }

    @Test
    public void isNodeInitialized(){
        int[] x = n.next;
        assertEquals(-1,x[200]);
    }
}