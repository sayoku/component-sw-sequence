package components;
// import components.HexColor;

// import components.HexColorString;

/**
 * Customized JUnit test fixture for {@code HexColorString}.
 *
 * @author Anna Huang
 */
public class HexColorStringTest extends HexColorTest {

    @Override
    protected final HexColor constructorTest() {
        return new HexColorString();
    }

    @Override
    protected final HexColor constructorTest(String hexValue) {
        return new HexColorString(hexValue);
    }

}
