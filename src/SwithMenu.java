import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SwithMenu {

    public static void sWMain() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        PritnUserMenu.mainMenu();
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                sW_Menu_1();
                break;
            case 2:
                sW_Menu_2();
                break;
            case 3:
                sW_Menu_3();
                break;
            case 4:
                sW_Menu_4();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

    public static void sW_Menu_1() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        PritnUserMenu.menu_1();
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                BdQuerryPatients.printPatients(BdQuerryPatients.getAllpatiens(Connections.connectTo()));
                sW_Menu_1();
                break;
            case 2:
                BdQuerryDoctors.printDoctors(BdQuerryDoctors.getAlldoctors(Connections.connectTo()));
                sW_Menu_1();
                break;
            case 3:
                BdQuerryVisits.printAllVisitsTable(BdQuerryVisits.getAllVisitsTableWithFirstAndLastName(Connections.connectTo()));
                sW_Menu_1();
                break;
            case 4:
                sWMain();
        }
    }

    public static void sW_Menu_2() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        PritnUserMenu.menu_2();
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                BdQuerryPatients.addNewPatient(Connections.connectTo());
                sW_Menu_2();
                break;
            case 2:
                BdQuerryDoctors.addNewDoctor(Connections.connectTo());
                sW_Menu_2();
                break;
            case 3:
                BdQuerryVisits.addNewVisit(Connections.connectTo());
                sW_Menu_2();
                break;
            case 4:
                sWMain();
        }
    }

    public static void sW_Menu_3() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        PritnUserMenu.menu_3();
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                BdQuerryPatients.deleteOnePatient(Connections.connectTo());
                sW_Menu_3();
                break;
            case 2:
                BdQuerryDoctors.deleteOneDoctor(Connections.connectTo());
                sW_Menu_3();
                break;
            case 3:
                BdQuerryVisits.deleteOneVisit(Connections.connectTo());
                sW_Menu_3();
                break;
            case 4:
                sWMain();
        }
    }

    public static void sW_Menu_4() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        PritnUserMenu.menu_4();
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                BdQuerryPatients.editOnePatient(Connections.connectTo());
                sW_Menu_4();
                break;
            case 2:
                BdQuerryDoctors.editOneDoctor(Connections.connectTo());
                sW_Menu_4();
                break;
            case 3:
                BdQuerryVisits.editOneVisit(Connections.connectTo());
                sW_Menu_4();
                break;
            case 4:
                sWMain();
        }
    }
}
