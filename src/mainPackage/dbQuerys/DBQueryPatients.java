package mainPackage.dbQuerys;

import mainPackage.Connections;
import mainPackage.Patient;
import mainPackage.SwithMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBQueryPatients {
    public static final String tableName = "Patients";

    public static List<Patient> getAllPatients(Connection connectTo) throws SQLException {
        ArrayList<Patient> patients = new ArrayList<>();
        try (Statement statement = connectTo.createStatement()) {
            ResultSet rs = statement.executeQuery("select patientId, firstNamePatient, lastNamePatient, ageOfPatient from Patients");
            while (rs.next()) {
                int dPat = rs.getInt(1);
                String fNamePat = rs.getString(2);
                String lNamePat = rs.getString(3);
                int agePat = rs.getInt(4);
                System.out.println("НОМЕР ПАЦИЕНТА: " + dPat + " ФАМИЛИЯ : " + fNamePat + " ИМЯ : " + lNamePat + " ВОЗВРАСТ: " + agePat);
                Patient pat = new Patient(dPat, fNamePat, lNamePat, agePat);
            }
        }
        return patients;
    }

    public static void printPatients(List<Patient> connectTo) {
        for (Patient pat : connectTo) {
            System.out.println(pat);
        }
    }

    public static void addNewPatient(Connection connectTo) {
        try (Statement statement = connectTo.createStatement()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nВВЕДИТЕ ФАМИЛИЮ НОВОГО ПАЦИЕНТА : ");
            System.out.println("Для отмены введите - Отмена");
            String str2 = bufferedReader.readLine();
            if (str2.equals("Отмена")) {
                SwithMenu.sW_Menu_2();
            }
            System.out.println("ВВЕДИТЕ ИМЯ НОВОГО ПАЦИЕНТА : ");
            String str3 = bufferedReader.readLine();
            if (str3.equals("Отмена")) {
                SwithMenu.sW_Menu_2();
            }
            System.out.println("ВВЕДИТЕ ВОЗВРАСТ НОВОГО ПАЦИЕНТА(полных лет) : ");
            String str4 = bufferedReader.readLine();
            if (str4.equals("Отмена")) {
                SwithMenu.sW_Menu_2();
            }
            int intStr4 = Integer.parseInt(str4);
            statement.executeUpdate("insert into mainPackage.Patient (firstNamePatient, lastNamePatient, ageOfPatient)" +
                    " values ('" + str2 + "','" + str3 + "', " + str4 + ")");
            System.out.println("mainPackage.dbQuerys.DBQueryDoctors.addNewDoctor();:: -- " + str2 + " " + str3 + " " + intStr4);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editOnePatient(Connection connetTo) {
        try {
            Statement statement = connetTo.createStatement();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printPatients(getAllPatients(Connections.connectTo()));
            System.out.println("\nВВЕДИТЕ ФАМИЛИЮ ПАЦИЕНТА НА ИЗМЕНЕНИЕ ДАННЫХ");
            System.out.println("Для отмены введите - Отмена");
            String fNameForEdit = bufferedReader.readLine();
            if (fNameForEdit.equals("Отмена")) {
                SwithMenu.sW_Menu_4();
            }
            System.out.println("РЕДАКТИРОВАНИЕ ФАМИЛИИ ");
            String newFirstName = bufferedReader.readLine();
            if (newFirstName.equals("Отмена")) {
                SwithMenu.sW_Menu_4();
            }
            System.out.println("РЕДАКТИРОВАНИЕ ИМЕНИ ");
            String newLastName = bufferedReader.readLine();
            if (newLastName.equals("Отмена")) {
                SwithMenu.sW_Menu_4();
            }
            System.out.println("РЕДАКТИРОВАНИЕ ВОЗВРАСТА ");
            String newAge = bufferedReader.readLine();
            if (newAge.equals("Отмена")) {
                SwithMenu.sW_Menu_4();
            }
            int tempAge = Integer.parseInt(newAge);
            statement.executeUpdate("update mainPackage.Patient set firstNamePatient = '" + newFirstName + "',lastNamePatient = '" + newLastName + "',ageOfPatient  = " +
                    "'" + tempAge + "' where firstNСидорчукamePatient = '" + fNameForEdit + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOnePatient(Connection connectTo) throws IOException {
        try (Statement statement = connectTo.createStatement()) {
            Scanner scanner = new Scanner(System.in);
            printPatients(getAllPatients(Connections.connectTo()));
            System.out.println("\nВВЕДИТЕ ФАМИЛИЮ ПАЦИЕНТА КОТОРЫЙ ПЕРЕСТАЛ ПЛАТИТЬ: ");
            System.out.println("Для отмена введите - Отмена");
            String str = scanner.nextLine();
            if (str.equals("Отмена")) {
                SwithMenu.sW_Menu_3();
            }
            statement.executeUpdate("delete from mainPackage.Patient where firstNamePatient='" + str + "'");
            System.out.println("mainPackage.dbQuerys.DBQueryDoctors::deleteOnePatient(); -- " + str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
