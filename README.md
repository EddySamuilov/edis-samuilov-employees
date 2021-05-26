# edis-samuilov-employees

In the first part of the task we read the data for employees from "input.txt" file. Then we split the data and create new Employee with ID, project ID, start and end date
(There've been added some encapsulation through the setters for the id's). Finally we add the new Employee in List where has to be stored all of the employees.
In the second part of the task, we find the employees who work together on given project for the longest time.
We iterate through all employees with two cycles and reduce the time complexity (which will be O(n^2)). In the second cycle we start from the "x+1" employee, 
because we have already evaluated the previous employees and we don't want to repeat the steps again (complexity now is O(nlogn)). We get the employee and compare it with the 
other employees. If they have been worked on the same project, we calculate the time when this was happened.
The function "findLongestWorkOnCommonProject" return the years, months and days for the longest period where two employees have worked on to common project.

/**
I don't have enough time to implement the bonus tasks. I started them but they are not finished yet, so the "DateFormatter" class may not performs as it meant to be.
The "models" folder includes only "ideas".
**/
