public class Type {
    private int id;
    private String typeName;

    public Type() {
    }

    public Type(int id, String name) {
        this.id = id;
        this.typeName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return typeName;
    }

    public void setName(String name) {
        this.typeName = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + typeName + '\'' +
                '}';
    }
}
