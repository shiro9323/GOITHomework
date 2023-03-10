package module8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeNameTest {

    public static void main(String[] args) {

        Circle circle = new Circle();

        Quad quad = new Quad();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Rhombus rhombus = new Rhombus();

        List<Shape> shapes = new ArrayList<>(Arrays.asList(circle, quad, rectangle, triangle, rhombus));

        for (Shape shape:shapes) {

            NameUtils.printName(shape);
            shape.draw();

        }

    }

}
