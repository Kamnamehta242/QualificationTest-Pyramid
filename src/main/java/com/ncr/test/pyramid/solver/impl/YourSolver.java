package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: This is your 3rd task.
 * Please implement the class to satisfy the interface. *
 */
public class YourSolver implements PyramidSolver {

    private Long[][] memo;
    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        int rows = pyramid.getRows();
        memo = new Long[rows][rows];
        return dfs(rows - 1, 0, pyramid);
    }

    private long dfs(int row, int col, Pyramid pyramid) {
        if (row < 0 || col < 0 || col >= pyramid.getRows()) return 0;

        if (memo[row][col] != null) return memo[row][col];

        int value = pyramid.get(row, col);

        // Only consider next valid positions: col and col+1 in previous row
        long left = dfs(row - 1, col, pyramid);
        long right = dfs(row - 1, col + 1, pyramid);

        memo[row][col] = value + Math.max(left, right);
        return memo[row][col];
    }

}
