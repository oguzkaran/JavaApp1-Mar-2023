/*----------------------------------------------------------------------------------------------------------------------
    Test İşlemleri:
    Yazılımda test süreçleri ürün geliştirmenin önemli bir aşamasını oluşturmaktadır. Bazı yazaılımlarda, ürünün herşeyiyle
    doğru olması kritik öneme sahip olabilmektedir. Bazı yazılımlarda hata toleransları olabilir. Gerektiğinde düzeltilebilir.

    Eskiden yazılım geliştirmede test süreçleri lüks olarak değerlendiriliyordu. Bu nedenle yalnızca büyük firmalar test
    bölümleri barındırıyorlardı. Ancak günümüzde yazılımda kalite (software quality) bilinci daha fazla artmış ve test
    süreçleri daha bilinir hale gelmiştir.

    Yazılımda test süreçleri için çeşitli stratejiler kullanılabilmektedir. Test işlemi en aşağı düzeyde programcının
    kendi yazdığı kodları test etmesi ile başlar. Buna "birim testi (unit testing)" denir. Programcı genel olarak, yazmış
    olduğu bir metodun doğru çalışıp çalışmadığını test eder (duruma göre "etmelidir"). İşte burada bir metot bir "birim (unit)"
    düşünülür. Biri yazılımda aslında parçalar bir araya getirilir. Yani metotlar çağrılarak yazılım geliştirilir. Bu bir
    araya getirme işlemi sonucunda genellikle parçalar yeniden test edilir. Buna da "entegrasyon testi (integration testing)"
    denilmektedir. Yazılımın önemli parçalarına "modül (module)" denir. Modüller de ayrı ayrı test edilebilir. Buna da
    "modül testi (module testing)" denir. Nihayet ürün oluşturulur ve bir bütün olarak test edilir. Genellikle bu testlere
    "kabul testleri (acceptance testing)" denir. Ürün bir bütün olarak önce kurum içerisinde test bölümleri tarafından
    test edilir. Genellikle bu testlere "alfa testi (alpha testing)" denir. Sonra ürün seçilmiş bazı son kullanıcılara
    dağıtılır ve gerçek hayat testine sokulur. Buna genellikle "beta testi (beta testing)" denir.

    Birim testi için prtatikte şu 3 yaklaşımdan biri uygulanır:
    - Hiç birim testi yapmamak: Bu durum yazılım geliştirmede tavsiye edilmese de bir takım özel sebeplerden dolayı firmalar
    tarafından uygulanabilmektedir. Örneğin geliştirici ekibin sayı olarak azlığı, projenin deadline'ının kısa olması,
    rakip firmalardan önce ürünü çıkarma kaygısı vb. durumlarda karşılaşılabilmektedir. Buradaki yaklaşım programcının
    hiç test yapmaması değil, programcıdan bir test beklentisi olmaması ya da özellikle test yapmasının istenmemesi gibi
    düşünülebilir. Şüphesiz programcı geliştirme sürecinde belirli ölçüde test yapacaktır.

    - Katı katıya birim testi yapmak:

    - Gereken birimler için birim testi yapmak:


----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.datetime.stopwatch.StopWatch;
import org.csystem.util.numeric.NumberUtil;

import java.math.BigInteger;

class Application {
    public static void run(String[] args)
    {
        IsPrimeTest.run();
    }
}

class IsPrimeTest {
    public static void run()
    {
        for (;;) {
            var val = Console.readLong("Bir sayı giriniz:");

            if (val <= 1)
                break;

            var stopWatch = new StopWatch();
            Console.writeLine("isPrime(BigInteger)");

            stopWatch.start();
            boolean result = NumberUtil.isPrime(BigInteger.valueOf(val));
            stopWatch.stop();
            Console.writeLine(result ? "Asal" : "Asal değil");
            Console.writeLine("Elapsed in seconds:%.20f", stopWatch.elapsedInMillis() / 1000.);

            Console.writeLine("isPrime(long)");
            stopWatch.start();
            result = NumberUtil.isPrime(val);
            stopWatch.stop();
            Console.writeLine(result ? "Asal" : "Asal değil");
            Console.writeLine("Elapsed in seconds:%.20f", stopWatch.elapsedInMillis() / 1000.);
        }
    }
}

