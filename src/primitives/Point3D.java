package primitives;

/**
 * Class Point3D is a basic class for this project
 *
 * @author keren or and avital
 */
public class Point3D {
    Coordinate _x;
    Coordinate _y;
    Coordinate _z;

    /**
     * @param _x coordinate on the X axis
     * @param _y coordinate on the Y axis
     * @param _z coordinate on the Z axis
     */
    public final static Point3D ZERO = new Point3D(0.0, 0.0, 0.0);

    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        this._x = _x;
        this._y = _y;
        this._z = _z;
    }

    public Point3D(Point3D other)
    {
        Point3D p2=new Point3D(other._x,other._y,other._z);
        this._x = p2._x;
        this._y = p2._y;
        this._z = p2._z;
    }


    public Point3D(double _x, double _y, double _z) {
        this(new Coordinate(_x), new Coordinate(_y), new Coordinate(_z));
    }

    public Coordinate getX() {
        return new Coordinate(_x);
    }
    public void set_x(Coordinate _x) {
        this._x = _x;
    }
    public Coordinate getY() {
        return new Coordinate(_y);
    }
    public void set_y(Coordinate _y) {
        this._y = _y;
    }

    public Coordinate getZ() {
        return new Coordinate(_z);
    }
    public void set_z(Coordinate _z) {
        this._z = _z;
    }

    public double distanceSquared(Point3D other)
    {
        return ( (other._x._coord - this._x._coord) * (other._x._coord - this._x._coord) +
                (other._y._coord - this._y._coord) * (other._y._coord - this._y._coord) +
                (other._z._coord - this._z._coord) * (other._z._coord - this._z._coord));
    }
    public double distance (Point3D other){
        return Math.sqrt(distanceSquared(other));
    }

    public Point3D add(Vector vec) {

        double dX = (this._x.get() + vec.get_head()._x.get());
        double dY = (this._y.get() + vec.get_head()._y.get());
        double dZ = (this._z.get() + vec.get_head()._z.get());

        return new Point3D(new Coordinate(dX), new Coordinate(dY), new Coordinate(dZ));
    }

        @Override
    public String toString() {
        return "(" +
                _x +
                ", " + _y +
                ", " + _z +
                ')';
    }
    public Point3D subtract(Vector v) {
        return new Point3D(this._x._coord - v.get_head()._x._coord,
                this._y._coord - v.get_head()._y._coord,
                this._z._coord - v.get_head()._z._coord);
    }

    public Vector subtract(Point3D p) {
        return new Vector(new Point3D(
                this._x._coord - p._x._coord,
                this._y._coord - p._y._coord,
                this._z._coord - p._z._coord));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return _x.equals(point3D._x) &&
                _y.equals(point3D._y) &&
                _z.equals(point3D._z);
    }




}
