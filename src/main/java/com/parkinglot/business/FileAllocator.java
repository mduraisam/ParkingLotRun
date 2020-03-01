package com.parkinglot.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author Durai
 *
 */
public class FileAllocator extends BaseAllocator{

	@SuppressWarnings("resource")
	public void allocate(String file) throws Exception {
		System.out.println("Parking allocation started for the file : " + file);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(file)));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			execute(line);
		}
	}
}
