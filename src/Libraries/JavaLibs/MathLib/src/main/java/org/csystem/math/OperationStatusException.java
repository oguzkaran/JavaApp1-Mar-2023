/*----------------------------------------------------------------------
	FILE        : OperationStatusException.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 16.03.2023

	Class for operation exceptions

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.math;

public class OperationStatusException extends RuntimeException {
    private final OperationStatus m_operationStatus;

    public OperationStatusException(String message, OperationStatus operationStatus)
    {
        super(message);
        m_operationStatus = operationStatus;
    }

    public String getMessage()
    {
        return String.format("Message:%s, Operation Status:%s", super.getMessage(), m_operationStatus);
    }
}
