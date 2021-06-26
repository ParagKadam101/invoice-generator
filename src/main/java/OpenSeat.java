public class OpenSeat extends Seating {

    public OpenSeat(int price, int gstPercent, int freeConferenceHours) {
        setPrice(price);
        setGstPercent(gstPercent);
        setName(OpenSeat.class.getName());
        setFreeConferenceHours(freeConferenceHours);
    }
}
