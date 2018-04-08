import java.util.Date;

public class Visits {
    private int visitId;
    private Date visitDate;
    private int visitDoctor;
    private int visitPatient;
    private String visitSpecifical;

    public Visits() {
    }

    public Visits(int visitId, Date visitDate, int visitDoctor, int visitPatient, String visitSpecifical) {
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
        return "Visits{" +
                "visitId=" + visitId +
                ", visitDate=" + visitDate +
                ", visitDoctor=" + visitDoctor +
                ", visitPatient=" + visitPatient +
                ", visitSpecifical='" + visitSpecifical + '\'' +
                '}';
    }
}
