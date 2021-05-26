import contants.GlobalConstants;
import services.EmployeeServiceImpl;

import java.io.IOException;
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

        System.out.printf("The longest work on project is:%nYears: %s Months: %s Days: %s"
        , longestWorkTogether.getYears(), longestWorkTogether.getMonths(), longestWorkTogether.getDays());
    }
}
