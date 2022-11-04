package java_problem.array;

public class TicTacTao {
    public static void main(String[] args) {
        int[][] moves = new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        System.out.println(ticTacToe(moves));
    }

    public static String ticTacToe(int[][] moves) {
        char board[][] = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = 'N';
            }
        }
        int i = 0;
        for (int[] arr : moves) {
            if (i % 2 == 0) {
                board[arr[0]][arr[1]] = 'X';
            } else {
                board[arr[0]][arr[1]] = 'O';
            }
            i++;
        }

        //checking winner from rows and columns
        for (i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2])
                if (board[i][0] == 'X')
                    return "A";
                else if (board[i][0] == 'O')
                    return "B";
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i])
                if (board[0][i] == 'X')
                    return "A";
                else if (board[0][i] == 'O')
                    return "B";

        }
        //checking winner from main diagonal
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
            if (board[0][0] == 'X')
                return "A";
            else if (board[0][0] == 'O')
                return "B";

        //checking winner from right diagonal
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2])
            if (board[2][0] == 'X')
                return "A";
            else if (board[2][0] == 'O')
                return "B";

        if (moves.length < 9)
            return "Pending";

        return "Draw";
    }
}

