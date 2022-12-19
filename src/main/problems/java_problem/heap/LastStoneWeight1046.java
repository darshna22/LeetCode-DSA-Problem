package java_problem.heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight1046 {
    public static void main(String args[]) {
        int stones[] = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0];
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int weight : stones) {
            heap.add(weight);
        }
        while (heap.size()!=1){
            int x=heap.poll();

            int y=heap.poll();

            if(x>y){
                heap.add(x-y);
            }else if (x==y){
                heap.add(0);
            }
        }
        return heap.poll();
    }
}
