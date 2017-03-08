package com.srujith.fileindex;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class FileParserTest {
    FileParser parser;
    File folder;
    Map<File, Trie> dataEngine;

    @Before
    public void setUp() throws Exception {
        folder = new File("/Users/srujithpoondla/IdeaProjects/fileindex/src/main/resources");
        parser = new FileParser();
        parser.startParsing(folder);
    }


    @Test
    public void shouldPrintNoFilesInDirectory() {
        parser = new FileParser();
        List<File> actual = parser.getListOfFiles(folder);

        assertNull(actual);
    }

    @Test
    public void shouldReturnIndexOfStringAsNull() {
        assertNull(parser.query("ZEBRA"));
    }

    @Test
    public void shouldReturnIndexOfStringAsFileName() {
        List<String> actualList = parser.query("Westminster");
        List<String> expectedList = Arrays.asList("sample1.txt");

        assertEquals(expectedList, actualList);
    }



}