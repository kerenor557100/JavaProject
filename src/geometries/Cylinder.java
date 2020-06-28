package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Cylinder is afinite Tube with a certain _height
 */
public class Cylinder extends Tube {
    /**
     *
     */
    private double _height;

    /**
     * Cylinder constructor
     *
     * @param _radius
     * @param _ray
     * @param _height
     */
    public Cylinder(double _radius, Ray _ray, double _height) {
        super(_radius, _ray);
        this._height = _height;
        buildBoundingBox(); //בונה בוקס
    }

    /**
     * @param point point to calculate the normal
     * @return normal
     * @author Dan Zilberstein
     */
    @Override
    public Vector getNormal(Point3D point) {
        Point3D o = _ray.getPoint();
        Vector v = _ray.getDirection();

        // projection of P-O on the ray:
        double t;
        try {
            t = alignZero(point.subtract(o).dotProduct(v));
        } catch (IllegalArgumentException e) { // P = O
            return v;
        }

        // if the point is at a base
        if (t == 0 || isZero(_height - t)) // if it's close to 0, we'll get ZERO vector exception
            return v;

        o = o.add(v.scale(t));
        return point.subtract(o).normalize();
    }

    @Override
    public List<GeoPoint> findIntersections(Ray ray,double max) {
        List<GeoPoint> intersections = super.findIntersections(ray,max);
        if (intersections != null) {
            for (GeoPoint geoPoint : intersections) {
                geoPoint._geometry = this;
            }
        }
        return intersections;
    }

    private void buildBoundingBox(){

        //cylinder's direction 
        if (this._ray.getDirection().get_head().getX().get() == 0 &&
                this._ray.getDirection().get_head().getZ().get() ==0){
            if (this._ray.getDirection().get_head().getY().get() > 0){
                this.box._min_Y = this._ray.getStartPoint().getY().get();
                this.box._max_Y = box._min_Y+_height;
            }
            else {
                this.box._max_Y = this._ray.getStartPoint().getY().get();
                this.box._min_Y = box._max_Y -_height;
            }
            this.box._max_X = this._ray.getStartPoint().getX().get() + _radius;
            this.box._min_X = this._ray.getStartPoint().getX().get() - _radius;

            this.box._max_Z = this._ray.getStartPoint().getZ().get() + _radius;
            this.box._min_Z = this._ray.getStartPoint().getZ().get() - _radius;
        }
        else {
            double xCenterBottom, xCenterTop;

            xCenterBottom = _ray.getStartPoint().getX().get();     //נקודת התחלה של הקרן
            xCenterTop = _ray.getPoint(_height).getX().get();
            Point3D normal = _ray.getDirection().get_head();   //נקודה של הכיוון
            double sqrX = _radius*Math.sqrt(1 - normal.getX().get()*normal.getX().get()); 

            double max_x_bottom = xCenterBottom + sqrX;
            double min_x_bottom = xCenterBottom -sqrX;
            double max_x_top = xCenterTop + sqrX;
            double min_x_top = xCenterTop - sqrX;

            this.box._max_X = max_x_bottom > max_x_top? max_x_bottom: max_x_top; //בודק מי צריך להיות המקסימום
            this.box._min_X = min_x_bottom < min_x_top? min_x_bottom: min_x_top;

            //נקודת Y
            double yCenterBottom, yCenterTop;
            yCenterBottom = _ray.getStartPoint().getY().get();
            yCenterTop = _ray.getPoint(_height).getY().get();
            double sqrY = _radius*Math.sqrt(1 - normal.getY().get()*normal.getY().get());

            double max_y_bottom = yCenterBottom + sqrY;
            double min_y_bottom = yCenterBottom - sqrY;
            double max_y_top = yCenterTop + sqrY;
            double min_y_top = yCenterTop - sqrY;

            this.box._max_Y = max_y_bottom > max_y_top? max_y_bottom: max_y_top;
            this.box._min_Y = min_y_bottom < min_y_top? min_y_bottom: min_y_top;

            //נקודת Z
            double zCenterBottom, zCenterTop;
            zCenterBottom = _ray.getStartPoint().getZ().get();
            zCenterTop = _ray.getPoint(_height).getZ().get();
            double sqrZ = _radius*Math.sqrt(1 - normal.getZ().get()*normal.getZ().get());

            double max_z_bottom = zCenterBottom + sqrZ;
            double min_z_bottom = zCenterBottom - sqrZ;
            double max_z_top = zCenterTop + sqrZ;
            double min_z_top = zCenterTop - sqrZ;

            this.box._max_Z = max_z_bottom > max_z_top? max_z_bottom: max_z_top;
            this.box._min_Z = min_z_bottom < min_z_top? min_z_bottom: min_z_top;
        }
    }
    public double get_height() {
        return _height;
    }
}
