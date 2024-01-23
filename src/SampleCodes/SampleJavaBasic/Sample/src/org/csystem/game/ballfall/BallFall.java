package org.csystem.game.ballfall;

public class BallFall {
	private final StringBuilder m_shape;

	private static boolean calculateRightFlag(boolean isRight, int ballIndex, int width)
	{
		if (ballIndex == 0)
			isRight = true;
		else if (ballIndex == width - 1)
			isRight = false;
		
		return isRight;
	}
	
	private static int calculateBallIndex(int ballIndex, boolean isRight)
	{
		if (isRight)
			return ballIndex + 1;
		
		return ballIndex - 1;		
	}

	private void fillSpace(int begin, int end)
	{
		m_shape.append(" ".repeat(end - begin));
	}

	private void fillBall(int ballIndex, int end)
	{
		fillSpace(0, ballIndex);
		m_shape.append('*');
		fillSpace(ballIndex + 1, end);
	}

	public BallFall()
	{
		m_shape = new StringBuilder();
	}

	public String getShape()
	{
		return m_shape.toString();
	}
	
	public void play(int width, int height)
	{
		if (width <= 0 || height <= 0)
			throw new IllegalArgumentException(String.format("Illegal width or height value!... -> Width:%d, Height:%d", width, height));

		int ballIndex = 0;
		boolean isRight = false;

		m_shape.delete(0, m_shape.length());

		for (int i = 1; i <= height; ++i) {
			m_shape.append('|');
			fillBall(ballIndex, width);
			if (width != 1) {
				isRight = calculateRightFlag(isRight, ballIndex, width);
				ballIndex = calculateBallIndex(ballIndex, isRight);
			}
			m_shape.append('|').append('\r').append('\n');
		}
	}
}
