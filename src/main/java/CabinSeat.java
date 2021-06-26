public class CabinSeat extends Seating {

    public CabinSeat(int price, int gstPercent, int freeConferenceHours) {
        setPrice(price);
        setGstPercent(gstPercent);
        setName(CabinSeat.class.getName());
        setFreeConferenceHours(freeConferenceHours);
    }
}
