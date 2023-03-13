package java_problem.graph;

public class SurroundedRegion {
    public static void main(String[] args) {
        char[][] board =
                {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        Solution solution = new Solution();
        solution.solve(board);
    }
}

class Solution {
    public void solve(char[][] board) {
        int rowNo = board.length;
        int colNo = board[0].length;

        visitBoundary(board, rowNo, colNo);
        flip(board, rowNo, colNo);

    }

    public void flip(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';

            }
        }
    }

    public void visitBoundary(char[][] board, int rowNo, int colNo) {
        //visit top row to check O
        for (int col = 0; col < colNo; col++) {
            if (board[0][col] == 'O') {
                board[0][col] = 'V';
                dfs(0, col, board);
            }
        }

        //visit bottom row to check O
        for (int col = 0; col < colNo; col++) {
            if (board[rowNo - 1][col] == 'O') {
                board[rowNo - 1][col] = 'V';
                dfs(rowNo, col, board);
            }
        }

        //visit left column to check O
        for (int row = 0; row < rowNo; row++) {
            if (board[row][0] == 'O') {
                board[row][0] = 'V';
                dfs(row, 0, board);
            }
        }

        //visit right column to check O
        for (int row = 0; row < rowNo; row++) {
            if (board[colNo - 1][row] == 'O') {
                board[colNo - 1][row] = 'V';
                dfs(colNo - 1, row, board);
            }
        }
    }

    public void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 'V') {
            return;
        }

        //mark as visited cell
        if (grid[row][col] == 'O')
            grid[row][col] = 'V';

        dfs(row - 1, col, grid);
        dfs(row, col - 1, grid);
        dfs(row, col + 1, grid);
        dfs(row + 1, col, grid);
    }

}





