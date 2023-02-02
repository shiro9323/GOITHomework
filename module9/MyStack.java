package module9;

public class MyStack <T> extends MyArrayList<T>{

    public void push(T value) {
        super.add(value);
    }

    public T peek() {
        return (T) arr[arr.length-1];
    }

    public T pop() {

        int indexFifo = arr.length-1;
        T firstElement = (T) arr[indexFifo];

        remove(indexFifo);

        return firstElement;

    }
}
