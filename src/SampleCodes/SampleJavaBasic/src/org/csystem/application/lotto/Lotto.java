package org.csystem.application.lotto;

import org.csystem.util.number.NumberUtil;

import java.util.Random;

public class Lotto {
	private final Random m_random;
	private boolean m_winGame1;
	private boolean m_winGame2;
	private boolean m_winGame3;
	
	private int randomValue()
	{
		return m_random.nextInt(99) + 1;
	}
	
	private int getFirst()
	{
		return randomValue();
	}
	
	private int getSecond(int first)
	{
		int second = 0;
		
		while ((second = randomValue()) == first)
			;
		
		return second;
	}
	
	private int getThird(int first, int second)
	{
		int third = 0;
		
		while ((third = randomValue()) == first || third == second)
			;
		
		return third;		
	}
	
	
	private void playGame1(int first, int second, int third)
	{
		m_winGame1 = first + second + third < 150;
	}
	
	private void playGame2(int first, int second, int third)
	{
		m_winGame2 = NumberUtil.isPrime(first + second + third);
	}
	
	private void playGame3(int first, int second, int third)
	{
		int min = Math.min(Math.min(first, second), third);
		int max = Math.max(Math.max(first, second), third);
		int mid = first + second + third - max - min;
		
		m_winGame3 = max - min > mid;
	}

	public Lotto()
	{
		this(new Random());
	}
	
	public Lotto(Random r)
	{
		m_random = r;
	}
	
	public void play()
	{
		int first = getFirst();
		int second = getSecond(first);
		int third = getThird(first, second);		
		
		playGame1(first, second, third);
		playGame2(first, second, third);
		playGame3(first, second, third);				
	}

	public boolean isWinGame1()
	{
		return m_winGame1;
	}

	public boolean isWinGame2()
	{
		return m_winGame2;
	}

	public boolean isWinGame3()
	{
		return m_winGame3;
	}
}
