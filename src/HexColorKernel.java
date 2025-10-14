import components.standard.Standard;

/**
 * HexColor kernel component with primary methods. All references are non-null.
 *
 * HexColor codes should be expressed as a String starting with # and ending
 * withh 6 hexadecimal digits.
 *
 */
public interface HexColorKernel extends Standard<HexColor> {

    /**
     * Constants (default colors, black, white).
     */
    String DEFAULT_COLOR = "#000000";
    String BLACK = "#000000";
    String WHITE = "#FFFFFF";
    String FORMAT = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

    /*
     * Kernel Methods ---------------------------------------------------
     */

    /**
     * Reutrns the hex value as a string.
     *
     * @ensures this = #this.hexValue
     * @return the hex color code
     */
    String getHexValue();

    /**
     * Sets the hex value to match the argument.
     *
     * @param hex
     *            the new hex value to set as
     * @requires isValidHex(this.hexValue) == true
     * @replaces this.hexValue
     * @ensures this.hexValue = hex
     */
    void setHexValue(String hex);

    /**
     * Checks whether the two hex values are the same.
     *
     * @param hex
     *            the hex string to compare
     * @return true if this.hexValue == hex
     * @ensures hexEquals = (#this == hex )
     */
    boolean hexEquals(String hex);

}
