package java_problem.heap;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args){
        System.out.println(subsets(new int[]{1,2,3}));

    }
    static void subsequence(int i, int[] arr, List<Integer> lst, List<List<Integer>> res){
        if(res.contains(lst)) return;
        if(i==arr.length){
            res.add(new ArrayList<>(lst));
            return;
        }
        lst.add(arr[i]);
        subsequence(i+1, arr, lst, res);
        lst.remove(lst.size()-1);
        subsequence(i+1, arr, lst, res);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        subsequence(0, nums, new ArrayList<>(), res);
        return res;
    }
}
