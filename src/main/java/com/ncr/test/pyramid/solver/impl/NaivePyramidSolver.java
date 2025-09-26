package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: There is something wrong here. A few things actually... 
 */
public class NaivePyramidSolver implements PyramidSolver {
    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        return getTotalAbove(pyramid.getRows() - 1, 0, pyramid);
    }

    private long getTotalAbove(int row, int column, Pyramid pyramid) {
        // FIX: Changed base condition from row==0 to row<0
        // Original condition excluded the top row from sum
        if (row < 0) return 0;

        // NOTE: Naive recursion without memoization → inefficient for large pyramids
        int myValue = pyramid.get(row, column);
        long left  = myValue + getTotalAbove(row - 1, column, pyramid);
        // In a regular pyramid, column+1 is always safe
        // In irregular pyramids, this may throw ArrayIndexOutOfBounds
        long right = myValue + getTotalAbove(row - 1, column + 1, pyramid);
        return Math.max(left, right);
    }
}