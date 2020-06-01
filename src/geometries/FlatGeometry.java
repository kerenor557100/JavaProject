package geometries;

import elements.Material;
import primitives.Color;

/**
 * we did not decalre it as an interface
 * geometries without radius
 */
public abstract class FlatGeometry extends Geometry {
    /**
     * Associated plane in which the flat geometry lays
     */
    protected Plane _plane;

    public FlatGeometry(Color _emission, Material _material) {
        super(_emission, _material);
    }

    public FlatGeometry(Color _emission) {
        super(_emission);
    }

    public FlatGeometry() {
        super();
    }

    public abstract long getNormal();
}
