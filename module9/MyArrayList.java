package module9;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList <T>{

    private Object[] arr = new Object[0];

    //private int index;

    public void add(T value){

        int size = arr.length;
        size++;
        Object[] secondArr = Arrays.copyOf(arr, size);
        for (int i = arr.length; i < size; i++) {
            secondArr[i] = value;
        }
        arr = secondArr;

    }

    public void clear() {
        arr = new Object[0];
    }

    public int size() {
        return arr.length;
    }

    public Object get(int index) {

        Objects.checkIndex(index, arr.length);

        return arr[index];
        /*if (index <= (arr.length - 1)) {
            return arr[index];
        } else throw new IndexOutOfBoundsException();*/
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

}
