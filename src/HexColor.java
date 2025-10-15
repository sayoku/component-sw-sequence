/**
 * {@code HexColorKernel} enhanced with secondary methods.
 */
public interface HexColor extends HexColorKernel {

    /**
     * Regular format for validating Hex Color Code. Accepts 6-digit and 3-digit
     * formats.
     */
    String FORMAT_HEX = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

    /**
     * Extract red component.
     *
     * @return red value as a string
     * @ensures getRed = this.substring[1, 2] where this = "#RRGGBB"
     */
    String getRed();

    /**
     * Extract green component.
     *
     * @return green value as a string
     * @ensures getGreen = this.substring[3, 4] where this = "#RRGGBB"
     */
    String getGreen();

    /**
     * Extract green component.
     *
     * @return green value as a string
     * @ensures getGreen = this.substring[5, 6] where this = "#RRGGBB"
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
     * @replaces this
     * @requires 0 <= red <= 255 and 0 <= green <= 255 and 0 <= blue <= 255.
     * @ensures this is "#" * the 2-digit hexadecimal representations of red,
     *          blue, and green
     */
    void setRGB(int red, int green, int blue);

    /**
     * Checks whether a given hex color code fits the valid format.
     *
     * @param hexValue
     *            the hex value to check
     * @return true iff format is a valid hex color code, false otherwise
     * @ensures isValidHex matches the format specified by FORMAT_HEX
     */
    boolean isValidHex(String hexValue);

    /**
     * Returns a lighter version of this.
     *
     * @param factor
     *            the lightening factor 0.0 to 1.0
     * @return a lighter color
     * @requires 0.0 <= factor <= 1.0
     * @ensures lighten is a valid hex color code where each component is moved
     *          towards 255 by factor
     */
    HexColor lighten(double factor);

    /**
     * Returns a darker version of this.
     *
     * @param factor
     *            the darkening factor 0.0 to 1.0
     * @return a darker color
     * @requires 0.0 <= factor <= 1.0
     * @ensures darker is a valid hex color code where each component is moved
     *          towards 0 by factor
     */
    HexColor darken(double factor);

    /**
     * Returns the luminance of this.
     *
     * @return the luminance of the color
     * @ensures luminance = (0.2126 * R) + (0.7152 * G) + (0.0722 * B) where R,
     *          G, and B are the corresponding substring of the Hex Color Code
     *          this
     */
    double getLuminance();

    /**
     * Returns the complementary color of this (opposite on the color wheel).
     *
     * @return the complement of the color
     * @ensures complement = "#" * (255 - R) * (255 - G) * (255 - B), where R,
     *          G, and B are the corresponding substring of the Hex Color Code
     *          this
     */
    HexColor complement();

    /**
     * Returns a string representation of the hex color in standard format
     * "#RRGGBB".
     *
     * @return the string representation of the color
     * @ensures toString = this in uppercase format
     */
    @Override
    String toString();

}
