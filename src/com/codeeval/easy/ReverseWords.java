package com.codeeval.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Write a program which reverses the words in an input sentence.
 * 
 * @author Sky
 *
 */
public class ReverseWords {

    // Split the string into arrays of words. Swap the words
    public static void main(String[] args) throws IOException {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader buffer = new BufferedReader(isr);
	String line;
	while ((line = buffer.readLine()) != null) {
	    line = line.trim();
	    String[] input = line.split(" ");
	    String[] output = swapWords(input);
	    for (int i = 0; i < output.length; i++) {
		if (i == 0)
		    System.out.print(output[i]);
		else
		    System.out.print(" " + output[i]);
	    }
	    System.out.println();
	}
	buffer.close();
    }

    private static String[] swapWords(String[] input) {
	int first = 0;
	int last = input.length - 1;
	while (last > first) {
	    input = doSwap(input, first, last);
	    first++;
	    last--;
	}
	return input;
    }

    private static String[] doSwap(String[] input, int first, int second) {
	String temp = input[first];
	input[first] = input[second];
	input[second] = temp;
	return input;
    }
}
