package module8;

public class Rhombus extends Shape{

    static String name = "rhombus";

    @Override
    public void draw() {

        System.out.println(name +" is draw");

    }

    @Override
    public String getName() {
        return name;
    }

}
