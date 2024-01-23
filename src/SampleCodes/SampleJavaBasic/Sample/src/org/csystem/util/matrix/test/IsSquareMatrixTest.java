package org.csystem.util.matrix.test;

import org.csystem.util.matrix.MatrixUtil;

public class IsSquareMatrixTest {
    public static void run()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        System.out.println(MatrixUtil.isSquareMatrix(a) ? "Kare matris" : "Kare matris değil");
        System.out.println(MatrixUtil.isSquareMatrix(b) ? "Kare matris" : "Kare matris değil");
    }

    public static void main(String[] args)
    {
        run();
    }
}
