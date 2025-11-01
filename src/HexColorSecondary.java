
/**
 * Layered implementations of secondary methods for {@code HexColor}.
 */
public abstract class HexColorSecondary implements HexColor {

    /*
     * Public members ---------------------------------------------------------
     */

    /*
     * Common methods (from Object) -------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {

        return null;

    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String getRed() {

        return null;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String getGreen() {

        return null;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String getBlue() {

        return null;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void setRGB(int red, int green, int blue) {

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean isValidHex(String hexValue) {

        return true;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public HexColor lighten(double factor) {
        return null;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public HexColor darken(double factor) {
        return null;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public double getLuminance() {
        return (Double) null;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public HexColor complement() {
        return null;

    }
}
