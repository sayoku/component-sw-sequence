
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

        String value = this.getHexValue();
        value.substring(1, 2);

        return value;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String getGreen() {

        String value = this.getHexValue();
        value.substring(3, 4);

        return value;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String getBlue() {

        String value = this.getHexValue();
        value.substring(5, 6);

        return value;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void setRGB(int red, int green, int blue) {

        String hexString = "#";
        String redString = Integer.toHexString(red);
        String greenString = Integer.toHexString(green);
        String blueString = Integer.toHexString(blue);

        hexString += redString + greenString + blueString;

        this.setHexValue(hexString);

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

        int R = Integer.decode("0x" + this.getRed());
        int G = Integer.decode("0x" + this.getGreen());
        int B = Integer.decode("0x" + this.getBlue());

        double lumi = (0.2126 * R) + (0.7152 * G) + (0.0722 * B);

        return lumi;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public HexColor complement() {

        String hexString = this.getHexValue();

        int R = Integer.decode("0x" + this.getRed());
        int G = Integer.decode("0x" + this.getGreen());
        int B = Integer.decode("0x" + this.getBlue());

        int cR = 255 - R;
        int cG = 255 - G;
        int cB = 255 - B;

        HexColor result = this.newInstance();
        result.setRGB(cR, cG, cB);

        return result;

    }
}
