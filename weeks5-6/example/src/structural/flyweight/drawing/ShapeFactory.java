package structural.flyweight.drawing;

import java.util.HashMap;
import java.util.Map;

class ShapeFactory {
    private static final Map<ShapeType, Shape> shapes = new HashMap<>();

    static Shape getShape(ShapeType type) {
        return shapes.computeIfAbsent(type,
                t -> switch (t) {
                    case OVAL_FILL -> new Oval(true);
                    case OVAL_NO_FILL -> new Oval(false);
                    case LINE -> new Line();
                });
    }
}
