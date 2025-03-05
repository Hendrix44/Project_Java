package rental;

import java.util.*;

/**
 * The  class represents a rental vehicle agency where clients can rent
 * one vehicle at a time. It manages a list of vehicles and tracks rented vehicles for clients.

 */
public class RentalAgency {

    /** List of vehicles managed by this agency. */
    protected List<Vehicle> theVehicles;

    /** Map to track rented vehicles for each client. */
    protected Map < Client, Vehicle> rentedVehicle;
    /**
     * builds an agency with no vehicles then none rented
     */
    public RentalAgency() {
        this.theVehicles = new ArrayList<Vehicle>();
        this.rentedVehicle = new HashMap<Client,Vehicle>();

    }

    /** adds a vehicle to this agency
     * @param v the added vehicle
     */
    public void addVehicle(Vehicle v) {
        if (!theVehicles.contains(v)) {
            this.theVehicles.add(v);
        }

    }
    /** removes vehicle v from this agency
     * @param v the vehicle to remove
     * @throws UnknownVehicleException if vehicle does not belong to this agency
     */
    public void removeVehicle(Vehicle v) throws UnknownVehicleException {
        if (!this.theVehicles.contains(v))
            throw new UnknownVehicleException("voiture inconnue");
        // else
        this.theVehicles.remove(v);
    }

    /** returns the list of vehicles managed by this agency
     * @return the list of vehicles managed by this agency
     */
    public List<Vehicle> getAllVehicles() {
        return this.theVehicles;
    }


    /** provides the list of the vehicles that is accepted by filter
     * @param filter the selection filter
     * @return  the list of the vehicles accepted by filter
     */
    public List<Vehicle> select(VehicleFilter filter) {

        List<Vehicle> result = new ArrayList<Vehicle>();
        for(Vehicle v : this.theVehicles) {
            if (filter.accept(v)) {
                result.add(v);
            }
        }
        return result;

    }

    /** displays the vehicles accepted by the filter
     * @param filter the selection filter
     */
    public void displaySelection(VehicleFilter filter) {
        for(Vehicle v : select(filter)){
            System.out.println(v);
        }
    }

    /** displays all vehicles of this agency */
    public void displayAllVehicles() {
        for(Vehicle v : this.theVehicles){
            System.out.println(v);
        }
    }

    /** returns <em>true</em> iff client c is renting a vehicle
     * @param client the client for which we want to know it has rented a vehicle
     * @return <em>true</em> iff client c is renting a vehicle
     */
    public boolean hasRentedAVehicle(Client client){
        return rentedVehicle.containsKey(client);
    }

    /** returns <em>true</em> iff vehicle v is rented
     * @param v the vehicle we want to check if it is rented
     * @return <em>true</em> iff vehicle v is rented
     */
    public boolean isRented(Vehicle v){
        return rentedVehicle.containsValue(v);
    }

    /** client rents a vehicle

     @param client the renter
     @param v the rented vehicle
     @return the daily rental price for client for vehicle v
     @exception UnknownVehicleException   if v is not a vehicle of this agency
     @exception IllegalStateException if v is already rented or client rents already another vehicle
     */
    public double rentVehicle(Client client, Vehicle v) throws UnknownVehicleException, IllegalStateException {
        if (!theVehicles.contains(v)) {
            throw new UnknownVehicleException("This vehicle does not exist in this agency");
        } else if (rentedVehicle.containsValue(v)) {
            throw new IllegalStateException("The vehicle is already rented by another client");
        } else if (hasRentedAVehicle(client)) {
            throw new IllegalStateException("The client is already renting another vehicle");
        } else {
            rentedVehicle.put(client, v);
            return v.getDailyPrice();
        }
    }

    /** the client returns a rented vehicle. Nothing happens if client didn't have rented a vehicle.
     * @param client the client who returns a vehicle
     */
    public void returnVehicle(Client client){
        rentedVehicle.remove(client);
    }
    /** provides the collection of rented vehicles for this agency
     * @return collection of currently rented vehicles
     */
    public Collection<Vehicle> allRentedVehicles(){
        List <Vehicle> result = new ArrayList<Vehicle>();
        for(Vehicle v : this.theVehicles){
            if(isRented(v)){
                result.add(v);
            }
        }
        return result;
    }

}
