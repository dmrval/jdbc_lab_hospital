import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SwithMenu {

    public static void sWMain() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        PritnUserMenu.mainMenu();
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                sW_Menu_1();
                break;
            case 2:
            case 3:
            case 4:
        }
    }

    public static void sW_Menu_1() throws SQLException {
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
}
