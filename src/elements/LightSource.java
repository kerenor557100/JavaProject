package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

import java.util.List;

/**
 * Interface for common actions of light sources

 */
//מקור תאורה.
public interface LightSource  {
    /**
     * Gets light source intensity

     */
    Color getIntensity(Point3D p);
    double getRadius();
    Point3D getPosition();
    /**
     * Get normalized vector in the direction from light source
     * towards the lighted point
     *
     * @param p the lighted point
     * @return light to point vector
     */

    Vector getL(Point3D p);
    List<Vector> getLs (Point3D p);
    /**
     * @param point from geopoint
     * @return distance from light source
     */
    double getDistance(Point3D point);


}
