package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Guest on 8/10/17.
 */
public class JobOpening {
    private String title;

    private String employer;
    private String description;
    private String contact;
    private String salary;
    private static ArrayList<JobOpening> jobBoard = new ArrayList<>();
    private LocalDateTime createdAt;



    public JobOpening(String title) {
        this.title = title;
        this.employer = employer;
        this.description = description;
        this.contact = contact;
        this.salary = salary;
        jobBoard.add(this);
        this.createdAt = LocalDateTime.now();
    }

    public static ArrayList<JobOpening> getAll() {
        return jobBoard;
    }

    public static void clearAllJobOpenings() {
        jobBoard.clear();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
