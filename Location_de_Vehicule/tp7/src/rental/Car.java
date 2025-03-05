package rental;

/**
 * The  class represents a car, which is a type of vehicle.
 * It extends the  class and includes additional information
 * about the passenger capacity.

 */
public class Car extends Vehicle {
    /** The passenger capacity of the car. */
    private int place;

    /**
     * Constructs a new Car with the specified details.
     *
     * @param brand           the brand of the car
     * @param model           the model of the car
     * @param year            the year of manufacture
     * @param dailyPrice      the daily rental price of the car
     * @param place the passenger capacity of the car
     */
    public Car(String brand, String model, int year, double dailyPrice, int place){
        super(brand, model, year, dailyPrice);
        this.place =place;
    }

    /**
     * Gets the passenger capacity of the car.
     *
     * @return the passenger capacity of the car
     */
    public int getPassengerCapacity() {
        return place;
    }


    /**
     * Returns a string representation of the car, including its details.
     *
     * @return a string representation of the car
     */
    public String toString() {
        return super.toString() + ", Passenger Capacity: " + place;
    }
}


