package FireDrill;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
public class TaskTwo {

    public static int calculateAge(String date){
        LocalDate currentDate = LocalDate.now();
        LocalDate inputDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Period checkPeriod = Period.between(inputDate,currentDate);
        return checkPeriod.getYears();
    }
}
