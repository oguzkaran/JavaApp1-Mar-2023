/*----------------------------------------------------------------------------------------------------------------------
    Lambda İfadeleri (Lambda Expressions): Java 8 ile birlikte dile eklenmiştir. Lambda ifadeleri genel olarak anonim
    sınıfların daha gelişmiş bir biçimi olarak düşünülebilir. Ancak Lamda ifadeleri her durumda anonim sınıf yerine
    kullanılamaz. Konular içerisinde bu durum anlaşılacaktır. Lambda ifadeleri karmaşık olarak yazılabilse de pratikte
    aşağıdaki 8 genel biçim kullanılır.
        1. (<değişken listesi>) -> <ifade>
        2 . (<değişken listesi>) -> {...}
        3. <değişken> -> ifade
        4. <değişken> -> {...}
        5. () -> ifade
        6. () -> {...}
        7. (<tür veya var değişken> listesi>) -> ifade
        8. (<tür veya var değişken> listesi>) -> {...}
    Aslında ne kadar karmaşık olursa olsun bu 8 genel biçime indirgenebilir. Lambda ifadeleri (uygun) fonksiyonel arayüz
    referanslarına atanabilir. Lambda ifadesi, atanmış olduğu arayüz referansına ilişkin bir tane olan abstract metodun
    yerine geçer. Yani atanmış olan arayüzün abstract metodunun kodları yazılmış olur.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class Application {
    public static void run(String [] args)
    {
        IIntBinaryOperator op = (a, b) -> a - b;
    }
}

interface IIntBinaryOperator {
    int applyAsInt(int a, int b);
}