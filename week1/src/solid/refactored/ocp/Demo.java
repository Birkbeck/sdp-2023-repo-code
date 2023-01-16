package solid.refactored.ocp;

class Circle implements Shape {
    @Override
    public void draw() {
        // draw circle
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        // draw square
    }
}

public class Demo {
    public void draw(Shape[] shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}