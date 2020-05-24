package elements;

import primitives.*;

/**
 * Interface for common actions of light sources

 */
//מקור תאורה.
public interface LightSource  {
    /**
     * Gets light source intensity

     */
    Color getIntensity(Point3D p);

    /**
     * Get normalized vector in the direction from light source
     * towards the lighted point
     */
    Vector getL(Point3D p);

    double getDistance(Point3D point);


}
