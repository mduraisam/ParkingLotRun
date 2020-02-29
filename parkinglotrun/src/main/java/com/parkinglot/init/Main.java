package com.parkinglot.init;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.parkinglot.model.Car;
import com.parkinglot.service.ParkingProcess;
import static com.parkinglot.constants.Action.*;

/**
 * @author Durai
 *
 */

public class Main {
	static ParkingProcess parkingProcess;

	public static void main(String[] args) throws Exception {

		System.out.println("Welcome to Parking Lot System!!!");
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String inputLine = bufferRead.readLine();
			execute(inputLine);
		}
	}

	public static void execute(String inputLine) throws Exception {
		String[] userInputs = inputLine.split(" ");
		String action = userInputs[0];

		switch (action) {
		case CREATE:
			int parkingSlots = Integer.parseInt(userInputs[1]);
			parkingProcess = ParkingProcess.createParkingLot(parkingSlots);
			break;
		case PARK:
			parkingProcess.allocateSlot(new Car(userInputs[1], userInputs[2]));
			break;
		case LEAVE:
			int slotNo = Integer.parseInt(userInputs[1]);
			parkingProcess.leaveSlot(slotNo);
			break;
		case STATUS:
			parkingProcess.getStatus();
			break;
		case REGNUM_CAR_COLOR:
			parkingProcess.getRegNumber(userInputs[1]);
			break;
		case SLOTNUM_CAR_COLOR:
			parkingProcess.getSlotNumber(userInputs[1]);
			break;
		case SLOTNUM_REG_NO:
			parkingProcess.getSlotNumberForRegNum(userInputs[1]);
			break;
		case EXIT:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid command");
			break;
		}
	}
}
