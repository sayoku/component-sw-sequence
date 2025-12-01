import components.HexColor;
import components.HexColorString;

/**
 * Generating a color palette for a predefined color theme. May be modified in
 * the future for user input.
 *
 */
public class PaletteGenerator {

    private HexColor color;

    /**
     * @param hex
     *            PaletteGenerator uses HexColor STRING constructor
     */
    public PaletteGenerator(String hex) {
        this.color = new HexColorString(hex);
    }

    public static void main(String[] args) {

        // Providing cornflower blue as an example
        PaletteGenerator theme = new PaletteGenerator("#6495ED");

        // Find the complement, light, and dark version of the primary color
        HexColor primary = theme.color;
        HexColor accent = primary.complement();
        HexColor light = primary.lighten(0.2);
        HexColor dark = primary.darken(0.3);

        // Print the color codes
        System.out.println("Primary: " + primary);
        System.out.println("Accent: " + accent);
        System.out.println("Light: " + light);
        System.out.println("Dark: " + dark);
    }

}
