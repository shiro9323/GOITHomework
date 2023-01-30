package module8;

public class Triangle extends Shape {
    static String name = "triangle";

    @Override
    public void draw() {

        System.out.println(name +" is draw");

    }

    @Override
    public String getName() {
        return name;
    }

}
