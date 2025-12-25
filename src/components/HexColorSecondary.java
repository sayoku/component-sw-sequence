package components;

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

        return this.getHexValue();

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }

        if (!(o instanceof HexColor)) {
            return false;
        }

        // THIS IS STRING EQUALS!!!
        HexColor h = (HexColor) o;
        return this.getHexValue().equals(h.getHexValue());
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int hashCode() {
        // Note: I'm using STRING hashCode
        return this.getHexValue().hashCode();

    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String getRed() {

        String value = this.getHexValue();
        String result = value.substring(1, 3);

        return result;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String getGreen() {

        String value = this.getHexValue();
        String result = value.substring(3, 5);

        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String getBlue() {

        String value = this.getHexValue();
        String result = value.substring(5, 7);

        return result;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void setRGB(int red, int green, int blue) {

        String hexString = String.format("#%02X%02X%02X", red, green, blue);
        this.setHexValue(hexString);

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean isValidHex(String hexValue) {

        boolean result = true;

        // Checking length, not null, and for '#'

        if (hexValue == null || hexValue.length() != 7
                || hexValue.charAt(0) != '#') {
            result = false;
        }

        // check the last 6 digits to be valid hexadecimal digits

        int i = 1;
        while (result && i < 7) {
            char pull = hexValue.charAt(i);
            char c = Character.toUpperCase(pull);
            result = (c >= '0' && c <= '9' || (c >= 'A' && c <= 'F'));
            i++;
        }

        return result;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public HexColor lighten(double factor) {

        int redInt = Integer.decode("0x" + this.getRed());
        int greenInt = Integer.decode("0x" + this.getGreen());
        int blueInt = Integer.decode("0x" + this.getBlue());

        // Move each component closer to 255
        // (255 - R) is the distance from red val to white
        // Multiply that distance by factor to move a fraction of that distance
        // Add how much you move to R

        int lightRed = (int) (redInt + (255 - redInt) * factor);
        int lightGreen = (int) (greenInt + (255 - greenInt) * factor);
        int lightBlue = (int) (blueInt + (255 - blueInt) * factor);

        HexColor result = this.newInstance();
        result.setRGB(lightRed, lightGreen, lightBlue);

        return result;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public HexColor darken(double factor) {
        int redInt = Integer.decode("0x" + this.getRed());
        int greenInt = Integer.decode("0x" + this.getGreen());
        int blueInt = Integer.decode("0x" + this.getBlue());

        // Move each component closer to 0
        // R is the distance to 0 (black)
        // 1 - factor: keep this portion of the orignal

        int darkRed = (int) (redInt * (1 - factor));
        int darkGreen = (int) (greenInt * (1 - factor));
        int darkBlue = (int) (blueInt * (1 - factor));

        HexColor result = this.newInstance();
        result.setRGB(darkRed, darkGreen, darkBlue);

        return result;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public double getLuminance() {

        int redInt = Integer.decode("0x" + this.getRed());
        int greenInt = Integer.decode("0x" + this.getGreen());
        int blueInt = Integer.decode("0x" + this.getBlue());

        double lumi = (0.2126 * redInt) + (0.7152 * greenInt)
                + (0.0722 * blueInt);

        return lumi;

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public HexColor complement() {

        int redInt = Integer.decode("0x" + this.getRed());
        int greenInt = Integer.decode("0x" + this.getGreen());
        int blueInt = Integer.decode("0x" + this.getBlue());

        int compRed = 255 - redInt;
        int compGreen = 255 - greenInt;
        int compBlue = 255 - blueInt;

        HexColor result = this.newInstance();
        result.setRGB(compRed, compGreen, compBlue);

        return result;

    }
}
