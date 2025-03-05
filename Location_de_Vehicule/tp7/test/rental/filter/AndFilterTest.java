package rental.filter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rental.VehicleFilter;
import rental.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

public class AndFilterTest {

    private AndFilter andFilter;
    private Vehicle vehicle;

    @BeforeEach
    public void setUp() {
        andFilter = new AndFilter();
        vehicle = new Vehicle("Toyota", "Camry", 2020, 80.0);
    }

    @Test
    public void testAcceptWithNoFilter() {
        assertTrue(andFilter.accept(vehicle));
    }

    @Test
    public void testAcceptWithOneFilter() {
        VehicleFilter filter = new BrandFilter("Toyota");
        andFilter.addFilter(filter);

        assertTrue(andFilter.accept(vehicle));
    }



    @Test
    public void testRejectWithOneFilter() {
        VehicleFilter filter = new BrandFilter("Honda");
        andFilter.addFilter(filter);

        assertFalse(andFilter.accept(vehicle));
    }



}
