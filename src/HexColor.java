/**
 * HexColor - Proof of Concept
 *
 * Minimum Viable Product (MVP) for a component representing hexadecimal color
 * values. Demonstrates feasibility by implementing a variety of kernel and
 * secondary methods.
 */

public class HexColor {

    /*
     * Private members ---------------------------------------------------
     */

    // Representation of {@code this}
    private String hexValue;

    // Constants (default colors, black, white)
    private static final String DEFAULT_COLOR = "#000000";
    private static final String BLACK = "#000000";
    private static final String WHITE = "#FFFFFF";
    private static final String FORMAT = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

    /*
     * Constructors ---------------------------------------------------
     */

    /**
     * Default constructor (no argument - black).
     */
    public HexColor() {
        this.hexValue = DEFAULT_COLOR;
    }

    /**
     * Constructor from {@code String}.
     *
     * @param hex
     *            {@code String} hex to initialize to
     */
    public HexColor(String hex) {
        if (this.isValidHex(hex)) {
            this.hexValue = hex.toUpperCase();
        }
    }

    /*
     * Kernel Methods ---------------------------------------------------
     */

    /**
     * Reutrns the hex value as a string.
     *
     * @return the hex color code
     */
    public String getHexValue() {
        return this.hexValue;
    }

    /**
     * Sets the hex value to match the arugment.
     *
     * @param hex
     *            the new hex value to set as
     * @requires isValidHex(this.hexValue) == true
     * @replaces this.hexValue
     */
    public void setHexValue(String hex) {
        assert hex != null : "Violation of: hex is not null.";

        // There is a requires clause
        this.hexValue = hex.toUpperCase();
    }

    /**
     * Checks whether the two hex values are the same.
     *
     * @param hex
     *            the hex string to compare
     * @return true if this.hexValue == hex
     */
    public boolean equals(String hex) {
        assert hex != null : "Violation of: hex is not null.";

        return this.hexValue.equals(hex.toUpperCase());
    }

    /*
     * Secondary Methods ---------------------------------------------------
     */

    /**
     * Extract red component.
     *
     * @return red value as a string
     */
    public String getRed() {
        String redHex = this.hexValue.substring(1, 3);
        return redHex;
    }

    /**
     * Extract green component.
     *
     * @return green value as a string
     */
    public String getGreen() {
        String greenHex = this.hexValue.substring(3, 5);
        return greenHex;
    }

    /**
     * Extract green component.
     *
     * @return green value as a string
     */
    public String getBlue() {
        String blueHex = this.hexValue.substring(5, 7);
        return blueHex;
    }

    /**
     * Check to make sure hex code format is correct.
     *
     * @param hex
     *            the hex value to check
     * @return true if format is valid, false otherwise
     */
    public boolean isValidHex(String hex) {
        assert hex != null : "Violation of: hex is not null.";

        return false; // added only to compile rn
        // Not sure how I should check format yet
    }

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
    public void setRGB(int red, int green, int blue) {
        // %02X three times
        // % - format specifier, 0 - pad with zeros if needed, 2 - use two characters
        // X - convert to hex

        this.hexValue = String.format("#%02X%02X%02X", red, green, blue);

    }

}
