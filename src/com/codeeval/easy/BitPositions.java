package com.codeeval.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitPositions {

    public static void main(String[] args) throws IOException {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader buffer = new BufferedReader(isr);
	String line;
	while ((line = buffer.readLine()) != null) {
	    line = line.trim();
	    String[] input = line.split(",");
	    if (input.length == 3) {
		int num = Integer.parseInt(input[0]);
		int bit1 = Integer.parseInt(input[1]);
		int bit2 = Integer.parseInt(input[2]);
		System.out.println(checkBit(num, bit1, bit2));
	    }
	}
	buffer.close();
    }

    private static String checkBit(int num, int bit1, int bit2) {
	int temp1 = num;
	int temp2 = num;
	int mask1 = 1 << bit1-1;
	int mask2 = 1 << bit2-1;
	temp1 = temp1 & mask1;
	temp2 = temp2 & mask2;
	temp1 = temp1 >> bit1-1;
	temp2 = temp2 >> bit2-1;
	if (temp1 == temp2)
	    return "true";
	else
	    return "false";
    }
}
