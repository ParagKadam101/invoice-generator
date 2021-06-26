public class Meal extends Product {
    public Meal(int price, int gstPercent) {
        setPrice(price);
        setGstPercent(gstPercent);
        setName(Meal.class.getName());
    }
}
