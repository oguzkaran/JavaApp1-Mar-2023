/*----------------------------------------------------------------------
	FILE        : OperationStatusException.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 05.12.2021

	Class for operation exceptions

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.math;

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
