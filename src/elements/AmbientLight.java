package elements;

import primitives.Color;
//תאורה סביבתית: מקור התאורה הסביבתית מיוצג על ידי מקור אור שהוא קבוע בעוצמתו וקבוע בצבעו, ומשפיע על כל האובייקטים בסצנה באופן שווה.

public class AmbientLight  extends  Light{
//    public void setIntensity(Color _intensity) {
//        this._intensity = _intensity;
//    }
//keren or and avital
public AmbientLight(Color ia, double ka) {
    this._intensity = ia.scale(ka);
}
}
