package services;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EmployeeServiceImp {


    @Test(expected = FileNotFoundException.class)
    public void testShouldThrownExceptionIfFilePathIsIncorrect() throws IOException {

            EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

            employeeService.readEmployees("Wrong path!");
    }

}
