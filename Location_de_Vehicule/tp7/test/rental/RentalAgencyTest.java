package rental;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class RentalAgencyTest {

    private RentalAgency rentalAgency;
    private Vehicle vehicle1, vehicle2;
    private Client client1, client2;

    @Before
    public void setUp() {
        rentalAgency = new RentalAgency();
        vehicle1 = new Vehicle("Mercedes", "amg", 2010, 100.0);
        vehicle2 = new Vehicle("Toyota", "yaris", 2005, 90.0);
        client1 = new Client("John wick", 36);
        client2 = new Client("Jack peralta", 30);

        rentalAgency.addVehicle(vehicle1);
        rentalAgency.addVehicle(vehicle2);
    }

    @Test
    public void testAddVehicle() {
        assertEquals(2, rentalAgency.getAllVehicles().size());
        assertTrue(rentalAgency.getAllVehicles().contains(vehicle1));
        assertTrue(rentalAgency.getAllVehicles().contains(vehicle2));
    }

    @Test
    public void testRemoveVehicle() throws UnknownVehicleException {
        rentalAgency.removeVehicle(vehicle1);
        assertEquals(1, rentalAgency.getAllVehicles().size());
        assertFalse(rentalAgency.getAllVehicles().contains(vehicle1));
        assertTrue(rentalAgency.getAllVehicles().contains(vehicle2));
    }

    @Test
    public void testRentVehicle() throws UnknownVehicleException, IllegalStateException {
        double rentalPrice = rentalAgency.rentVehicle(client1, vehicle1);
        assertTrue(rentalAgency.hasRentedAVehicle(client1));
        assertTrue(rentalAgency.isRented(vehicle1));
        assertEquals(vehicle1.getDailyPrice(), rentalPrice, 0.001); // Added delta for double comparison
    }

   /* @Test
    public void testRentUnknownVehicle() {
        UnknownVehicleException exception = assertThrows(UnknownVehicleException.class,
                () -> rentalAgency.rentVehicle(client1, new Vehicle("porsche", "cayenne", 2015, 200.0)));
        assertEquals("Unknown vehicle", exception.getMessage());
    }
*/
   /*
    @Test
    public void testRentAlreadyRentedVehicle() throws UnknownVehicleException, IllegalStateException {
        rentalAgency.rentVehicle(client1, vehicle1);

        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> rentalAgency.rentVehicle(client2, vehicle1));
        assertEquals("Vehicle is already rented or client is already renting another vehicle", exception.getMessage());
    }
    */

    @Test
    public void testReturnVehicle() throws UnknownVehicleException {
        rentalAgency.rentVehicle(client1, vehicle1);
        assertTrue(rentalAgency.hasRentedAVehicle(client1));

        rentalAgency.returnVehicle(client1);
        assertFalse(rentalAgency.hasRentedAVehicle(client1));
    }

    @Test
    public void testReturnUnrentedVehicle() {
        rentalAgency.returnVehicle(client1);
        assertFalse(rentalAgency.hasRentedAVehicle(client1));
    }

    @Test
    public void testAllRentedVehicles() throws UnknownVehicleException, IllegalStateException {
        rentalAgency.rentVehicle(client1, vehicle1);
        rentalAgency.rentVehicle(client2, vehicle2);

        Collection<Vehicle> rentedVehicles = rentalAgency.allRentedVehicles();
        assertEquals(2, rentedVehicles.size());
        assertTrue(rentedVehicles.contains(vehicle1));
        assertTrue(rentedVehicles.contains(vehicle2));
    }
    @Test
    public void testHasRentedAVehicle() throws UnknownVehicleException {
        assertFalse(rentalAgency.hasRentedAVehicle(client1)); // Use client1 instead of client

        rentalAgency.addVehicle(vehicle1); // Add vehicle1 instead of vehicle
        rentalAgency.rentVehicle(client1, vehicle1); // Rent vehicle1 to client1

        assertTrue(rentalAgency.hasRentedAVehicle(client1));
    }

    @Test
    public void testHasRentedAVehicleForUnrentedClient() {
        assertFalse(rentalAgency.hasRentedAVehicle(client1));
    }
}
