public class PurchaseItem {
    private final int count;
    private final Product product;

    public PurchaseItem(int count, Product product) {
        this.count = count;
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public Product getProduct() {
        return product;
    }
}
