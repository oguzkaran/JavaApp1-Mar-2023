/*----------------------------------------------------------------------
FILE        : IActionCallback.java
AUTHOR      : Oğuz Karan
LAST UPDATE : 30.09.2020

IActionCallback functional interface

Copyleft (c) 1993 by C and System Programmers Association (CSD)
All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.exception;

@FunctionalInterface
public interface IActionCallback {
    void run() throws Exception;
}
