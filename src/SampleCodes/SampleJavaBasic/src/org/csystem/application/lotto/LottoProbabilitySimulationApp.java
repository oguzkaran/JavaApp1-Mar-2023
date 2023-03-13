package org.csystem.application.lotto;

class LottoProbabilitySimulationApp {
	private LottoProbabilitySimulationApp()
	{
	}

	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		
		LottoProbabilitySimulation simulation = new LottoProbabilitySimulation(n);
		
		simulation.run();
		
		System.out.printf("1. oyunun kazanma olasılığı:%f%n", simulation.getGame1Prob());
		System.out.printf("2. oyunun kazanma olasılığı:%f%n", simulation.getGame2Prob());
		System.out.printf("3. oyunun kazanma olasılığı:%f%n", simulation.getGame3Prob());
	}
}
