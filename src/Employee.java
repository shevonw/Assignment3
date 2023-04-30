import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

class Employee implements Payable {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    @Override
    public double getPaymentAmount() {
        return 0.0;
    }

    @Override
    public void writeToFile() {
        try {
            FileWriter writer = new FileWriter("paystub.txt", true);
            writer.write("Employee Name: " + this.firstName + " " + this.lastName + "\n");
            writer.write("Date of Payment: " + LocalDate.now() + "\n");
            writer.write("Payment Amount: $" + this.getPaymentAmount() + "\n\n");
            writer.close();
            System.out.println("Paystub generated successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while generating paystub: " + e.getMessage());
        }
    }
}
