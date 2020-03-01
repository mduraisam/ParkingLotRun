package com.parkinglot.business;

import java.util.Scanner;

/**
 * @author Durai
 *
 */
public class InteractiveAllocator extends BaseAllocator {

	@SuppressWarnings("resource")
	public void allocate() throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter your input:");
			String inputLine = scanner.nextLine();
			execute(inputLine);
		}
	}
}
