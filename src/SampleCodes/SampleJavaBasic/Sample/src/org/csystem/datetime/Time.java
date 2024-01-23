/*----------------------------------------------------------------------------------------------------------------------
    Aşağıda bildirilen Date sınıfını açıklamalara göre yazınız
    Açıklamalar:
        - Sınıf bir zamanı temsil edecektir (saat, dakika, saniye ve milisaniye)

        - JavaSE'nin veya başka bir kütüphanenin tarih zaman işlemlerine ilişkin sınıfları ve metotları kullanılmayacaktır

        - Sınıfın public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz

        - Sınıf geçersiz zaman durumunu kontrol edecektir. Geçersizlik durumunda bir mesaj vererek program sonlandırılacaktır.

        - Sınıf 24 saat dilimine göre değerleri ele alacaktır

        - Sınıfa ilişkin test kodlarını da yazınız
-----------------------------------------------------------------------------------------------------------------------*/

/*------------------------------------------------------------------
	FILE		: Time.java
	AUTHOR		: Java-Nov-2022 Group
	LAST UPDATE	: 22.07.2023

	Time class that represents a time

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
------------------------------------------------------------------ */
package org.csystem.datetime;

public class Time {

    public Time(int hour, int minute, int second, int millisecond)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public int getHour()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public void setHour(int hour)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public int getMinute()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public void setMinute(int minute)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public int getSecond()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public void setSecond(int second)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public int getMillisecond()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public void setMillisecond(int millisecond)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public boolean equals(Object other)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public String toString()
    {
        throw new UnsupportedOperationException("TODO -> 09:31:34");
    }

    public String toShortTimeString()
    {
        throw new UnsupportedOperationException("TODO -> 09:31");
    }

    public String toLongTimeString()
    {
        throw new UnsupportedOperationException("TODO -> 09:31:34.345");
    }
}
