package primitives;

/**
*Class Vector
 */
public class Vector {
    private  Point3D _head;

    public  final static Vector ZERO = new Vector(new Point3D(new Coordinate(0.0),new Coordinate(0.0),new Coordinate(0.0)));

    /*
     * Constractor
     * • Builders receiving:
     * a) three coordinates,
     * b) three double-digit numbers,
     * c) a point,
     * d) a vector
     * @param _head
     */
    public Vector(Point3D _head) {
        Point3D Zero=new Point3D(new Coordinate(0.0),new Coordinate(0.0),new Coordinate(0.0));

        if (_head != Zero)
            this._head = _head;

        else throw new IllegalArgumentException (  "head cannot be the zero vector");


    }
    public Point3D get_head() {
        return _head;
    }

    /*
     * set Fun set Point to _head
     * @param _head
     */
    public void set_head(Point3D _head) {
        this._head = _head;
    }
    public Vector(){}
    public  Vector(Point3D p1,Point3D p2){
        this._head=p1.subtract(p2)._head;
    }
    public Vector (Coordinate _x,Coordinate _y,Coordinate _z){
        Point3D _head =new Point3D(new Coordinate(_x),new Coordinate(_y),new Coordinate(_z));
        //  Point3D Zero=new Point3D(new Coordinate(0.0),new Coordinate(0.0),new Coordinate(0.0));

        if (_head.getX().get() == 0.0 &&_head.getY().get() == 0.0 &&_head.getX().get() == 0.0)
            throw new IllegalArgumentException (  "head cannot be the zero vector");

        else
            this._head = _head;

    }

    public Vector(double _x,double _y,double _z){

        if (_x == 0.0 &&_y == 0.0 &&_z == 0.0)
            throw new IllegalArgumentException (  "head cannot be the zero vector");
        this._head=new Point3D(_x,_y,_z);
//    else throw new IllegalArgumentException (  "head cannot be the zero vector");

    }
    public Vector(Vector _head)
    {
        Vector v2=new Vector(_head.get_head().getX().get(),_head.get_head().getY().get(),_head.get_head().getZ().get());
        this._head=v2._head;
    }
//פעולות חשבון על וקטורים
    /**
     * @param vector
     */
    public Vector  add(Vector vector)
    {
        return  new Vector(this._head.add(vector));
    }

    /**
     * @param vector
     */
    public Vector subtract(Vector vector) {
        return  this._head.subtract(vector._head);
    }

    /**
     * @param scalingFacor
     */
    public Vector scale(double scalingFacor) {
        return new Vector(
                new Point3D(
                        new Coordinate(scalingFacor * _head._x._coord),
                        new Coordinate(scalingFacor * _head._y._coord),
                        new Coordinate(scalingFacor * _head._z._coord)));
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return _head.equals(vector._head);
    }

    /**
     * @param v
     * @return
     */
    public double dotProduct(Vector v) {
        return (this._head._x._coord * v._head._x._coord +
                this._head._y._coord * v._head._y._coord +
                this._head._z._coord * v._head._z._coord);
    }

    /**
     * @param v the second vector
     * @return new Vector for the crossproduct (this X v)
     */
    public Vector crossProduct(Vector v) {
        double w1 = this._head._y._coord * v._head._z._coord - this._head._z._coord * v._head._y._coord;
        double w2 = this._head._z._coord * v._head._x._coord - this._head._x._coord * v._head._z._coord;
        double w3 = this._head._x._coord * v._head._y._coord - this._head._y._coord * v._head._x._coord;

        return new Vector(new Point3D(w1, w2, w3));
    }

    /**
     * @return
     */
    public double lengthSquared() {
        double xx = this._head._x._coord * this._head._x._coord;
        double yy = this._head._y._coord * this._head._y._coord;
        double zz = this._head._z._coord * this._head._z._coord;

        return xx + yy + zz;

    }

    /**
     * @return
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * @return the same Vector after normalisation
     * @throws ArithmeticException if length = 0
     */
    public Vector normalize() {

        double x = this._head._x._coord;
        double y = this._head._y._coord;
        double z = this._head._z._coord;

        double length = this.length();

        if (length == 0)
            throw new ArithmeticException("divide by Zero");

        this._head._x = new Coordinate(x / length);
        this._head._y = new Coordinate(y / length);
        this._head._z = new Coordinate(z / length);

        return this;
    }

    public Vector normalized() {
        Vector vector = new Vector(this);
        vector.normalize();
        return vector;
    }

    @Override
    public String toString() {
        return  _head .toString();
    }
}
