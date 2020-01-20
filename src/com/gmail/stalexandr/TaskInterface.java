package com.gmail.stalexandr;

import java.util.ArrayList;
import java.util.Set;

/**
 * This interface shows the architecture of the application.
 * The main methods are shown here.
 *
 */

public interface TaskInterface {

        void doTask();
        ArrayList<String> getWords(String a);
        boolean checkConcatenated(String a, Set<String> b);
        ArrayList<String> getConcatenatedWords(ArrayList<String> a);
        void getResult();
}
