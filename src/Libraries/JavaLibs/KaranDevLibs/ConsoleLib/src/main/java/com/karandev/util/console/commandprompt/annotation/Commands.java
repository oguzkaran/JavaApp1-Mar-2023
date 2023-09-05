/*----------------------------------------------------------------------
	FILE        : Commands.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 05.09.2023

	Commands annotation of REPL framework

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.console.commandprompt.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Commands {
    Command [] value();
}
