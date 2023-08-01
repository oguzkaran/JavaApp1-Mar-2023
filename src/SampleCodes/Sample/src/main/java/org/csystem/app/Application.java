/*----------------------------------------------------------------------------------------------------------------------
    Java 8 ile birlikte java.util.function paketine bir grup fonksiyonel arayüz eklenmiştir. Bu arayüzler özellikle
    yine Java 8 ile eklenen "Stream API" tarafından kullanılmaktadır. Stream API Java'da programlama modelini geliştirmiştir
    ve kullanılabildiği yerde Java programcısının Stream API kullanması kesinlikle gerekir. Stream API ileride ele
    alınacaktır. Şüphesiz bu arayüzler yalnızca Stream API'de kullanılmaz. Gerektiğinde başka sınıflarda da kullanılır,
    programcı da kendisi tasarladığı "high order function"'lar için de gereken arayüzleri kullanabilir.
    java.util.function paketi içerisindeki fonksiyonel arayüzler şu şekilde gruplanabilir:
    1. Function arayüzleri: Bu arayüzler bir ya da iki tane giriş (input) alan ve bir sonuç elde edilmesi gereken işlemlerde
    kullanılır. Bunların en genelleri Function<T, R> ve BiFunction<T, U, R> arayüzleridir. Bu arayüzlerin abstract metotları
    applyXXX biçiminde isimlendirilmiştir

    2. Predicate arayüzleri: Bu arayüzler bir veya iki giriş alan ve sonucunda boolean türden bir değer elde edilmesi
    gereken durumlarda kullanılır. Bu arayüzlerin abstract metotları test biçiminde isimlendirilmiştir

    3. Consumer arayüzleri: Bu arayüzler bir ya da iki girişe göre sadece işlem yapan, bir sonuç vermeyen durumlarda
    kullanılır. Bu arayüzlerin metotları accept olarak isimlendirilmiştir

    4. Operator arayüzleri: Bu arayüzler bir ya da iki girişe göre bir işlem yapılması ve bir sonuç elde edilmesi
    durumunda kullanılır. Bu gruptaki arayüzlerin çoğu Function ve BiFunction arayüzlerinden türetilmiştir. Bu arayüzler
    genel olarak BinaryOperator ve UnaryOperator olarak iki gruba ayrılır. Bu arayüzlerin metotları applyXXX biçiminde
    isimlendirilmiştir

    5. Supplier arayüzleri:  Bu arayüzler bir girş almadan bir değer elde edilmesi durumunda kullanılır. Bu arayüzlerin
    metotları getXXX biçiminde isimlendirilmiştir. getXXX metotların geri dönüş değerleri ilgili türdendir

    Anahtar Notlar: Bu arayüzlerin temel tür karşılıkları her tür ve her işlem için bulunmaz. Bu arayüzlerin tenmel tür
    karşılıkları çok kullanılan ve diğerlerinin bu türlere doğrudan (implicit) dönüşümlerinin geçerli olduğu durumlar
    için vardır.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class Application {
    public static void run(String [] args)
    {

    }
}

