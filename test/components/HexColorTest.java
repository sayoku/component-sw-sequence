package components;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code HexColor}'s constructor, kernel, and secondary
 * methods.
 *
 * @author Anna Huang
 */
public abstract class HexColorTest {

    /**
     * Invokes the {@code HexColor} constructor for the implementation under
     * test and returns the result.
     *
     * @return the new HexColor
     * @ensures constructorTest = "#000000"
     */
    protected abstract HexColor constructorTest();

    /**
     * Invokes the {@code HexColor} constructor for the implementation under
     * test and returns the result.
     *
     * @param hexValue
     *            the hex color string
     * @return the new HexColor
     * @requires hexValue is a valid hex color code
     * @ensures constructorTest = hexValue
     */
    protected abstract HexColor constructorTest(String hexValue);

    /*
     * Test cases for constructors -------------------------------------------
     */

    @Test
    public final void testNoArgumentConstructor() {
        HexColor h = this.constructorTest();
        assertEquals("#000000", h.getHexValue());
    }

    @Test
    public final void testConstructorWithArgument() {
        HexColor h = this.constructorTest("#000000");
        assertEquals("#000000", h.getHexValue());
    }

    @Test
    public final void testConstructorWithWhite() {
        HexColor h = this.constructorTest("#FFFFFF");
        assertEquals("#FFFFFF", h.getHexValue());
    }

    @Test
    public final void testConstructorWithLowerCase() {
        HexColor h = this.constructorTest("#abc123");
        assertEquals("#ABC123", h.getHexValue());
    }

    /*
     * Test cases for kernel methods -------------------------------------------
     */

    /*
     * Test cases for getHexValue()
     */

    @Test
    public final void testGetHexValueDefault() {
        HexColor h = this.constructorTest();
        assertEquals("#000000", h.getHexValue());
    }

    @Test
    public final void testGetHexValueRed() {
        HexColor h = this.constructorTest("#FF0000");
        assertEquals("#FF0000", h.getHexValue());
    }

    /*
     * Test cases for setHexValue()
     */

    @Test
    public final void testSetHexValueDefaultToWhite() {
        HexColor h = this.constructorTest();
        h.setHexValue("#FFFFFF");
        assertEquals("#FFFFFF", h.getHexValue());
    }

    @Test
    public final void testSetHexValueRedToBlue() {
        HexColor h = this.constructorTest("#FF0000");
        h.setHexValue("#0000FF");
        assertEquals("#0000FF", h.getHexValue());
    }

    @Test
    public final void testSetHexValueLowerCase() {
        HexColor h = this.constructorTest();
        h.setHexValue("#aabbcc");
        assertEquals("#AABBCC", h.getHexValue());
    }

    /*
     * Test cases for hexEquals()
     */

    @Test
    public final void testHexEqualsTrue() {
        HexColor h = this.constructorTest("#FF0000");
        assertEquals(true, h.hexEquals("#FF0000"));
    }

    @Test
    public final void testHexEqualsFalse() {
        HexColor h = this.constructorTest("#FF0000");
        assertEquals(false, h.hexEquals("#00FF00"));
    }

    @Test
    public final void testHexEqualsCaseInsensitive() {
        HexColor h = this.constructorTest("#FF0000");
        assertEquals(true, h.hexEquals("#ff0000"));
    }

    @Test
    public final void testHexEqualsDefault() {
        HexColor h = this.constructorTest();
        assertEquals(true, h.hexEquals("#000000"));
    }

    /*
     * Test cases for secondary methods ----------------------------------------
     */

    /*
     * Test cases for
     */

    /*
     * Test cases for
     */

    /*
     * Test cases for
     */

    /*
     * Test cases for
     */

    /*
     * Test cases for
     */

    /*
     * Test cases for
     */

    /*
     * Test cases for
     */

    /*
     * Test cases for
     */

    /*
     * Test cases for
     */

    /*
     * Test cases for
     */

    /*
     * Test cases for
     */

}
