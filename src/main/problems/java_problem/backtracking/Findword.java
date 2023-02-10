package java_problem.backtracking;

public class Findword {
    public static void main(String args[]) {
        char[][] board = new char[][]{{
                'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'T'}};
        FindSolution findSolution = new FindSolution();
        System.out.println(findSolution.exist(board, "T"));

    }

}

class FindSolution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
// simply creating boolean array of visited cells
        boolean[][] visi = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (found(board, row, col, w, 0, visi)) return true;
            }
        }
        return false;

    }

    public boolean found(char[][] board, int row, int col, char[] w, int i, boolean[][] visi) {
        if (i == w.length) return true; // you reached at the destinations
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != w[i] || visi[row][col] == true)
            return false;
        visi[row][col] = true; // mark the particular row and col you visited as a true(reason--not to get trap in infinite loop)
// choose any directions accordingly , like i choose right,down,left,up
        if (found(board, row, col + 1, w, i + 1, visi)) return true;
        else if (found(board, row + 1, col, w, i + 1, visi)) return true;
        else if (found(board, row, col - 1, w, i + 1, visi)) return true;
        else if (found(board, row - 1, col, w, i + 1, visi)) return true;
        visi[row][col] = false; // mark false if char at i doesn't match

        return false;
    }
}

