package com.parkinglot.service;

import java.util.*;

import com.parkinglot.model.Car;
import static com.parkinglot.constants.Message.*;

/**
 * @author Durai
 *
 */
public class ParkingProcess {

	private static ParkingProcess parkingLotProcessor = null;
	private int numParkingSlots = 0;
	private List<Integer> availableSlots;
	private Map<String, Integer> regNumSlotMap;
	private Map<Integer, Car> slotCarMap;
	private Map<String, List<String>> colorMap;

	
	/**
	 * 
	 * @param numParkingSlots
	 */
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

	/**
	 * 
	 * @param numParkingSlots
	 * @return
	 */
	public synchronized static ParkingProcess createParkingLot(int numParkingSlots) {

		if (parkingLotProcessor != null) {
			return parkingLotProcessor;
		} else {
			parkingLotProcessor = new ParkingProcess(numParkingSlots);
			return parkingLotProcessor;
		}
	}

	/**
	 * 
	 * @param car
	 */
	public void allocateSlot(Car car) {
		if (numParkingSlots == 0) {
			System.out.println(NOT_CREATED);
			return;
		} else if (slotCarMap.size() == numParkingSlots) {
			System.out.println(PARKING_FULL);
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
			System.out.println(ALLOCATED_SLOTNUM + slot + NEW_LINE);
			availableSlots.remove(0);
		}
	}

	
	public void getStatus() {
		if (numParkingSlots == 0) {
			System.out.println(NOT_CREATED);
		} else if (slotCarMap.size() > 0) {
			System.out.println(OUTPUT_HEADER);
			Car car;
			for (int i = 1; i <= numParkingSlots; i++) {
				if (slotCarMap.containsKey(i)) {
					car = slotCarMap.get(i);
					System.out.println(i + "\t\t" + car.getRegNum() + "\t\t" + car.getColor());
				}
			}
			System.out.println();
		} else {
			System.out.println(PARKING_EMPTY);
		}
	}

	/**
	 * 
	 * @param color
	 */
	public void getRegNumber(String color) {
		if (numParkingSlots == 0) {
			System.out.println(NOT_CREATED);
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
			System.out.println(NOT_FOUND);
		}
	}

	/**
	 * 
	 * @param slotNo
	 */
	public void leaveSlot(Integer slotNo) {
		if (numParkingSlots == 0) {
			System.out.println(NOT_CREATED);
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
			System.out.println(PARKING_EMPTY);
		}
	}

	/**
	 * 
	 * @param RegNum
	 */
	public void getSlotNumberForRegNum(String RegNum) {
		if (numParkingSlots == 0) {
			System.out.println(NOT_CREATED);
		} else if (regNumSlotMap.containsKey(RegNum)) {
			System.out.println(regNumSlotMap.get(RegNum));
		} else {
			System.out.println(NOT_FOUND);
		}
	}

	/**
	 * 
	 * @param color
	 */
	public void getSlotNumber(String color) {
		if (numParkingSlots == 0) {
			System.out.println(NOT_CREATED);
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
			System.out.println(NOT_FOUND);
		}
	}

}
