// package components.HexColor; ?

/**
 * {@code HexColorKernel} enhanced with secondary methods.
 */
public interface HexColor {

    /**
     * Extract red component.
     *
     * @return red value as a string
     */
    String getRed();

    /**
     * Extract green component.
     *
     * @return green value as a string
     */
    String getGreen();

    /**
     * Extract green component.
     *
     * @return green value as a string
     */
    String getBlue();

    /**
     * Sets hex code from RGB values.
     *
     * @param red
     *            red component (0-255)
     * @param green
     *            green component (0-255)
     * @param blue
     *            blue component (0-255)
     *
     */
    void setRGB(int red, int green, int blue);

    /**
     * Check to make sure hex code format is correct.
     *
     * @param hex
     *            the hex value to check
     * @return true if format is valid, false otherwise
     */
    boolean isValidHex(String hex);

    /**
     * return lighter version.
     *
     * @param factor
     * @return lighter
     */
    HexColor lighten(double factor);

    /**
     * return darker version.
     *
     * @param factor
     * @return darker
     */
    HexColor darken(double factor);

    /**
     * calulcate brightness.
     *
     * @return luminance
     */
    double getLuminance();

    /**
     * return complementary color.
     *
     * @return complement
     */
    HexColor complement();

    @Override
    String toString();

}
