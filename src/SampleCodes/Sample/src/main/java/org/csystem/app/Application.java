/*----------------------------------------------------------------------------------------------------------------------
    Bu durumda bir özet olarak şu söylenebilir. Yalnızca yazma yapılacağı zaman convariance, yalnızca okuma yapılacağı
    zaman contravariant, her ikisi birden yapılacağı zaman ise invariant kullanmak daha esnek bir yapı sağlar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.List;

class Application {
    public static void run(String[] args)
    {

    }
}

class Util {
    public static void copy(List<? extends Number> src, List<? super Number> dest)
    {
        dest.addAll(src);
    }
}