package UnitTests;

import org.junit.Test;
import primitives.Vector;

import static org.junit.Assert.assertTrue;
/**
 * Unit tests for primitives.Vector class
 * @author Keren or and Avital
 */

public class VectorTest {

    @Test
    /**
     * Test method for {@link primitives.Vector#subtract (primitives.Vector)}.
     */

    public void subtract() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.0);

        v1.subtract(v2);
        assertTrue(v1.compareTo(new Vector(2.0, 2.0, 2.0)) == 0);

        v2.subtract(v1);
        assertTrue(v2.compareTo(new Vector(-3.0, -3.0, -3.0)) == 0);

    }

    @Test
    /**
     * Test method for {@link primitives.Vector#add(primitives.Vector)}.
     */
    public void add() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.0);

        v1 = v1.add(v2);
        assertTrue(v1.compareTo(new Vector(0.0, 0.0, 0.0)) == 0);

        v2 = v2.add(v1);
        assertTrue(v2.compareTo(v2) == 0);

    }

    @Test
    /**
     * Test method for {@link primitives.Vector#scale (primitives.Vector)}.
     */
    public void scale() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);

        v1.scale(1);
        assertTrue(v1.compareTo(v1) == 0);

        v1.scale(2);
        assertTrue(v1.compareTo(new Vector(2.0, 2.0, 2.0)) == 0);

        v1.scale(-2);
        assertTrue(v1.compareTo(new Vector(-4.0, -4.0, -4.0)) == 0);
    }

    @Test
    /**
     * Test method for {@link primitives.Vector#dotProduct (primitives.Vector)}.
     */
    public void dotProduct() {
        Vector v1 = new Vector(3.5, -5, 10);
        Vector v2 = new Vector(2.5, 7, 0.5);

        assertTrue(Double.compare(v1.dotProduct(v2), (8.75 + -35 + 5)) == 0);

    }

    @Test
    /**
     * Test method for {@link primitives.Vector#crossProduct (primitives.Vector)}.
     */
    public void crossProduct() {
        Vector v1 = new Vector(3.5, -5.0, 10.0);
        Vector v2 = new Vector(2.5, 7, 0.5);
        Vector v3 = v1.crossProduct(v2);

        assertEquals("", 0, v3.dotProduct(v2), 1e-10);
        assertEquals("", 0, v3.dotProduct(v1), 1e-10);

        Vector v4 = v2.crossProduct(v1);
        v3.add(v4);
        assertEquals("", 0, v3.length(), 1e-10);

    }






    @Test
    /**
     * Test method for {@link primitives.Vector#length (primitives.Vector)}.
     */
    public void length() {
        Vector v = new Vector(3.5,-5,10);
        assertTrue(v.length() ==
                Math.sqrt(12.25 + 25 + 100));
    }

    @Test
    /**
     * Test method for {@link primitives.Vector#normalize (primitives.Vector)}.
     */
    public void normalize() {
        Vector v = new Vector(3.5,-5,10);
        v.normalize();
        assertEquals("", 1, v.length(),1e-10);

        v = new Vector(0,0,0);

        try {
            v.normalize();
            fail("Didn't throw divide by zero exception!");
        } catch (ArithmeticException e) {
            assertTrue(true);
        }

    }
    @Test
    /**
     * Test method for {@link primitives.Vector#lengthSquared (primitives.Vector)}.
     */
    public void lengthSquared() {
        Vector v = new Vector(3.5,-5,10);
        assertTrue(v.lengthSquared() ==
                (12.25 + 25 + 100));

    }

    @Test
    /**
     * Test method for {@link primitives.Vector#normalized(primitives.Vector)}.
     */
    public void normalized() {
        Vector v =  new Vector(4,16,32);
       assertTrue(v.normalized()== new Vector(1/9,4/9,8/9));

    }
}