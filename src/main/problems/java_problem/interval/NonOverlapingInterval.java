package java_problem.interval;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlapingInterval {
    public static void main(String args[]) {
//        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] intervals = new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}};

        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        //Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(intervals, new MySort());
        int overlapCount = 0;
        int i = 1;
        int[] newInterval = intervals[0];
        while (i < intervals.length) {
            int[] interval = intervals[i];

            if (!(newInterval[1] <= interval[0] || newInterval[0] > interval[1])) {
                overlapCount++;
                if (newInterval[1] > interval[1])
                    newInterval = interval;
            }
            i++;
        }
        return overlapCount;
    }

}

class MySort implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        if (a[0] == b[0]) {
            return b[1] - a[1];
        }
        return a[0] - b[0];
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
