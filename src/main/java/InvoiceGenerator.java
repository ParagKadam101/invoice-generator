import java.util.ArrayList;
import java.util.List;

public class InvoiceGenerator {

    public static void generateAndDisplayInvoice(List<PurchaseItem> purchaseItems) {
        List<InvoiceEntry> invoiceEntries = generateInvoice(purchaseItems);
        displayInvoice(invoiceEntries);
    }

    private static List<InvoiceEntry> generateInvoice(List<PurchaseItem> purchaseItems) {
        List<InvoiceEntry> invoiceEntries = new ArrayList<>();
        for(PurchaseItem purchaseItem: purchaseItems) {
            Product product = purchaseItem.getProduct();
            int itemCost = product.getPrice() * purchaseItem.getCount();
            if(product.getName().equals(ConferenceRoom.class.getName())) {
                int usedConferenceHours = getUsedConferenceRoomHours(purchaseItems);
                itemCost = product.getPrice() * usedConferenceHours;
            }

            invoiceEntries.add(new InvoiceEntry(purchaseItem.getCount(), product.getName(), itemCost, product.getGstPercent()));
        }
        return invoiceEntries;
    }

    private static int getUsedConferenceRoomHours(List<PurchaseItem> purchaseItems) {
        int totalHoursUsed = 0;
        int freeHours = 0;
        for(PurchaseItem item: purchaseItems) {
            if(item.getProduct() instanceof ConferenceRoom) {
                totalHoursUsed += item.getCount();
            }

            else if(item.getProduct() instanceof Seating) {
                freeHours += item.getCount() * ((Seating) item.getProduct()).getFreeConferenceHours();
            }
        }

        if(freeHours >= totalHoursUsed)
            return 0;
        return totalHoursUsed - freeHours;
    }

    private static void displayInvoice(List<InvoiceEntry> invoiceEntries) {
        int total = 0;
        int totalGst = 0;
        for(InvoiceEntry entry: invoiceEntries) {
            total += entry.itemCost + entry.gstAmount;
            totalGst += entry.gstAmount;
            if(entry.productName.equals(ConferenceRoom.class.getName())) {
                System.out.println(entry.count + " Hours of " + entry.productName + " usage: " + (entry.itemCost + entry.gstAmount));
                continue;
            }
            System.out.println(entry.count + " " + entry.productName + " : " + (entry.itemCost + entry.gstAmount));
        }
        System.out.println("Total:" + total);
        System.out.println("Total GST:" + totalGst);
    }

    private static int getGstAmount(int cost, int gstPercent) {
        return (cost * gstPercent) / 100;
    }

    private static class InvoiceEntry {
        private final int count;
        private final String productName;
        private final int itemCost;
        private final int gstAmount;

        InvoiceEntry(int count, String productName, int itemCost, int gstPercent) {
            this.count = count;
            this.productName = productName;
            this.itemCost = itemCost;
            this.gstAmount = getGstAmount(itemCost, gstPercent);
        }
    }
}
