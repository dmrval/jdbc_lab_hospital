public class MusicaLinstruments {
    private int id;
    private String name;
    private double price;
    private int typeID;
    private int guaranteeID;

    public MusicaLinstruments() {
    }

    public MusicaLinstruments(int id, String name, double price, int typeID, int guaranteeID) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.typeID = typeID;
        this.guaranteeID = guaranteeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getGuaranteeID() {
        return guaranteeID;
    }

    public void setGuaranteeID(int guaranteeID) {
        this.guaranteeID = guaranteeID;
    }

    @Override
    public String toString() {
        return "MusicaLinstruments{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", typeID=" + typeID +
                ", guaranteeID=" + guaranteeID +
                '}';
    }
}
