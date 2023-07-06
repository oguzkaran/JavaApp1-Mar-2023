/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Yukarıdaki örneği aşağıdaki gibi çalıştırabilecek şekilde yazınız.
        java -jar PeriodicTexGenerator-1.0.0.jar count min bound delay period,
    Program aldığı komut satırı argümanlarına göre periyodik olarak üreteceği, karakter sayısı [min, bound) aralığında
    rasgele belirlenen, İngilizce alfabedeki karakterlerden oluşan yazıları stdout'a satır satır basacaktır.
    Çözüm için ~/src/Projects/005-PeriodicTextGeneratorApp uygulamasını inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

class Application {
    public static void run(String [] args)
    {
        var timer = new Timer();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss");

        timer.scheduleAtFixedRate(new TimerTask() {
            int n;
            public void run()
            {
                Console.write("%s\r", formatter.format(LocalDateTime.now()));
            }
        }, 0, 1000);
    }
}
