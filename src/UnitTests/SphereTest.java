package UnitTests;

import org.junit.Test;
import primitives.Vector;

import static org.junit.Assert.*;
/**
 * Unit tests for geometries.Sphere class
 * @author Keren or and Avital
 */
public class SphereTest {

    @Test
    /**
     * Test method for {@link geometries.Sphere#getNormal(geometries.Sphere)}.
     */
    public void getNormal() {
        Vector v =  new Vector(4,16,32);
        assertTrue(v.getNormal()== new Vector(1/9,4/9,8/9));

    }
}