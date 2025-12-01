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
     * Test cases for getRed()
     */

    @Test
    public final void testGetRedFromRed() {
        HexColor h = this.constructorTest("#FF0000");
        assertEquals("FF", h.getRed());
        assertEquals("#FF0000", h.getHexValue());
    }

    @Test
    public final void testGetRedFromBlack() {
        HexColor h = this.constructorTest("#000000");
        assertEquals("00", h.getRed());
        assertEquals("#000000", h.getHexValue());
    }

    /*
     * Test cases for getGreen()
     */

    @Test
    public final void testGetGreenFromGreen() {
        HexColor h = this.constructorTest("#00FF00");
        assertEquals("FF", h.getGreen());
        assertEquals("#00FF00", h.getHexValue());
    }

    @Test
    public final void testGetGreenFromBlack() {
        HexColor h = this.constructorTest("#000000");
        assertEquals("00", h.getGreen());
        assertEquals("#000000", h.getHexValue());
    }

    /*
     * Test cases for getBlue()
     */

    @Test
    public final void testGetBlueFromBlue() {
        HexColor h = this.constructorTest("#0000FF");
        assertEquals("FF", h.getBlue());
        assertEquals("#0000FF", h.getHexValue());
    }

    @Test
    public final void testGetBlueFromBlack() {
        HexColor h = this.constructorTest("#000000");
        assertEquals("00", h.getBlue());
        assertEquals("#000000", h.getHexValue());
    }

    // Test for getting RGB from one hex code

    @Test
    public final void testGetRGBComponentsMixed() {
        HexColor h = this.constructorTest("#123456");
        assertEquals("12", h.getRed());
        assertEquals("34", h.getGreen());
        assertEquals("56", h.getBlue());
        assertEquals("#123456", h.getHexValue());
    }

    /*
     * Test cases for setRGB()
     */

    @Test
    public final void testSetRGBAllZero() {
        HexColor h = this.constructorTest();
        h.setRGB(0, 0, 0);
        assertEquals("#000000", h.getHexValue());
    }

    @Test
    public final void testSetRGBAllMax() {
        HexColor h = this.constructorTest();
        h.setRGB(255, 255, 255);
        assertEquals("#FFFFFF", h.getHexValue());
    }

    @Test
    public final void testSetRGBMixed() {
        HexColor h = this.constructorTest();
        h.setRGB(27, 47, 67);
        assertEquals("#1B2F43", h.getHexValue());
    }

    /*
     * Test cases for isValidHex()
     */

    @Test
    public final void testIsValidHexTrue() {
        HexColor h = this.constructorTest();
        assertEquals(true, h.isValidHex("#FF0000"));
    }

    @Test
    public final void testIsValidHexTrueLowerCase() {
        HexColor h = this.constructorTest();
        assertEquals(true, h.isValidHex("#abc123"));
    }

    @Test
    public final void testIsValidHexFalseNoHash() {
        HexColor h = this.constructorTest();
        assertEquals(false, h.isValidHex("FF0000"));
    }

    @Test
    public final void testIsValidHexFalseShort() {
        HexColor h = this.constructorTest();
        assertEquals(false, h.isValidHex("#FF00"));
    }

    @Test
    public final void testIsValidHexFalseLong() {
        HexColor h = this.constructorTest();
        assertEquals(false, h.isValidHex("#FF00000"));
    }

    @Test
    public final void testIsValidHexFalseWrongChar() {
        HexColor h = this.constructorTest();
        assertEquals(false, h.isValidHex("#GG0000"));
    }

    @Test
    public final void testIsValidHexNull() {
        HexColor h = this.constructorTest();
        assertEquals(false, h.isValidHex(null));
    }

    /*
     * Test cases for lighten()
     */

    @Test
    public final void testLightenBlackHalfway() {
        HexColor h = this.constructorTest("#000000");
        HexColor lighter = h.lighten(0.5);
        assertEquals("#7F7F7F", lighter.getHexValue());
        assertEquals("#000000", h.getHexValue());
    }

    @Test
    public final void testLightenRedHalfway() {
        HexColor h = this.constructorTest("#FF0000");
        HexColor lighter = h.lighten(0.5);
        assertEquals("#FF7F7F", lighter.getHexValue());
        assertEquals("#FF0000", h.getHexValue());
    }

    @Test
    public final void testLightenFactorZero() {
        HexColor h = this.constructorTest("#FF0000");
        HexColor lighter = h.lighten(0.0);
        assertEquals("#FF0000", lighter.getHexValue());
        assertEquals("#FF0000", h.getHexValue());
    }

    @Test
    public final void testLightenFactorOne() {
        HexColor h = this.constructorTest("#000000");
        HexColor lighter = h.lighten(1.0);
        assertEquals("#FFFFFF", lighter.getHexValue());
        assertEquals("#000000", h.getHexValue());
    }

    /*
     * Test cases for darken()
     */

    @Test
    public final void testDarkenWhiteHalfway() {
        HexColor h = this.constructorTest("#FFFFFF");
        HexColor darker = h.darken(0.5);
        assertEquals("#7F7F7F", darker.getHexValue());
        assertEquals("#FFFFFF", h.getHexValue());
    }

    @Test
    public final void testDarkenRedHalfway() {
        HexColor h = this.constructorTest("#FF0000");
        HexColor darker = h.darken(0.5);
        assertEquals("#7F0000", darker.getHexValue());
        assertEquals("#FF0000", h.getHexValue());
    }

    @Test
    public final void testDarkenFactorZero() {
        HexColor h = this.constructorTest("#FF0000");
        HexColor darker = h.darken(0.0);
        assertEquals("#FF0000", darker.getHexValue());
        assertEquals("#FF0000", h.getHexValue());
    }

    @Test
    public final void testDarkenFactorOne() {
        HexColor h = this.constructorTest("#FFFFFF");
        HexColor darker = h.darken(1.0);
        assertEquals("#000000", darker.getHexValue());
        assertEquals("#FFFFFF", h.getHexValue());
    }

    /*
     * Test cases for getLuminance()
     */

    @Test
    public final void testGetLuminanceBlack() {
        HexColor h = this.constructorTest("#000000");
        assertEquals(0.0, h.getLuminance(), 0.01);
        // the 0.01 being the allowed difference
        assertEquals("#000000", h.getHexValue());
    }

    @Test
    public final void testGetLuminanceWhite() {
        HexColor h = this.constructorTest("#FFFFFF");
        assertEquals(255.0, h.getLuminance(), 0.01);
        assertEquals("#FFFFFF", h.getHexValue());
    }

    @Test
    public final void testGetLuminanceRed() {
        HexColor h = this.constructorTest("#FF0000");
        double expected = 0.2126 * 255;
        assertEquals(expected, h.getLuminance(), 0.01);
        assertEquals("#FF0000", h.getHexValue());
    }

    @Test
    public final void testGetLuminanceGreen() {
        HexColor h = this.constructorTest("#00FF00");
        double expected = 0.7152 * 255;
        assertEquals(expected, h.getLuminance(), 0.01);
        assertEquals("#00FF00", h.getHexValue());
    }

    @Test
    public final void testGetLuminanceBlue() {
        HexColor h = this.constructorTest("#0000FF");
        double expected = 0.0722 * 255;
        assertEquals(expected, h.getLuminance(), 0.01);
        assertEquals("#0000FF", h.getHexValue());
    }

    /*
     * Test cases for complement()
     */

    @Test
    public final void testComplementBlack() {
        HexColor h = this.constructorTest("#000000");
        HexColor comp = h.complement();
        assertEquals("#FFFFFF", comp.getHexValue());
        assertEquals("#000000", h.getHexValue());
    }

    @Test
    public final void testComplementRed() {
        HexColor h = this.constructorTest("#FF0000");
        HexColor comp = h.complement();
        assertEquals("#00FFFF", comp.getHexValue());
        assertEquals("#FF0000", h.getHexValue());
    }

    @Test
    public final void testComplementGreen() {
        HexColor h = this.constructorTest("#00FF00");
        HexColor comp = h.complement();
        assertEquals("#FF00FF", comp.getHexValue());
        assertEquals("#00FF00", h.getHexValue());
    }

}
