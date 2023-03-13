/*----------------------------------------------------------------------
	FILE        : Month.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 24.10.2021

	enum class that represents months

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime;

public enum Month {
    JAN(31), FEB(28), MAR(31), APR(30), MAY(31), JUN(30), JUL(31), AUG(31), SEP(30), OCT(31), NOV(30), DEC(31);

    Month(int days)
    {
        this.days = days;
    }

    final int days;

    int getDays(int year)
    {
        return ordinal() == 1 && Date.isLeapYear(year) ? 29 : days;
    }
}
