package mainPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckValidData {

    public static boolean isYear(String s) {
        return s != null && s.matches("20[0-2][0-9]");
    }

    public static boolean isDay(String day) {//WoRK
        return day != null && day.matches("([0-9]|1[0-9]|2[0-9]|30|31)");
    }

    public static boolean isMounth(String day) {
        return day != null && day.matches("Январь|Февраль|Март|Апрель|Май|Июнь|Июль|Август|Сентябрь|Октябрь|Ноябрь|Декабрь");
    }

    public static boolean isHour(String day) {
        return day != null && day.matches("([0-9]|1[0-9]|2[0-3])");
    }

    public static boolean isMinut(String day) {
        return day != null && day.matches("^(?!60$)([0-5][0-9]|[0-9])$");
    }

    public static boolean isName(String day) {
        return day != null && day.matches("^[a-zA-Zа-яА-Я]+$");
    }

    public static boolean isAge(String day) {
        return day != null && day.matches("[0-9][0-9]");
    }

    public static boolean isNumber_1_4(String day) {
        return day != null && day.matches("[0-9]|[0-9][0-9]|[0-9][0-9][0-9]|[0-9][0-9][0-9][0-9]");
    }

}
