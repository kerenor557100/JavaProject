package UnitTests;

import geometries.Triangle;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.assertEquals;
/**
 * Unit tests for geometries.Triangle class
 * @author Keren or and Avital
 */
public class TriangleTest {

    @Test
    public void testEquals() {
        Triangle t= new Triangle(new Point3D(1,0,0),new Point3D(0,1,0),new Point3D(0,0,1));
        Triangle t2= new Triangle(new Point3D(1,0,0),new Point3D(0,1,0),new Point3D(0,0,1));
        assertEquals(t.equals(t2),true);
    }

    @Test
    public void getNormal() {
        Triangle t= new Triangle(new Point3D(1,0,0),new Point3D(0,1,0),new Point3D(0,0,1));
        assertEquals(t.getNormal(),new Vector(new Point3D(-0.5773502691896258, -0.5773502691896258, -0.5773502691896258)));
    }
    Triangle t1=new Triangle(new Point3D(0,0,4),new Point3D(0,0,0),new Point3D(4,0,0));
    Ray r1=new Ray(new Point3D(0,-2,0),new Vector(1,2,1));
    Ray r2=new Ray(new Point3D(0,-2,0),new Vector(-1,1,1));
    Ray r3=new Ray(new Point3D(0,-2,0),new Vector(-1,-1,1));
    Ray r4=new Ray(new Point3D(0,-2,0),new Vector(2,1,1));
    //   Ray r5=new Ray(new Point3D(0,0,4),new Vector(4,0,0));
    Triangle t2=new Triangle(new Point3D(5,0,0),new Point3D(0,-4,0),new Point3D(0,0,5));

    /**
     * Test method for {@link geometries.Triangle#findIntersections(primitives.Ray)}.
     */
    @Test
    public void findIntersections() {
        assertEquals("",t1.findIntersections(r1).size(),1);

        try {
            t1.findIntersections(r2).size();
        }
        catch (NullPointerException e){
            System.out.println(e+ "r2 no Intersections with t1");
        }

        try {
            t1.findIntersections(r3).size();
        }
        catch (NullPointerException e){
            System.out.println("r3 no Intersections with t1");
        }

        try {
            t1.findIntersections(r4).size();
        }
        catch (NullPointerException e){
            System.out.println("r4 no Intersections with t1");
        }
        try{
            t2.findIntersections(r1).size();
        }
        catch (NullPointerException e){
            System.out.println("r1 no Intersections with t2");
        }
        try{
            t2.findIntersections(r2).size();
        }
        catch (NullPointerException e){
            System.out.println("r2 no Intersections with t2");
        }
        try{
            t2.findIntersections(r3).size();
        }
        catch (NullPointerException e){
            System.out.println("r3 no Intersections with t2");
        }

        try{

            assertEquals("",t2.findIntersections(r4).size(),1);

        }
        catch (NullPointerException e){
            System.out.println("r4 no Intersections with t2");
        }






    }
}