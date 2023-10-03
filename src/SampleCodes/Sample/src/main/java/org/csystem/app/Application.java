/*----------------------------------------------------------------------------------------------------------------------
    Liste tarzı collection sınıflar, elemanları arasında öncelik-sonralık ilişkisi olan collection sınıflardır. Bu sınıflar
    Java'da bir convention (contract) olarak List<E> arayüzünü destekler. List<E> arayüzü Collection<E> arayüzünden türetilmiştir.
    List<E> arayüzünün Collection<E> arayüzünden gelen metotları dışında kalan (yani List<E>'ye eklenen metotlar) önemli
    iki metot indexOf ve get metotlarıdır. indexOf metodu arama işleminde equals metoduna bakarak eşitlik karşılaştırması
    yapacak şekilde override edilir. Bu metot daha önce anlatıldığı gibi Objects sınıfının equals metodu ile override
    edilir. Bu durum List<T> arayüzünün indexOf metodunda da dokümante edilmiştir. get metodu da verilen bir indeksteki
    elemanına ilişkin referansa döner. Yine bu metot da List<T> arayüzünde uygun şekilde dokümante edilmiştir. List<T>
    arayüzüne özgü başka metotlar da bulunmaktadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

class Application {
    public static void run(String[] args)
    {
        var random = new Random();
        var vector = new Vector<Integer>();
        var list = new ArrayList<>();

        while (true) {
            var val = random.nextInt(-20, 20);

            if (NumberUtil.isPrime(val))
                list.add(val);

            vector.add(val);

            if (val == 0)
                break;
        }

        vector.forEach(val -> Console.write("%d ", val));
        Console.writeLine();

        list.addAll(vector);

        list.forEach(val -> Console.write("%d ", val));
        Console.writeLine();

    }
}
