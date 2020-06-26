package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.LinkedList;
import java.util.List;

import static primitives.Util.isZero;

//המצלמה!! מרכז המצלמה המשקיף על המודל הוא ראשית הצירים ממנו יוצאים שלושה וקטורים שהם הצירים של המערכת.תפקידה חשוב מאוד במערכת.
//Avital and Keren Or


public class Camera {
    Point3D _p0;
    Vector _vTo;
    Vector _vUp;
    Vector _vRight;

    public Camera(Point3D _p0, Vector _vTo, Vector _vUp) {

        //must be orthogonal
        if (_vUp.dotProduct(_vTo) != 0)
            throw new IllegalArgumentException("the vectors must be orthogonal");

        this._p0 = new Point3D(_p0);
        this._vTo = _vTo.normalized();
        this._vUp = _vUp.normalized();

        _vRight = this._vTo.crossProduct(this._vUp).normalize();

    }

//getters
    public Point3D getP0() {
        return new Point3D(_p0);
    }

    public Vector getVTo() {
        return new Vector(_vTo);
    }

    public Vector getVUp() {
        return new Vector(_vUp);
    }

    public Vector getVRight() {
        return new Vector(_vRight);
    }

    /**
    *constructRay function - מעביר קרניים דרך פיקסלים
    */
        
    public Ray constructRayThroughPixel(int nX, int nY,
                                        int j, int i, double screenDistance,
                                        double screenWidth, double screenHeight) {
        if (isZero(screenDistance)) {
            throw new IllegalArgumentException("distance cannot be 0");
        }

        Point3D Pc = _p0.add(_vTo.scale(screenDistance));

        double Ry = screenHeight / nY;
        double Rx = screenWidth / nX;

        double yi = ((i - nY / 2d) * Ry + Ry / 2d);
        double xj = ((j - nX / 2d) * Rx + Rx / 2d);

        Point3D Pij = Pc;

        if (!isZero(xj)) {
            Pij = Pij.add(_vRight.scale(xj));
        }
        if (!isZero(yi)) {
            Pij = Pij.subtract(_vUp.scale(yi)); 
        }

        Vector Vij = Pij.subtract(_p0);

        return new Ray(_p0, Vij);

    }

    public List<Ray> construct9RaysBeamThroughPixel(int nX, int nY, double i, double j, double screenDist, double screenWidth, double screenHeight) {

        double Rx = screenWidth / nX;//the length of pixel in X axis
        double Ry = screenHeight / nY;////the length of pixel in Y axis

        double yi = ((i - nY / 2d) * Ry + Ry / 2d);
        double xj = ((j - nX / 2d) * Rx + Rx / 2d);


        Point3D Pc = new Point3D(_p0.add(_vTo.scale(screenDist)));//new point from the camera to the screen

        //pc is the center of the view plane
        Point3D P = Pc.add(_vRight.scale(xj).subtract(_vUp.scale(yi)));

        //finding the intersection point with the view plane according the formula in the moodle

        
   
        
        //-----SuperSampling-----
        List<Ray> rays = new LinkedList<>();//the return list, construct Rays Through Pixels

        rays.add(new Ray(P, _p0.subtract(P)));//the first ray(we already find it)
        //the next 8 rays we gonna add is the same thing, but there's difference in the variation on
        // x and y arguments, some times we will change one of them and some times both of them

        // x coord middle of pixel/2 downwards
        Point3D tmp = new Point3D(P.getX().get() - Rx / 2, P.getY().get(), P.getZ().get());
        rays.add(new Ray(tmp, new Vector(_p0.subtract(tmp)).normalized()));

        // y coord middle of pixel/2 downward
        tmp = new Point3D(P.getX().get(), P.getY().get() - Ry / 2, P.getZ().get());
        rays.add(new Ray(tmp, new Vector(_p0.subtract(tmp)).normalized()));

        // x coord middle of pixel/2 upwards
        tmp = new Point3D(P.getX().get() + Rx / 2, P.getY().get(), P.getZ().get());
        rays.add(new Ray(tmp, new Vector(_p0.subtract(tmp)).normalized()));

        // y coord middle of pixel/2 upward
        tmp = new Point3D(P.getX().get(), P.getY().get() + Ry / 2, P.getZ().get());
        rays.add(new Ray(tmp, new Vector(_p0.subtract(tmp)).normalized()));

        // x coord middle of pixel/2 downwards  y coord middle of pixel/2 downward
        tmp = new Point3D(P.getX().get() - Ry / 2, P.getY().get() - Ry / 2, P.getZ().get());
        rays.add(new Ray(tmp, new Vector(_p0.subtract(tmp)).normalized()));

        // x coord middle of pixel/2 upwards  y coord middle of pixel/2 downward
        tmp = new Point3D(P.getX().get() + Ry / 2, P.getY().get() - Ry / 2, P.getZ().get());
        rays.add(new Ray(tmp, new Vector(_p0.subtract(tmp)).normalized()));

        // x coord middle of pixel/2 downwards    y coord middle of pixel/2 upward
        tmp = new Point3D(P.getX().get() - Ry / 2, P.getY().get() + Ry / 2, P.getZ().get());
        rays.add(new Ray(tmp, new Vector(_p0.subtract(tmp)).normalized()));

        // x coord middle of pixel/2 upwards   y coord middle of pixel/2 upward
        tmp = new Point3D(P.getX().get() + Ry / 2, P.getY().get() + Ry / 2, P.getZ().get());
        rays.add(new Ray(tmp, new Vector(_p0.subtract(tmp)).normalized()));

        return rays;

    }

}
