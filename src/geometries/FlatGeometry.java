package geometries;

import elements.Material;
import primitives.Color;

/**
 * all the geometries who did not extends radialgeometry
 *
 * we didn't decalre it as an interface
 */
public abstract class FlatGeometry extends Geometry {

    public FlatGeometry(Color _emission, Material _material) {
        super(_emission, _material);
    }
    public FlatGeometry(Color _emission) {
        super(_emission);
    }
    public FlatGeometry() {
        super();
    }


}
