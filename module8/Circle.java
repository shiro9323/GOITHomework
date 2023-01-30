package module8;

public class Circle extends Shape {

    static String name = "circle";


    @Override
    public String getName() {
        return name;
    }


    @Override
    public void draw() {
        System.out.println(name +" is draw");
    }
}
