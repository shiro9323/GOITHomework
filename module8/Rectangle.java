package module8;

public class Rectangle extends Shape{

    static String name = "rectangle";

    @Override
    public void draw() {

        System.out.println(name +" is draw");

    }

    @Override
    public String getName() {
        return name;
    }
}
