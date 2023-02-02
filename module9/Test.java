package module9;

public class Test {
    public static void main(String[] args) {

        /*
        Test method MyArrayList
         */
        System.out.println("-----Test MyArrayList:-----");

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

        cars.clear();
        System.out.println(cars);

        /*
        Test method MyLinkedList
         */
        System.out.println("-----Test MyLinkedList:-----");

        MyLinkedList<String> names = new MyLinkedList<>();
        names.add("Andrii");
        names.add("Bogdan");
        names.add("Sergii");

        System.out.println(names);
        System.out.println(names.size());
        System.out.println(names.get(2));

        names.remove(2);
        System.out.println(names);
        System.out.println(names.size());

        names.clear();
        System.out.println(names);
        System.out.println(names.size());


    }
}
