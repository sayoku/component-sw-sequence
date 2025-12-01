import components.HexColor;
import components.HexColorString;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A contrast check for cases in verifying that contrast and color meets
 * accessibility standards. WCAG 2.0 level AA requires a contrast ratio of at
 * least 4.5:1 for normal text and 3:1 for large text
 */
public class ContrastChecker {

    private static final double WCAG_RATIO = 4.5;

    /**
     * Determines if the text and background color combination luminosity meets
     * WCAG AA standards.
     *
     * @param text
     *            the text color
     * @param background
     *            the background color
     * @param out
     *            simplewriter out
     * @return whether the combination is accessible
     */
    public static boolean isAccessible(HexColor text, HexColor background,
            SimpleWriter out) {

        double textLuminosity = text.getLuminance();
        double backgroundLuminosity = background.getLuminance();

        // The ratio formula always puts the lighter color in the numerator

        // Lighter closer to 255, darker closer to 0
        double lighter = Math.max(textLuminosity, backgroundLuminosity);
        double darker = Math.min(textLuminosity, backgroundLuminosity);

        // Formula is: (L1 + 0.05) / (L2 + 0.05)
        double ratio = (lighter + 0.05) / (darker + 0.05);
        boolean accessible = ratio >= WCAG_RATIO;
        out.println("Your contrast ratio is:" + ratio);

        return accessible;
    }

    public static void main(String[] args) {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.println("Contrast Checker for Compliance with WCAG AA standards.");

        out.print("Please enter your text color: ");
        String textString = in.nextLine();
        out.println();
        out.print("Please enter your background color: ");
        String backgroundString = in.nextLine();
        out.println();

        HexColor text = new HexColorString(textString);
        HexColor background = new HexColorString(backgroundString);

        if (isAccessible(text, background, out)) {
            out.println("This color combination is accessible!");
        } else {
            out.println(
                    "This color combination is not accessible: poor contrast ratio");
        }

        in.close();
        out.close();
    }

}
