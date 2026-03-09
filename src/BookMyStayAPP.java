/**
 * BookMyStayAPP.java
 *
 * This class represents the entry point of the Hotel Booking Management System.
 * UC1: Demonstrates application startup and console output.
 * UC2: Introduces object modeling with abstract classes, inheritance,
 *      encapsulation, and static availability representation.
 *
 * @author Aanish
 * @version 2.1
 */

// Abstract class representing a generalized Room
abstract class Room {
    private String roomType;
    private int numberOfBeds;
    private double pricePerNight;

    // Constructor
    public Room(String roomType, int numberOfBeds, double pricePerNight) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = pricePerNight;
    }

    // Encapsulated getters
    public String getRoomType() {
        return roomType;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    // Abstract method to display room details
    public abstract void displayRoomDetails();
}

// Concrete class for Single Room
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 1500.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + getRoomType() +
                " | Beds: " + getNumberOfBeds() +
                " | Price: ₹" + getPricePerNight());
    }
}

// Concrete class for Double Room
class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 2500.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + getRoomType() +
                " | Beds: " + getNumberOfBeds() +
                " | Price: ₹" + getPricePerNight());
    }
}

// Concrete class for Suite Room
class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 5000.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + getRoomType() +
                " | Beds: " + getNumberOfBeds() +
                " | Price: ₹" + getPricePerNight());
    }
}

// Application Entry Point
public class BookMyStayAPP {
    public static void main(String[] args) {
        // UC1: Welcome message
        System.out.println("=======================================");
        System.out.println("   Welcome to Book My Stay App!");
        System.out.println("   Hotel Booking Management System v2.1");
        System.out.println("=======================================\n");

        // UC2: Initialize room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        // Display room details and availability
        single.displayRoomDetails();
        System.out.println("Availability: " + singleRoomAvailability + " rooms\n");

        doubleRoom.displayRoomDetails();
        System.out.println("Availability: " + doubleRoomAvailability + " rooms\n");

        suite.displayRoomDetails();
        System.out.println("Availability: " + suiteRoomAvailability + " rooms\n");

        // Application terminates
    }
}