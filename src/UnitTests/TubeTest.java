package UnitTests;

import org.junit.Test;
import primitives.Vector;

import static org.junit.Assert.*;
/**
 * Unit tests for geometries.Tube class
 * @author Keren or and Avital
 */
public class TubeTest {

    @Test
    /**
     * Test method for {@link geometries.Tube#getNormal(geometries.Tube)}.
     */
    public void getNormal()
    {
        Vector v =  new Vector(4,16,32);
        assertTrue(v.getNormal()*v== 0);

    }


}