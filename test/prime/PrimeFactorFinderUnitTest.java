/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
/**
 *
 * @author Alex McWhae
 */
public class PrimeFactorFinderUnitTest {
    
    public PrimeFactorFinderUnitTest() {
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
    public void shouldntConstructWhenZero() {
        boolean exceptionThrown = false;
        try {
            PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(0);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
    
    @Test 
    public void shouldntConstructWhenOne() {
        boolean exceptionThrown = false;
        try {
            PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(1);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
    
    @Test
    public void shouldntConstructWhenNegative1() {
        boolean exceptionThrown = false;
        try {
            PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(-1);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
    
    @Test
    public void shouldntConstructWhenNegative2() {
        boolean exceptionThrown = false;
        try {
            PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(-100000);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
    
    @Test
    public void shouldntConstructWhenLarge() {
        boolean exceptionThrown = false;
        try {
            PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(2000000001);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }  
    
    @Test 
    public void testIsPrimeNumber1() {
        PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(2);
        
        MockitoAnnotations.initMocks(this);        
        PrimeNumberFinder mockPrimeNumberFinder = Mockito.mock(PrimeNumberFinder.class);
        
        primeFactorFinder.setPrimeNumberFinder(mockPrimeNumberFinder);
        
        int[] numberArray = {2};
        ArrayList<Integer> primeNumberList = new ArrayList<Integer>(numberArray.length);
        for (int i : numberArray)
        {
            primeNumberList.add(i);
        }
        
        Mockito.doNothing().when(mockPrimeNumberFinder).calculatePrimes();
        Mockito.doReturn(primeNumberList).when(mockPrimeNumberFinder).getPrimeNumberList();
      
        primeFactorFinder.CalculatePrimeFactors();
        
        String expectedString = "2 is a prime number!";
        String actualString = primeFactorFinder.getResultString();
        assertEquals(expectedString, actualString);
    }
    
    @Test 
    public void testPrimeNumber2() {
        PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(17);
        
        MockitoAnnotations.initMocks(this);        
        PrimeNumberFinder mockPrimeNumberFinder = Mockito.mock(PrimeNumberFinder.class);
        
        primeFactorFinder.setPrimeNumberFinder(mockPrimeNumberFinder);
        
        int[] numberArray = {2, 3, 5, 7, 11, 13, 17};
        ArrayList<Integer> primeNumberList = new ArrayList<Integer>(numberArray.length);
        for (int i : numberArray)
        {
            primeNumberList.add(i);
        }
        
        Mockito.doNothing().when(mockPrimeNumberFinder).calculatePrimes();
        Mockito.doReturn(primeNumberList).when(mockPrimeNumberFinder).getPrimeNumberList();
      
        primeFactorFinder.CalculatePrimeFactors();
        
        String expectedString = "17 is a prime number!";
        String actualString = primeFactorFinder.getResultString();
        assertEquals(expectedString, actualString);
    }
    
    @Test 
    public void testIsPrimeNumber3() {
        PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(1999999973);        
        MockitoAnnotations.initMocks(this);        
        PrimeNumberFinder mockPrimeNumberFinder = Mockito.mock(PrimeNumberFinder.class);
        
        primeFactorFinder.setPrimeNumberFinder(mockPrimeNumberFinder);
        
        // due to large amount of numbers, middle primes are ignored
        int[] numberArray = {2, 3, 5, 7, 11, 13, 1999999973};
        ArrayList<Integer> primeNumberList = new ArrayList<Integer>(numberArray.length);
        for (int i : numberArray)
        {
            primeNumberList.add(i);
        }
        
        Mockito.doNothing().when(mockPrimeNumberFinder).calculatePrimes();
        Mockito.doReturn(primeNumberList).when(mockPrimeNumberFinder).getPrimeNumberList();
      
        primeFactorFinder.CalculatePrimeFactors();
        
        String expectedString = "1999999973 is a prime number!";
        String actualString = primeFactorFinder.getResultString();
        assertEquals(expectedString, actualString);
    }
    
    @Test 
    public void testPrimeNumberFactors1() {
        PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(4);
        
        MockitoAnnotations.initMocks(this);        
        PrimeNumberFinder mockPrimeNumberFinder = Mockito.mock(PrimeNumberFinder.class);
        
        primeFactorFinder.setPrimeNumberFinder(mockPrimeNumberFinder);
        
        int[] numberArray = {2, 3};
        ArrayList<Integer> primeNumberList = new ArrayList<Integer>(numberArray.length);
        for (int i : numberArray)
        {
            primeNumberList.add(i);
        }
        
        Mockito.doNothing().when(mockPrimeNumberFinder).calculatePrimes();
        Mockito.doReturn(primeNumberList).when(mockPrimeNumberFinder).getPrimeNumberList();
      
        primeFactorFinder.CalculatePrimeFactors();
        
        
        String expectedString = "2, 2";
        String actualString = primeFactorFinder.getResultString();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testPrimeNumberFactors2() {
        PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(17483781);
        
        MockitoAnnotations.initMocks(this);        
        PrimeNumberFinder mockPrimeNumberFinder = Mockito.mock(PrimeNumberFinder.class);
        
        primeFactorFinder.setPrimeNumberFinder(mockPrimeNumberFinder);
        
        int[] numberArray = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499, 1511, 1523, 1531, 1543, 1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597, 1601, 1607, 1609, 1613, 1619, 1621, 1627, 1637, 1657, 1663, 1667, 1669, 1693, 1697, 1699, 1709, 1721, 1723, 1733, 1741, 1747, 1753, 1759, 1777, 1783, 1787, 1789, 1801, 1811, 1823, 1831, 1847, 1861, 1867, 1871, 1873, 1877, 1879, 1889, 1901, 1907, 1913, 1931, 1933, 1949, 1951, 1973, 1979, 1987, 1993, 1997, 1999, 2003, 2011, 2017, 2027, 2029, 2039, 2053, 2063, 2069, 2081, 2083, 2087, 2089, 2099, 2111, 2113, 2129, 2131, 2137, 2141};
        ArrayList<Integer> primeNumberList = new ArrayList<Integer>(numberArray.length);
        for (int i : numberArray)
        {
            primeNumberList.add(i);
        }
        
        Mockito.doNothing().when(mockPrimeNumberFinder).calculatePrimes();
        Mockito.doReturn(primeNumberList).when(mockPrimeNumberFinder).getPrimeNumberList();
      
        primeFactorFinder.CalculatePrimeFactors();
        
        String expectedString = "3, 7, 19, 29, 1511";
        String actualString = primeFactorFinder.getResultString();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testPrimeNumberFactors3() {
        PrimeFactorFinder primeFactorFinder = new PrimeFactorFinder(2000000000);
                MockitoAnnotations.initMocks(this);        
        PrimeNumberFinder mockPrimeNumberFinder = Mockito.mock(PrimeNumberFinder.class);
        
        primeFactorFinder.setPrimeNumberFinder(mockPrimeNumberFinder);
        
        int[] numberArray = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499, 1511, 1523, 1531, 1543, 1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597, 1601, 1607, 1609, 1613, 1619, 1621, 1627, 1637, 1657, 1663, 1667, 1669, 1693, 1697, 1699, 1709, 1721, 1723, 1733, 1741, 1747, 1753, 1759, 1777, 1783, 1787, 1789, 1801, 1811, 1823, 1831, 1847, 1861, 1867, 1871, 1873, 1877, 1879, 1889, 1901, 1907, 1913, 1931, 1933, 1949, 1951, 1973, 1979, 1987, 1993, 1997, 1999, 2003, 2011, 2017, 2027, 2029, 2039, 2053, 2063, 2069, 2081, 2083, 2087, 2089, 2099, 2111, 2113, 2129, 2131, 2137, 2141};
        ArrayList<Integer> primeNumberList = new ArrayList<Integer>(numberArray.length);
        for (int i : numberArray)
        {
            primeNumberList.add(i);
        }
        
        Mockito.doNothing().when(mockPrimeNumberFinder).calculatePrimes();
        Mockito.doReturn(primeNumberList).when(mockPrimeNumberFinder).getPrimeNumberList();
      
        primeFactorFinder.CalculatePrimeFactors();
        
        String expectedString = "2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5";
        String actualString = primeFactorFinder.getResultString();
        assertEquals(expectedString, actualString);
    }
}
