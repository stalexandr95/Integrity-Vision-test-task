package com.gmail.stalexandr;


/**
 * There's a file called “words.txt” which contains a sorted list of
 * approximately 173,000 words. The words are listed one word per line, do not contain spaces, and
 * are all lowercase.
 *
 * Your task is to write a program that reads the file and provides the following:
 * the longest concatenated word (that is,the longest word that is comprised entirely of shorter words in the
 * file)
 * the 2nd longest concatenated word
 * the total count of all the concatenated words in the file
 */

public class Main {

    public static void main(String[] args) {
        ConcatenatedTask task = new ConcatenatedTask("res//words.txt");
        //For a simple check, we can use the list of words from the challenge condition
        //ConcatenatedTask task = new ConcatenatedTask("res//testwords.txt");
        //Result sets you can check in results.txt

        task.doTask();
        task.getResult();


    }
}
