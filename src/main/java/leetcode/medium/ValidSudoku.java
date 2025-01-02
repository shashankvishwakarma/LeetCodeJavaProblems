package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * <p>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {

    public static void main(String[] args) {

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

        // Validate the Sudoku board
        boolean isValid = isValidSudoku(board);
        System.out.println("Is the Sudoku board valid? " + isValid); // true
    }

    public static boolean isValidSudoku(char[][] board) {
        // Iterate through each row
        for (int i = 0; i < 9; i++) {
            // Sets to track the digits in each row, column, and subgrid
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> subgridSet = new HashSet<>();

            // Check each column and subgrid for the current row
            for (int j = 0; j < 9; j++) {
                char currentRowVal = board[i][j];
                char currentColVal = board[j][i];
                char currentSubgridVal = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3];

                // Check for row validity
                if (currentRowVal != '.' && !rowSet.add(currentRowVal)) {
                    return false; // Found a duplicate in the row
                }

                // Check for column validity
                if (currentColVal != '.' && !colSet.add(currentColVal)) {
                    return false; // Found a duplicate in the column
                }

                // Check for subgrid validity
                if (currentSubgridVal != '.' && !subgridSet.add(currentSubgridVal)) {
                    return false; // Found a duplicate in the subgrid
                }
            }
        }

        return true; // All checks passed, the board is valid
    }
}
