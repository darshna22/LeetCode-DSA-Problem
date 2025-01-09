package java_problem.slidewindow;

import java.util.ArrayList;
import java.util.List;

public class MinimumWindowSubstring {
    public static void main(String args[]) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n2 > n1) return "";

        String minWindow = "";
        List<Character> ls = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < n1; r++) {
            ls.add(s.charAt(r));
            sb.append(s.charAt(r));

            // Check if the current window contains all characters of t
            while (containsAll(ls, t)) {
                if (minWindow.isEmpty() || sb.length() < minWindow.length()) {
                    minWindow = sb.toString();
                }
                ls.remove(0); // Remove the leftmost character from the window
                sb.deleteCharAt(0); // Remove the leftmost character from the StringBuilder
            }
        }

        return minWindow;
    }

    // Helper function to check if all characters in t are present in ls
    private static boolean containsAll(List<Character> ls, String t) {
        List<Character> temp = new ArrayList<>(ls);
        for (char c : t.toCharArray()) {
            if (temp.contains(c)) {
                temp.remove((Character) c); // Remove the character from temp
            } else {
                return false; // If a character is missing, return false
            }
        }
        return true;
    }


}
