package module9;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList <T>{

    protected Object[] arr = new Object[0];

    public void add(T value){

        int size = arr.length;
        size++;
        Object[] secondArr = Arrays.copyOf(arr, size);
        for (int i = arr.length; i < size; i++) {
            secondArr[i] = value;
        }
        arr = secondArr;

    }

    public void remove(int index) {
        Objects.checkIndex(index, arr.length);

        int size = arr.length;
        size--;
        Object[] secondArr = new Object[size];

        int j = 0;
        for(int i = 0; i<size; i++) {

            if(i==index){
                j++;
            }
            secondArr[i] = arr[j];
            j++;
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
