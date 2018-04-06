public class Guitar extends MusicalProducts {
    private int id_guitar;
    private int haveStrings; //кол-во струн
    private String madeIn;

    public Guitar() {
    }

    public Guitar(int id_MusicalProducts, String name, double salary) {
        super(id_MusicalProducts, name, salary);
    }

    public Guitar(int id_guitar, int haveStrings, String madeIn) {
        this.id_guitar = id_guitar;
        this.haveStrings = haveStrings;
        this.madeIn = madeIn;
    }

    public Guitar(int id_MusicalProducts, String name, double salary, int id_guitar, int haveStrings, String madeIn) {
        super(id_MusicalProducts, name, salary);
        this.id_guitar = id_guitar;
        this.haveStrings = haveStrings;
        this.madeIn = madeIn;
    }

    public int getId_guitar() {
        return id_guitar;
    }

    public void setId_guitar(int id_guitar) {
        this.id_guitar = id_guitar;
    }

    public int getHaveStrings() {
        return haveStrings;
    }

    public void setHaveStrings(int haveStrings) {
        this.haveStrings = haveStrings;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "id_guitar=" + id_guitar +
                ", haveStrings=" + haveStrings +
                ", madeIn='" + madeIn + '\'' +
                '}';
    }
}
