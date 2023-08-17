/*----------------------------------------------------------------------
	FILE        : IRunnable.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 17.08.2023

	IRunnable class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/

package org.csystem.util.scheduler;

@FunctionalInterface
public interface IRunnable {
    void run() throws Exception;
}
