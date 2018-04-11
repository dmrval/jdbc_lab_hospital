import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
                System.out.println("НОМЕР: " + d + " ФАМИЛИЯ: " + fName + " ИМЯ: " + lName + " СПЕЦИАЛИЗАЦИЯ: " + prof);
                Doctors doc = new Doctors(d, fName, lName, prof);
//                doctors.add(doc);
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
            System.out.println("ВВЕДИТЕ ФАМИЛИЮ НОВОГО ДОКТОРА : ");
            String str2 = bufferedReader.readLine();
            System.out.println("ВВЕДИТЕ ИМЯ НОВОГО ДОКТОРА : ");
            String str3 = bufferedReader.readLine();
            System.out.println("ВВЕДИТЕ СПЕЦИАЛЬЗАЦИЮ НОВОГО ДОКТОРА : ");
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

    public static void editOneDoctor(Connection connetTo) {
        try {
            Statement statement = connetTo.createStatement();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("ВВЕДИТЕ ФАМИЛИЮ ДОКТОРА НА ИЗМЕНЕНИЕ ДАННЫХ");
            String fNameForEdit = bufferedReader.readLine();
            System.out.println("РЕДАКТИРОВАНИЕ ФАМИЛИИ ");
            String newFirstName = bufferedReader.readLine();
            System.out.println("РЕДАКТИРОВАНИЕ ИМЕНИ ");
            String newLastName = bufferedReader.readLine();
            System.out.println("РЕДАКТИРОВАНИЕ СПЕЦИЛИЗАЦИИ ");
            String newSpecilization = bufferedReader.readLine();
            statement.executeUpdate("update Doctors set firstName = '" + newFirstName + "',lastName = '" + newLastName + "',profession  = '" + newSpecilization + "' where firstName = '" + fNameForEdit + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOneDoctor(Connection connectTo) {
        try (Statement statement = connectTo.createStatement()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ВВЕДИТЕ ФАМИЛИЮ ДОКТОРА КОТОРОГО УДАЛИТЬ ИЗ БАЗЫ: ");
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
                System.out.println("НОМЕР ПАЦИЕНТА: " + dPat + " ФАМИЛИЯ : " + fNamePat + " ИМЯ : " + lNamePat + " ВОЗВРАСТ: " + agePat);
                Patients pat = new Patients(dPat, fNamePat, lNamePat, agePat);
//                patients.add(pat);
            }
        }
        return patients;
    }

    static void printPatients(List<Patients> connectTo) {
        for (Patients pat : connectTo) {
            System.out.println(pat);
        }
    }

    public static void addNewPatient(Connection connectTo) {
        try (Statement statement = connectTo.createStatement()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("ВВЕДИТЕ ФАМИЛИЮ НОВОГО ПАЦИЕНТА : ");
            String str2 = bufferedReader.readLine();
            System.out.println("ВВЕДИТЕ ИМЯ НОВОГО ПАЦИЕНТА : ");
            String str3 = bufferedReader.readLine();
            System.out.println("ВВЕДИТЕ ВОЗВРАСТ НОВОГО ПАЦИЕНТА(полных лет) : ");
            String str4 = bufferedReader.readLine();
            int intStr4 = Integer.parseInt(str4);
            statement.executeUpdate("insert into Patients (firstNamePatient, lastNamePatient, ageOfPatient)" +
                    " values ('" + str2 + "','" + str3 + "', " + str4 + ")");
            System.out.println("BdQuerryDoctors.addNewDoctor();:: -- " + str2 + " " + str3 + " " + intStr4);
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
            System.out.println("ВВЕДИТЕ ФАМИЛИЮ ПАЦИЕНТА НА ИЗМЕНЕНИЕ ДАННЫХ");
            String fNameForEdit = bufferedReader.readLine();
            System.out.println("РЕДАКТИРОВАНИЕ ФАМИЛИИ ");
            String newFirstName = bufferedReader.readLine();
            System.out.println("РЕДАКТИРОВАНИЕ ИМЕНИ ");
            String newLastName = bufferedReader.readLine();
            System.out.println("РЕДАКТИРОВАНИЕ ВОЗВРАСТА ");
            String newAge = bufferedReader.readLine();
            int tempAge = Integer.parseInt(newAge);
            statement.executeUpdate("update Patients set firstNamePatient = '" + newFirstName + "',lastNamePatient = '" + newLastName + "',ageOfPatient  = " +
                    "'" + newAge + "' where firstNamePatient = '" + fNameForEdit + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOnePatient(Connection connectTo) {
        try (Statement statement = connectTo.createStatement()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ВВЕДИТЕ ИМЯ ПАЦИЕНТА КОТОРЫЙ ПЕРЕСТАЛ ПЛАТИТЬ: ");
            String str = scanner.nextLine();
            statement.executeUpdate("delete from Patients where firstNamePatient='" + str + "'");
            System.out.println("BdQuerryDoctors::deleteOnePatient(); -- " + str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class BdQuerryVisits {
    public static List<Visits> getAllVisitsTable(Connection connectTo) throws SQLException {
        ArrayList<Visits> visits = new ArrayList<>();
        try (Statement statement = connectTo.createStatement()) {
            ResultSet rs = statement.executeQuery("select visitId, visitDoctor, visitPatient, visitSpecifical from Visits");
            while (rs.next()) {
                int visitId = rs.getInt(1);
                int visitDoctor = rs.getInt(2);
                int visitPatient = rs.getInt(3);
                String visitSpecifical = rs.getString(4);
                System.out.println("Номер визита: " + visitId + " Доктор: " + visitDoctor +
                        " Пациент: " + visitPatient + " Описание: " + visitSpecifical);
                Visits vis = new Visits(visitId, visitDoctor, visitPatient, visitSpecifical);
//                visits.add(vis);
            }
        }
        return visits;
    }

    public static void printAllVisitsTable(List<Visits> connectTo) {
        for (Visits vit : connectTo) {
            System.out.println(vit);
        }
    }

    public static List<Visits> getAllVisitsTableWithFirstAndLastName(Connection connectTo) throws SQLException {
        ArrayList<Visits> visits = new ArrayList<>();
        try (Statement statement = connectTo.createStatement()) {
            ResultSet rs = statement.executeQuery("select Visits.visitDoctor, Visits.visitPatient, Visits.visitSpecifical, Doctors.firstName, Patients.firstNamePatient from Visits inner join Doctors on Visits.visitDoctor = Doctors.doctorId inner join Patients on  Visits.visitPatient = Patients.patientId");
            while (rs.next()) {
                int visitId = rs.getInt(1);
                String visitDoctor = rs.getString(2);
                String spec = rs.getString(3);
                String doctorsfirstName = rs.getString(4);
                String firstNamePatient = rs.getString(5);
                System.out.println("НОМЕР ПОСЕЩЕНИЯ: " + visitId + ", НОМЕР ДОКТОРА: " + visitDoctor +
                        ", ОПИСАНИЕ ПРИЕМА: " + spec + ", ФАМИЛИЯ ПАЦИЕНТА: " + firstNamePatient + ", ФАМИЛИЯ ДОКТОРА: " + doctorsfirstName);
            }
        }
        return visits;
    }

    public static void giveVisitsByOneDoctor(Connection connectTo) {
        try (Statement statement = connectTo.createStatement()) {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("ВВЕДИТЕ ФАМИЛИЮ ДОКТОРА У КОТОРОГО ХОТИТЕ УЗНАТЬ ИНФОРМАЦИЮ О ПЕСЕЩЕНИЯХ : ");
            int id_doc = BdQuerryAdditionalQuerry.giveDoctorByFirstName(connectTo);
            System.out.println(id_doc);
            ResultSet rs = statement.executeQuery("select Doctors.firstName, Patients.firstNamePatient,Visits.visitSpecifical from Visits inner join Doctors on Visits.visitDoctor = Doctors.doctorId inner join Patients on " +
                    " Visits.visitPatient = Patients.patientId where Doctors.doctorId = " + id_doc + "");
            while (rs.next()) {
                String str1 = rs.getString(1);
                String str2 = rs.getString(2);
                String str3 = rs.getString(3);
                System.out.println("ФАМИЛИЯ ДОКТОРА: " + str1 + " ФАМИЛИЯ ПАЦИЕНТА: " + str2 + " ОПИСАНИЕ ПРИЕМА: " + str3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void giveVisitsByOnePatient(Connection connectTo) {
        try (Statement statement = connectTo.createStatement()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("ВВЕДИТЕ ФАМИИЮ ПАЦИЕНТА КОТОРЫЙ ПОСЕЩАЛ ВРАЧЕЙ : ");
            int id_pat = BdQuerryAdditionalQuerry.givePatientByFirstName(connectTo);
            System.out.println(id_pat);
            ResultSet rs = statement.executeQuery("select Doctors.firstName, Patients.firstNamePatient, Visits.visitSpecifical from Visits inner join Doctors on Visits.visitDoctor = Doctors.doctorId inner join Patients on " +
                    " Visits.visitPatient = Patients.patientId where Patients.patientId = " + id_pat + "");
            while (rs.next()) {
                String str1 = rs.getString(1);
                String str2 = rs.getString(2);
                String str3 = rs.getString(3);
                System.out.println("ФАМИЛИЯ ПАЦИЕНТА: " + str2 + " ФАМИЛИЯ ДОКТОРА: " + str1 + " ОПИСАНИЕ ПРИЕМА: " + str3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addNewVisit(Connection connectTo) {
        try {
            Statement statement = connectTo.createStatement();
            Scanner scanner = new Scanner(System.in);
            PritnUserMenu.standartFormatDate();
//            System.out.println("Укажите год приема: ");
//            int year = scanner.nextInt();
//            System.out.println("Укажите месяц: ");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            String mon = bufferedReader.readLine();
////            int k = Integer.parseInt(mon)
//            int mounth_tmp = Times.nameMounth(mon);
//            System.out.println("День приема: ");
//            int dayOfMonth = scanner.nextInt();
//            System.out.println("Укажите Час приема: ");
//            int hourOfDay = scanner.nextInt();
//            System.out.println("И минут: ");
//            int minute = scanner.nextInt();
//            int second = 0;
//
            Date date = Times.getDateForSql(1990,12,12);
            System.out.println("ФАМИЛИЯ ДОКТОРА ОСМОТРЕВШИЙ ПАЦИЕНТА: ");
            int visitDoctor_temp = BdQuerryAdditionalQuerry.giveDoctorByFirstName(connectTo);
            System.out.println("ФАМИЛИЯ ОСМАТРИВАЕМОГО ПАЦИЕНТА: ");
            int visitPatient_temp = BdQuerryAdditionalQuerry.givePatientByFirstName(connectTo);
            System.out.println("ОПИСАНИЕ ВИЗИТА: ");
            String visitSpecifical = bufferedReader.readLine();
            statement.executeUpdate("insert into Visits (visitDate, visitDoctor, visitPatient, visitSpecifical) values " +
                    "(" + date + "," + visitDoctor_temp + "," + visitPatient_temp + ",'" + visitSpecifical + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void deleteOneVisit(Connection connectTo) {
        try (Statement statement = connectTo.createStatement()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ВВЕДИТЕ НОМЕР ВИЗИТА КОТОРЫЙ ХОТИТЕ УДАЛИТЬ ИЗ БАЗЫ: ");
            int temp = scanner.nextInt();
            statement.executeUpdate("delete from Visits where visitId='" + temp + "'");
            System.out.println("BdQuerryDoctors::deleteOneVisit(); -- " + temp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editOneVisit(Connection connectTo) {
        try {
            Statement statement = connectTo.createStatement();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("ВВЕДИТЕ НОМЕР ВИЗИТА ДЛЯ РЕДАКТИРОВАНИЯ");
            BdQuerryVisits.printAllVisitsTable(BdQuerryVisits.getAllVisitsTable(connectTo));
            String fNameForEdit = bufferedReader.readLine();
            int visitId = Integer.parseInt(fNameForEdit);
            System.out.println("РЕДАКТИРОВАНИЕ ФАМИЛИИ ДОКТОРА КОТОРЫЙ ПРОИЗВЕЛ ОСМОТР");
            int visitDoctor = BdQuerryAdditionalQuerry.giveDoctorByFirstName(connectTo);
            System.out.println("РЕДАКТИРОВАНИЕ ФАМИЛИИ ОСМАТРИВАЕМОГО ПАЦИЕНТА ");
            int visitPatient = BdQuerryAdditionalQuerry.givePatientByFirstName(connectTo);
            System.out.println("РЕДАКТИРОВАНИЕ ОПИСАНИЯ ВИЗИТА ");
            String newAge = bufferedReader.readLine();
            int tempAge = Integer.parseInt(newAge);
            statement.executeUpdate("update Visits set visitDoctor = '" + visitDoctor + "',visitPatient = '" + visitPatient + "',visitSpecifical  = " +
                    "'" + newAge + "' where visitId = '" + visitId + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public  static  void editDoctorInVisit(Connection connectTo) {
//        try {
//            Statement statement = connectTo.createStatement();
//            System.out.println("ВВЕДИТЕ ФАМИЛИЮ ДОКТОРА ");
//            int id_doc_temp = BdQuerryAdditionalQuerry.giveDoctorByFirstName(connectTo);
//            statement.executeUpdate("update Visits set visitDoctor = 437 where visitDoctor="+id_doc_temp+"");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}

class BdQuerryAdditionalQuerry {
    public static int giveDoctorByFirstName(Connection connectTo) {
        int temp = 0;
        try {
            Statement statement = connectTo.createStatement();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String strTemp = bufferedReader.readLine();
            ResultSet rs = statement.executeQuery("select Doctors.doctorId from Doctors where Doctors.firstName = '" + strTemp + "'");
            while (rs.next()) {
                temp = rs.getInt(1);
//                System.out.println("BdQuerryAdditionalQuerry::giveDoctorByFirstName() -- " + temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static int givePatientByFirstName(Connection connectTo) {
        int temp = 0;
        try {
            Statement statement = connectTo.createStatement();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String strTemp = bufferedReader.readLine();
            ResultSet rs = statement.executeQuery("select Patients.patientId from Patients where Patients.firstNamePatient = '" + strTemp + "'");
            while (rs.next()) {
                temp = rs.getInt(1);
//                System.out.println("BdQuerryAdditionalQuerry::givePatientByFirstName() -- " + temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static String giveFirstNameDoctorById(Connection connectTo) {
        String give = null;
        try {
            Statement statement = connectTo.createStatement();
            Scanner scanner = new Scanner(System.in);
            int temp_id = scanner.nextInt();
            ResultSet rs = statement.executeQuery("select Doctors.firstName from Doctors where Doctors.doctorId = " + temp_id + "");
            give = rs.getString(1);
            System.out.println(give);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return give;
    }

    public static String giveFirstNamePatientById(Connection connectTo) {
        String give = null;
        try {
            Statement statement = connectTo.createStatement();
            Scanner scanner = new Scanner(System.in);
            int temp_id = scanner.nextInt();
            ResultSet rs = statement.executeQuery("select Patients.firstNamePatient from Patients where Patients.patientId = " + temp_id + "");
            give = rs.getString(1);
            System.out.println(give);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return give;
    }

    public static String giveFirstNamePatientByIdWithParametr(Connection connectTo, int id) {
        String give = null;
        try {
            Statement statement = connectTo.createStatement();
            ResultSet rs = statement.executeQuery("select Patients.firstNamePatient from Patients where Patients.patientId = " + id + "");
            give = rs.getString(1);
            System.out.println(give);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return give;
    }

}

class Times {
//    public static String gregCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
////        GregorianCalendar gregorianCalendar = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
//        java.sql.Date = gregorianCalendar.getTime();
//        String dateString = date.toString();
//        dateString= dateString.replace(" ", "-");
//        dateString= dateString.replace(":", "|");
//        System.out.println(dateString);
//        return dateString;
//    }

    public static Date getDateForSql (int year, int month, int dayOfMonth) {
        java.sql.Date date = new java.sql.Date(year,month,dayOfMonth);
        System.out.println(date);
        return date;
    }

    public static int nameMounth(String mounth) {
        switch (mounth) {
            case "Январь":
                return 0;
            case "Февраль":
                return 1;
            case "Март":
                return 2;
            case "Апрель":
                return 3;
            case "Май":
                return 4;
            case "Июнь":
                return 5;
            case "Июль":
                return 6;
            case "Август":
                return 7;
            case "Сентябрь":
                return 8;
            case "Октябрь":
                return 9;
            case "Ноябрь":
                return 10;
            case "Декабрь":
                return 11;

        }
        return 0;
    }
}
