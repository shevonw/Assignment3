import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;


public interface Payable {
    //public double setPayableAmount();
}

class Employee implements Payable{
    private String Firstname;
    private String Lastname;
    private String socialSecurityNum;
}

class Invoice implements Payable{
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;
}

class CommissionEmployee extends Employee{
    private double grossSales;
    private double commissionRate;
}

class HourlyEmployee extends Employee{
    private double wage;
    private double hours;
}

class SalariedEmployee extends Employee{
    private double weeklySalary;
}

class BasePlusCommissionEmployee extends CommissionEmployee{
    private double baseSalary;
}







       /* 2. Include a writeToFile() method in the Payable Interface that should write the value returned by the
        getPaymentAmount() method.This method will essentially generate a pay stub for each of the Employees
        and Invoices for contractors. The file should be saved as paystub.txt and should include the name of
        the employee and the date of payment in addition to the amount*/


    double getPaymentAmount();

    default void writeToFile(String name) {
        LocalDate paymentDate = LocalDate.now();
        String fileName = "paystub.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Payment Date: " + paymentDate.toString());
            writer.newLine();
            writer.write("Amount: $" + getPaymentAmount());
            writer.newLine();
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


    /*3. Include the necessary exception handling for file I/O. (10 Marks)*/

    @Override
    public void writeToFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Pay stub for " + name + "\n");
            writer.write("Date: " + LocalDate.now() + "\n");
            writer.write("Amount: $" + getPaymentAmount() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

    /* 4.In the main method to test the functionality of the application by creating objects and testing the methods. (10 Marks)*/

    public static void main(String[] args) {
        // Create an Employee object
        Employee employee = new Employee("John Doe", 5000.0);

        // Test the getPaymentAmount method
        System.out.println("Employee Payment Amount: $" + employee.getPaymentAmount());

        // Test the writeToFile method
        try {
            employee.writeToFile("paystub_employee.txt");
            System.out.println("Employee pay stub saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving employee pay stub: " + e.getMessage());
        }

        // Create a Contractor object
        Contractor contractor = new Contractor("Jane Smith", 25.0, 40);

        // Test the getPaymentAmount method
        System.out.println("Contractor Payment Amount: $" + contractor.getPaymentAmount());

        // Test the writeToFile method
        try {
            contractor.writeToFile("paystub_contractor.txt");
            System.out.println("Contractor pay stub saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving contractor pay stub: " + e.getMessage());
        }
    }








}

