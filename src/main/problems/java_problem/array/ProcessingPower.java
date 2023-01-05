package java_problem.array;

import kotlin.Pair;

import java.util.*;

public class ProcessingPower {

    public static void main(String[] args) {
        int[] D = new int[]{5,5,5,5};
        int[] C = new int[]{8,3,3,4};
        System.out.println(solution(D, C, 6));
    }

    public static int solution(int D[], int C[], int p) {
        int disLen=D.length;
        int playersCount=0;
        List<Pair<Integer,Integer>> pairList=new ArrayList<Pair<Integer,Integer>>();
        for (int i=0;i<disLen;i++){
            Pair pair=new Pair(D[i],C[i]);
            pairList.add(pair);
        }
        Collections.sort(pairList, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(final Pair<Integer, Integer> p1, final Pair<Integer, Integer> p2) {
                if (Objects.equals(p1.getFirst(), p2.getFirst())) {
                    return p1.getSecond()-p2.getSecond();
                }
               return p1.getFirst()-p2.getFirst();
            }
        });

        int totalCost=0;
        for (Pair<Integer, Integer> pair: pairList){
            int temp=totalCost + pair.getSecond();
            if (temp<=p){
                totalCost=temp;
                playersCount++;
            }else
                break;

        }
        return playersCount;
    }
}
