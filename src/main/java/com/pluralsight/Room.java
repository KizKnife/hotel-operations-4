package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return !isOccupied && !isDirty;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void checkIn() {
        if (isAvailable()) {
            isOccupied = true;
            isDirty = true;
        } else if (!isAvailable() && isOccupied && isDirty) {
            System.out.println("Room is occupied and must be cleaned.");
        } else if (!isAvailable() && isOccupied) {
            System.out.println("Room already occupied.");
        } else if (!isAvailable() && isDirty) {
            System.out.println("Room must be cleaned first.");
        }
    }

    public void checkOut() {
        isOccupied = false;
        isDirty = true;
    }

    public void cleanRoom() {
        isDirty = false;
    }

    public String toString() {
        return String.format(
                "Beds: %d%n" +
                "Price: $%.2f%n" +
                "Available: %b%n: ",
                getNumberOfBeds(),
                getPrice(),
                isAvailable()
        );
    }
}