package services;

import org.junit.Test;

import java.io.FileNotFoundException;

public class EmployeeServiceImp {


    @Test(expected = FileNotFoundException.class)
    public void testShouldThrownExceptionIfFilePathIsIncorrect() throws FileNotFoundException {

            EmployeeServiceImpl employeeService = new EmployeeServiceImpl("Wrong path!");
    }

}
