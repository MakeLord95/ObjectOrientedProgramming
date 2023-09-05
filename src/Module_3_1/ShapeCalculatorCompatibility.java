package Module_3_1;

public class ShapeCalculatorCompatibility {
    public static boolean areShapesCompatibleForCombining(Shape shape1, Shape shape2) {
        return (shape1 instanceof Circle && shape2 instanceof Rectangle) ||
                (shape1 instanceof Rectangle && shape2 instanceof Circle);
    }

    public static void main(String[] args) {
        Shape[] shapes = {new Circle(5), new Rectangle(4, 6), new Triangle(3, 8)};

        for (int i = 0; i < shapes.length; i++) {
            for (int j = i + 1; j < shapes.length; j++) {
                Shape shape1 = shapes[i];
                Shape shape2 = shapes[j];

                if (areShapesCompatibleForCombining(shape1, shape2)) {
                    System.out.printf("Shapes %s and %s are compatible for combining.%n", shape1, shape2);
                }
            }
        }
    }
}
