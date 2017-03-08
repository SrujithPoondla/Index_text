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


    @Test
    public void shouldPrintNoFilesInDirectory() {
        folder = new File("src/main/resources");
        parser = new FileParser();
        parser.startParsing(folder);

        List<File> actual = parser.getListOfFiles(folder);
        assertNull(actual);
    }

    @Test
    public void shouldReturnIndexOfStringAsNull() {
        folder = new File("src/main/resources");
        parser = new FileParser();
        parser.startParsing(folder);

        assertNull(parser.query("ZEBRA"));
    }

    @Test
    public void shouldReturnIndexOfStringAsFileName() {
        folder = new File("src/main/resources");
        parser = new FileParser();
        parser.startParsing(folder);

        List<String> actualList = parser.query("Westminster");
        List<String> expectedList = Arrays.asList("sample1.txt");
        assertEquals(expectedList, actualList);
    }



}