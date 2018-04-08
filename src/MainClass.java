import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection connentTo = DriverManager.getConnection("jdbc:sqlite:Hospital.db")) {
//            BdQuerryDoctors.getAlldoctors(connentTo);
//            BdQuerryDoctors.printDoctors(BdQuerryDoctors.getAlldoctors(connentTo));
//                BdQuerryDoctors.deleteOneDoctor(connentTo);
//                BdQuerryDoctors.addNewDoctor(connentTo);
//                BdQuerryDoctors.printDoctors(BdQuerryDoctors.getAlldoctors(connentTo));
//                BdQuerryDoctors.deleteOneDoctor(connentTo);
                BdQuerryPatients.printPatients(BdQuerryPatients.getAllpatiens(connentTo));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
