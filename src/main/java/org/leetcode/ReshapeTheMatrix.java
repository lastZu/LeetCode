package org.leetcode;

public class ReshapeTheMatrix {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int deepLength = mat.length * mat[0].length;
        if (deepLength != r * c) {
            return mat;
        }
        int n = mat[0].length;
        int[][] rmat = new int[r][c];
        for (int i = 0; i < deepLength; i++) {
            rmat[i / c][i % c] = mat[i / n][i % n];
        }
        return rmat;
    }
}
