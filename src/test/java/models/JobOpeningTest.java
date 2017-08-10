package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/10/17.
 */
public class JobOpeningTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void NewJobOpeningObjectGetsCorrectlyCreated_true() throws Exception {
        JobOpening jobOpening = setupNewJobOpening();
        assertEquals(true, jobOpening instanceof JobOpening);
    }



    public JobOpening setupNewJobOpening() {return new JobOpening("programmer");}

}