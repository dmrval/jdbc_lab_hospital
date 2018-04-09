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
//                BdQuerryDoctors.printDocttors.getAlldoctors(connentTo));
////              BdQuerryDoctors.deleteOneDoctor(connentTors(BdQuerryDoco);
//                BdQuerryPatients.addNewPatient(connentTo);
//                BdQuerryPatients.deleteOnePatient(connentTo);
//                BdQuerryPatients.printPatients(BdQuerryPatients.getAllpatiens(connentTo));
//                BdQuerryVisits.printAllVisitsTable(BdQuerryVisits.getAllVisitsTable(connentTo));
//                BdQuerryVisits.printAllVisitsTable(BdQuerryVisits.getAllVisitsTableWithFirstAndLastName(connentTo));
//                BdQuerryAdditionalQuerry.giveDoctorByFirstName(connentTo);
//                BdQuerryAdditionalQuerry.givePatientByFirstName(connentTo);
//                BdQuerryVisits.giveVisitsByOneDoctor(connentTo);
//                BdQuerryVisits.giveVisitsByOneDoctor(connentTo);
//                PritnUserMenu.mainMenu();
//                BdQuerryDoctors.editOneDoctor(connentTo);
//                BdQuerryPatients.editOnePatient(connentTo);
//                BdQuerryDoctors.addNewDoctor(connentTo);
//                BdQuerryDoctors.editOneDoctor(connentTo);
//                BdQuerryVisits.addNewVisit(connentTo);
//                BdQuerryVisits.deleteOneVisit(connentTo);
                BdQuerryVisits.editOneVisit(connentTo);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
