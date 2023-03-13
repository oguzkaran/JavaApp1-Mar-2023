package org.csystem.application.calculatesumcountminmaxaverage;

import java.util.Scanner;

public class SumCountMaxMinAverageOperation {
	private final Scanner m_kb;
	private final SumCountMaxMinAverage m_sumCountMaxMinAverage;

	private int getValue()
	{
		for (;;) {
			System.out.print("Bir tamsayı giriniz:");
			int val = Integer.parseInt(m_kb.nextLine());

			if (0 <= val && val <= 100)
				return val;

			System.out.print("Geçersiz değer girdiniz!...Yeni bir değer giriniz:");
		}
	}

	private int getOption()
	{
		int option;

		do
			option = Integer.parseInt(m_kb.nextLine());
		while (option != 0 && option != 1);

		return option;
	}

	public SumCountMaxMinAverageOperation()
	{
		m_kb = new Scanner(System.in);
		m_sumCountMaxMinAverage = new SumCountMaxMinAverage();
	}

	public SumCountMaxMinAverage getSumCountMaxMinAverage()
	{
		return m_sumCountMaxMinAverage;
	}

	public void run()
	{
		for (;;) {
			int val = getValue();
			m_sumCountMaxMinAverage.sum(val);

			System.out.print("Yeni bir değer girmek istiyor musunuz?[Evet için 1(bir) Hayır için 0(sıfır) değerlerinden birini giriniz]");
			int option = getOption();
			if (option == 0)
				break;
		}
	}

	public void displayReport()
	{
		System.out.printf("Toplam %d değer girildi%n", m_sumCountMaxMinAverage.getCount());
		System.out.printf("Max = %d%n", m_sumCountMaxMinAverage.getMax());
		System.out.printf("Min = %d%n", m_sumCountMaxMinAverage.getMin());
		System.out.printf("Ortalama = %f%n", m_sumCountMaxMinAverage.getAverage());
	}
}