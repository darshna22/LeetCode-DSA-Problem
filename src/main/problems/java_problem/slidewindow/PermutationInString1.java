package java_problem.slidewindow;


import java.util.Arrays;
import java.util.Arrays;

public class PermutationInString1 {
    public static void main(String args[]) {
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) return false;

        // Convert s1 to a sorted string
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String nS1 = new String(s1Arr);

        // Loop through s2 and check each substring of length n1
        for (int i = 0; i <= n2 - n1; i++) {
            // Extract the substring from s2 of length n1
            String substring = s2.substring(i, i + n1);

            // Sort the substring and check if it matches sorted s1
            char[] arr = substring.toCharArray();
            Arrays.sort(arr);
            String sortedSubstring = new String(arr);

            if (sortedSubstring.equals(nS1)) {
                return true;
            }
        }

        return false;
    }
}
