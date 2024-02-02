/*----------------------------------------------------------------------
	FILE        : RepositoryException.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 21.01.2023

	RepositoryException class which can wrap the exception in repository

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.data.repository.exception;

public class RepositoryException extends RuntimeException {
    public RepositoryException(String message)
    {
        this(message, null);
    }

    public RepositoryException(String message, Throwable cause)
    {
        super(message, cause);
    }

    @Override
    public String getMessage()
    {
        var cause = getCause();

        return String.format("Message: %s %s", super.getMessage(), cause != null ? ", Cause Message:" + cause.getMessage() : "");
    }
}
