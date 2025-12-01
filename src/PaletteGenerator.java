import components.HexColor;
import components.HexColorString;

public class PaletteGenerator {

    private HexColor color;

    // Palette Generator uses the HexColor STRING constructor
    public PaletteGenerator(String colory) {
        this.color = new HexColorString();
    }

    public static void main(String[] args) {

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
