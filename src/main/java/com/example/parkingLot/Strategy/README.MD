Parking Lot - Low Level Design (LLD) Problem Statement
Problem Statement

Design a parking lot management system for a multi-level parking facility that can efficiently park and unpark different types of vehicles, issue parking tickets, calculate parking fees, and display parking availability.

The system should be modular, extensible, and follow object-oriented design principles.

Functional Requirements
1. Parking Lot
   The parking lot has multiple floors.
   Each floor contains multiple parking spots.
   Each parking spot has a unique ID.
2. Vehicle Types

The system should support:

Bike
Car
Truck

Each vehicle has:

Vehicle Number
Vehicle Type
3. Parking Spot Types

The parking lot contains different spot types:

Bike Spot
Compact Spot
Large Spot

Allocation rules:

Vehicle	Allowed Spot
Bike	Bike Spot
Car	Compact Spot
Truck	Large Spot

(Interviewers may later ask you to allow a car to use a large spot if no compact spots are available.)

4. Park Vehicle

When a vehicle arrives:

Find an appropriate free parking spot.
Mark the spot as occupied.
Generate a parking ticket.
Record entry time.

If no suitable spot is available, reject the request.

5. Unpark Vehicle

When a vehicle exits:

Validate the parking ticket.
Free the parking spot.
Calculate parking charges.
Accept payment.
Close the ticket.
6. Parking Ticket

A ticket should contain:

Ticket ID
Vehicle Number
Entry Time
Parking Spot
Floor Number
7. Parking Fee

Parking charges should be calculated based on:

Entry time
Exit time
Vehicle type (optional)
Pricing strategy

Example:

₹30/hour for bikes
₹50/hour for cars
₹100/hour for trucks
8. Display Board

Each floor should display:

Available Bike Spots
Available Car Spots
Available Truck Spots
Non-Functional Requirements
Extensible
Scalable
Thread-safe
Maintainable
Follows SOLID principles
Easy to add new vehicle types
Expected APIs
Ticket parkVehicle(Vehicle vehicle);

double unparkVehicle(Ticket ticket);

ParkingSpot findAvailableSpot(Vehicle vehicle);

boolean isSpotAvailable();

double calculateFee(Ticket ticket);
Constraints
A parking spot can hold only one vehicle.
A vehicle can occupy only one parking spot at a time.
Spot assignment should be automatic.
Ticket IDs must be unique.
Parking spots become available immediately after exit.
Possible Classes
ParkingLot
|
+-- ParkingFloor
|
+-- EntranceGate
|
+-- ExitGate
|
+-- DisplayBoard

ParkingFloor
|
+-- ParkingSpot

ParkingSpot
|
+-- BikeSpot
+-- CompactSpot
+-- LargeSpot

Vehicle
|
+-- Bike
+-- Car
+-- Truck

Ticket

Payment

FeeStrategy
Expected OOP Concepts
Abstraction: Vehicle, ParkingSpot, FeeStrategy
Inheritance: Bike, Car, Truck; specialized parking spot types
Polymorphism: Different implementations of calculateFee() or canFitVehicle()
Encapsulation: Hide parking and ticket state behind class methods
Design Patterns (Bonus)

Interviewers often expect discussion of patterns such as:

Strategy Pattern: Fee calculation (HourlyFeeStrategy, WeekendFeeStrategy, etc.)
Factory Pattern: Creating vehicles or parking spots
Singleton Pattern: Single ParkingLot instance
Observer Pattern: Updating display boards when spot availability changes
State Pattern: Ticket or parking spot states (e.g., Available, Occupied)
Common Interview Follow-up Questions

Once you've completed the basic design, interviewers may ask you to extend it:

How would you support electric vehicle (EV) charging spots?
How would you allow cars to park in large spots when compact spots are full?
How would you make spot allocation thread-safe?