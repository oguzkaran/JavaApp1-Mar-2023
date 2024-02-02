/*----------------------------------------------------------------------
	FILE        : IRunnable.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 21.01.2023

	IRunnable interface that can be used for checked exceptions

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.data.error;

@FunctionalInterface
public interface IRunnable {
    void run() throws Exception;
}
