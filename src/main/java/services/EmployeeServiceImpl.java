package services;

import entities.Employee;
import utils.DateFormatter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public void readEmployees(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String input;

        while ((input = reader.readLine()) != null) {
            String[] data = input.split(", ");
            Long employeeId = Long.valueOf(data[0]);
            Long projectId = Long.valueOf(data[1]);

            LocalDate startDate = DateFormatter.getCorrectDatePattern(data[2]);
//            LocalDate startDate = LocalDate.parse(data[2]);

            LocalDate endDate;
            if (data[3].equals("NULL")) {
                endDate = LocalDate.now();
            } else {
                endDate = DateFormatter.getCorrectDatePattern(data[3]);
            }

            this.employees.add(new Employee(employeeId, projectId, startDate, endDate));
        }
    }

    @Override
    public Period findLongestWorkOnCommonProject() {
        int foundYears = Integer.MIN_VALUE;
        int foundMonths = Integer.MIN_VALUE;
        int foundDays = Integer.MIN_VALUE;

        for (int x = 0; x < employees.size(); x++) {
            for (int i = (x + 1); i < employees.size(); i++) {
                Employee firstEmployee = employees.get(x);
                Employee secondEmployee = employees.get(i);

                if (firstEmployee.getId().equals(secondEmployee.getId())) {
                    continue;
                }

                boolean isEmployeesWorkedOnCommonProject = findIfEmployeesHaveWorkedOnCommonProject(firstEmployee, secondEmployee);
                if (isEmployeesWorkedOnCommonProject) {
                    LocalDate startDate = findCommonStartDate(firstEmployee, secondEmployee);
                    LocalDate endDate = findCommonEndDate(firstEmployee, secondEmployee);

                    Period period = Period.between(startDate, endDate);
                    int years = period.getYears();
                    int months = period.getMonths();
                    int days = period.getDays();

                    if (foundYears < years) {
                        foundYears = years;
                        foundMonths = months;
                        foundDays = days;

                    } else if (foundYears == years) {
                        if (foundMonths < months) {
                            foundMonths = months;
                            foundDays = days;
                        } else if (foundMonths == months) {
                            if (foundDays < days) {
                                foundDays = days;
                            }
                        }
                    }
                }
            }
        }

        return Period.of(foundYears, foundMonths, foundDays);
    }

    private boolean findIfEmployeesHaveWorkedOnCommonProject(Employee firstEmployee, Employee secondEmployee) {
        return firstEmployee.getProjectId().equals(secondEmployee.getProjectId())
                && (firstEmployee.getStartDate().compareTo(secondEmployee.getEndDate()) < 0);
    }

    private LocalDate findCommonEndDate(Employee firstEmployee, Employee secondEmployee) {
        if (firstEmployee.getEndDate().isAfter(secondEmployee.getEndDate())) {
            return secondEmployee.getEndDate();
        }

        return firstEmployee.getEndDate();
    }

    private LocalDate findCommonStartDate(Employee firstEmployee, Employee secondEmployee) {
        if (firstEmployee.getStartDate().isAfter(secondEmployee.getStartDate())) {
            return firstEmployee.getStartDate();
        }

        return secondEmployee.getStartDate();
    }
}





