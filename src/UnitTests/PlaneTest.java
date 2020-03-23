package UnitTests;

import org.junit.Test;
import primitives.Vector;

import static org.junit.Assert.*;
/**
 * Unit tests for geometries.Plane class
 * @author Keren or and Avital
 */
public class PlaneTest {

    @Test
    /**
     * Test method for {@link geometries.Plane#getNormal(geometries.Plane)}.
     */
    public void getNormal() {
        Vector v =  new Vector(4,16,32);
        assertTrue(v.getNormal()== new Vector(1/9,4/9,8/9));

    }


}