package java_problem.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] array = new int[][]{{2, 2},{2, 2},{2, 2},{2, 2},{2, 2},{1, 1}};
        Solution solution = new Solution();
        int[][] closest = solution.kClosest(array, 1);
        System.out.println(closest.length);
    }


}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] closest = new int[k][2];
        PriorityQueue<MinDistance> pq = new PriorityQueue<MinDistance>(new CompareDistance());
        for (int[] point : points) {
            int x1 = 0;
            int y1 = 0;
            int x2 = point[0];
            int y2 = point[1];
            double dis = Math.abs(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
            pq.add(new MinDistance(dis, x2, y2));
        }

        ArrayList<MinDistance> ls = new ArrayList<>();
        int i = k;
        while (i > 0) {
            ls.add(pq.poll());
            i--;
        }
        i = 0;
        for (MinDistance minDistance : ls) {
            int[] point = new int[2];
            point[0] = minDistance.x;
            point[1] = minDistance.y;
            closest[i] = point;
            i++;
        }
        return closest;
    }

    class CompareDistance implements Comparator<MinDistance> {
        @Override
        public int compare(MinDistance o1, MinDistance o2) {
            return Double.compare(o1.dis, o2.dis);
        }
    }

    class MinDistance {
        double dis;
        int x;
        int y;

        public MinDistance(double dis, int x2, int y2) {
            this.dis = dis;
            this.x = x2;
            this.y = y2;
        }
    }
}
