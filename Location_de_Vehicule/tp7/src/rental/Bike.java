package rental;

/**
 * The  class represents a bike, which is a type of vehicle.
 * It extends the  class and includes additional information
 * about the cylinder
 */
public class Bike extends Vehicle {
    /** The cylinder of the bike in cubic centimeters. */
    private int cylinder; // cylindre


    /**
     * Constructs a new Bike with the specified details.
     *
     * @param brand      the brand of the bike
     * @param model      the model of the bike
     * @param year       the year of manufacture
     * @param dailyPrice the daily rental price of the bike
     * @param cylinder   the cylinder of the bike in cubic centimeters
     */
    public Bike(String brand, String model, int year, double dailyPrice, int cylinder) {
        super(brand, model, year, dailyPrice);
        this.cylinder = cylinder;
    }

    /**
     * Gets the cylinder of the bike.
     *
     * @return the cylinder of the bike in cubic centimeters
     */
    public int getCylinder() {
        return cylinder;
    }

    /**
     * Returns a string representation of the bike, including its details.
     *
     * @return a string representation of the bike
     */
    @Override
    public String toString() {
        return super.toString() + ", Cynlinder " + cylinder + " cm3";
    }
}