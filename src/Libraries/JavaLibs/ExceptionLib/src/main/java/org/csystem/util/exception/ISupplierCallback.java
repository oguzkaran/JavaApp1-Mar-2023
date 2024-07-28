/*----------------------------------------------------------------------
FILE        : ISupplierCallback.java
AUTHOR      : Oğuz Karan
LAST UPDATE : 30.09.2020

ISupplierCallback<T> functional interface

Copyleft (c) 1993 by C and System Programmers Association (CSD)
All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.exception;

@FunctionalInterface
public interface ISupplierCallback<R> {
    R get() throws Exception;
}
