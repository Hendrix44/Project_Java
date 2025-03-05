package rental;

import java.util.HashMap;
import java.util.Map;

public class FriendlyRentalAgency extends RentalAgency {
    private Map<Client, Integer> fidelityPointsMap;
    private int discountThreshold;
    public static final double DISCOUNT_PERCENTAGE = 0.15;

    /**
     * creates an instance of a Friendly Agency that attributes fidelity points to
     * each client that has or is renting a vehicle and at certain threshold when
     * reached, the client earn a perk where whenever he rents a vehicle from the
     * agency he gets a small reduction in price.
     */
    public FriendlyRentalAgency() {
        this.fidelityPointsMap = new HashMap<>();
        this.discountThreshold = 2; // seuil
    }

    /**
     * the map that associates every client with his current fidelity point
     * accumulation
     *
     * @return the map that associates every client with his current fidelity point
     *         accumulation
     */
    public Map<Client, Integer> getFidelityPointsMap() {
        return this.fidelityPointsMap;
    }

    /**
     * the discount threshold to whish the client would get a discount when reached
     *
     * @return the discount threshold to whish the client would get a discount when
     *         reached
     */
    public int getDiscountThreshold() {
        return this.discountThreshold;
    }

    /**
     * the client's current accumulated points so far
     *
     * @param c the client we're searching for his points
     * @return the client's current points
     */
    public int clientPoints(Client c) {
        return this.fidelityPointsMap.get(c);
    }

    /**
     * a modified rentVehicle method from the one from parent class to fit the
     * FriendlyAgency
     * a couple of special cases were treated here:
     * 1) when a client never rented a car, he'll be added to the fidelity map and
     * will initially have one point only since it's his first time and return the
     * rental price
     * 2) when a client has rented a car before but hasn't attained the threshold
     * that would qualify him to earn a reduction on rent, in this case his points
     * will increment by one and the price of rental will be returned
     * 3) finally, when the client is a frequent then his rent price will be reduced
     * by a specific percentage that is defined beforehand, the price is of course
     * then returned
     *
     * @param client the client to rent a vehicle to
     *
     * @param v      the vehicle to rent
     * @exception UnknownVehicleException if v is not a vehicle of
     *                                    this agency (from parent method)
     * @exception IllegalStateException   if v is already rented or client rents
     *                                    already another vehicle (from parent
     *                                    method)
     */
    public double rentVehicle(Client client, Vehicle v) throws UnknownVehicleException, IllegalStateException {
        double finalPrice;
        int incrementedPoints;
        // the client never rented a car before
        if (!this.fidelityPointsMap.containsKey(client)) {
            int newClientPoints = 1;
            finalPrice = super.rentVehicle(client, v);
            this.fidelityPointsMap.put(client, newClientPoints);
            return finalPrice;
        }
        if (this.clientPoints(client) >= this.discountThreshold) {
            // calculate the reduced price for this specific client/car
            double reducedPrice = v.getDailyPrice() * DISCOUNT_PERCENTAGE;
            // call the super method to make sure that we get no exceptions and store that
            // value
            finalPrice = super.rentVehicle(client, v) - reducedPrice;
            // increase the client's points and put them back in the map

              incrementedPoints = this.fidelityPointsMap.get(client) + 1;
              this.fidelityPointsMap.put(client, incrementedPoints);
              return finalPrice;

        } else {
            // in the case where he's not a new customer nor included in the fidelity
            // programme
            finalPrice = super.rentVehicle(client, v);
        }
        incrementedPoints = this.fidelityPointsMap.get(client) + 1;
        this.fidelityPointsMap.put(client, incrementedPoints);
        return finalPrice;
    }
}
