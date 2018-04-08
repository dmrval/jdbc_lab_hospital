import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BdQuerryDoctors {

    public static List<Doctors> getAlldoctors(Connection connectTo) throws SQLException {
        ArrayList<Doctors> doctors = new ArrayList<>();
        try (Statement statement = connectTo.createStatement()) {
            ResultSet rs = statement.executeQuery("select doctorId, firstName, lastName, profession from Doctors");
            while (rs.next()) {
                int d = rs.getInt(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String prof = rs.getString(4);
                System.out.println("BdQuerryDoctors::getAlldoctors(); -- d:" + d + " fName:" + fName + " lName:" + lName + " prof:" + prof);
                Doctors doc = new Doctors(d, fName, lName, prof);
                doctors.add(doc);
            }
        }
        return doctors;
    }

    public static void printDoctors(List<Doctors> connectTo) {
        for (Doctors doc : connectTo) {
            System.out.println(doc);
        }
    }

//    public static void addDoctorYourself(Connection connectTo, Doctors doc) {  //добавление доктора с параметрами вручную
//        try {
//            PreparedStatement preparedStatement = connectTo.prepareStatement("insert into Doctors(firstName, lastName, profession)" +
//                    "values(?,?,?)");
//            preparedStatement.setString(1, doc.getFirstName());
//            preparedStatement.setString(2, doc.getLastName());
//            preparedStatement.setString(3, doc.getProfession());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    public static void addNewDoctor(Connection connectTo) {
        try (Statement statement = connectTo.createStatement()) {
//            System.out.println("Введите уникальный номер доктора : ");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            String cx = bufferedReader.readLine();
//            int str1 = Integer.parseInt(cx);
            System.out.println("Введите фамилию нового доктора : ");
            String str2 = bufferedReader.readLine();
            System.out.println("Введите имя нового доктора : ");
            String str3 = bufferedReader.readLine();
            System.out.println("Введите специлиализацию нового доктора : ");
            String str4 = bufferedReader.readLine();
            statement.executeUpdate("insert into Doctors (firstName, lastName, profession)" +
                    " values ('" + str2 + "','" + str3 + "', '" + str4 + "')");
            System.out.println("BdQuerryDoctors.addNewDoctor();:: -- " + str2 + " " + str3 + " " + str4);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOneDoctor(Connection connectTo) {
        try (Statement statement = connectTo.createStatement()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя доктора которого удалить из базы: ");
            String str = scanner.nextLine();
            statement.executeUpdate("delete from Doctors where firstName='" + str + "'");
            System.out.println("BdQuerryDoctors::deleteOneDoctor(); -- " + str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class BdQuerryPatients {
    public static List<Patients> getAllpatiens(Connection connectTo) throws SQLException {
        ArrayList<Patients> patients = new ArrayList<>();
        try (Statement statement = connectTo.createStatement()) {
            ResultSet rs = statement.executeQuery("select patientId, firstNamePatient, lastNamePatient, ageOfPatient from Patients");
            while (rs.next()) {
                int dPat = rs.getInt(1);
                String fNamePat = rs.getString(2);
                String lNamePat = rs.getString(3);
                int agePat = rs.getInt(4);
                System.out.println("BdQuerryDoctors::getAllpatiens(); -- dPac:" + dPat + " fNamePac:" + fNamePat + " lNamePac:" + lNamePat + " agePac:" + agePat);
                Patients pat = new Patients(dPat, fNamePat, lNamePat, agePat);
                patients.add(pat);
            }
        }
        return patients;
    }

    static void printPatients(List<Patients> connectTo) {
        for(Patients pat:connectTo) {
            System.out.println(pat);
        }
    }


}
