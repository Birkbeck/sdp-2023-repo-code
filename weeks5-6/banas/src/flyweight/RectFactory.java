package flyweight;

// This factory only creates a new rectangle if it
// uses a color not previously used

// Intrinsic State: Color
// Extrinsic State: X & Y Values

import java.awt.*;
import java.util.HashMap;

public class RectFactory {

    // The HashMap uses the color as the key for every
    // rectangle it will make up to 8 total

    private static final HashMap<Color, MyRect> rectsByColor = new HashMap<>();

    public static MyRect getRect(Color color) {
        // Checks if a rectangle with a specific
        // color has been made. If not it makes a
        // new one, otherwise it returns one made already
        return rectsByColor.computeIfAbsent(color, c -> new MyRect(color));
    }
}