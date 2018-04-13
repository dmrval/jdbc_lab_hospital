import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
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
    }
}
