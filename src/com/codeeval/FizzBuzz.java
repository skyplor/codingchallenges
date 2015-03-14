package com.codeeval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {

    public static void main(String[] args) throws IOException {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader buffer = new BufferedReader(isr);
	String line;
	int f = 0;
	int b = 0;
	int size = 0;
	while ((line = buffer.readLine()) != null) {
	    line = line.trim();
	    // Process line of input Here
	    String[] input = line.split(" ");
	    if (input.length == 3) {
		f = Integer.parseInt(input[0]);
		b = Integer.parseInt(input[1]);
		size = Integer.parseInt(input[2]);
	    }
	    printFizzBuzz(f, b, size);
	}
	buffer.close();
    }

    private static void printFizzBuzz(int f, int b, int size) {
	for (int i = 1; i <= size; i++) {
	    if ((i % f) == 0)
		System.out.print("F");
	    if ((i % b) == 0)
		System.out.print("B");
	    if ((i % f) != 0 && (i % b) != 0)
		System.out.print(i);
	    System.out.print(" ");
	}
	System.out.println();
    }
}
