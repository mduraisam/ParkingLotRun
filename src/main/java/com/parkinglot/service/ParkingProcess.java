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
		if (numParkingSlots == 0) {
			System.out.println("Sorry, parking lot is not created\n");
			return;
		} else if (slotCarMap.size() == numParkingSlots) {
			System.out.println("Sorry, parking lot is full\n");
			return;
		} else {
			Collections.sort(availableSlots);
			int slot = availableSlots.get(0);
			slotCarMap.put(slot, car);

			regNumSlotMap.put(car.getRegNum(), slot);

			if (colorMap.containsKey(car.getColor())) {
				List<String> regNumlst = colorMap.get(car.getColor());
				colorMap.remove(car.getColor());
				regNumlst.add(car.getRegNum());
				colorMap.put(car.getColor(), regNumlst);
			} else {
				LinkedList<String> regNumlst = new LinkedList<String>();
				regNumlst.add(car.getRegNum());
				colorMap.put(car.getColor(), regNumlst);
			}
			System.out.println("Allocated slot number: " + slot + "\n");
			availableSlots.remove(0);
		}
	}

	public void getStatus() {
		if (numParkingSlots == 0) {
			System.out.println("Sorry, parking lot is not created \n");
		} else if (slotCarMap.size() > 0) {
			System.out.println("Slot No.\t Registration No.\t Color\n");
			Car car;
			for (int i = 1; i <= numParkingSlots; i++) {
				if (slotCarMap.containsKey(i)) {
					car = slotCarMap.get(i);
					System.out.println(i + "\t" + car.getRegNum() + "\t" + car.getColor());
				}
			}
			System.out.println();
		} else {
			System.out.println("Parking lot is empty\n");
		}
	}

	public void getRegNumber(String color) {
		if (numParkingSlots == 0) {
			System.out.println("Sorry, parking lot is not created\n");
		} else if (colorMap.containsKey(color)) {
			List<String> regNumlst = colorMap.get(color);
			 System.out.println();
			for (int i = 0; i < regNumlst.size(); i++) {
				if (!(i == regNumlst.size() - 1)) {
					System.out.print(regNumlst.get(i) + ",");
				} else {
					System.out.print(regNumlst.get(i));
				}
			}
			 System.out.println();
		} else {
			System.out.println("Not found\n");
		}
	}

	public void leaveSlot(Integer slotNo) {
		if (numParkingSlots == 0) {
			System.out.println("Sorry, parking lot is not created\\n");
		} else if (slotCarMap.size() > 0) {
			Car carToLeave = slotCarMap.get(slotNo);
			if (carToLeave != null) {
				slotCarMap.remove(slotNo);
				regNumSlotMap.remove(carToLeave.getRegNum());
				List<String> regNumlst = colorMap.get(carToLeave.getColor());
				if (regNumlst.contains(carToLeave.getRegNum())) {
					regNumlst.remove(carToLeave.getRegNum());
				}
				availableSlots.add(slotNo);
				System.out.println("Slot number " + slotNo + " is free\n");
			} else {
				System.out.println("Slot number " + slotNo + " is already empty\n");
			}
		} else {
			System.out.println("Parking lot is empty\n");
		}
	}

	public void getSlotNumber(String color) {
		if (numParkingSlots == 0) {
			System.out.println("Sorry, parking lot is not created\n");
		} else if (colorMap.containsKey(color)) {
			List<String> regNumlst = colorMap.get(color);
			List<Integer> slotList = new ArrayList<Integer>();
			System.out.println();
			for (int i = 0; i < regNumlst.size(); i++) {
				slotList.add(Integer.valueOf(regNumSlotMap.get(regNumlst.get(i))));
			}
			Collections.sort(slotList);
			for (int j = 0; j < slotList.size(); j++) {
				if (!(j == slotList.size() - 1)) {
					System.out.print(slotList.get(j) + ", ");
				} else {
					System.out.print(slotList.get(j));
				}
			}
			System.out.println();
		} else {
			System.out.println("Colour is not found\n");
		}
	}

	public void getSlotNumberForRegNum(String RegNum) {
		if (numParkingSlots == 0) {
			System.out.println("Sorry, parking lot is not created\n");
		} else if (regNumSlotMap.containsKey(RegNum)) {
			System.out.println(regNumSlotMap.get(RegNum));
		} else {
			System.out.println("RegNum is not found\n");
		}
	}

}
