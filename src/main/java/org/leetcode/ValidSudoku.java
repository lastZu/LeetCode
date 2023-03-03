package org.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 *     Each row must contain the digits 1-9 without repetition.
 *     Each column must contain the digits 1-9 without repetition.
 *     Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 *
 *     A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 *     Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Set<Character>[] validator = new HashSet[27];
        for (int i = 0; i < validator.length; i++) {
            validator[i] = new HashSet<>();
        }
        int startColumn = 0;
        int startRow = 9;
        int startBox = 18;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char temp = board[i][j];
                if (temp == '.') {
                    continue;
                }
                if (validator[startColumn + j].contains(temp) ||
                        validator[startRow + i].contains(temp) ||
                        validator[startBox + i / 3 + (j / 3) * 3].contains(temp)) {
                    return false;
                }
                validator[startColumn + j].add(temp);
                validator[startRow + i].add(temp);
                validator[startBox + i / 3 + (j / 3) * 3].add(temp);
            }
        }
        return true;
    }
}
