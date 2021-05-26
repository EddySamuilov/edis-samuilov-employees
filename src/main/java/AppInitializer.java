import contants.GlobalConstants;
import services.EmployeeServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class AppInitializer {
    public static void main(String[] args) {
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

        try {
            employeeServiceImpl.readEmployees(GlobalConstants.INPUT_PATH);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
            return;
        }

        Period longestWorkTogether = employeeServiceImpl.findLongestWorkOnCommonProject();
        System.out.println(longestWorkTogether);

        Period diff = Period.between(LocalDate.of(2009, 11, 21),
                LocalDate.of(2016, 9, 7));
        System.out.println(diff);
    }
}
