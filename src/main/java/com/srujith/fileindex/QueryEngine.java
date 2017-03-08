package com.srujith.fileindex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by srujithpoondla on 3/7/17.
 */
class QueryEngine {
    private Map<File, Trie> dataBase;

    public QueryEngine(Map<File, Trie> dataBase) {
        this.dataBase = dataBase;
    }

    public List<String> query(String str) {
        final List<String> queryResult = new ArrayList<>();
        int x = 0;
        for (final Map.Entry<File, Trie> entry : dataBase.entrySet()
                ) {
            new Thread("" + x) {
                public void run() {
                    if ((entry.getValue()).contains(str)) {
                        queryResult.add(entry.getKey().getName());
                    }

                }
            }.start();
            x = x + 1;
        }
        return queryResult;
    }
}

