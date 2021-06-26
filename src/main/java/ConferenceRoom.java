public class ConferenceRoom extends Product {

    public ConferenceRoom(int price, int gstPercent) {
        setPrice(price);
        setGstPercent(gstPercent);
        setName(ConferenceRoom.class.getName());
    }
}
