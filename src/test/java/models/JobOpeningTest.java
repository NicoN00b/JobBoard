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
        JobOpening JobOpening = new JobOpening("programmer");
        assertEquals("programmer", JobOpening.getTitle());
    }

    @Test
    public void AllJobOpeningsAreCorrectlyReturned_true() {
        JobOpening jobOpening = new JobOpening("programmer ");
        JobOpening otherJobOpening = new JobOpening ("SEO");
        assertEquals(2, JobOpening.getAll().size());
    }

    @Test
    public void JobBoardContainsAllJobOpenings_true() {
        JobOpening jobOpening = new JobOpening("programmer");
        JobOpening otherJobOpening = new JobOpening("otherJobOpening");
        assertTrue(JobOpening.getAll().contains(jobOpening));
        assertTrue(JobOpening.getAll().contains(otherJobOpening));
    }



    public JobOpening setupNewJobOpening() {return new JobOpening("programmer");}

}