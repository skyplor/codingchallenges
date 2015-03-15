package com.codeeval.easy;

import java.io.IOException;

/**
 * Print to stdout the sum of the first 1000 prime numbers.
 * 
 * @author Sky
 *
 */
public class SumOfPrimes {
    static int sum = 0;
    static int count = 0;
    static int current = 0;

    public static void main(String[] args) throws IOException {
	sumOfPrimes(1000);
    }

    private static void sumOfPrimes(int n) {
	// if number is a prime, add it to the sum and increment the count. If count equal to n, we print out the sum.
	while (count < n) {
	    if (isPrime(current)) {
		sum += current;
		count++;
	    }
	    current++;
	}
	System.out.println(sum);
    }

    private static boolean isPrime(int n) {
	if (n == 1) return false;
	if (n != 2 && n % 2 == 0)
	    return false;
	for (int i = 3; i < n; i += 2)
	    if (n % i == 0)
		return false;
	return true;
    }
}
