package rental;

/**
 * The  class represents a rental vehicle agency that applies
 * a surcharge for young drivers (clients under 25 years old). It extends the functionality
 * of the  class and overrides the rentVehicle method to apply the surcharge.

 */
public class SuspiciousRentalAgency extends RentalAgency {

    /** The surcharge percentage for young drivers. */
    private static final double YOUNG_SURCHARGE = 0.10;


    /**
     * Rents a vehicle for a client and applies a surcharge for young drivers.
     *
     * @param client the client renting the vehicle
     * @param v the rented vehicle
     * @return the daily rental price after applying surcharge for young drivers
     * @throws UnknownVehicleException if v is not a vehicle of this agency
     * @throws IllegalStateException if v is already rented or the client rents another vehicle
     */
    public double rentVehicle(Client client, Vehicle v) throws UnknownVehicleException, IllegalStateException {
        double basePrice = super.rentVehicle(client, v);

        // Apply surcharge for young drivers
        if (client.getAge() < 25) {
            double surcharge = basePrice * YOUNG_SURCHARGE;
            return basePrice + surcharge;
        } else {
            return basePrice;
        }
    }



}
