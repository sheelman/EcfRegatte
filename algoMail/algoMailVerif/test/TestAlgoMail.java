/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AlgoTestMail.AlgoMail;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sheelman
 */
public class TestAlgoMail {
    
    AlgoMail estcorrect = new AlgoMail();
    
    public TestAlgoMail() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     /**
     * Test les mail avec la fonction
     */
    @Test
    public void testEmailEstCorrect() {
        assertTrue(estcorrect.mail("ab@cd.ef"));
        assertTrue(estcorrect.mail("abcdef@ghij.klmn"));
        assertFalse(estcorrect.mail("ab@c.f.ef"));
        assertFalse(estcorrect.mail("a@ghij.klmn"));
        assertFalse(estcorrect.mail("ab@c.de"));
        assertFalse(estcorrect.mail("ab@cd.e"));
        assertFalse(estcorrect.mail("abcdefghij"));
        assertFalse(estcorrect.mail("abcdefghij.kl"));
        assertFalse(estcorrect.mail("ab@cdef"));
    }
}
