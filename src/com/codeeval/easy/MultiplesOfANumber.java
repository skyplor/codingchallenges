package com.codeeval.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given numbers x and n, where n is a power of 2, print out the smallest multiple of n which is greater than or equal to x. Do not use division or modulo operator.
 * 
 */
public class MultiplesOfANumber {

    public static void main(String[] args) throws IOException {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader buffer = new BufferedReader(isr);
	String line;
	while ((line = buffer.readLine()) != null) {
	    line = line.trim();
	    String[] input = line.split(",");
	    if (input.length == 2) {
		int max = Integer.parseInt(input[0]);
		int multiple = Integer.parseInt(input[1]);
		System.out.println(getMinimum(max, multiple));
	    }
	}
	buffer.close();
    }

    private static int getMinimum(int max, int multiple) {
	int result = multiple;
	while (result < max) {
	    result += multiple;
	}
	return result;
    }

}
