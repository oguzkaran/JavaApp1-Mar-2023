/*----------------------------------------------------------------------
	FILE        : IIntConsumer.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 17.08.2023

	IIntConsumer functional interface

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.generator.random.function;

@FunctionalInterface
public interface IIntConsumer {
    void accept(int val) throws Exception;
}
