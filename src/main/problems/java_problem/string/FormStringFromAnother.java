package java_problem.string;

import java.util.HashMap;
import java.util.Map;

public class FormStringFromAnother {
    public static void main(String args[]) {
        System.out.println(isStringPossible("ababt", "cat"));
    }

    public static boolean isStringPossible(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            int c = (int) s1.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else
                map.put(c, 1);
        }
        for (int i = 0; i < n2; i++) {
            int c = s2.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else if (map.containsKey(c - 1) && map.containsKey(c - 2) && map.get(c - 1) > 0 && map.get(c - 2) > 0) {
                map.put(c - 1, map.get(c - 1) - 1);
                map.put(c - 2, map.get(c - 2) - 1);
            } else
                return false;
        }
        return true;
    }
}
