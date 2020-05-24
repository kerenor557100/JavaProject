package primitives;

import static primitives.Util.isZero;

public class Ray {

    /**
     * The point from which the ray is starting.
     */
    private final Point3D _point;
    /**
     * The direction
     */
    private final Vector _direction;

    /**
     * Constructor
     */
    public Ray(Point3D point, Vector direction) {
        _point = new Point3D(point);
        _direction = new Vector(direction).normalized();
    }

    /**
     * @return new Point3D
     */
    public Point3D getTargetPoint(double length) {
        return isZero(length ) ? _point : _point.add(_direction.scale(length));
    }


    /**
     * Copy constructor for a deep copy of an Ray object.
     * @param other the object that being copied
     */
    public Ray(Ray other) {
        this._point = new Point3D(other._point);
        this._direction = other._direction.normalized();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return  false;
        }
        if (!(obj instanceof Ray)) {
            return false;
        }
        if (this == obj)
            return true;
        Ray other = (Ray)obj;
        return (_point.equals(other._point) &&
                _direction.equals(other._direction));
    }

    @Override
    public String toString() {
        return "point: " + _point + ", direction: " + _direction;
    }

    /**
     * Getter for the point from which the ray starts.
     */
    public Point3D getPoint() {
        return new Point3D(_point);
    }

    /**
     * Getter for the direction of the ray that is
     * represented by this object.
     */
    public Vector getDirection() {
        return new Vector(_direction);
    }
}
