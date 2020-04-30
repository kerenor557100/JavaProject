package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public class Geometries implements Intersectable {

    private List<Intersectable> _geometries = new ArrayList<Intersectable>();

    public Geometries(Intersectable... _geometries) {
        add( _geometries);
    }

    /**
     * The function add a Geometry to the list
     * @param geometries
     */
    public void add(Intersectable... geometries) {
        for (Intersectable geo : geometries ) {
            _geometries.add(geo);
        }
    }
    public void remove(Intersectable... intersectables) {
        for (Intersectable geo : _geometries) {
            _geometries.remove(geo);
        }
    }
    /**
     * This function find the intersections between the list of Geometry and a Ray
     *
     * @param ray
     * @return the list of Point3D who are the intersections
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersections = null;

        for (Intersectable geometry : _geometries) {
            List<Point3D> tempIntersections = geometry.findIntersections(ray);
            if (tempIntersections != null) {
                if (intersections == null)
                    intersections = new ArrayList<Point3D>();
                intersections.addAll(tempIntersections);
            }
        }
        return intersections;

    }
}
