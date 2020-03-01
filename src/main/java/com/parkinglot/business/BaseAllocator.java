package com.parkinglot.business;

import static com.parkinglot.constants.Action.*;

import com.parkinglot.constants.Message;
import com.parkinglot.model.Car;
import com.parkinglot.service.ParkingProcess;

/**
 * @author Durai
 *
 */
public abstract class BaseAllocator {

	private ParkingProcess parkingProcess;
	
	public void execute(String inputLine) throws Exception {
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
			System.out.println(Message.WRONG_INPUT);
			break;
		}
	}
}
