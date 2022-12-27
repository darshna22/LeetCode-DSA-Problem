package java_problem.stack;

import java.util.Stack;

public class DailyTemperaturesByStack {
    public static void main(String args[]) {
        int[] tokens = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(dailyTemperatures(tokens));
    }

    public static int[] dailyTemperatures(int[] t) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[t.length];

        for (int i = t.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && t[i] >= t[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) result[i] = 0;
            else result[i] = stack.peek() - i;

            stack.push(i);
        }

        return result;
    }
}
