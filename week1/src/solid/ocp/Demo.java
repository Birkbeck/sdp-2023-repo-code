package solid.ocp;

class Circle implements Shape {
}

class Square implements Shape {

}

public class Demo {
    public void draw(Shape[] shapes) {
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                // draw circle
            }
            else if (shape instanceof Square) {
                // draw square
            }
        }
    }
}