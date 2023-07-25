package org.csystem.util.math;

import org.csystem.util.math.exception.MathException;
import org.csystem.util.math.exception.MathResultStatus;

public final class MathUtil {
    private MathUtil()
    {}

    public static double sqrt(double val) throws MathException
    {
        if (val < 0)
            throw new MathException("Invalid argument for sqrt", MathResultStatus.NAN);

        return Math.sqrt(val);
    }
}
