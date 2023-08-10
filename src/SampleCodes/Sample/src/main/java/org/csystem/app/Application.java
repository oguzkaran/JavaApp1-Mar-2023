/*----------------------------------------------------------------------------------------------------------------------
    Java'da annotation'lar kategori olarak 3 gruba ayrılır: RUNTIME, CLASS, SOURCE
    RUNTIME: Çalışma zamanında kullanılmak üzere tasarlanmış bir annotation olduğunu belirler. Bu ketegorideki
    annotation'ların çalışma zamanında nasıl ele alınacağı "reflection" konusunda detaylandırılacaktır.

    CLASS: Derleyici tarafından arakoda yazılsa da çalışma zamanında kullanılamayan annotation olduğunu belirler.

    SOURCE: Derleyicini arakoda eklemediği bir annotation olacağını belirler

    Anahtar Notlar: CLASS ve SOURCE annotation'ların yazımı ve genel olarak derleme zamanında kullanımı bu kursta ele
    alınmayacaktır. "Java ile Uygulama Geliştirme 2" kursunda ele alınacaktır

    Burada anlatılan kategorilere "retention policy" denir. Bir annotation'ın "retention policy"si Retention annotation'ı
    iler belirlenir. Bu annotation'ın value elemanı RetentionPolicy enum sınıfı türündendir. Yukarıdaki kategoriler bu
    enum sınıfının sabitleridir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class Application {
    public static void run(String [] args)
    {

    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    //...
}

@Retention(RetentionPolicy.CLASS)
@interface YourAnnotation {
    //...
}