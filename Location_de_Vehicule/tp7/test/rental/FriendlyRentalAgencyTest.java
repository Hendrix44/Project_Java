package rental;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FriendlyRentalAgencyTest {

    private FriendlyRentalAgency agency;
    private Client client;
    private Vehicle vehicle;

    @Before
    public void setUp() {
        agency = new FriendlyRentalAgency();
        client = new Client("John Doe", 25);
        vehicle = new Vehicle("Toyota", "Camry", 2022, 50.0);
        agency.addVehicle(vehicle);
    }

    @Test
    public void testRentVehicleForNewClient() throws UnknownVehicleException, IllegalStateException {
        double price = agency.rentVehicle(client, vehicle);
        assertEquals(50.0, price, 0.01);
        assertTrue(agency.getFidelityPointsMap().containsKey(client));
        assertEquals(1, agency.clientPoints(client));
    }

    @Test
    public void testRentVehicleForExistingClientBelowThreshold() throws UnknownVehicleException, IllegalStateException {
        agency.getFidelityPointsMap().put(client, 1);
        double price = agency.rentVehicle(client, vehicle);
        assertEquals(50.0, price, 0.01);
        assertEquals(2, agency.clientPoints(client));
    }

    @Test
    public void testRentVehicleForExistingClientAboveThreshold() throws UnknownVehicleException, IllegalStateException {
        agency.getFidelityPointsMap().put(client, 2);
        double price = agency.rentVehicle(client, vehicle);
        assertEquals(42.5, price, 0.01);
        assertEquals(3, agency.clientPoints(client));
    }

    @Test
    public void testRentVehicleForExistingClientNoDiscount() throws UnknownVehicleException, IllegalStateException {
        agency.getFidelityPointsMap().put(client, 0);
        double price = agency.rentVehicle(client, vehicle);
        assertEquals(50.0, price, 0.01);
        assertEquals(1, agency.clientPoints(client));
    }



}
