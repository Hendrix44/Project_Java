package rental.filter;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import rental.Vehicle;

public class BrandFilterTest {

   @Test
   public void testAccept() {
      BrandFilter filter = new BrandFilter("brand1");
      Vehicle v1 = new Vehicle("brand1", "model1", 2015, 100.0);
      Vehicle v2 = new Vehicle("brand2", "model2", 2000, 200.0);
      assertTrue(filter.accept(v1));
      assertFalse(filter.accept(v2));
   }

}
