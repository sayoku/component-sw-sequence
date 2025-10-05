/**
 * HexColor - Proof of Concept
 *
 * Minimum Viable Product (MVP) for a component representing hexadecimal color
 * values. Demonstrates feasibility by implementing a variety of kernel and
 * secondary methods.
 */

public class HexColor {

    /*
     * Private members --------------------------
     */

    // Representation of {@code this}
    private String hexValue;

    // Constants (default colors, black, white)
    private static final String DEFAULT_COLOR = "#000000";
    private static final String BLACK = "#000000";
    private static final String WHITE = "#FFFFFF";

    /*
     * Constructors --------------------------
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
     * Kernel Methods --------------------------
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
     * Secondary Methods --------------------------
     */

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
    }

}
