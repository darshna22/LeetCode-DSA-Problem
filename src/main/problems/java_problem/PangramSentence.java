package java_problem;

import java.util.ArrayList;

public class PangramSentence {
    public static void main(String args[]) {
        String sentence = "thequ";
        System.out.println(checkIfPangram(sentence));
    }

    private static boolean checkIfPangram(String sentence) {
        if (sentence.trim().equals("")) return false;
        ArrayList<Character> ls = new ArrayList<Character>();
        for (int c = 0; c < sentence.length(); c++) {
            if (!ls.contains(sentence.charAt(c)))
                ls.add(sentence.charAt(c));
        }
        for (char c='a';c<='z';c++){
            if (!ls.contains(c))
                return  false;
        }

       return true;
    }
}
