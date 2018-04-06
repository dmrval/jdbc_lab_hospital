import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("org.sqlite.JDBC");
//        try (Connection connentTo = DriverManager.getConnection("jdbc:sqlite:MusicSalone.db")) {
//        }
//        System.out.println("Главное меню: ");
//        int token;
//        Scanner scanner = new Scanner(System.in);
//        token = scanner.nextInt();
//        switch (token) {
//            case 1:
//            case 2:
//            case 3:
//            case 4:
//                default:
//        }
        GiveAllMenu.giveMainMenu();
    }
}
