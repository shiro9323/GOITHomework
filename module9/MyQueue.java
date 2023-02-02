package module9;

public class MyQueue<T> extends MyArrayList<T>{

    @Override
    public void add(T value) {
        super.add(value);
    }

    @Override
    public void remove(int index) {
        super.remove(index);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public Object get(int index) {
        return super.get(index);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public T peek() {
        return (T) arr[0];
    }

    public T pool() {

        int indexFifo = 0;
        T firstElement = (T) arr[indexFifo];

        remove(indexFifo);

        return firstElement;

    }
}
