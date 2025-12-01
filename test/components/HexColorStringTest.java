package components;

//import static org.junit.Assert.assertEquals;

//import org.junit.Test;

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

}
