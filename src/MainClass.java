import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection connentTo = DriverManager.getConnection("jdbc:sqlite:Hospital.db")) {
                PritnUserMenu.mainMenu();
                Scanner scanner = new Scanner(System.in);
                int i;
                    i = scanner.nextInt();
                        switch (i) {
                            case 1:
                                PritnUserMenu.menu_1();
                                int j = scanner.nextInt();
                                switch (j) {
                                    case 1:
                                        BdQuerryPatients.printPatients(BdQuerryPatients.getAllpatiens(connentTo));
                                        break;
                                    case 2:
                                        BdQuerryDoctors.printDoctors(BdQuerryDoctors.getAlldoctors(connentTo));
                                        break;
                                    case 3:
                                        BdQuerryVisits.printAllVisitsTable(BdQuerryVisits.getAllVisitsTableWithFirstAndLastName(connentTo));
                                        break;
                                    case 4:
                                        System.out.println("4 - Вернуться назад");
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("2222");
                            case 3:
                            case 4:
                        }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
