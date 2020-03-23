package UnitTests;

import geometries.RadialGeometry;
import org.junit.Test;
import primitives.Vector;

import static org.junit.Assert.*;
/**
 * Unit tests for geometries.RadialGeometry class
 * @author Keren or and Avital
 */
public class RadialGeometryTest {

    @Test
    /**
     * Test method for {@link geometries.RadialGeometry#get_radius(geometries.RadialGeometry)}.
     */
    public void get_radius() {
        Vector v =  new Vector(4,16,32);
        assertTrue(v.getNormal()== new Vector(1/9,4/9,8/9));

    }
}