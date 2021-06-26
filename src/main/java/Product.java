public abstract class Product {

    private String name;
    private int price;
    private int gstPercent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGstPercent() {
        return gstPercent;
    }

    public void setGstPercent(int gstPercent) {
        this.gstPercent = gstPercent;
    }
}
