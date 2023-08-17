/*----------------------------------------------------------------------
	FILE        : IConsumer.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 17.08.2023

	IConsumer functional interface

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.generator.random.function;

@FunctionalInterface
public interface IConsumer<T> {
    void accept(T t) throws Exception;
}
