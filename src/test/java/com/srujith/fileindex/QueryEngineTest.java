package com.srujith.fileindex;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.*;

import static org.junit.Assert.*;


public class QueryEngineTest {
    QueryEngine queryEngine;
    Map<File, Trie> dataEngine;

    @Before
    public void setUp() throws Exception {
        List<String> inputStringList = new ArrayList<>();
        inputStringList.add("Lord of the Rings");

        inputStringList.add("Westminster");
        dataEngine = new HashMap<>();
        File folder = new File("/Users/srujithpoondla/IdeaProjects/fileindex/src/main/resources");
        File[] listOfFiles = folder.listFiles();
        Indexer indexer;
        Map<File, Trie> dataEngine = new HashMap<>();

        for (File file : listOfFiles) {
            indexer = new Indexer();
            dataEngine.put(file, indexer.start_Indexing(file));
        }
        queryEngine = new QueryEngine(dataEngine);
    }

}