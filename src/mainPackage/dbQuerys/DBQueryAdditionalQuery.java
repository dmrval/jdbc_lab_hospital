package mainPackage.dbQuerys;

import mainPackage.CheckValidData;
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
import java.util.Scanner;

public class DBQueryAdditionalQuery {
    public static int giveDoctorByFirstName(Connection connectTo) {
        int temp = 0;
        try {
            Statement statement = connectTo.createStatement();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String strTemp;
            do {
                strTemp = bufferedReader.readLine();
                if (strTemp.equals("Отмена")) {
                    SwithMenu.sWMain();
                }
                if (!CheckValidData.isName(strTemp)) {
                    System.out.println("Неверный формат повторите");
                }
            }while (!CheckValidData.isName(strTemp));
            ResultSet rs = statement.executeQuery("select Doctors.doctorId from Doctors where Doctors.firstName = '" + strTemp + "'");
            while (rs.next()) {
                temp = rs.getInt(1);
            }
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
        return temp;
    }

    public static int givePatientByFirstName(Connection connectTo) {
        int temp = 0;
        try {
            Statement statement = connectTo.createStatement();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String strTemp;
            do {
                strTemp = bufferedReader.readLine();
                if (strTemp.equals("Отмена")) {
                    SwithMenu.sWMain();
                }
                if (!CheckValidData.isName(strTemp)) {
                    System.out.println("Неверный формат повторите");
                }
            }while (!CheckValidData.isName(strTemp));
            ResultSet rs = statement.executeQuery("select Patients.patientId from Patients where Patients.firstNamePatient = '" + strTemp + "'");
            while (rs.next()) {
                temp = rs.getInt(1);
            }
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
