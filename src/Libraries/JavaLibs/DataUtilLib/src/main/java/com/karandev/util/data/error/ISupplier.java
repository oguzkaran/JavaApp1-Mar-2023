/*----------------------------------------------------------------------
	FILE        : ISupplier.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 21.01.2023

	ISupplier interface that can be used for checked exceptions

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.data.error;

@FunctionalInterface
public interface ISupplier<R> {
    R get() throws Exception;
}
