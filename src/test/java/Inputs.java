import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Inputs {

    @BeforeEach
    void setup() {
        System.out.println("\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("\n");
    }

    @Test
    void input1() {
        List<PurchaseItem> purchaseItems = getPurchaseItems(2, 3, 35, 5);
        InvoiceGenerator.generateAndDisplayInvoice(purchaseItems);
    }

    @Test
    void input2() {
        List<PurchaseItem> purchaseItems = getPurchaseItems(0, 1, 50, 10);
        InvoiceGenerator.generateAndDisplayInvoice(purchaseItems);
    }

    @Test
    void input3() {
        List<PurchaseItem> purchaseItems = getPurchaseItems(2, 0, 0, 30);
        InvoiceGenerator.generateAndDisplayInvoice(purchaseItems);
    }

    List<PurchaseItem> getPurchaseItems(int openSeatCount, int cabinSeatCount, int conferenceSeatCount, int mealSeatCount) {
        List<PurchaseItem> purchaseItems = new ArrayList<>();

        if(openSeatCount > 0)
            purchaseItems.add(new PurchaseItem(openSeatCount, new OpenSeat(5000, 18, 5)));

        if(cabinSeatCount > 0)
            purchaseItems.add(new PurchaseItem(cabinSeatCount, new CabinSeat(10000, 18, 10)));

        if(conferenceSeatCount > 0)
            purchaseItems.add(new PurchaseItem(conferenceSeatCount, new ConferenceRoom(200, 18)));

        if(mealSeatCount > 0)
            purchaseItems.add(new PurchaseItem(mealSeatCount, new Meal(100, 12)));

        return purchaseItems;
    }
}
