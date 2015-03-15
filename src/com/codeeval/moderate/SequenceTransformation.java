package com.codeeval.moderate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

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

    static HashMap<Integer, List<String>> hash;

    public static void main(String[] args) throws IOException {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader buffer = new BufferedReader(isr);
	String line;
	while ((line = buffer.readLine()) != null) {
	    line = line.trim();
	    String[] s = line.split(" ");
	    if (s.length == 2)
		System.out.println(checkTransform(s[0], s[1]));
	}
	buffer.close();
    }

    private static boolean checkTransform(String binary, String s) {

	return checkTransform(binary, s, binary.length() - 1);
    }

    private static boolean checkTransform(String binary, String s, int posB) {
	// We can use DP to solve by having a hash table with the possible results
	if (posB == 0)
	    return true;
	List<String> l = hash.get(posB);
	int size = l.size();
	String sub = binary.substring(0, posB - 1);
	for (int i = 0; i < size; i++) {
	    String temp = l.get(i);
	    if ((temp + sub).equals(s))
		return true;
	}
	return checkTransform(sub, s, posB - 1);
    }
}
