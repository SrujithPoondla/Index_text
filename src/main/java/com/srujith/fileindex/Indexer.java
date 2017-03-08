package com.srujith.fileindex;

import java.io.*;

/**
 * Created by srujithpoondla on 3/7/17.
 */
class Indexer {
    private Trie index_table;

    /**
     * Intializes a new Trie
     */
    public Indexer() {
        index_table = new Trie();
    }

    /**
     * Creates a trie index on the given file. Reads the given file and splits each line based up on the delimiters
     * "[\s\ .,--?:")*(]"
     * @param file File on which the index is built
     * @return Indexed Trie constructed on the file
     */
    public Trie start_Indexing(File file) {
        if (file.isFile() && file.getName().endsWith(".txt")) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    sb.append(line);
                    String s = "[\\s\\ .,--?:\")*(]";
                    String[] word_stream = sb.toString().split(s);
                    for (String str : word_stream
                            ) {
                        index_table.insert(str);
                    }
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
        }
        return index_table;
    }
}
