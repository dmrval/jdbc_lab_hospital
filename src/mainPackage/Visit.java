package mainPackage;

import java.util.Date;

public class Visit {
    private int visitId;
    private Date visitDate;
    private int visitDoctor;
    private int visitPatient;
    private String visitSpecifical;

    public Visit() {
    }

    public Visit(int visitDoctor, int visitPatient, String visitSpecifical, String doctorFName) {
        this.visitDoctor = visitDoctor;
        this.visitPatient = visitPatient;
        Patient p = new Patient();
    }

    public Visit(int visitId, int visitDoctor, int visitPatient, String visitSpecifical) {
        this.visitId = visitId;
        this.visitDoctor = visitDoctor;
        this.visitPatient = visitPatient;
        this.visitSpecifical = visitSpecifical;
    }

    public Visit(int visitId, Date visitDate, int visitDoctor, int visitPatient, String visitSpecifical) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.visitDoctor = visitDoctor;
        this.visitPatient = visitPatient;
        this.visitSpecifical = visitSpecifical;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public int getVisitDoctor() {
        return visitDoctor;
    }

    public void setVisitDoctor(int visitDoctor) {
        this.visitDoctor = visitDoctor;
    }

    public int getVisitPatient() {
        return visitPatient;
    }

    public void setVisitPatient(int visitPatient) {
        this.visitPatient = visitPatient;
    }

    public String getVisitSpecifical() {
        return visitSpecifical;
    }

    public void setVisitSpecifical(String visitSpecifical) {
        this.visitSpecifical = visitSpecifical;
    }

    @Override
    public String toString() {
        return "mainPackage.Visit{" +
                "visitId=" + visitId +
                ", visitDate=" + visitDate +
                ", visitDoctor=" + visitDoctor +
                ", visitPatient=" + visitPatient +
                ", visitSpecifical='" + visitSpecifical + '\'' +
                '}';
    }
}
