package org.csystem.util.math.exception;

public class MathException extends Exception {
    private final MathResultStatus m_mathResultStatus;

    public MathException(String message, MathResultStatus mathResultStatus)
    {
        super(message);
        m_mathResultStatus = mathResultStatus;
    }

    public String getMessage()
    {
        return String.format("Message:%s, Status:%s", super.getMessage(), m_mathResultStatus);
    }
}
