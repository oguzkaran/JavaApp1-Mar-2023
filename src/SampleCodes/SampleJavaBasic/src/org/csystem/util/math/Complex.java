/*----------------------------------------------------------------------
	FILE        : Complex.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 14.11.2021

	Immutable Complex class that can be used for Complex numbers

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.math;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;


public class Complex {
	private static Complex add(double real1, double imag1, double real2, double imag2)
	{				
		return new Complex(real1 + real2, imag1 + imag2);
	}
	
	private static Complex subtract(double real1, double imag1, double real2, double imag2)
	{
		return add(real1, imag1, -real2, -imag2);				
	}

	private final double m_real;
	private final double m_imag;
	
	public Complex()
	{
		this(0);
	}	
	
	public Complex(Complex other)
	{
		this(other.m_real, other.m_imag);
	}
	
	public Complex(double re)
	{
		this(re, 0);
	}
	
	public Complex(double re, double im)
	{
		m_real = re;
		m_imag = im;
	}

	public double getReal()
	{
		return m_real;
	}

	public double getImag()
	{
		return m_imag;
	}

	public double getLength()
	{
		return this.getNorm();
	}
	
	public double getNorm()
	{
		return sqrt(m_real * m_real + m_imag * m_imag);
	}	
	
	public Complex getConjugate()
	{
		return new Complex(m_real, -m_imag);
	}
	
	//add	
	public static Complex add(double val, Complex right)
	{
		return add(val, 0, right.m_real, right.m_imag);
	}
	
	public Complex add(Complex right)
	{
		return add(m_real, m_imag, right.m_real, right.m_imag);
	}	
	
	public Complex add(double val)
	{
		return add(m_real, m_imag, val, 0);
	}
	
	//subtract
	public static Complex subtract(double val, Complex right)
	{
		return subtract(val, 0, right.m_real, right.m_imag);
	}
	
	public Complex subtract(Complex right)
	{
		return subtract(m_real, m_imag, right.m_real, right.m_imag);
	}	
	
	public Complex subtract(double val)
	{
		return subtract(m_real, m_imag, val, 0);
	}
	
	//inc
	public Complex inc()
	{
		return this.add(1);
	}
	
	//dec
	public Complex dec()
	{
		return this.inc();
	}

	public String toString()
	{				
		return String.format("|%.1f%si| = %f", m_real, (m_imag < 0 ? " - " : " + ") +  abs(m_imag), this.getNorm());
	}
}
