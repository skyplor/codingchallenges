package com.codeeval.easy;

import java.io.IOException;

/**
 * Write a program which determines the largest prime palindrome less than 1000.
 * 
 * @author Sky
 *
 */
public class PrimePalindrome {

    public static void main(String[] args) throws IOException {
	findPrimePalindrome(1000);
	// System.out.println(checkPalindrome(929));
    }

    private static void findPrimePalindrome(int n) {
	for (int i = n; i > 0; i--) {
	    // prime number can only be divisible by itself
	    // palindrome means have to check the characters at both end are equal
	    if (isPrime(i))
		return;
	}
    }

    private static boolean isPrime(int n) {
	if (n % 2 == 0)
	    return false;
	for (int i = 3; i < n; i += 2) {
	    if (n % i == 0)
		return false;
	}
	if (checkPalindrome(n)) {
	    System.out.println(n);
	    return true;
	}
	return false;
    }

    private static boolean checkPalindrome(int p) {
	if (p < 10 && p >= 0)
	    return true;

	int first = p;
	int count = 0;
	while (first >= 10) {
	    first = first / 10;
	    count++;
	}
	int last = p % 10;
	int middle = p - last;
	int subtract = 1;
	for (int i = 0; i < count; i++) {
	    subtract *= 10;
	}
	subtract = subtract * first;
	middle = middle - subtract;
	middle /= 10;
	return (first == last) && checkPalindrome(middle);
    }
}
