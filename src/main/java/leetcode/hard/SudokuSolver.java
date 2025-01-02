package leetcode.hard;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * <p>
 * solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 */
public class SudokuSolver {

    public static void main(String[] args) {

        // Input board
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        // Solving the Sudoku
        solveSudoku(board);

        // Print the solved Sudoku
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    // Helper method to check if a number can be safely placed
    public static boolean isSafe(char[][] board, int row, int col, int number) {
        // Check the column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char) (number + '0')) {
                return false;
            }
        }

        // Check the row
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == (char) (number + '0')) {
                return false;
            }
        }

        // Check the 3x3 grid
        int sr = 3 * (row / 3);
        int sc = 3 * (col / 3);
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == (char) (number + '0')) {
                    return false;
                }
            }
        }

        return true;
    }

    // Backtracking helper function to solve the puzzle
    public static boolean helper(char[][] board, int row, int col) {
        // If we have completed all rows, return true
        if (row == board.length) {
            return true;
        }

        // Move to the next cell
        int nrow = 0;
        int ncol = 0;
        if (col == board.length - 1) {
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }

        // If the current cell is not empty (it's a digit), skip it
        if (board[row][col] != '.') {
            return helper(board, nrow, ncol);
        }

        // Try filling the cell with numbers 1 to 9
        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, row, col, i)) {
                board[row][col] = (char) (i + '0');  // Place the number
                if (helper(board, nrow, ncol)) {
                    return true;
                } else {
                    board[row][col] = '.';  // Backtrack
                }
            }
        }

        return false;
    }
}
