package visitor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class VisitorLambda {

    static Function<Shape, Double> areaVisitor = new LambdaVisitor<Shape, Double>()
        .on(Square.class).then(s -> s.side * s.side)
        .on(Circle.class).then(c -> Math.PI * c.radius * c.radius)
        .on(Rectangle.class).then(r -> r.height * r.width);

    static Function<Shape, Double> perimeterVisitor = new LambdaVisitor<Shape, Double>()
        .on(Square.class).then(s -> 4 * s.side)
        .on(Circle.class).then(c -> 2 * Math.PI * c.radius)
        .on(Rectangle.class).then(r -> 2 * r.height + 2 * r.width);

    // requires pattern matching for switch (preview in Java 19)
    static Function<Shape, Double> perimeterVisitorWithSwitch = o ->
            switch (o) {
                case Square s -> 4 * s.side;
                case Circle c -> 2 * Math.PI * c.radius;
                case Rectangle r -> 2 * r.height + 2 * r.width;
            };
    
    public static void main(String[] args) {
        List<Shape> figures = Arrays.asList(new Circle(4), new Square(5), new Rectangle(6, 7));

        double totalArea = figures.stream()
                .map(areaVisitor)
                .reduce(0.0, (v1, v2) -> v1 + v2);
        System.out.println("Total area = " + totalArea);

        double totalPerimeter = figures.stream()
                .map(perimeterVisitor)
                .reduce(0.0, (v1, v2) -> v1 + v2);
        System.out.println("Total perimeter = " + totalPerimeter);
    }

    public static class LambdaVisitor<T, A> implements Function<T, A> {
        private final Map<Class<? extends T>, Function<T, A>> fMap = new HashMap<>();

        public <B extends T> Acceptor<T, A, B> on(Class<B> clazz) {
            return new Acceptor<>(this, clazz);
        }

        @Override
        public A apply(T o) {
            return fMap.get(o.getClass()).apply(o);
        }

        static class Acceptor<T, A, B extends T> {
            private final LambdaVisitor<T, A> visitor;
            private final Class<B> clazz;

            public Acceptor(LambdaVisitor<T, A> visitor, Class<B> clazz) {
                this.visitor = visitor;
                this.clazz = clazz;
            }

            public LambdaVisitor<T, A> then(Function<B, A> f) {
                // the type cast is safe due to the implementation of apply above
                visitor.fMap.put(clazz, (Function<T, A>) f);
                return visitor;
            }
        }
    }

    public static sealed abstract class Shape
            permits Square, Circle, Rectangle  {

    }

    public static non-sealed class Square extends Shape {
        final double side;

        public Square(double side) {
            this.side = side;
        }
    }

    public static non-sealed class Circle extends Shape {
        final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }
    }

    public static non-sealed class Rectangle extends Shape {
        final double width;
        final double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }
    }
}
