package UnitTests;

import org.junit.Test;
import primitives.Vector;

import static org.junit.Assert.*;
/**
 * Unit tests for geometries.Cylinder class
 * @author Keren or and Avital
 */
public class CylinderTest {

    @Test
    /**
     * Test method for {@link geometries.Cylinder#getNormal(geometries.Cylinder)}.
     */
    public void getNormal() {
        Vector v =  new Vector(4,16,32);
        assertTrue(v.getNormal()== new Vector(1/9,4/9,8/9));

    }
}