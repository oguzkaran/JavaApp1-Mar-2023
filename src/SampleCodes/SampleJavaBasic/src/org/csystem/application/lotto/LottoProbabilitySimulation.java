package org.csystem.application.lotto;

public class LottoProbabilitySimulation {
	private int m_count;
	private double m_game1Prob;
	private double m_game2Prob;
	private double m_game3Prob;
	
	public LottoProbabilitySimulation(int n)
	{
		m_count = n;
	}
	
	public void run()
	{
		java.util.Random r = new java.util.Random();
		Lotto lotto = new Lotto(r);
		int win1Count, win2Count, win3Count;
		
		win1Count= win2Count = win3Count = 0;
		
		for (int i = 0; i < m_count; ++i) {
			lotto.play();
			
			if (lotto.isWinGame1())
				++win1Count;
			
			if (lotto.isWinGame2())
				++win2Count;
			
			if (lotto.isWinGame3())
				++win3Count;
		}
		
		m_game1Prob = (double)win1Count / m_count;
		m_game2Prob = (double)win2Count / m_count;
		m_game3Prob = (double)win3Count / m_count;
	}

	public int getCount()
	{
		return m_count;
	}

	public void setCount(int count)
	{
		m_count = count;
	}

	public double getGame1Prob()
	{
		return m_game1Prob;
	}

	public double getGame2Prob()
	{
		return m_game2Prob;
	}

	public double getGame3Prob()
	{
		return m_game3Prob;
	}
}
