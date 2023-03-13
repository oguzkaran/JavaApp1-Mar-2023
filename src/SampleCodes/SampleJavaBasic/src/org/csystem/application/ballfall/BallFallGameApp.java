package org.csystem.application.ballfall;

public class BallFallGameApp {
	private BallFallGameApp()
	{
	}

	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		BallFall ballFall = new BallFall();
		
		for (;;) {
			System.out.print("Width?");
			int width = Integer.parseInt(kb.nextLine());	
			
			if (width == 0)
				break;
			
			System.out.print("Height?");
			int height= Integer.parseInt(kb.nextLine());
			
			ballFall.play(width, height);
			
			System.out.println(ballFall.getShapeStr());
		}
	}
}