package models;

import java.time.LocalDate;

public class EmployeeViewModel {
    private Long firstEmployeeId;
    private Long secondEmployeeId;
    private Long projectId;
    private LocalDate daysWorked;

    public EmployeeViewModel() {
    }

    public EmployeeViewModel(Long firstEmployeeId, Long secondEmployeeId, Long projectId, LocalDate daysWorked) {
        this.firstEmployeeId = firstEmployeeId;
        this.secondEmployeeId = secondEmployeeId;
        this.projectId = projectId;
        this.daysWorked = daysWorked;
    }

    public Long getFirstEmployeeId() {
        return firstEmployeeId;
    }

    public void setFirstEmployeeId(Long firstEmployeeId) {
        this.firstEmployeeId = firstEmployeeId;
    }

    public Long getSecondEmployeeId() {
        return secondEmployeeId;
    }

    public void setSecondEmployeeId(Long secondEmployeeId) {
        this.secondEmployeeId = secondEmployeeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public LocalDate getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(LocalDate daysWorked) {
        this.daysWorked = daysWorked;
    }

    @Override
    public String toString() {
        return String.format("|%-10s10|%-10s10|%-10s10|%-10s10|%n"
                , this.firstEmployeeId
                , this.secondEmployeeId
                , this.projectId
                , this.daysWorked
        );
    }
}
