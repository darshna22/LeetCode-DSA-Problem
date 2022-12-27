package java_problem.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationinString {
    public static void main(String args[]) {
        System.out.println(checkInclusion("adc","dcda"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2) return false;
        Map<Character,Integer> m1=new HashMap<>();
        Map<Character,Integer> m2=new HashMap<>();
        int i=0;
        while (i<n1){
            if (m1.containsKey(s1.charAt(i))){
               int val= m1.get(s1.charAt(i));
               m1.put(s1.charAt(i),val+1);
            }else {
                m1.put(s1.charAt(i),1);
            }

            if (m2.containsKey(s2.charAt(i))){
                int val= m2.get(s2.charAt(i));
                m2.put(s2.charAt(i),val+1);
            }else {
                m2.put(s2.charAt(i),1);
            }
            i++;
        }

        if(m1.equals(m2)) return true;

        int left=0,right=i;
        while (right<n2){

            //remove first value from map
            int val= m2.get(s2.charAt(left));
            if (val>1){
                m2.put(s2.charAt(left),val-1);
            }else {
                m2.remove(s2.charAt(left));
            }

            //add next value to map
            if (m2.containsKey(s2.charAt(right))){
                int val1= m2.get(s2.charAt(right));
                m2.put(s2.charAt(right),val1+1);
            }else {
                m2.put(s2.charAt(right),1);
            }

            if(m1.equals(m2)) return true;

            right++;
            left++;
        }



        return false;
    }


}
