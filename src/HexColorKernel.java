import components.standard.Standard;

/**
 * HexColor kernel component with primary methods. All references are non-null.
 *
 * @mathsubtypes <pre>
 * HEXSTRING h is a string of characters
 *     constraint:
 *     |h| = 7 and h[0] = '#' and for all i, 1 <= i <= 7
 *        h[i] is in set {'0','1','2','3','4','5','6','7','8','9',
 *                 'A','B','C','D','E','F','a','b','c','d','e','f'}
 * </pre>
 *
 * @mathmodel type HexColorKernel is modeled by HEXSTRING
 * @initially <pre>
 * ():
 *  ensures
 *      this = "#000000"
 * (String hexValue):
 *      requires
 *       there exists hexValue in HEXSTRING
 *      ensures
 *       this = hexValue
 * </pre>
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
