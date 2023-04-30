public class Main {
    public static void main(String[] args) {

        // Add Employee sublasses objects to the array
        Employee employee = new Employee("John", "Doe", "123-45-6789");
        HourlyEmployee hourlyemployee = new HourlyEmployee("Jane", "Smith", "987-65-4321", 15.00, 50.00);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Bob", "Johnson", "456-78-9012", 5000.00, 0.05);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Mike", "Williams", "789-01-2345", 10000.00, 0.06, 2000.00);

        // Add Invoice objects to the array
        Invoice invoice = new Invoice("01234", "Hammer", 6, 19.95);

        System.out.print("Employee Name: "+ employee.getFirstName() + " " + employee.getLastName() + " " + "Socialsecuritynumber: "+ employee.getSocialSecurityNumber());
        System.out.print("\nEmployee Name: "+ hourlyemployee.getFirstName() + " " + hourlyemployee.getLastName() + " " + "Socialsecuritynumber: "+ hourlyemployee.getSocialSecurityNumber()+ " "+ "Salary: "+ hourlyemployee.getPaymentAmount());
        System.out.print("\nEmployee Name: "+ commissionEmployee.getFirstName() + " " + commissionEmployee.getLastName() + " " + "Socialsecuritynumber: "+ commissionEmployee.getSocialSecurityNumber()+ " "+ "Salary: "+ commissionEmployee.getPaymentAmount());
        System.out.print("\nEmployee Name: "+ basePlusCommissionEmployee.getFirstName() + " " + basePlusCommissionEmployee.getLastName() + " " + "Socialsecuritynumber: "+ basePlusCommissionEmployee.getSocialSecurityNumber()+ " "+ "Salary: "+ basePlusCommissionEmployee.getPaymentAmount());
        hourlyemployee.writeToFile();
        commissionEmployee.writeToFile();
        basePlusCommissionEmployee.writeToFile();
        invoice.writeToFile();


    }


}