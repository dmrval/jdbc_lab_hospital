package mainPackage;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * Create Valeev Damir R.
 * Работает с базой данных , в которой 3 таблицы(Пациенты, врач, посещения).
 *
 * */

public class MainClass {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            SwithMenu.sWMain();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String str = null;
//        do {
//            try {
//                str = bufferedReader.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (CheckValidData.isNumber_1_4(str)) {
//                System.out.println("Подходит ");
//            }
//            else System.out.println("НЕТ");
//        }while (0==0);
    }
}
