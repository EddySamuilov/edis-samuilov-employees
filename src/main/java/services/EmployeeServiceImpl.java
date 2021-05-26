package services;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final BufferedReader reader;
    private final List<Employee> employees;

    public EmployeeServiceImpl(String inputPath) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(inputPath));
        this.employees = new ArrayList<>();
    }

    @Override
    public void readEmployees() throws IOException {
        String input;

        while ((input = reader.readLine()) != null) {
            String[] split = input.split(", ");
            Long employeeId = Long.valueOf(split[0]);
            Long projectId = Long.valueOf(split[1]);
            LocalDate startDate = LocalDate.parse(split[2]);


            LocalDate endDate;
            if (split[3].equals("NULL")) {
                endDate = LocalDate.now();
            } else {
                endDate = LocalDate.parse(split[3]);
            }

            this.employees.add(new Employee(employeeId, projectId, startDate, endDate));

        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public Period findLongestWorkTogether() {
        int foundYears = Integer.MIN_VALUE;
        int foundMonths = Integer.MIN_VALUE;
        int foundDays = Integer.MIN_VALUE;

        for (int x = 0; x < employees.size(); x++) {


            for (int i = (x + 1); i < employees.size(); i++) {
                Employee employee1 = employees.get(x);
                Employee employee2 = employees.get(i);

                if (employee1.getId().equals(employee2.getId())) {
                    continue;
                }

                boolean isEmployeesWorkedOnCommonProject = findIfEmployeesHaveWorkedOnCommonProject(employee1, employee2);
                if (isEmployeesWorkedOnCommonProject) {
                    LocalDate startDate = findCommonStartDate(employee1, employee2);
                    LocalDate endDate = findCommonEndDate(employee1, employee2);

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

    private boolean findIfEmployeesHaveWorkedOnCommonProject(Employee employee1, Employee employee2) {
        return employee1.getProjectId().equals(employee2.getProjectId())
                && (employee1.getStartDate().compareTo(employee2.getEndDate()) < 0);
    }

    private LocalDate findCommonEndDate(Employee employee1, Employee employee2) {

        if (employee1.getEndDate().isAfter(employee2.getEndDate())) {
            return employee2.getEndDate();
        }

        return employee1.getEndDate();
    }

    private LocalDate findCommonStartDate(Employee employee1, Employee employee2) {

        if (employee1.getStartDate().isAfter(employee2.getStartDate())) {
            return employee1.getStartDate();
        }
        return employee2.getStartDate();
    }
//
//    private boolean findIfFirstStartDateIsAfterSecond(Employee employee1, Employee employee2) {
//        return employee1.getStartDate().isAfter(employee2.getStartDate());
//    }
//
//    private boolean findIfFirstEndDateIsAfterSecond(Employee employee1, Employee employee2) {
//        return employee1.getEndDate().isAfter(employee2.getEndDate());
//    }


}





