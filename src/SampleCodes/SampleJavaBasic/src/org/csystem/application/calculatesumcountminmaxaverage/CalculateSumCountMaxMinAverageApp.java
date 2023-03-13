package org.csystem.application.calculatesumcountminmaxaverage;

public class CalculateSumCountMaxMinAverageApp {
    public static void run()
    {
        SumCountMaxMinAverageOperation operation = new SumCountMaxMinAverageOperation();

        operation.run();

        operation.displayReport();
    }
}
