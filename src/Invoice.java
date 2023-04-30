import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

class Invoice implements Payable {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public void writeToFile() {
        try {
            FileWriter writer = new FileWriter("paystub.txt", true);
            writer.write("Invoice Part Number: " + this.partNumber + "\n");
            writer.write("Date of Payment: " + LocalDate.now() + "\n");
            writer.write("Payment Amount: $" + this.getPaymentAmount() + "\n\n");
            writer.close();
            System.out.println("Invoice generated successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while generating invoice: " + e.getMessage());
        }
    }
}
