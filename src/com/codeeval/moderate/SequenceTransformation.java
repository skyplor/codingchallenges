package com.codeeval.moderate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * There are two sequences. The first sequence consists of digits "0" and "1", the second one consists of letters "A" and "B". The challenge is to determine whether it's possible to transform a given
 * binary sequence into a string sequence using the following rules:
 * 1. "0" can be transformed into non empty sequence of letters "A" ("A", "AA", "AAA" etc.)
 * 2. "1" can be transformed into non empty sequence of letters "A" ("A", "AA", "AAA" etc.) or to non empty sequence of letters "B" ("B", "BB", "BBB" etc) e.g.
 * 
 * @author Sky
 *
 */
public class SequenceTransformation {

    public static void main(String[] args) throws IOException {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader buffer = new BufferedReader(isr);
	String line;
	while ((line = buffer.readLine()) != null) {
	    line = line.trim();
	    String[] s = line.split(" ");
	    if (s.length == 2) {
		if (checkTransform(s[0], s[1]))
		    System.out.println("Yes");
		else
		    System.out.println("No");
	    }
	}
	buffer.close();
    }

    private static boolean checkTransform(String binary, String s) {

	boolean[][] memory = new boolean[binary.length()][s.length()];
	for (int j = 0; j < s.length(); j++) {
	    if (binary.substring(0, 1).equals("1") || (binary.substring(0, 1).equals("0") && s.substring(j, j + 1).equals("A")))
		memory[0][j] = true;
	    else
		memory[0][j] = false;
	}
	for (int i = 1; i < binary.length(); i++) {
	    for (int j = 1; j < s.length(); j++) {
		if (memory[i - 1][j - 1]) {
		    if (binary.substring(i, i + 1).equals("1") || (binary.substring(i, i + 1).equals("0") && s.substring(j, j + 1).equals("A"))) {
			memory[i][j] = true;
		    }
		} else {
		    memory[i][j] = memory[i - 1][j] && (s.substring(j - 1, j).equals(s.substring(j, j + 1)));
		}

	    }
	}
	return memory[binary.length() - 1][s.length() - 1];
    }
}
