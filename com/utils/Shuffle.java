package com.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import static java.lang.System.out;

public class Shuffle {

	public static void main(String[] args) {
		if (args.length == 1) {
			try {
				int input = Integer.parseInt(args[0]);
				if (input <= 0) {
					out.println("Input must be greater than 0. You've entered : " + input);
					return;
				}
				new Shuffle().generateRandonNumbers(input);
			} catch (NumberFormatException e) {
				out.println("Invalid input - " + args[0]);
				return;
			}
		} else {
			out.println("Input a number !");
		}

	}

	public void generateRandonNumbers(int n) {
		// Create an ordered list
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < (n + 1); i++) {
			list.add(i);
		}

		// Shuffle it
		Collections.shuffle(list);

		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			out.println(iter.next());
		}
	}

}
