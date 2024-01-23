package org.csystem.util.matrix.test;

import org.csystem.util.matrix.MatrixUtil;

public class IsMatrixTest {
    public static void run()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int [][] b = {{1, 2, 3}, {4, 5, 6, 0}, {7, 8, 9}, {10, 11, 12}};

        System.out.println(MatrixUtil.isMatrix(a) ? "Matris" : "Matris değil");
        System.out.println(MatrixUtil.isMatrix(b) ? "Matris" : "Matris değil");
    }

    public static void main(String[] args)
    {
        run();
    }
}
