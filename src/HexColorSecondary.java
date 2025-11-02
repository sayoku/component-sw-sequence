
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

        int R = Integer.decode("0x" + this.getRed());
        int G = Integer.decode("0x" + this.getGreen());
        int B = Integer.decode("0x" + this.getBlue());

        // Move each component closer to 255
        // (255 - R) is the distance from red val to white
        // Multiply that distance by factor to move a fraction of that distance
        // Add how much you move to R

        int lightRed = (int) (R + (255 - R) * factor);
        int lightGreen = (int) (G + (255 - G) * factor);
        int lightBlue = (int) (B + (255 - B) * factor);

        HexColor result = this.newInstance();
        result.setRGB(lightRed, lightGreen, lightBlue);

        return result;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public HexColor darken(double factor) {
        int R = Integer.decode("0x" + this.getRed());
        int G = Integer.decode("0x" + this.getGreen());
        int B = Integer.decode("0x" + this.getBlue());

        // Move each component closer to 0
        // R is the distance to 0 (black)
        // 1 - factor: keep this portion of the orignal

        int darkRed = (int) (R * (1 - factor));
        int darkGreen = (int) (G * (1 - factor));
        int darkBlue = (int) (B * (1 - factor));

        HexColor result = this.newInstance();
        result.setRGB(darkRed, darkGreen, darkBlue);

        return result;

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
