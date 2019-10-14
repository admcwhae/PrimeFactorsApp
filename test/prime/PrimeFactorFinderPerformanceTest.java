/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime;

import java.util.ArrayList;
import org.assertj.core.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex McWhae
 */
public class PrimeFactorFinderPerformanceTest {
    
    public PrimeFactorFinderPerformanceTest() {
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
     * Test whether all primes below 100,000,000 can be calculated within 10 seconds.
     * Calculates the number ten times and calculates and checks the average. 
     */
    @Test 
    public void performanceTestCalculatePrimes() {
        int testCount = 10; 
        long[] times = new long[testCount];
        
        for(int i = 0; i < testCount; i++) {
            long start = System.currentTimeMillis();
            PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(598765432);
            primeFactorFinder.CalculatePrimeFactors();

            long end = System.currentTimeMillis();
            times[i] = end - start;
            System.out.println(times[i]);
        }
        
        long sum = 0;
        for(int i = 0; i < testCount; i++) {
            sum += times[i];
        } 
        
        long actualAverage = sum / testCount;
        long timeLimit = 10000;      
        
        assertTrue(actualAverage < timeLimit);
    }
}
