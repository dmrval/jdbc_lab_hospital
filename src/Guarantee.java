public class Guarantee {
    private int id;
    private String guaranteeView;

    public Guarantee() {
    }

    public Guarantee(int id, String guaranteeView) {
        this.id = id;
        this.guaranteeView = guaranteeView;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuaranteeView() {
        return guaranteeView;
    }

    public void setGuaranteeView(String guaranteeView) {
        this.guaranteeView = guaranteeView;
    }

    @Override
    public String toString() {
        return "Guarantee{" +
                "id=" + id +
                ", guaranteeView='" + guaranteeView + '\'' +
                '}';
    }
}
