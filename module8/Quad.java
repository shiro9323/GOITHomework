package module8;

public class Quad extends Shape{

    static String name = "quad";


    @Override
    public void draw() {

        System.out.println(name +" is draw");

    }

    @Override
    public String getName() {
        return name;
    }
}
