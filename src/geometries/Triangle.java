package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Triangle extends Polygon {
    Point3D _p1;
    Point3D _p2;
    Point3D _p3;

    /**
     * the Triangles constructor
     * @param p1
     * @param p2
     * @param p3
     */
    public Triangle(Point3D p1, Point3D p2,Point3D p3)
    {
        super(p1, p2, p3);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "_p1=" + _p1 +
                ", _p2=" + _p2 +
                ", _p3=" + _p3 +
                '}';
    }
    public Vector getNormal() {
        return getNormal(null);
    }

}

