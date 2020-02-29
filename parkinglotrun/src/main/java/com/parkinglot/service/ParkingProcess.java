package com.parkinglot.service;

import java.util.*;

import com.parkinglot.model.Car;

public class ParkingProcess {

	private static ParkingProcess parkingLotProcessor = null;
	private int numParkingSlots = 0;

	private List<Integer> availableSlots;
	private Map<String, Integer> regNumSlotMap;
	private Map<Integer, Car> slotCarMap;
	private Map<String, List<String>> colorMap;

	private ParkingProcess(int numParkingSlots) {
		this.numParkingSlots = numParkingSlots;
		availableSlots = new ArrayList<>();
		for (int slot = 1; slot <= numParkingSlots; slot++) {
			availableSlots.add(slot);
		}
		slotCarMap = new HashMap<>();
		regNumSlotMap = new HashMap<>();
		colorMap = new HashMap<>();
		System.out.println("User requested " + numParkingSlots + " parking lots created!");
	}

	public synchronized static ParkingProcess createParkingLot(int numParkingSlots) {

		if (parkingLotProcessor != null) {
			return parkingLotProcessor;
		} else {
			parkingLotProcessor = new ParkingProcess(numParkingSlots);
			return parkingLotProcessor;
		}
	}

	public void allocateSlot(Car car) {

	}

	public void leaveSlot(Integer slotNo) {

	}

	public void getStatus() {

	}

	public void getRegNumber(String color) {

	}

	public void getSlotNumber(String color) {

	}

	public void getSlotNumberForRegNum(String RegNum) {

	}

}
