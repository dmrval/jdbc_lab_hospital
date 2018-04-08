public class Doctors {
    private int doctorId;
    private String firstName;
    private String lastName;
    private String profession;

    public Doctors() {
    }

    public Doctors(int id, String firstName, String lastName, String profession) {
        this.doctorId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
