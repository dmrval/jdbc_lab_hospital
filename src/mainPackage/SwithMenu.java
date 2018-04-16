package mainPackage;

import mainPackage.dbQuerys.DBQueryDoctors;
import mainPackage.dbQuerys.DBQueryPatients;
import mainPackage.dbQuerys.DBQueryVisits;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class SwithMenu {

    public static void sWMain() throws SQLException, IOException, TransformerException, ParserConfigurationException, ClassNotFoundException {
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
                sW_Menu_5();
            case 6:
                System.exit(0);
                break;
        }
    }

    public static void sW_Menu_1() throws SQLException, IOException, TransformerException, ParserConfigurationException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PritnUserMenu.menu_1();
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                DBQueryPatients.printPatients(DBQueryPatients.getAllPatients(Connections.connectTo()));
                sW_Menu_1();
                break;
            case 2:
                DBQueryDoctors.printDoctors(DBQueryDoctors.getAllDoctors(Connections.connectTo()));
                sW_Menu_1();
                break;
            case 3:
                DBQueryVisits.printAllVisitsTable(DBQueryVisits.getAllVisitsTableWithFirstAndLastName(Connections.connectTo()));
                sW_Menu_1();
                break;
            case 4:
                sWMain();
        }
    }

    public static void sW_Menu_2() throws SQLException, IOException, TransformerException, ParserConfigurationException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PritnUserMenu.menu_2();
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                DBQueryPatients.addNewPatient(Connections.connectTo());
                sW_Menu_2();
                break;
            case 2:
                DBQueryDoctors.addNewDoctor(Connections.connectTo());
                sW_Menu_2();
                break;
            case 3:
                DBQueryVisits.addNewVisit(Connections.connectTo());
                sW_Menu_2();
                break;
            case 4:
                sWMain();
        }
    }

    public static void sW_Menu_3() throws SQLException, IOException, TransformerException, ParserConfigurationException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PritnUserMenu.menu_3();
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                DBQueryPatients.deleteOnePatient(Connections.connectTo());
                sW_Menu_3();
                break;
            case 2:
                DBQueryDoctors.deleteOneDoctor(Connections.connectTo());
                sW_Menu_3();
                break;
            case 3:
                DBQueryVisits.deleteOneVisit(Connections.connectTo());
                sW_Menu_3();
                break;
            case 4:
                sWMain();
        }
    }

    public static void sW_Menu_4() throws SQLException, IOException, TransformerException, ParserConfigurationException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PritnUserMenu.menu_4();
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                DBQueryPatients.editOnePatient(Connections.connectTo());
                sW_Menu_4();
                break;
            case 2:
                DBQueryDoctors.editOneDoctor(Connections.connectTo());
                sW_Menu_4();
                break;
            case 3:
                DBQueryVisits.editOneVisit(Connections.connectTo());
                sW_Menu_4();
                break;
            case 4:
                sWMain();
        }
    }

    public static void sW_Menu_5() throws SQLException, IOException, TransformerException, ParserConfigurationException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PritnUserMenu.menu_5();
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                ExportToXML.ExportToXMLPatients();
                sW_Menu_5();
                break;
            case 2:
                ExportToXML.ExportToXMLDoctors();
                sW_Menu_5();
                break;
            case 3:
                ExportToXML.ExportToXMLVisits();
                sW_Menu_5();
                break;
            case 4:
                sWMain();
        }
    }
}
