package java_problem.string;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String args[]) {
        System.out.println(checkInclusion("ab", "eidbooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            int c = (int) s2.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else
                map.put(c, 1);
        }
        for (int i = 0; i < n1; i++) {
            int c = s1.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else
                return false;
        }
        return true;
    }


}
