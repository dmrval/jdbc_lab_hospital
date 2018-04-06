public class MusicalProducts {
    private int id_MusicalProducts;
    private String name;
    private double salary;

    public MusicalProducts() {
    }

    public MusicalProducts(int id_MusicalProducts, String name, double salary) {
        this.id_MusicalProducts = id_MusicalProducts;
        this.name = name;
        this.salary = salary;
    }

    public int getId_MusicalProducts() {
        return id_MusicalProducts;
    }

    public void setId_MusicalProducts(int id_MusicalProducts) {
        this.id_MusicalProducts = id_MusicalProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "MusicalProducts{" +
                "id_MusicalProducts=" + id_MusicalProducts +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
