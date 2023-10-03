package Module_3_1;

class Shape {
    public double calculateArea() {
        return 0;
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle with radius " + radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class Rectangle extends Shape {
    private final double height;
    private final double width;

    public Rectangle(double length, double width) {
        this.height = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle with width " + width + " and height " + height;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }
}

class Triangle extends Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Triangle with base " + base + " and height " + height;
    }

    @Override
    public double calculateArea() {
        return (base * height) / 2;
    }
}

public class ShapeCalculator {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(5),  new Rectangle(4, 6), new Triangle(3, 8)};

        for (Shape shape : shapes) {
            System.out.printf("Area of %s: %.2f\n", shape.toString(), shape.calculateArea());
        }
    }
}
