import models.JobOpening;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/jobs/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "jobPost-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/jobs/new", (request, response) -> { //URL to make new place on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String newTitle = request.queryParams("title");
            String newLocation = request.queryParams("location");
            String newEmployer = request.queryParams("employer");
            String newDescription = request.queryParams("description");
            String newContact = request.queryParams("contact");
            String newSalary = request.queryParams("salary");

            JobOpening newJobOpening = new JobOpening();
            model.put("jobOpening", newJobOpening);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<JobOpening> jobs = JobOpening.getAll();
            model.put("jobs", jobs);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/jobs", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<JobOpening> jobs = JobOpening.getAll();
            model.put("jobs", jobs);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/jobs/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            JobOpening.clearAllJobOpenings();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/jobs/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfJobOpeningToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            JobOpening foundJobOpening = JobOpening.findById(idOfJobOpeningToFind); //use it to find place
            model.put("JobOpening", foundJobOpening); //add it to model for template to display
            return new ModelAndView(model, "job-details.hbs"); //individual place page.
        }, new HandlebarsTemplateEngine());

        get("/jobs/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfJobOpeningToEdit = Integer.parseInt(req.params("id"));
            JobOpening editJobOpening = JobOpening.findById(idOfJobOpeningToEdit);
            model.put("editJobOpening", editJobOpening);
            return new ModelAndView(model, "jobPost-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/jobs/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newTitle = req.queryParams("title");
            String newLocation = req.queryParams("location");
            String newEmployer = req.queryParams("employer");
            String newDescription = req.queryParams("description");
            String newContact = req.queryParams("contact");
            String newSalary = req.queryParams("salary");
            int idOfJobOpeningToEdit = Integer.parseInt(req.params("id"));
            JobOpening editJobOpening = JobOpening.findById(idOfJobOpeningToEdit);
            editJobOpening.updateJobBoard(newTitle, newLocation, newEmployer, newDescription, newContact, newSalary); //don’t forget me
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/jobs/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfJobOpeningToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            JobOpening deleteJobOpening = JobOpening.findById(idOfJobOpeningToDelete); //use it to find place
            deleteJobOpening.deleteJobOpening();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


    }


}

