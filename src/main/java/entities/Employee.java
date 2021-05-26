package entities;

import java.time.LocalDate;

public class Employee {
    private Long id;
    private Long projectId;
    private LocalDate startDate;
    private LocalDate endDate;

    public Employee(Long id, Long projectId, LocalDate startDate, LocalDate endDate) {
        this.setId(id);
        this.setProjectId(projectId);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        if (id < 0){
            throw new IllegalArgumentException("Employee Id can't be less than 0!");
        }
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    private void setProjectId(Long projectId) {
        if (projectId < 0){
            throw new IllegalArgumentException("Project Id can't be negative number!");
        }
        this.projectId = projectId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    private void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    private void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return String.format("Employee ID: %s ProjectID: %s Start date: %s End date: %s"
                ,this.getId()
                ,this.getProjectId()
                ,this.getStartDate()
                ,this.getEndDate());
    }

}
