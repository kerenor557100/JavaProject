package geometries;

import primitives.*;


import java.util.List;
import java.util.Objects;

/**
 * Intersectable is a common interface for all geometries that are able
 * to intersect from a ray to their entity (Shape)
 */
public interface Intersectable {
    /***
     * GeoPoint
     */
    public static class GeoPoint {

        Geometry _geometry;
        Point3D point;

        public GeoPoint(Geometry _geometry, Point3D pt) {
            this._geometry= _geometry;
            point =pt;
        }

        public Point3D getPoint() {
            return  new Point3D(point);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GeoPoint geoPoint = (GeoPoint) o;
            return Objects.equals(_geometry, geoPoint._geometry) &&
                    Objects.equals(point, geoPoint.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(_geometry, point);
        }

        public Geometry getGeometry() {
            return  _geometry;
        }
    }  /**
     *
     * @param ray ray pointing toward a Gepmtry
     * @return List<Point3D> return values
     */
    List<GeoPoint> findIntersections(Ray ray);

}
