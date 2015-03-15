package com.codeeval.moderate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestLine {

    public static void main(String[] args) throws IOException {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader buffer = new BufferedReader(isr);
	String line;
	line = buffer.readLine();
	int size = Integer.parseInt(line);
	HashMap<Integer, List<String>> hash = new HashMap<Integer, List<String>>();
	// add into dictionary
	while ((line = buffer.readLine()) != null) {
	    line = line.trim();
	    hash = addEntry(hash, line);
	}
	buffer.close();

	getString(hash, size);

    }

    private static HashMap<Integer, List<String>> addEntry(HashMap<Integer, List<String>> hash, String line) {
	if (!hash.containsKey(line.length())) {
	    List<String> l = new ArrayList<String>();
	    l.add(line);
	    hash.put(line.length(), l);
	} else {
	    List<String> a = hash.get(line.length());
	    a.add(line);
	}
	return hash;
    }

    private static void getString(HashMap<Integer, List<String>> hash, int size) {
	int maxKey = 0;
	int count = 0;
	List<String> result = new ArrayList<String>();
	while (count < size) {
	    maxKey = 0;
	    for (int key : hash.keySet()) {
		if (key > maxKey)
		    maxKey = key;
	    }
	    List<String> l = hash.remove(maxKey);
	    for (int j = 0; j < l.size(); j++) {
		if (result.size() < size) {
		    result.add(l.get(j));
		    count++;
		} else
		    break;
	    }

	}
	for (int k = 0; k < result.size(); k++)
	    System.out.println(result.get(k));
    }
}
