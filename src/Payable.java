import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
public interface Payable {
    public double getPaymentAmount();
    public void writeToFile();

}


