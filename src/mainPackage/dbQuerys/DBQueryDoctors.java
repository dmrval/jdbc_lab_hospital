package mainPackage.dbQuerys;

import mainPackage.Connections;
import mainPackage.Doctor;
import mainPackage.SwithMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBQueryDoctors {
    public static final String tableName = "Doctors";

    public static List<Doctor> getAllDoctors(Connection connectTo) throws SQLException {
        ArrayList<Doctor> doctors = new ArrayList<>();
        try (Statement statement = connectTo.createStatement()) {
            ResultSet rs = statement.executeQuery("select doctorId, firstName, lastName, profession from Doctors");
            while (rs.next()) {
                int d = rs.getInt(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String prof = rs.getString(4);
                System.out.println("НОМЕР: " + d + " ФАМИЛИЯ: " + fName + " ИМЯ: " + lName + " СПЕЦИАЛИЗАЦИЯ: " + prof);
                Doctor doc = new Doctor(d, fName, lName, prof);
                doctors.add(doc);
//                System.out.println(doctors);
//                System.out.println();
            }
        }
        return doctors;
    }

    public static void printDoctors(List<Doctor> connectTo) {
        for (Doctor doc : connectTo) {
            System.out.println(doc);
        }
    }

    public static void addDoctorYourself(Connection connectTo, Doctor doc) {  //добавление доктора с параметрами вручную
        try {
            PreparedStatement preparedStatement = connectTo.prepareStatement("insert into Doctor(firstName, lastName, profession)" +
                    "values(?,?,?)");
            preparedStatement.setString(1, doc.getFirstName());
            preparedStatement.setString(2, doc.getLastName());
            preparedStatement.setString(3, doc.getProfession());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addNewDoctor(Connection connectTo) {
        try (Statement statement = connectTo.createStatement()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nВВЕДИТЕ ФАМИЛИЮ НОВОГО ДОКТОРА : ");
            System.out.println("Для отмены введите - Отмена");
            String str2 = bufferedReader.readLine();
            if (str2.equals("Отмена")) {
                SwithMenu.sW_Menu_2();
            }
            System.out.println("ВВЕДИТЕ ИМЯ НОВОГО ДОКТОРА : ");
            String str3 = bufferedReader.readLine();
            if (str3.equals("Отмена")) {
                SwithMenu.sW_Menu_2();
            }
            System.out.println("ВВЕДИТЕ СПЕЦИАЛЬЗАЦИЮ НОВОГО ДОКТОРА : ");
            String str4 = bufferedReader.readLine();
            if (str4.equals("Отмена")) {
                SwithMenu.sW_Menu_2();
            }
            statement.executeUpdate("insert into Doctors (firstName, lastName, profession)" +
                    " values ('" + str2 + "','" + str3 + "', '" + str4 + "')");
            System.out.println("DBQueryDoctors.addNewDoctor(); -- " + str2 + " " + str3 + " " + str4);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editOneDoctor(Connection connectTo) {
        try {
            Statement statement = connectTo.createStatement();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            DBQueryDoctors.printDoctors(DBQueryDoctors.getAllDoctors(Connections.connectTo()));
            System.out.println("\nВВЕДИТЕ ФАМИЛИЮ ДОКТОРА НА ИЗМЕНЕНИЕ ДАННЫХ");
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
            System.out.println("РЕДАКТИРОВАНИЕ СПЕЦИЛИЗАЦИИ ");
            String newSpecilization = bufferedReader.readLine();
            if (newSpecilization.equals("Отмена")) {
                SwithMenu.sW_Menu_4();
            }
            statement.executeUpdate("update Doctors set firstName = '" + newFirstName + "',lastName = '" + newLastName + "',profession  = '" + newSpecilization + "' where firstName = '" + fNameForEdit + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOneDoctor(Connection connectTo) throws IOException {
        try (Statement statement = connectTo.createStatement()) {
            Scanner scanner = new Scanner(System.in);
            DBQueryDoctors.printDoctors(DBQueryDoctors.getAllDoctors(Connections.connectTo()));
            System.out.println("\nВВЕДИТЕ ФАМИЛИЮ ДОКТОРА КОТОРОГО УДАЛИТЬ ИЗ БАЗЫ: ");
            System.out.println("для отмены введите - Отмена");
            String str = scanner.nextLine();
            if (str.equals("Отмена")) {
                SwithMenu.sW_Menu_3();
            }
            statement.executeUpdate("delete from Doctors where firstName='" + str + "'");
            System.out.println("DBQueryDoctors::deleteOneDoctor(); -- " + str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

