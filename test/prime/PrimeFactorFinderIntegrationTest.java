/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime;

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
public class PrimeFactorFinderIntegrationTest {
    
    public PrimeFactorFinderIntegrationTest() {
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
    
    @Test 
    public void testIsPrimeNumber1() {
        PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(2);
        primeFactorFinder.CalculatePrimeFactors();
        
        String expectedString = "2 is a prime number!";
        String actualString = primeFactorFinder.getResultString();
        assertEquals(expectedString, actualString);
    }
    
    @Test 
    public void testPrimeNumber2() {
        PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(17);
        primeFactorFinder.CalculatePrimeFactors();
        
        String expectedString = "17 is a prime number!";
        String actualString = primeFactorFinder.getResultString();
        assertEquals(expectedString, actualString);
    }
    
    @Test 
    public void testIsPrimeNumber3() {
        PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(1999999973);
        primeFactorFinder.CalculatePrimeFactors();
        
        String expectedString = "1999999973 is a prime number!";
        String actualString = primeFactorFinder.getResultString();
        assertEquals(expectedString, actualString);
    }
    
    @Test 
    public void testPrimeNumberFactors1() {
        PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(4);
        primeFactorFinder.CalculatePrimeFactors();
        
        String expectedString = "2, 2";
        String actualString = primeFactorFinder.getResultString();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testPrimeNumberFactors2() {
        PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(17483781);
        primeFactorFinder.CalculatePrimeFactors();
        
        String expectedString = "3, 7, 19, 29, 1511";
        String actualString = primeFactorFinder.getResultString();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testPrimeNumberFactors3() {
        PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(2000000000);
        primeFactorFinder.CalculatePrimeFactors();
        
        String expectedString = "2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5";
        String actualString = primeFactorFinder.getResultString();
        assertEquals(expectedString, actualString);
    }
    
    
}
