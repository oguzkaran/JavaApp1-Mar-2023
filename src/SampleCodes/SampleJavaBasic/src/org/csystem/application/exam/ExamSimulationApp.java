/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Bir okulda Matematik sınavı ortak olarak yapılıyor olsun. Kaç şube ve herbir şubede kaç öğrenci olduğu
	bilgisi klavyeden alınsın. Öğrencilerin notları rasgele belirlensin. Tüm bu işlemlerden sonra Matematik sınavı
	için herbir şubenin ayrı ayrı not ortalamaları ile okulun ortalamasını bulan basit bir simülasyon programını
	yazınız. Programı mümkün olduğunca genel düşünerek yazmaya çalışınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.application.exam;

public class ExamSimulationApp {
    private ExamSimulationApp()
    {
    }
    public static void run()
    {
        ExamSimulation examSimulationMath = new ExamSimulation("Matematik");
        ExamSimulation examSimulationPhysics = new ExamSimulation("Fizik");

        examSimulationMath.run();
        examSimulationPhysics.run();
        examSimulationMath.displayReport();
        examSimulationPhysics.displayReport();
    }
}
