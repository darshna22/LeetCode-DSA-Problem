package java_problem.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AverageOfLevels {
}

class SolutionAvg {

    Deque<TreeNode> de = new LinkedList<TreeNode>();

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg = new ArrayList<>();
        if (root == null) return avg;
        de.add(root);
        calculateAvg(avg);
        return avg;
    }

    public void calculateAvg(List<Double> avg) {
        while (!de.isEmpty()) {
            Deque<TreeNode> de1 = new LinkedList<TreeNode>();
            while (!de.isEmpty()) {
                TreeNode node = de.poll();
                findChild(node, de1);
            }
            int count = 0;
            int sum = 0;
            while (!de1.isEmpty()) {
                TreeNode node = de.poll();
                de.addLast(node);
                sum += node.val;
                count++;
            }

            double avgVal = (double) sum / count;
            avg.add(avgVal);
        }
    }

    public void findChild(TreeNode node, Deque<TreeNode> de1) {
        if (node.left != null)
            de1.addLast(node.left);
        if (node.right != null)
            de1.addLast(node.right);
    }


}