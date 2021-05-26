package services;

import java.io.IOException;
import java.text.ParseException;
import java.time.Period;

public interface EmployeeService {

    void readEmployees() throws IOException, ParseException;

    Period findLongestWorkTogether();
}
