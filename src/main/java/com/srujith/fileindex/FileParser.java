package com.srujith.fileindex;

import java.io.File;
import java.util.*;

/**
 * Class to maintain information of file and its index.
 */
public class FileParser {
    Map<File, Trie> dataEngine;
    QueryEngine search;

    /**
     * Gets the list of files in the directory to populate the file - index map.
     * Constructs an index for each of the file in the directory.
     */
    public void startParsing(File folder) {
        List<File> listOfFiles = getListOfFiles(folder);
        Indexer indexer;
        dataEngine = new HashMap<>();
        for (File file : listOfFiles) {
            indexer = new Indexer();
            dataEngine.put(file, indexer.start_Indexing(file));
        }
    }

    /**
     * Method to fetch the list of files in a directory.
     * Returns null if the directory is empty.
     * @param file Directory from which the files are to be fetched.
     * @return List of files in the directory; null if the directory is empty.
     */
    public List<File> getListOfFiles(File file) {
        List<File> listOfFiles;
        listOfFiles = Arrays.asList(file.listFiles());
        if (listOfFiles.size() == 0) {
            return null;
        } else {
            return listOfFiles;
        }
    }

    /**
     * Queries the indexes for a string
     * @param str String to be searched for in the directory
     * @return List of files in which the query string is present.
     */
    public List<String> query(String str) {
        search = new QueryEngine(dataEngine);
        if (search.query(str).isEmpty()) {
            return null;
        } else {
            return search.query(str);
        }
    }

}

