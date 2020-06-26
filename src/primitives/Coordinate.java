package primitives;

import static primitives.Util.*;

/**
 * A basic class representing a coordinate for Cartesian
 * coordinate system.
 *
 * @author keren or and avital
 */

/**
* Coordinate class
*/
public final class Coordinate {
    /**
     * Coordinate value, intentionally "package-friendly" due to performance
     * constraints
     */
    final double _coord;

    /**
     * Coordinate constructor receiving a coordinate value
     *
     * @param coord coordinate value
     */
    public Coordinate(double coord) {
        // if it too close to zero make it zero
        _coord = alignZero(coord);
    }

    /**
     * Copy constructor
     */
    public Coordinate(Coordinate other) {
        _coord = other._coord;
    }

    /**
     * getter
     */
    public double get() {
        return _coord;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Coordinate)) return false;
        return isZero(_coord - ((Coordinate)obj)._coord);
    }

    @Override
    public String toString() {
        return "" + _coord;
    }
}
