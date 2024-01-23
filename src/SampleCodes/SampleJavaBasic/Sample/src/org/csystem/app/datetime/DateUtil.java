package org.csystem.app.datetime;

public class DateUtil {
    public static int [] daysOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static String [] monthsTR = {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz",
                                        "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};

    public static String [] daysOfWeekTR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};

    public static String [] monthsEN = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public static String [] daysOfWeekEN = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    public static void printDateTR(int day, int month, int year)
    {
        int dayOfWeek = getDayOfWeek(day, month, year);

        if (dayOfWeek == -1) {
            System.out.println("Geçeriz tarih!...");
            return;
        }

        System.out.printf("%d %s %d %s%n", day, monthsTR[month], year, daysOfWeekTR[dayOfWeek]);
    }

    public static void printDateEN(int day, int month, int year)
    {
        int dayOfWeek = getDayOfWeek(day, month, year);

        if (dayOfWeek == -1) {
            System.out.println("Invalid date!...");
            return;
        }

        System.out.printf("%d%s %s %d %s%n", day, getDaySuffix(day), monthsEN[month], year, daysOfWeekEN[dayOfWeek]);
    }

    public static String getDateStrTR(int day, int month, int year)
    {
        int dayOfWeek = getDayOfWeek(day, month, year);

        return String.format("%d %s %d %s", day, monthsTR[month], year, daysOfWeekTR[dayOfWeek]);
    }

    public static String getDaySuffix(int day)
    {
        return switch (day) {
            case 1, 21, 31 -> "st";
            case 2, 22 -> "nd";
            case 3, 23 -> "rd";
            default -> "th";
        };
    }

    public static int getDayOfWeek(int day, int month, int year)
    {
        int totalDays;

        if (year < 1900 || (totalDays = getDayOfYear(day, month, year)) == -1)
            return -1;

        return (totalDays + getTotalDays(year)) % 7;
    }

    public static int getTotalDays(int year)
    {
        int totalDays = 0;

        for (int y = 1900; y < year; ++y)
            totalDays += isLeapYear(y) ? 366 : 365;

        return totalDays;
    }

    public static int getDayOfYear(int day, int month, int year)
    {
        return isValidDate(day, month, year) ? day + getTotalDaysByMonth(month, year) : -1;
    }

    public static int getTotalDaysByMonth(int month, int year)
    {
        int totalDays = 0;

        for (int m = month - 1; m >= 1; --m)
            totalDays += daysOfMonths[m];

        return month > 2 && isLeapYear(year) ? totalDays + 1 : totalDays;
    }

    public static boolean isValidDate(int day, int month, int year)
    {
        return 1 <= day && day <= 31 && 1 <= month && month <= 12 && day <= getDays(month, year);
    }

    public static int getDays(int month, int year)
    {
        return month == 2 && isLeapYear(year) ? 29 : daysOfMonths[month];
    }

    public static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
