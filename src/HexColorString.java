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
 *
 * @convention this.rep is not null and has the form "#RRGGBB" where the first
 *             character is '#' followed by exactly 6 hexadecimal digits (0-9,
 *             A-F), all uppercase
 * @correspondence this = this.rep
 *
 * @author Anna Huang
 *
 */
public class HexColorString extends HexColorSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private String rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = HexColorKernel.DEFAULT_COLOR;
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public HexColorString() {
        this.createNewRep();
    }

    /**
     * Constructor from {@code String}.
     *
     * @param hexValue
     *            {@code String} to initialize to
     */
    public HexColorString(String hexValue) {
        assert hexValue != null : "Violation of: hexValue is not null";
        assert this.isValidHex(hexValue) : ""
                + "Violation of: hexValue is a valid hex color code";

        this.rep = hexValue.toUpperCase();
    }

    /**
     * Constructor from {@code HexColor}.
     *
     * @param color
     *            {@code HexColor} to initialize from
     */
    public HexColorString(HexColor color) {
        assert color != null : "Violation of: color is not null";

        this.rep = color.getHexValue();
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    // Based off of the NaturalNumber1L kernel implementation!

    @Override
    public final HexColor newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(HexColor source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof HexColorString : ""
                + "Violation of: source is of dynamic type HexColorString";

        HexColorString localSource = (HexColorString) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final String getHexValue() {
        return this.rep;
    }

    @Override
    public final void setHexValue(String hexValue) {
        assert hexValue != null : "Violation of: hexValue is not null";
        assert this.isValidHex(hexValue) : ""
                + "Violation of: hexValue is a valid hex color code";

        this.rep = hexValue.toUpperCase();
    }

    @Override
    public final boolean hexEquals(String hexValue) {
        assert hexValue != null : "Violation of: hexValue is not null";

        return this.rep.equals(hexValue.toUpperCase());
    }

}
