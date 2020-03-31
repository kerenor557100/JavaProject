package UnitTests;

import geometries.Cylinder;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import static org.junit.Assert.*;
import static java.lang.System.out;

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
        Point3D d=new Point3D(76,64,3);
        Vector e=new Vector(3,4,5);
        out.println(d.toString());
        out.println(e.toString());
        Ray r=new Ray(d,e);
        out.println(r.toString());
        Cylinder c= new Cylinder(4,r,7);
        out.println(c.toString());
        Vector v4=c.getNormal(new Point3D(5,6,7));
        assertTrue(v4.equals(new Vector(-0.6561552174109048, -0.3461038509420157, 0.6705762112001553)));

    }

}