package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Guest on 8/10/17.
 */
public class JobOpening {
    private String title;
    private String location;
    private String employer;
    private String description;
    private String contact;
    private String salary;
    private static ArrayList<JobOpening> allJobs = new ArrayList<>();
    private LocalDateTime createdAt;
    private static int id;



    public JobOpening(String title, String location, String employer, String description, String contact, String salary) {
        this.title = title;
        this.location = location;
        this.employer = employer;
        this.description = description;
        this.contact = contact;
        this.salary = salary;
        allJobs.add(this);
        this.createdAt = LocalDateTime.now();
        this.id = allJobs.size();
    }

    public static ArrayList<JobOpening> getAll() {
        return allJobs;
    }

    public static void clearAllJobOpenings() {
        allJobs.clear();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }

    public static int getId() {
        return id;
    }

    public static JobOpening findById(int id) {
        return allJobs.get(id-1);
    }

    public void updateJobBoard(String title, String location, String employer, String description, String contact, String salary) {
        this.title = title;
        this.location = location;
        this.employer = employer;
        this.description = description;
        this.contact = contact;
        this.salary = salary;
    }

    public void deleteJobOpening() {
        allJobs.remove(id - 1); //same reason
        for (JobOpening thisJobOpening : allJobs) {
            thisJobOpening.id = allJobs.indexOf(thisJobOpening) + 1;
        }
    }



}
