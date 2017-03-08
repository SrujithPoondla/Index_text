package com.srujith.fileindex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * To search for the index of the word using QueryEngine
 */
class QueryEngine {
    private Map<File, Trie> dataBase;

    /**
     * Initialize the database to the QueryEngine
     * @param dataBase Map of the files and their index
     */
    public QueryEngine(Map<File, Trie> dataBase) {
        this.dataBase = dataBase;
    }

    /**
     * Query the String in the given directory
     * @param str String to query
     * @return List of files in which the given word is present
     */
    public List<String> query(String str) {
        final List<String> queryResult = new ArrayList<>();
        int x = 0;
        for (final Map.Entry<File, Trie> entry : dataBase.entrySet()
                ) {
            Thread t1 = new Thread("" + x) {
                public void run() {
                    if ((entry.getValue()).contains(str)) {
                        queryResult.add(entry.getKey().getName());
                    }

                }
            };

            t1.start();
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x = x + 1;
        }
        return queryResult;
    }
}

