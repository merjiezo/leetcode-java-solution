package com.merjiezo.simple;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        if (null == paragraph || "".equals(paragraph)) {
            return "";
        }
        String word = "";
        String[] str = paragraph.toLowerCase().split(" ");
        int length = str.length;
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String innerWord = str[i];
            innerWord = innerWord.replaceAll("[\\pP\\s]", "");
            if (wordMap.containsKey(innerWord)) {
                wordMap.put(innerWord, wordMap.get(innerWord) + 1);
            } else {
                wordMap.put(innerWord, 1);
            }
        }
        for (int j = 0; j < banned.length; j++) {
            wordMap.remove(banned[j]);
        }
        int num = 0;
        for (String key: wordMap.keySet()) {
            Integer number = wordMap.get(key);
            if (number > num) {
                word = key;
                num = number;
            }
        }
        return word;
    }
}
