package org.csystem.app.simulation.exam;

import org.csystem.simulation.exam.ExamSimulation;

import java.util.Random;

public class ExamSimulationApp {
    private static void run()
    {
        Random r = new Random();

        ExamSimulation mathSimulation = new ExamSimulation("Matematik", r);
        ExamSimulation physSimulation = new ExamSimulation("Fizik", r);

        mathSimulation.run();
        physSimulation.run();

        mathSimulation.displayReport();
        physSimulation.displayReport();
    }

    public static void main(String[] args)
    {
        run();
    }
}
