/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Complex sınıfını aşağıdaki açıklamalara göre tasarlayıp yazınız.
	Açıklamalar:
		- Complex sınıfı immutable olacaktır Ayrıca mutable versiyonu olan MutableComplex sınıfı da yazılacaktır
		- Complex ve MutableComplex sınıfları girdi olarak yarıçap(r) ve açı (theta) bilgisini alacaktır. Bu değerlere göre
		karmaşık sayı aşağıdaki formüle göre oluşturulabilecektir:
			i = sqrt(-1) olmak üzere
			z = r * (cos(theta) + i * sin(theta))
-----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------
	FILE			: MutableComplex.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 22.07.2023
	
	MutableComplex class that represents a complex number
	
	Copyleft (c) 1993 C and System Programmers Association 
	All Rights Free
------------------------------------------------------------*/
package org.csystem.math;

import java.io.Serial;
import java.io.Serializable;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class MutableComplex implements Serializable {
	@Serial
	private static final long serialVersionUID = -1L;

	private static final double DELTA = 0.00001;
	public double m_real;
	public double m_imag;
	
	private static MutableComplex add(double re1, double im1, double re2, double im2)
	{
		return new MutableComplex(re1 + re2, im1 + im2);
	}
	
	private static MutableComplex subtract(double re1, double im1, double re2, double im2)
	{
		return add(re1, im1, -re2, -im2);
	}
	
	private static MutableComplex multiply(double re1, double im1, double re2, double im2)
	{
		throw new UnsupportedOperationException("TODO");
	}
	
	private MutableComplex(double real, double imag)
	{
		m_real = real;
		m_imag = imag;
	}

	public static MutableComplex of()
	{
		return of(0);
	}
	public static MutableComplex of(double real)
	{
		return of(real, 0);
	}
	public static MutableComplex of(double real, double imag)
	{
		throw new UnsupportedOperationException("TODO:");
	}

	public static MutableComplex ofPolar(double radius, double theta)
	{
		throw new UnsupportedOperationException("TODO:");
	}

	public double getReal()
	{
		return m_real;
	}

	public void setReal(double real)
	{
		m_real = real;
	}

	public double getImag()
	{
		return m_imag;
	}

	public void setImag(double imag)
	{
		m_imag = imag;
	}

	public static MutableComplex add(double val, MutableComplex z)
	{
		return add(val, 0, z.m_real, z.m_imag);
	}
	
	public MutableComplex add(double real, double imag)
	{
		return add(m_real, m_imag, real, imag);
	}
	
	public MutableComplex add(double val)
	{
		return add(m_real, m_imag, val, 0);
	}
	
	public MutableComplex add(MutableComplex other)
	{
		return add(other.m_real, other.m_imag);
	}
	
	public static MutableComplex subtract(double val, MutableComplex z)
	{
		return subtract(val, 0, z.m_real, z.m_imag);
	}
	
	public MutableComplex subtract(double real, double imag)
	{
		return subtract(m_real, m_imag, real, imag);
	}
	
	public MutableComplex subtract(double val)
	{
		return subtract(m_real, m_imag, val, 0);
	}
	
	public MutableComplex subtract(MutableComplex other)
	{
		return subtract(other.m_real, other.m_imag);
	}
	
	public static MutableComplex multiply(double val, MutableComplex z)
	{
		return multiply(val, 0, z.m_real, z.m_imag);
	}
	
	public MutableComplex multiply(double real, double imag)
	{
		return multiply(m_real, m_imag, real, imag);
	}
	
	public MutableComplex multiply(double val)
	{
		return multiply(m_real, m_imag, val, 0);
	}
	
	public MutableComplex multiply(MutableComplex other)
	{
		return multiply(other.m_real, other.m_imag);
	}
	
	public MutableComplex getConjugate()
	{
		return new MutableComplex(m_real, -m_imag);
	}
	
	public double getLength()
	{
		return sqrt(m_real * m_real + m_imag * m_imag);
	}
	
	public double getNorm()
	{
		return getLength();
	}

	public boolean equals(Object other)
	{
		return other instanceof MutableComplex z && abs(m_real - z.m_real) < DELTA && abs(m_imag - z.m_imag) < DELTA;
	}

	public String toString()
	{
		return String.format("(%.2f, %.2f)", m_real, m_imag);
	}	
}

