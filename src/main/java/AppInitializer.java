import contants.GlobalConstants;
import services.EmployeeServiceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class AppInitializer {
    public static void main(String[] args) {
        EmployeeServiceImpl employeeServiceImpl = null;


        try {
            employeeServiceImpl = new EmployeeServiceImpl(GlobalConstants.INPUT_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }


        try {
            assert employeeServiceImpl != null;
            employeeServiceImpl.readEmployees();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Period longestWorkTogether = employeeServiceImpl.findLongestWorkTogether();

        System.out.println(longestWorkTogether);

        Period diff = Period.between(LocalDate.of(2009, 11, 21), LocalDate.of(2016,9,7));
        System.out.println(diff);
    }
}
