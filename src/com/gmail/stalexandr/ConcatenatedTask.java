package com.gmail.stalexandr;

import java.io.*;
import java.util.*;

/**
 * A class in which all interface methods and application logic
 * are implemented.
 *
 */

public class ConcatenatedTask implements TaskInterface {
    //wordsWay - string with path to words file
    private String wordsWay;
    //firstLongestWord - string with the longest concatenated word
    private String firstLongestWord;
    //secondLongestWord - string with 2nd longest word
    private String secondLongestWord;
    //concatenatedCount - the count of all concatenated words in file
    private int concatenatedCount;

    //basic constructor of ConcatenatedTask class
    public ConcatenatedTask(String wordsWay) {
        this.wordsWay = wordsWay;
        this.firstLongestWord = firstLongestWord;
        this.secondLongestWord = secondLongestWord;
        this.concatenatedCount = concatenatedCount;
    }

    @Override
    // A method that launches a task to receive a file and search for concatenated words
    public void doTask() {
        ArrayList<String> concatenatedWords =
                getConcatenatedWords(getWords(wordsWay));
        concatenatedCount = concatenatedWords.size();
        firstLongestWord = concatenatedWords.get(concatenatedCount - 1);
        secondLongestWord = concatenatedWords.get(concatenatedCount - 2);



    }

    @Override
    //A method that receives a file with words and fills an array with these words
    public ArrayList<String> getWords(String wordsWay) {
        ArrayList<String> wordsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(wordsWay))) {
            for(String word; (word = br.readLine()) != null; ) {
                if(!word.isEmpty()) {
                    wordsList.add(word);
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }

        return wordsList;
    }

    @Override
    //A method that checks words from a file or whether they are concatenated or not
    public boolean checkConcatenated(String word, Set<String> chekedWord) {
        if (chekedWord.isEmpty()) return false;
        boolean[] concatMarkers = new boolean[word.length() + 1];
        concatMarkers[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!concatMarkers[j]) continue;
                if (chekedWord.contains(word.substring(j, i))) {
                    concatMarkers[i] = true;
                    break;
                }
            }
        }
        return concatMarkers[word.length()];
    }

    @Override
    //A method that creates new list with only concatenated words and sorts all of them
    public ArrayList<String> getConcatenatedWords(ArrayList<String> wordsList) {
        ArrayList<String> concatenatedList = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Collections.sort(wordsList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        for(String word:wordsList){
            if (checkConcatenated(word, preWords)) {
                concatenatedList.add(word);
            }
            preWords.add(word);
        }
        return concatenatedList;
    }

    @Override
    //A method that give result set in console
    public void getResult() {
       if (!firstLongestWord.isEmpty()) {
           System.out.println(firstLongestWord + " - the longest concatenated word");
           System.out.println(secondLongestWord + " - the second longest concatenated word");
           System.out.println("File has " + concatenatedCount + " concatenated words");
       } else {
           System.out.println("No concatenated words in file");
       }
    }
}
