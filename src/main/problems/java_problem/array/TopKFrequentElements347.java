package java_problem.array;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements347 {
    public static void main(String args[]) {
        int stones[] = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(topKFrequent(stones,3));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        PriorityQueue<MyPair> heap = new PriorityQueue<MyPair>(k, new Comparator<MyPair>() {
            @Override
            public int compare(MyPair a, MyPair b) {
                if (a.count < b.count) {
                    return -1;
                } else if (a.count == b.count) {
                    return 0;
                }
                return 1;
            }

        });

        for (Map.Entry<Integer, Integer> keyVal : map.entrySet()) {
            if (heap.size() < k) {
                MyPair p = new MyPair(keyVal.getKey(), keyVal.getValue());
                heap.add(p);
            } else {
                if (heap.peek().value < keyVal.getValue()) {
                    heap.poll();
                    MyPair p = new MyPair(keyVal.getKey(), keyVal.getValue());
                    heap.add(p);
                }
            }
        }


        int[] topK=new int[k];
        int i=0;
        while (!heap.isEmpty()) {
            MyPair myPair=heap.poll();
            topK[i]=myPair.value;
            i++;
        }

        return topK;
    }


}

class MyPair {
    int value;
    int count;

    public MyPair(int key, int value) {
        this.value = key;
        this.count = value;
    }
}