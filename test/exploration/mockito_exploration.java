/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exploration;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import prime.PrimeFactorFinder;
import prime.PrimeNumberFinder;

/**
 *
 * @author Alex McWhae
 */
public class mockito_exploration {    
    public mockito_exploration() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
    }
    
    @After
    public void tearDown() {
    }          
    
    @Test
    public void testCalculateFactors() {
        PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(12);
        
        PrimeNumberFinder mockPrimeNumberFinder = Mockito.mock(PrimeNumberFinder.class);
        
        primeFactorFinder.setPrimeNumberFinder(mockPrimeNumberFinder);
        
        int[] numberArray = {2, 3, 5};
        ArrayList<Integer> primeNumberList = new ArrayList<Integer>(numberArray.length);
        for (int i : numberArray)
        {
            primeNumberList.add(i);
        }
        
        Mockito.doNothing().when(mockPrimeNumberFinder).calculatePrimes();
        Mockito.doReturn(primeNumberList).when(mockPrimeNumberFinder).getPrimeNumberList();
      
        primeFactorFinder.CalculatePrimeFactors();
        
        String expectedString = "2, 2, 3";
        String actualString = primeFactorFinder.getResultString();
        assertEquals(expectedString, actualString);
    }    
}
