/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime;

import java.util.ArrayList;

/**
 *
 * @author Alex McWhae
 */
public class PrimeNumberFinder {

    private int endNumber;
    private ArrayList<Integer> primeNumberList;

    public PrimeNumberFinder(int endNumber) {
        if (endNumber == 0) {
            throw new IllegalArgumentException("Number cannot be zero");
        } else if (endNumber == 1) {
            throw new IllegalArgumentException("Number cannot be one.");
        } else if (endNumber < 0) {
            throw new IllegalArgumentException("Number cannot be less than zero");
        } else if (endNumber > 1000000000) {
            throw new IllegalArgumentException("Number cannot be larger than 1,000,000,000");
        } else {
            this.endNumber = endNumber;
            this.primeNumberList = null;
        }
    }

    /**
     * Finds a list of primes up to a given n using efficient Sieve of
     * Eratosthenes algorithm Adapted from
     * http://www.javawithus.com/programs/sieve-of-eratosthenes
     *
     * @param n end limit number to check
     * @return a list of primes to n
     */
    public void calculatePrimes() {
        int n = this.endNumber;

        boolean[] primes = populateBooleanArray(n);
        int num = 2;
        while (true) {
            for (int i = 2;; i++) {
                int multiple = num * i;
                if (multiple > n) {
                    break;
                } else {
                    primes[multiple] = false;
                }
            }
            boolean nextNumFound = false;
            for (int i = num + 1; i < n + 1; i++) {
                if (primes[i]) {
                    num = i;
                    nextNumFound = true;
                    break;
                }
            }
            if (!nextNumFound) {
                break;
            }
        }
        this.primeNumberList = convertBooleanArrayToList(primes);
    }

    // returns an array of trues of the length of the input number
    public boolean[] populateBooleanArray(int n) {
        boolean[] array = new boolean[n + 1];
        int len = array.length;
        for (int i = 2; i < len; i++) {
            array[i] = true;
        }
        return array;
    }

    // takes boolean array end converts it to a list of numbers of the index of the trues in the array
    public ArrayList<Integer> convertBooleanArrayToList(boolean[] array) {
        ArrayList<Integer> returnList = new ArrayList<>();
        for (int i = 1; i < array.length; i++) {
            if (array[i]) {
                returnList.add(i);
            }
        }
        return returnList;
    }

    public int getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(int endNumber) {
        this.endNumber = endNumber;
    }

    public ArrayList getPrimeNumberList() {
        return primeNumberList;
    }

    public void setPrimeNumberList(ArrayList primeList) {
        this.primeNumberList = primeList;
    }

}
