public class Amplifier extends MusicalProducts {
    private int id_Amplifier;
    private double power;
    private String type;
    private boolean lampType; //налие_лампы

    public Amplifier() {
    }

    public Amplifier(int id_MusicalProducts, String name, double salary) {
        super(id_MusicalProducts, name, salary);
    }

    public Amplifier(int id_Amplifier, double power, String type, boolean lampType) {
        this.id_Amplifier = id_Amplifier;
        this.power = power;
        this.type = type;
        this.lampType = lampType;
    }

    public Amplifier(int id_MusicalProducts, String name, double salary, int id_Amplifier, double power, String type, boolean lampType) {
        super(id_MusicalProducts, name, salary);
        this.id_Amplifier = id_Amplifier;
        this.power = power;
        this.type = type;
        this.lampType = lampType;
    }

    public int getId_Amplifier() {
        return id_Amplifier;
    }

    public void setId_Amplifier(int id_Amplifier) {
        this.id_Amplifier = id_Amplifier;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isLampType() {
        return lampType;
    }

    public void setLampType(boolean lampType) {
        this.lampType = lampType;
    }

    @Override
    public String toString() {
        return "Amplifier{" +
                "id_Amplifier=" + id_Amplifier +
                ", power=" + power +
                ", type='" + type + '\'' +
                ", lampType=" + lampType +
                '}';
    }
}
