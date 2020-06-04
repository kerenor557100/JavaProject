package primitives;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static primitives.Util.isZero;


public class Ray {

    private static final double DELTA = 0.1;
    private static final Random rnd = new Random();

    /**
     * The point from which the ray starts.
     */
    private final Point3D _point;
    /**
     * The direction of the ray.
     */
    private final Vector _direction;

    /**
     * Constructor for creating a new instance of this class
     *
     * @param point     the start of the ray.
     * @param direction the direction of the ray.
     */
    public Ray(Point3D point, Vector direction) {
        _point = new Point3D(point);
        _direction = new Vector(direction).normalized();
    }

    public Ray(Point3D point, Vector direction, Vector normal) {
        //point + normal.scale(±DELTA)
        _direction = new Vector(direction).normalized();

        double nv = normal.dotProduct(direction);

        Vector normalDelta = normal.scale((nv > 0 ? DELTA : -DELTA));
        _point = point.add(normalDelta);
    }

    /**
     * Copy constructor for a deep copy of an Ray object.
     *
     * @param other the object that being copied
     */
    public Ray(Ray other) {
        this._point = new Point3D(other._point);
        this._direction = other._direction.normalized(); //create new normalized vector
    }

    /**
     * @param length length to reach the target point
     * @return new Point3D
     */
    public Point3D getTargetPoint(double length) {
        if (isZero(length)) {
            return _point;
        }

        Vector targetVector = _direction.scale(length);

        return _point.add(targetVector);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Ray)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        Ray other = (Ray) obj;
        return (_point.equals(other._point) && _direction.equals(other._direction));
    }

    @Override
    public String toString() {
        return "point: " + _point + ", direction: " + _direction;
    }

    /**
     * Getter for the point from which the ray starts.
     *
     * @return A new Point3D that represents the
     * point from which the ray starts.
     */
    public Point3D getPoint() {
        return new Point3D(_point);
    }

    /**
     * Getter for the direction of the ray that is
     * represented by this object.
     *
     * @return A new Vector that represents the
     * direction of the ray that is
     * represented by this object.
     */
    public Vector getDirection() {
        return _direction.normalized();
    }

    public List<Ray> constructRayBeamThroughPixel(Point3D targetPoint, double delta, int amount) {
        if (isZero(_point.distance(targetPoint))) {
            throw new IllegalArgumentException("distance cannot be 0");
        }
        Vector direction = this._direction;
        Point3D point = direction.getHead();

        Vector v = this._point.subtract(targetPoint);
        Point3D referPoint = v.getHead();

        //TODO verify that n1 and n2 are normals to originalRay.getDirection()
        Vector n1 = new Vector(referPoint.getY()._coord * -1d, referPoint.getX()._coord, 0d).normalized();
        Vector n2 = direction.crossProduct(n1).normalized();
        double x;
        double y;


        LinkedList<Ray> rays = new LinkedList<>();
        rays.add(this);

        double[] doubles = rnd.doubles(amount * 2, -1 * delta, delta)
                .distinct()
                .toArray();

        for (int i = 0; i < doubles.length; i++) {
            x = doubles[i];
            y = doubles[++i];

            Point3D Pxy = point.add(n1.scale(x)).add(n2.scale(y));
            Vector Vxy = Pxy.subtract(point);

            rays.add(new Ray(point, Vxy));
        }
        return rays;

    }

}
