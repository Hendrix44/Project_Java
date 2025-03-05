package rental;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SuspiciousRentalAgencyTest {

    private SuspiciousRentalAgency agency;
    private Client youngClient;
    private Client nonYoungClient;
    private Vehicle vehicle;

    @Before
    public void setUp() {
        agency = new SuspiciousRentalAgency();
        youngClient = new Client("Young Driver", 22);
        nonYoungClient = new Client("Experienced Driver", 30);
        vehicle = new Vehicle("Toyota", "Camry", 2022, 50.0);
        agency.addVehicle(vehicle);
    }

    @Test
    public void testRentVehicleForYoungClient() throws UnknownVehicleException, IllegalStateException {
        double price = agency.rentVehicle(youngClient, vehicle);
        assertEquals(55.0, price, 0.01);
    }

    @Test
    public void testRentVehicleForNonYoungClient() throws UnknownVehicleException, IllegalStateException {
        double price = agency.rentVehicle(nonYoungClient, vehicle);
        assertEquals(50.0, price, 0.01);
    }

    @Test(expected = UnknownVehicleException.class)
    public void testRentVehicleUnknownVehicle() throws UnknownVehicleException, IllegalStateException {
        Vehicle unknownVehicle = new Vehicle("Unknown", "Model", 2023, 60.0);
        agency.rentVehicle(nonYoungClient, unknownVehicle);
    }

    @Test(expected = IllegalStateException.class)
    public void testRentVehicleAlreadyRented() throws UnknownVehicleException, IllegalStateException {
        // Rent the vehicle once
        agency.rentVehicle(nonYoungClient, vehicle);
        // Attempt to rent the same vehicle again
        agency.rentVehicle(nonYoungClient, vehicle);
    }



}
