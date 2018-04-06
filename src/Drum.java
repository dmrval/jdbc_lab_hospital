public class Drum extends MusicalProducts {
    private int id_Drum;
    private String makeFirm;
    private int drum_plate; //кол-во тарелок

    public Drum() {
    }

    public Drum(int id_MusicalProducts, String name, double salary) {
        super(id_MusicalProducts, name, salary);
    }

    public Drum(int id_Drum, String makeFirm, int drum_plate) {
        this.id_Drum = id_Drum;
        this.makeFirm = makeFirm;
        this.drum_plate = drum_plate;
    }

    public Drum(int id_MusicalProducts, String name, double salary, int id_Drum, String makeFirm, int drum_plate) {
        super(id_MusicalProducts, name, salary);
        this.id_Drum = id_Drum;
        this.makeFirm = makeFirm;
        this.drum_plate = drum_plate;
    }

    public int getId_Drum() {
        return id_Drum;
    }

    public void setId_Drum(int id_Drum) {
        this.id_Drum = id_Drum;
    }

    public String getMakeFirm() {
        return makeFirm;
    }

    public void setMakeFirm(String makeFirm) {
        this.makeFirm = makeFirm;
    }

    public int getDrum_plate() {
        return drum_plate;
    }

    public void setDrum_plate(int drum_plate) {
        this.drum_plate = drum_plate;
    }

    @Override
    public String toString() {
        return "Drum{" +
                "id_Drum=" + id_Drum +
                ", makeFirm='" + makeFirm + '\'' +
                ", drum_plate=" + drum_plate +
                '}';
    }
}
