package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;


public class JobOpeningTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        JobOpening.clearAllJobOpenings();
    }

    @Test
    public void NewJobOpeningObjectGetsCorrectlyCreated_true() throws Exception {
        JobOpening jobOpening = setupNewJobOpening();
        assertEquals(true, jobOpening instanceof JobOpening);
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception{
        JobOpening jobOpening =  setupNewJobOpening(); //see below
        assertEquals(LocalDateTime.now().getDayOfWeek(), jobOpening.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void JobOpeningInstantiatesWithContent_true() throws Exception {
        JobOpening JobOpening = setupNewJobOpening();
        assertEquals("programmer", JobOpening.getTitle());
    }

    @Test
    public void AllJobOpeningsAreCorrectlyReturned_true() {
        JobOpening jobOpening = setupNewJobOpening();
        JobOpening otherJobOpening = setupNewJobOpening();
        assertEquals(2, JobOpening.getAll().size());
    }

    @Test
    public void JobBoardContainsAllJobOpenings_true() {
        JobOpening jobOpening = setupNewJobOpening();
        JobOpening otherJobOpening = setupNewJobOpening();
        assertTrue(JobOpening.getAll().contains(jobOpening));
        assertTrue(JobOpening.getAll().contains(otherJobOpening));
    }

    @Test
    public void getId_JobOpeningsInstantiateWithAnID_1() throws Exception {
        JobOpening.clearAllJobOpenings();  // Remember, the test will fail without this line! We need to empty leftover JobOpenings from previous tests!
        JobOpening jobOpening = setupNewJobOpening();
        assertEquals(1, jobOpening.getId());
    }

    @Test
    public void findReturnsCorrectJobOpening() throws Exception {
        JobOpening jobOpening = setupNewJobOpening();
        assertEquals(1, JobOpening.findById(jobOpening.getId()).getId());
    }

    @Test
    public void findReturnsCorrectJobOpeningWhenMoreThanOneJobOpeningExists() throws Exception {
        JobOpening jobOpening = setupNewJobOpening();
        JobOpening otherJobOpening = setupNewJobOpening();
        assertEquals(2, JobOpening.findById(otherJobOpening.getId()).getId());
    }

    @Test
    public void updateChangesJobOpeningContent() throws Exception {
        JobOpening jobOpening = setupNewJobOpening();
        String formerTitle = jobOpening.getTitle();
        String formerLocation = jobOpening.getLocation();
        String formerEmployer = jobOpening.getEmployer();
        String formerDescription = jobOpening.getDescription();
        String formerContact = jobOpening.getContact();
        Integer formerSalary =  jobOpening.getSalary();
        LocalDateTime formerDate = jobOpening.getCreatedAt();
        int formerId = jobOpening.getId();

        jobOpening.updateJobBoard("SEO Manager", "portland", "epicodus", "Instructor", "Debbie", 50000);

        assertNotEquals(formerTitle, jobOpening.getTitle());
        assertNotEquals(formerLocation, jobOpening.getLocation());
        assertNotEquals(formerEmployer, jobOpening.getEmployer());
        assertNotEquals(formerDescription, jobOpening.getDescription());
        assertNotEquals(formerContact, jobOpening.getContact());
        assertNotEquals(formerSalary, jobOpening.getSalary());
        assertEquals(formerId, JobOpening.getId());


    }

    public JobOpening setupNewJobOpening() {return new JobOpening("programmer", 40000);}

}