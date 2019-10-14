package prime;

import java.util.ArrayList;

/**
 *
 * @author Alex McWhae
 */
public class PrimeFactorFinder {

    private int inputNumber;
    private ArrayList<Integer> primeFactorList;
    private String resultString;
    private boolean isPrime;
    private PrimeNumberFinder primeNumberFinder;

    /**
     * Create a triangle with sides x, y, z (all positive) Make sure such a
     * triangle can be formed using the "static isTriangle()" above
     *
     * @param inputNumber
     */
    public PrimeFactorFinder(int inputNumber) {
        if (inputNumber == 0) {
            throw new IllegalArgumentException("Number cannot be zero.");
        } else if (inputNumber < 0) {
            throw new IllegalArgumentException("Number cannot be less than zero.");
        } else if (inputNumber == 1) {
            throw new IllegalArgumentException("Number cannot be one.");
        } else if (inputNumber > 2000000000) {
            throw new IllegalArgumentException("Number cannot be larger than 2,000,000,000");
        } else {
            this.inputNumber = inputNumber;
            this.primeFactorList = new ArrayList<>();
            this.resultString = "Not yet calculated.";
            int lastPrimeFactor = (int) Math.ceil(((double) inputNumber)/2);
            this.primeNumberFinder = new PrimeNumberFinder(lastPrimeFactor);
        }
    }

    public void CalculatePrimeFactors() {
        primeNumberFinder.calculatePrimes();

        ArrayList<Integer> primeList = primeNumberFinder.getPrimeNumberList();

        // need to add the input number to the list as if its a prime itself it will be it's only prime factor
        primeList.add(inputNumber);

        boolean finished = false;
        int number = inputNumber;
        int i = 0;
        while (!finished) {
            if (number == 1) {
                finished = true;
            } else {
                int factor = primeList.get(i);
                if (number % factor == 0) {
                    number = number / factor;
                    primeFactorList.add(factor);
                } else {
                    i++;
                }
            }
        }
        if ((primeFactorList.size()) == 1) {
            this.isPrime = true;
            this.resultString = inputNumber + " is a prime number!";
        }
        else {
            String listString = "";
            for (i = 0; i < primeFactorList.size(); i++) {
                listString += primeFactorList.get(i) + ", " ;
            }     
            this.isPrime = false;
            // remove last space and comma
            listString = listString.substring(0, listString.length() - 2);
            this.resultString = listString;
        }
    }

    public int getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public ArrayList<Integer> getPrimeFactorList() {
        return primeFactorList;
    }

    public void setPrimeFactorList(ArrayList<Integer> primeFactorList) {
        this.primeFactorList = primeFactorList;
    }

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }

    public boolean getIsPrime() {
        return isPrime;
    }

    public void setIsPrime(boolean isPrime) {
        this.isPrime = isPrime;
    }

    public PrimeNumberFinder getPrimeNumberFinder() {
        return primeNumberFinder;
    }

    public void setPrimeNumberFinder(PrimeNumberFinder primeNumberFinder) {
        this.primeNumberFinder = primeNumberFinder;
    }
}
