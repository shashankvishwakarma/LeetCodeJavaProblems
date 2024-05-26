package leetcode;

/**
 * Description:
 * <p>
 * Given a 8x8 chessboard, a pawn starts at a specific position denoted by a row and a column (e.g., "5h").
 * The pawn can move R times vertically (up or down) and C times horizontally (left or right).
 * If the pawn moves past the edges of the board, it wraps around to the opposite side.
 * The task is to determine the final position of the pawn on the board after all the moves have been made.
 * <p>
 * Input:
 * <p>
 * A string startPosition representing the starting position of the pawn on the board (e.g., "5h").
 * An integer R representing the number of vertical moves.
 * An integer C representing the number of horizontal moves.
 * <p>
 * Output:
 * <p>
 * A string representing the final position of the pawn on the board.
 * <p>
 * Constraints:
 * <p>
 * The board is a 8x8 grid.
 * R and C can be positive, negative, or zero.
 * <p>
 * Example 1:
 * <p>
 * Input: startPosition = "5h", R = 10, C = 15
 * Output: "7g"
 */
public class ChessPawnPosition {

    public static void main(String[] args) {
        // Example input
        String startingPosition = "5h"; // Starting at row 5, column 'h'
        int R = 10; // Number of vertical moves
        int C = 15; // Number of horizontal moves

        // Calculate the final position
        String finalPosition = calculateFinalPosition(startingPosition, R, C);

        // Output the final position
        System.out.println("Final Position: " + finalPosition);
    }

    public static String calculateFinalPosition(String startPosition, int R, int C) {
        // Extract row and column from the starting position
        int initialRow = Character.getNumericValue(startPosition.charAt(0));
        char initialColumnChar = startPosition.charAt(1);

        // Convert column character to numeric value
        int initialColumn = convertColumnToNumber(initialColumnChar);

        // Size of the chessboard
        int boardSize = 8;

        // Calculate the final row position with wrapping
        int finalRow = (initialRow - 1 + R) % boardSize;
        if (finalRow < 0) finalRow += boardSize;
        finalRow += 1; // Convert back to 1-based indexing

        // Calculate the final column position with wrapping
        int finalColumn = (initialColumn - 1 + C) % boardSize;
        if (finalColumn < 0) finalColumn += boardSize;
        finalColumn += 1; // Convert back to 1-based indexing

        // Convert the final position to chess notation
        return convertToChessNotation(finalRow, finalColumn);
    }

    // Function to convert a chess column letter to its corresponding number
    public static int convertColumnToNumber(char column) {
        return column - 'a' + 1;
    }

    // Function to convert row and column to chess notation (e.g., 1 -> a, 2 -> b, ..., 8 -> h)
    public static String convertToChessNotation(int row, int column) {
        char columnChar = (char) ('a' + column - 1);
        return "" + row + columnChar;
    }
}
