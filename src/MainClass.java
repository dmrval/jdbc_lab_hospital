import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
//            SwithMenu.sWMain();
            java.sql.Date sqlDate = new java.sql.Date(2012,11,12);
//            System.out.println(sqlDate.getYear()+"-"+);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
