package java_problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams51 {
    public static void main(String args[]){
        String anagrams[]=new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(anagrams));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> alist = new ArrayList<List<String>>();

        if(strs == null || strs.length == 0){
            return alist;
        }
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] charArr=s.toCharArray();
            Arrays.sort(charArr);
            String curr = new String(charArr);
            if(!map.containsKey(curr)){
                map.put(curr, new ArrayList<String>());
            }
            map.get(curr).add(s);
        }
        for(String s : map.keySet()){
            alist.add(map.get(s));
        }
        return alist;
    }
}
