
package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * מקור אור נקודתי: מקור אור שאינו כיווני בעל עוצמה.יש מיקום אך לא כיוון.
 *כמו מנורה בחדר.
 */

public class PointLight extends Light implements LightSource {
    Point3D _position;
    double _kC; // Constant attenuation
    double _kL; // Linear attenuation
    double _kQ; // Quadratic attenuation
    double _radius;
    public Point3D getPosition() {
        return _position;
    }

    public double getRadius() {
        return _radius;
    }

    public PointLight(Color colorIntensity, Point3D position, double kC, double kL, double kQ) {
        this._intensity = colorIntensity;
        this._position = new Point3D(position);
        this._kC = kC;
        this._kL = kL;
        this._kQ = kQ;
    }

    // by default, the constant attenuation value is 1 and the other two values are 0
    public PointLight(Color colorIntensity, Point3D position) {
        this(colorIntensity, position, 1d, 0d, 0d);
    }

    public PointLight(Color colorIntensity, Point3D _position, double _kC, double _kL, double _kQ, double _radius) {
        this._intensity = colorIntensity;
        this._position = _position;
        this._kC = _kC;
        this._kL = _kL;
        this._kQ = _kQ;
        this._radius = _radius;
    }
    @Override
    public Color getIntensity() {
        return super.getIntensity();
        //מקבל את העוצמה של האור
    }

    //overriding LightSource getIntensity(Point3D)
    @Override
    public Color getIntensity(Point3D p) {
        double dsquared = p.distanceSquared(_position);
        double d = p.distance(_position);

        return (_intensity.reduce(_kC + _kL * d + _kQ * dsquared));
    }

    // Light vector
    @Override
    public Vector getL(Point3D p) {
        if (p.equals(_position)) {
            return null;
        }
        return p.subtract(_position).normalize();
    }
    public List<Vector> getLs(Point3D p) {
        // double size = _radius * _radius * Math.PI;
        List<Point3D> pointLights = new LinkedList<Point3D>();
        for (int x = 0; x < _radius; x++)
            for (int y = 0; y < _radius; y++)
                for (int z = 0; z < _radius; z++) {
                    pointLights.add(new Point3D(_position.getX().get() + x, _position.getY().get() + y, _position.getZ().get() + z));
                    pointLights.add(new Point3D(-_position.getX().get() + x, -_position.getY().get() + y, -_position.getZ().get() + z));

                }
        pointLights=pointLights.stream().distinct().collect(Collectors.toList());
        if (p.equals(_position)) {
            return null;
        }
        List<Vector> allSubstract = new LinkedList<Vector>();
        for (Point3D po : pointLights)
            allSubstract.add(p.subtract(po).normalize());
        return allSubstract;

    }
    @Override
    public double getDistance(Point3D point) {
        return _position.distance(point);
    }
}
