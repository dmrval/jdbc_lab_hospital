package mainPackage.dbQuerys;

import mainPackage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DBQueryVisits {
    public static final String tableName = "Visits";

    public static List<Visit> getAllVisitsTable(Connection connectTo) throws SQLException {
        ArrayList<Visit> visits = new ArrayList<>();
        try (Statement statement = connectTo.createStatement()) {
            String queryStr = MessageFormat.format("select {1}.visitId, {1}.visitDoctor, {1}.visitPatient, {1}.visitSpecifical from {1};", tableName);
            ResultSet rs = statement.executeQuery(queryStr);
            while (rs.next()) {
                int visitId = rs.getInt(1);
                int visitDoctor = rs.getInt(2);
                int visitPatient = rs.getInt(3);
                String visitSpecifical = rs.getString(4);
                System.out.println("Номер визита: " + visitId + " Доктор: " + visitDoctor +
                        " Пациент: " + visitPatient + " Описание: " + visitSpecifical);
                Visit vis = new Visit(visitId, visitDoctor, visitPatient, visitSpecifical);
            }
        }
        return visits;
    }

    public static void printAllVisitsTable(List<Visit> connectTo) {
        for (Visit vit : connectTo) {
            System.out.println(vit);
        }
    }

    public static List<Visit> getAllVisitsTableWithFirstAndLastName(Connection connectTo) throws SQLException {
        ArrayList<Visit> visits = new ArrayList<>();
        try (Statement statement = connectTo.createStatement()) {
            String queryStr = MessageFormat.format("select {0}.visitId, {0}.visitDoctor, {0}.visitPatient, {0}.visitSpecifical, {1}.firstName, {2}.firstNamePatient, {0}.visitDate from {0} inner join {1} on {0}.visitDoctor = {1}.doctorId inner join {2} on {0}.visitPatient = {2}.patientId;", DBQueryVisits.tableName, DBQueryDoctors.tableName, DBQueryPatients.tableName);
            System.out.println("DBQueryVisits::getAllVisitsTableWithFirstAndLastName(); -- queryStr:" + queryStr);
            ResultSet rs = statement.executeQuery(queryStr);
            while (rs.next()) {
                int visitId = rs.getInt(1);
                String visitDoctor = rs.getString(2);
                String visitPatient = rs.getString(3);
                String spec = rs.getString(4);
                String doctorsfirstName = rs.getString(5);
                String firstNamePatient = rs.getString(6);
                String dbSqlDate = rs.getString(7);
//                Date dt = rs.getDate(6);
                System.out.println("НОМЕР ПОСЕЩЕНИЯ: " + visitId + ", НОМЕР ДОКТОРА: " + visitDoctor + " НОМЕР ПАЦИЕНТА: " + visitPatient +
                        ", ОПИСАНИЕ ПРИЕМА: " + spec + ", ФАМИЛИЯ ПАЦИЕНТА: " + firstNamePatient + ", ФАМИЛИЯ ДОКТОРА: " + doctorsfirstName + ", ДАТА ПРИЕМА: " + dbSqlDate);
            }
        }
        return visits;
    }

    public static void giveVisitsByOneDoctor(Connection connectTo) {
        try (Statement statement = connectTo.createStatement()) {
            System.out.println("ВВЕДИТЕ ФАМИЛИЮ ДОКТОРА У КОТОРОГО ХОТИТЕ УЗНАТЬ ИНФОРМАЦИЮ О ПЕСЕЩЕНИЯХ : ");
            int id_doc = DBQueryAdditionalQuery.giveDoctorByFirstName(connectTo);
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
            int id_pat = DBQueryAdditionalQuery.givePatientByFirstName(connectTo);
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
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            PritnUserMenu.standartFormatDate();
            System.out.println("Укажите год приема: ");
            System.out.println("Для отмены введите - Отмена");
            String year_visit = bufferedReader.readLine();
            if (year_visit.equals("Отмена")) {
                SwithMenu.sW_Menu_2();
            }
            int year = Integer.parseInt(year_visit);
            System.out.println("Укажите месяц: ");
            String scan = bufferedReader.readLine();
            if (scan.equals("Отмена")) {
                SwithMenu.sW_Menu_2();
            }
            int mounth_tmp = Times.nameMounth(scan);
            System.out.println("День приема: ");
            String day_visit = bufferedReader.readLine();
            if (day_visit.equals("Отмена")) {
                SwithMenu.sW_Menu_2();
            }
            int dayOfMonth = Integer.parseInt(day_visit);
            System.out.println("Час приема: ");
            String hour_visit = bufferedReader.readLine();
            if (hour_visit.equals("Отмена")) {
                SwithMenu.sW_Menu_2();
            }
            int hourVisit = Integer.parseInt(hour_visit);
            System.out.println("Минуты: ");
            String min_visit = bufferedReader.readLine();
            if (min_visit.equals("Отмена")) {
                SwithMenu.sW_Menu_2();
            }
            int minuteVisit = Integer.parseInt(min_visit);
            Date dateString = new Date(year, mounth_tmp, dayOfMonth, hourVisit, minuteVisit);
            System.out.println(dateString);
            DBQueryDoctors.printDoctors(DBQueryDoctors.getAllDoctors(Connections.connectTo()));
            System.out.println("ФАМИЛИЯ ДОКТОРА ОСМОТРЕВШИЙ ПАЦИЕНТА: ");
            int visitDoctor_temp = DBQueryAdditionalQuery.giveDoctorByFirstName(connectTo);
            DBQueryPatients.printPatients(DBQueryPatients.getAllPatients(Connections.connectTo()));
            System.out.println("ФАМИЛИЯ ОСМАТРИВАЕМОГО ПАЦИЕНТА: ");
            int visitPatient_temp = DBQueryAdditionalQuery.givePatientByFirstName(connectTo);
            System.out.println("ОПИСАНИЕ ВИЗИТА: ");
            String visitSpecifical = bufferedReader.readLine();
            if (visitSpecifical.equals("Отмена")) {
                SwithMenu.sW_Menu_2();
            }
            statement.executeUpdate("insert into Visits (visitDate, visitDoctor, visitPatient, visitSpecifical) values " +
                    "('" + dateString + "'," + visitDoctor_temp + "," + visitPatient_temp + ",'" + visitSpecifical + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void deleteOneVisit(Connection connectTo) throws IOException {
        try (Statement statement = connectTo.createStatement()) {
            Scanner scanner = new Scanner(System.in);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            DBQueryVisits.printAllVisitsTable(DBQueryVisits.getAllVisitsTableWithFirstAndLastName(Connections.connectTo()));
            System.out.println("\nВВЕДИТЕ НОМЕР ВИЗИТА КОТОРЫЙ ХОТИТЕ УДАЛИТЬ ИЗ БАЗЫ: ");
            System.out.println("Для отмена введите - Отмена");
            String str = bufferedReader.readLine();
            if (str.equals("Отмена")) {
                SwithMenu.sW_Menu_3();
            }
            int temp = Integer.parseInt(str);
            statement.executeUpdate("delete from Visits where visitId='" + temp + "'");
            System.out.println("DBQueryDoctors::deleteOneVisit(); -- " + temp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editOneVisit(Connection connectTo) {
        try {
            Statement statement = connectTo.createStatement();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printAllVisitsTable(getAllVisitsTableWithFirstAndLastName(Connections.connectTo()));
            System.out.println("\nВВЕДИТЕ НОМЕР ВИЗИТА ДЛЯ РЕДАКТИРОВАНИЯ");
            System.out.println("Для отмены введите - Отмена");
            String fNameForEdit = bufferedReader.readLine();
            if (fNameForEdit.equals("Отмена")) {
                SwithMenu.sW_Menu_4();
            }
            int visitId = Integer.parseInt(fNameForEdit);
            DBQueryDoctors.printDoctors(DBQueryDoctors.getAllDoctors(Connections.connectTo()));
            System.out.println("РЕДАКТИРОВАНИЕ ФАМИЛИИ ДОКТОРА КОТОРЫЙ ПРОИЗВЕЛ ОСМОТР");
            int visitDoctor = DBQueryAdditionalQuery.giveDoctorByFirstName(connectTo);
            DBQueryPatients.printPatients(DBQueryPatients.getAllPatients(Connections.connectTo()));
            System.out.println("РЕДАКТИРОВАНИЕ ФАМИЛИИ ОСМАТРИВАЕМОГО ПАЦИЕНТА ");
            int visitPatient = DBQueryAdditionalQuery.givePatientByFirstName(connectTo);
            System.out.println("РЕДАКТИРОВАНИЕ ОПИСАНИЯ ВИЗИТА ");
            String newAge = bufferedReader.readLine();
            if (newAge.equals("Отмена")) {
                SwithMenu.sW_Menu_4();
            }
            int tempAge = Integer.parseInt(newAge);
            statement.executeUpdate("update Visits set visitDoctor = '" + visitDoctor + "',visitPatient = '" + visitPatient + "',visitSpecifical  = " +
                    "'" + newAge + "' where visitId = '" + visitId + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editDoctorInVisit(Connection connectTo) {
        try {
            Statement statement = connectTo.createStatement();
            System.out.println("ВВЕДИТЕ ФАМИЛИЮ ДОКТОРА ");
            int id_doc_temp = DBQueryAdditionalQuery.giveDoctorByFirstName(connectTo);
            statement.executeUpdate("update Visits set visitDoctor = 437 where visitDoctor=" + id_doc_temp + "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
