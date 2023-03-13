package org.csystem.application.ballfall;

public class BallFall {
	private static boolean updateRightFlag(boolean isRight, int ballIndex, int width)
	{
		if (ballIndex == 0)
			isRight = true;		
		else if (ballIndex == width - 1)
			isRight = false;
		
		return isRight;		
	}
	
	private static int updateBallIndex(boolean isRight, int ballIndex)
	{
		if (isRight)
			return ballIndex + 1;
		
		return ballIndex - 1;			
	}
	
	private String m_shapeStr;
	
	private void fillSpace(int begin, int end) //[begin, end)
	{
		for (int i = begin; i < end; ++i)
			m_shapeStr += ' ';
	}
	
	public void fillBall(int ballIndex, int end)
	{
		fillSpace(0, ballIndex);
		m_shapeStr += '*';
		fillSpace(ballIndex + 1, end);
	}	
	
	
	public BallFall()
	{
		m_shapeStr = "";
	}
	
	public void play(int width, int height)
	{
		int ballIndex = 0;
		boolean isRight = false;
		m_shapeStr = "";
		
		for (int i = 1; i <= height; ++i) {
			m_shapeStr += '|';
			fillBall(ballIndex, width);
			if (width != 1) {				
				isRight = updateRightFlag(isRight, ballIndex, width);			
				ballIndex = updateBallIndex(isRight, ballIndex);
			}
			m_shapeStr += "|\r\n";
		}
	}

	public String getShapeStr()
	{
		return m_shapeStr;
	}
}