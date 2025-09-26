package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: This is your 3rd task.
 * Please implement the class to satisfy the interface. *
 */
public class YourSolver implements PyramidSolver {

    // Memoization table to store maximum sums for (row, col)
    private Long[][] memo;

    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        int rows = pyramid.getRows();
        // Initialize memoization array
        memo = new Long[rows][rows];
        // Start from the bottom-left cell (last row, column 0)
        return dfs(rows - 1, 0, pyramid);
    }

    /**
     * Recursive DFS to calculate maximum path sum to current cell (row, col)
     *
     * @param row    current row
     * @param col    current column
     * @param pyramid pyramid data
     * @return maximum sum to reach this cell
     */
    private long dfs(int row, int col, Pyramid pyramid) {
        // Base case: return 0 if out of bounds
        if (row < 0 || col < 0 || col >= pyramid.getRows()) return 0;

        // If already computed, return cached value
        if (memo[row][col] != null) return memo[row][col];

        // Current cell value
        int value = pyramid.get(row, col);

        // Only consider next valid positions: col and col+1 in previous row
        long left = dfs(row - 1, col, pyramid);
        long right = dfs(row - 1, col + 1, pyramid);

        // Store the maximum path sum for this cell
        memo[row][col] = value + Math.max(left, right);
        return memo[row][col];
    }

}
