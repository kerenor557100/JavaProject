package UnitTests;

import geometries.Tube;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for geometries.Tube class
 * @author Keren or and Avital
 */
public class TubeTest {

    @Test
    /**
     * Test method for {@link geometries.Tube#get_ray(geometries.Tube)}.
     */

    public void get_ray() {
        Ray _r=new Ray(new Point3D(1,1,1),new Vector(1,2,3));

        assertEquals(new Point3D(1,1,1),_r.getPoint());
    }



    @Test
    /**
     * Test method for {@link geometries.Tube#getNormal(geometries.Tube)}.
     */
    public void getNormal() {
        Ray _r=new Ray(new Point3D(1,1,1),new Vector(1,2,3));
        Tube _t=new Tube(2,_r);

        Point3D p2=new Point3D(1,2,3);

        //The Normal vector expected
        Vector c2=new Vector(0.0,0.4472135954999579,0.8944271909999159);

        assertEquals(c2,_t.getNormal(p2));
    }




}