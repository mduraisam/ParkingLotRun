/**
 * 
 */
package com.parkinglot;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.parkinglot.business.BaseAllocator;
import com.parkinglot.business.InteractiveAllocator;

/**
 * @author Durai
 *
 */
public class ParkingLotTest {

	static BaseAllocator allocator = null;

	@BeforeClass
	public static void setUp() throws Exception {
		allocator = new InteractiveAllocator();
		allocator.execute("create_parking_lot 6");
	}

	@Test
	public void testCreateParkingLot() {
		try {
			allocator.execute("create_parking_lot 6");
		} catch (Exception e) {
			fail("Creation of parking slot failed");
		}
	}

	@Test
	public void testPark() {
		try {
			allocator.execute("park KA-01-HH-1234 White");
		} catch (Exception e) {
			fail("Creation of parking slot failed");
		}
	}

	@Test
	public void testStatus() {
		try {
			allocator.execute("status");
		} catch (Exception e) {
			fail("Fetching status functioanlity failed");
		}
	}

	@Test
	public void testGetSlotNumber() {
		try {
			allocator.execute("slot_numbers_for_cars_with_colour White");
		} catch (Exception e) {
			fail("slot_numbers_for_cars_with_colour functionality failed");
		}
	}

	@Test
	public void testGetSlotNumberForRegNum() {
		try {
			allocator.execute("registration_numbers_for_cars_with_colour White");
		} catch (Exception e) {
			fail("registration_numbers_for_cars_with_colour functionality failed");
		}
	}

	@Test
	public void testSlotByRegNo() {
		try {
			allocator.execute("registration_numbers_for_cars_with_colour 1111");
		} catch (Exception e) {
			fail("registration_numbers_for_cars_with_colour functionality failed");
		}
	}
	
	@Test
	public void testLeaveSlot() {
		try {
			allocator.execute("leave 4");
		} catch (Exception e) {
			fail("leave functionality failed");
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

}
