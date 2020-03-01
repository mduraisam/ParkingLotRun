package com.parkinglot.init;

import com.parkinglot.business.FileAllocator;
import com.parkinglot.business.InteractiveAllocator;

/**
 * @author Durai
 *
 */

public class Main {

	public static void main(String[] args) throws Exception {

		// File input
		if (args != null && args.length > 0) {
			new FileAllocator().allocate(args[0]);
		} else {
			new InteractiveAllocator().allocate();
		}
	}

}
