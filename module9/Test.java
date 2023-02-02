package module9;

public class Test {
    public static void main(String[] args) {

        /*
        MyArrayList
         */

        MyArrayList<String> cars = new MyArrayList<>();

        cars.add("Dodge");
        cars.add("Mercedes");
        cars.add("BMW");

        System.out.println(cars);
        System.out.println(cars.size());
        System.out.println(cars.get(1));

        cars.remove(2);
        System.out.println(cars);
        System.out.println(cars.size());

        //cars.clear();
        //System.out.println(cars.get(3));

    }
}
