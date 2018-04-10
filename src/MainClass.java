import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            SwithMenu.sWMain();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
