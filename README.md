# ParkingLotRun

1) It should provide us with an interactive command prompt based shell where
commands can be typed in.
2) It should accept a filename as a parameter at the command prompt and read the
commands from that file.

# Tech Stack Used here:
1. Java 8
2. Maven
3. JUnit


# Sequence/Flow Diagram:


# Find Run Report:

## Interactive
	
F:\GIT\ParkingLotRun>parking_lot

F:\GIT\ParkingLotRun>java -jar target/parkinglot-run-0.1.jar
Enter your input:   create_parking_lot 6
User requested 6 parking lots created!
Enter your input:   park KA-01-HH-1234 White
Allocated slot number: 1

Enter your input:   park KA-01-HH-9999 White
Allocated slot number: 2

Enter your input:   park KA-01-BB-0001 Black
Allocated slot number: 3

Enter your input:   park KA-01-HH-7777 Red
Allocated slot number: 4

Enter your input:   park KA-01-HH-2701 Blue
Allocated slot number: 5

Enter your input:   park KA-01-HH-3141 Black
Allocated slot number: 6

Enter your input:   leave 4
Slot number 4 is free

Enter your input:   status
Slot No.        Registration No.         Color

1               KA-01-HH-1234           White
2               KA-01-HH-9999           White
3               KA-01-BB-0001           Black
5               KA-01-HH-2701           Blue
6               KA-01-HH-3141           Black

Enter your input:   park KA-01-P-333 White
Allocated slot number: 4

Enter your input:   park DL-12-AA-9999 White
Sorry, parking lot is full

Enter your input:   registration_numbers_for_cars_with_colour White

KA-01-HH-1234,KA-01-HH-9999,KA-01-P-333
Enter your input:   slot_numbers_for_cars_with_colour White

1, 2, 4
Enter your input:   slot_number_for_registration_number KA-01-HH-3141
6
Enter your input:   slot_number_for_registration_number MH-04-AY-1111
Not found

Enter your input:   exit

--------------

# ***File Input***

F:\GIT\ParkingLotRun>"parking_lot file_input.bat"

F:\GIT\ParkingLotRun>java -jar target/parkinglot-run-0.1.jar parking_lot_file_inputs.txt

Parking allocation started for the file : parking_lot_file_inputs.txt
User requested 6 parking lots created!
Allocated slot number: 1

Allocated slot number: 2

Allocated slot number: 3

Allocated slot number: 4

Allocated slot number: 5

Allocated slot number: 6

Slot number 4 is free

Slot No.        Registration No.         Color

1               KA-01-HH-1234           White
2               KA-01-HH-9999           White
3               KA-01-BB-0001           Black
5               KA-01-HH-2701           Blue
6               KA-01-HH-3141           Black

Allocated slot number: 4

Sorry, parking lot is full


KA-01-HH-1234,KA-01-HH-9999,KA-01-P-333

1, 2, 4
6
Not found


# Pending Actions:


