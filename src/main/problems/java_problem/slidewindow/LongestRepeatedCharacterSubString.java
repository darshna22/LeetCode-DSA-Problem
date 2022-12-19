package java_problem.slidewindow;

import java.util.HashMap;

public class LongestRepeatedCharacterSubString {
    public static void main(String args[]){
        System.out.println("Longest sub string length="+characterReplacement( "AABABBA ",1));
    }
    public static int characterReplacement(String s, int k) {
        int n=s.length();
        HashMap<Character,Integer> hs=new HashMap<Character,Integer>();
        int i=0;
        int subStrSize=0;
        int maxFreq=0;
        for(int j=0;j<n;j++){
            int freq=1;
            if(hs.containsKey(s.charAt(j))){
                freq=hs.get(s.charAt(j));
                freq=freq+1;
                hs.put(s.charAt(j),freq);
            }else{
                hs.put(s.charAt(j),freq);
            }
            maxFreq=Math.max(maxFreq,freq);
            int windowSize=j-i+1;
            int ops=windowSize-maxFreq;
            if(ops>k){
                char pre=s.charAt(i);
                freq=hs.get(pre)-1;
                hs.put(pre,freq);
                i++;
                windowSize=j-i+1;
            }

            subStrSize=Math.max(windowSize,subStrSize);
        }
        return subStrSize;
    }
}
