// Time Complexity : O(1) since the board is always 9x9, we are checking a fixed number of cells
// Space Complexity : O(1) since we are using a fixed amount of space for the HashSet
// Did this code successfully run on Leetcode : Yes
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) { // go through each row
            for (int j = 0; j < 9; j++) { // go through each column
                char c = board[i][j];
                if (c != '.') { // if the cell is filled

                    // Check same row
                    for (int col = 0; col < 9; col++) {
                        if (col != j && board[i][col] == c)
                            return false;
                    }

                    // Check same column
                    for (int row = 0; row < 9; row++) {
                        if (row != i && board[row][j] == c)
                            return false;
                    }

                    // Check 3x3 box
                    int boxRowStart = 3 * (i / 3);
                    int boxColStart = 3 * (j / 3);
                    for (int row = boxRowStart; row < boxRowStart + 3; row++) {
                        for (int col = boxColStart; col < boxColStart + 3; col++) {
                            if ((row != i || col != j) && board[row][col] == c)
                                return false;
                        }
                    }
                }
            }
        }
        return true; // No duplicates found
    }

}
