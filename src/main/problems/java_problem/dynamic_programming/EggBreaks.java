package java_problem.dynamic_programming;

public class EggBreaks {
    public static void main(String[] args) {
        System.out.println(twoEggDrop(7));
    }

    public static int twoEggDrop(int floor) {
        int egg = 2; // hard coded to 2 eggs for this problem
        int[][] dp = new int[floor + 1][egg + 1];
        return eggDrop(floor, egg, dp);
    }

    public static int eggDrop(int floor, int egg, int[][] dp) {
        if (floor <= 2 || egg == 1) return floor;
        if (dp[floor][egg] != 0) return dp[floor][egg];
        int min = floor; // when you drop at each floor starting from 1
        for (int flr = 1; flr < floor; flr++) {
            int eggBreak = 1 + eggDrop(flr - 1, egg - 1, dp); // drops needed if egg breaks at this floor
            int noEggBreak = 1 + eggDrop(floor - flr, egg, dp); // drops needed if egg does not break at this floor
            int moves = Math.max(eggBreak, noEggBreak); // since we want certain moves for floor floor take max
            min = Math.min(min, moves);
        }
        dp[floor][egg] = min;
        return min;
    }
}
