package eci.ieti.data.model;

import java.util.Date;

public class Todo {
    private String description;
    private int priority;
    private Date dueDate;
    private User responsible;
    private String status;

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public User getResponsible() {
        return responsible;
    }

    public String getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
