package services;

import java.io.IOException;
import java.time.Period;

public interface EmployeeService {

    void readEmployees(String filePath) throws IOException;

    Period findLongestWorkOnCommonProject();
}
