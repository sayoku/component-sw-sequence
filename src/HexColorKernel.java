//package components.HexColor; ??

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
     * Default Color Constant (black).
     */
    String DEFAULT_COLOR = "#000000";

    /**
     * While Color Constant.
     */
    String WHITE = "#FFFFFF";

    /**
     * Regular format for validating Hex Color Code. Accepts 6-digit and 3-digit
     * formats. I am not sure if this should be in the kernel or the
     * implementation!!
     */
    String FORMAT = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

    /*
     * Kernel Methods ---------------------------------------------------
     */

    /**
     * Returns the hex value as a string.
     *
     * @return the hex color code
     * @ensures getHexValue = this
     */
    String getHexValue();

    /**
     * Sets the hex value to match the given hex string.
     *
     * @param hexValue
     *            the new hex color code
     * @requires isValidHex is a valid hex color string
     * @replaces this
     * @ensures this = hexValue
     */
    void setHexValue(String hexValue);

    /**
     * Checks whether the two hex values are the same.
     *
     * @param hexValue
     *            the hex color code to compare
     * @return true iff this equals hexValue
     * @ensures hexEquals = ( this == hexValue )
     */
    boolean hexEquals(String hexValue);

}
