package mainPackage;

import javax.annotation.processing.SupportedSourceVersion;
import javax.sql.rowset.WebRowSet;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * Create Valeev Damir R.
 * Работает с базой данных , в которой 3 таблицы(Пациенты, врач, посещения).
 *
 * */

public class MainClass {
    public static void main(String[] args) throws SQLException, TransformerException, ParserConfigurationException {
        try {
            Class.forName("org.sqlite.JDBC");
            SwithMenu.sWMain();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Check Valid Data Code
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        do {
            try {
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (CheckValidData.isNumber_1_4(str)) {
                System.out.println("Yes");
            }
            else System.out.println("No");
        }while (0==0);
        */
    }
}
