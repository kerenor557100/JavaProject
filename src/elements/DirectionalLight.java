// מקור אור כיווני: (כגון השמש) זהו מקור אור הנמצא באינסוף או במיקום רחוק מאוד, בעל כיוון ואין הנחתה בעקבות המרחק.
package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource {
    private Vector _direction;


    /**
     * Initialize directional light with it's intensity and direction, direction
     * vector will be normalized.
     */

    public DirectionalLight(Color colorintensity, Vector direction) {
        super(colorintensity);
        _direction = direction.normalized();
    }

  
    @Override
    public Color getIntensity(Point3D p) {
        return _intensity;
    }

    //instead of getDirection()
    @Override
    public Vector getL(Point3D p) {
        return _direction;
    }
    @Override
    public double getDistance(Point3D point) {
//        return  this._direction.getHead().distance(point);
        return Double.POSITIVE_INFINITY;
    }
}
