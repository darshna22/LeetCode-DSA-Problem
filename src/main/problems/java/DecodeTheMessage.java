package java;

import java.util.HashMap;

public class DecodeTheMessage {
    public static void main(String args[]){
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        decodeMessage(key,message);
    }
    public static String decodeMessage(String key, String message) {
        char alphabet='a';
        HashMap<Character,Character> hs = new HashMap<Character,Character>();
        for(int c=0;c< key.length();c++){
            if(Character.toString(key.charAt(c)).equals(" ") || hs.containsKey(key.charAt(c)) )
                continue;
            else{
                hs.put(key.charAt(c),alphabet);
                alphabet++;
            }
        }

        StringBuilder sb = new StringBuilder(message);
        for(int c=0;c< message.length();c++){
            if(!Character.toString(message.charAt(c)).equals(" "))
             sb.setCharAt(c,hs.get(message.charAt(c)));
        }

        return sb.toString();
    }
}
