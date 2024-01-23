package org.csystem.util.thread;

public final class ThreadUtil {
    public static void sleep(long ms)
    {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ignore) {

        }
    }
}
