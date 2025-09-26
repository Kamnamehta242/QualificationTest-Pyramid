package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NaivePyramidSolverTest {

    private PyramidSolver solver;

    @BeforeEach
    public void setup() {
        solver = new NaivePyramidSolver();
    }

    @Test
    public void testSmallPyramid() {
        Pyramid pyramid = new Pyramid(new int[][] {
                {5, 9, 8, 4},
                {6, 4, 5},
                {6, 7},
                {3}
        });

        // Maximum path sum = 3 + 6 + 6 + 9 = 24
        assertEquals(24, solver.pyramidMaximumTotal(pyramid));
    }

    @Test
    public void testAnotherPyramid() {
        Pyramid pyramid = new Pyramid(new int[][] {
                {81, 20, 20, 1, 19},
                {24, 51, 93, 60},
                {72, 97, 25},
                {95, 43},
                {4}
        });

        assertEquals(309, solver.pyramidMaximumTotal(pyramid));
    }

    @Test
    public void testIrregularPyramid() {
        Pyramid pyramid = new Pyramid(new int[][] {
                {10, 20},  // Row 0 (top)
                {5, 6},    // Row 1
                {1}        // Row 2 (bottom)
        });

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            solver.pyramidMaximumTotal(pyramid);
        });
    }


}
