package mainPackage;

import java.util.Date;

public class Times {
    public static Date getDateForSql(int year, int month, int dayOfMonth) {
        java.sql.Date date = new java.sql.Date(year, month, dayOfMonth);
        System.out.println(date);
        return date;
    }

    public static int nameMounth(String mounth) {
        switch (mounth) {
            case "Январь":
                return 0;
            case "Февраль":
                return 1;
            case "Март":
                return 2;
            case "Апрель":
                return 3;
            case "Май":
                return 4;
            case "Июнь":
                return 5;
            case "Июль":
                return 6;
            case "Август":
                return 7;
            case "Сентябрь":
                return 8;
            case "Октябрь":
                return 9;
            case "Ноябрь":
                return 10;
            case "Декабрь":
                return 11;
        }
        return 10;
    }
}