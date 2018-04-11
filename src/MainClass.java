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
//            BdQuerryVisits.addNewVisit(Connections.connectTo());
            Times.getDateForSql(18,2,12);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
