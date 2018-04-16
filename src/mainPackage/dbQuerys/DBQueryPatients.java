package mainPackage.dbQuerys;

import mainPackage.CheckValidData;
import mainPackage.Connections;
import mainPackage.Patient;
import mainPackage.SwithMenu;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
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
                System.out.println("Номер пациента: " + dPat + " фамилия : " + fNamePat + " имя : " + lNamePat + " возвраст: " + agePat);
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
            System.out.println("\nВведите фамилию нового пациента : ");
            System.out.println("Для отмены Введите - Отмена");
            String str2;
            do {
                str2 = bufferedReader.readLine();
                if (str2.equals("Отмена")) {
                    SwithMenu.sW_Menu_2();
                }
                if (!CheckValidData.isName(str2)) {
                    System.out.println("Неверный формат повторите");
                }
            }while (!CheckValidData.isName(str2));

            System.out.println("Введите имя нового пациента : ");
            String str3;
            do {
                str3 = bufferedReader.readLine();
                if (str3.equals("Отмена")) {
                    SwithMenu.sW_Menu_2();
                }
                if (!CheckValidData.isName(str3)) {
                    System.out.println("Неверный формат повторите");
                }
            }while (!CheckValidData.isName(str3));

            String str4;
            do {
                System.out.println("Введите возвраст нового пациента(полных лет) : ");
                str4 = bufferedReader.readLine();
                if (!CheckValidData.isAge(str4)) {
                    System.out.println("Неверный формат повторите ввод(только числа 0-99)");
                }
                if (str4.equals("Отмена")) {
                    SwithMenu.sW_Menu_2();
                }
            } while (!CheckValidData.isAge(str4));
            int intStr4 = Integer.parseInt(str4);
            statement.executeUpdate("insert into Patients (firstNamePatient, lastNamePatient, ageOfPatient)" +
                    " values ('" + str2 + "','" + str3 + "', " + str4 + ")");
//            System.out.println("mainPackage.dbQuerys.DBQueryDoctors.addNewDoctor();:: -- " + str2 + " " + str3 + " " + intStr4);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void editOnePatient(Connection connetTo) {
        try {
            Statement statement = connetTo.createStatement();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printPatients(getAllPatients(Connections.connectTo()));
            System.out.println("\nВведите фамилию пациента на изменение данных");
            System.out.println("Для отмены введите - Отмена");
            String fNameForEdit;
            do {
                fNameForEdit = bufferedReader.readLine();
                if (fNameForEdit.equals("Отмена")) {
                    SwithMenu.sW_Menu_4();
                }
                if (!CheckValidData.isName(fNameForEdit)) {
                    System.out.println("Неверный формат повторите");
                }
            }while (!CheckValidData.isName(fNameForEdit));
            System.out.println("Редактирование фамилии ");
            String newFirstName;
            do {
                newFirstName = bufferedReader.readLine();
                if (newFirstName.equals("Отмена")) {
                    SwithMenu.sW_Menu_4();
                }
                if (!CheckValidData.isName(newFirstName)) {
                    System.out.println("Неверный формат повторите");
                }
            }while (!CheckValidData.isName(newFirstName));
            System.out.println("Редактирование имени ");
            String newLastName;
            do {
                newLastName = bufferedReader.readLine();
                if (newLastName.equals("Отмена")) {
                    SwithMenu.sW_Menu_4();
                }
                if (!CheckValidData.isName(newFirstName)) {
                    System.out.println("Неверный формат повторите");
                }
            }while (!CheckValidData.isName(newFirstName));

            System.out.println("Редактирование возвраста ");
            String newAge;
            do {
                newAge = bufferedReader.readLine();
                if (newAge.equals("Отмена")) {
                    SwithMenu.sW_Menu_4();
                }
                System.out.println("Неверный формат повторите");
            } while (!CheckValidData.isYear(newAge));
            int tempAge = Integer.parseInt(newAge);
            statement.executeUpdate("update Patients set firstNamePatient = '" + newFirstName + "',lastNamePatient = '" + newLastName + "',ageOfPatient  = " +
                    "'" + tempAge + "' where firstNamePatient = '" + fNameForEdit + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOnePatient(Connection connectTo) throws IOException {
        try (Statement statement = connectTo.createStatement()) {
            Scanner scanner = new Scanner(System.in);
            printPatients(getAllPatients(Connections.connectTo()));
            System.out.println("\nВведите фамилию пациента который перестал платить: ");
            System.out.println("Для отмена Введите - Отмена");
            String str;
            do {
                str = scanner.nextLine();
                if (str.equals("Отмена")) {
                    SwithMenu.sW_Menu_3();
                }
                if (!CheckValidData.isName(str)) {
                    System.out.println("Неверный формат повторите ввод(0-99)");
                }
            }while (!CheckValidData.isName(str));
            statement.executeUpdate("delete from Patients where firstNamePatient='" + str + "'");
//            System.out.println("mainPackage.dbQuerys.DBQueryDoctors::deleteOnePatient(); -- " + str);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
