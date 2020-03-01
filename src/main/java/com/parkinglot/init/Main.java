package com.parkinglot.init;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

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

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter your input:");
			String inputLine = scanner.nextLine();
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
			System.out.println("Wrong Input, please provide the correct input.");
			break;
		}
	}
}
