package module9;

import java.util.Objects;

public class MyLinkedList<E> {
    private int size;
    private Node<E> last;
    private Node<E> first;



    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (size == 0) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void remove(int index){

        Objects.checkIndex(index, size);
        size--;


        Node<E> prev = first;

        for (int i = 0; i < index-1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;

    }

    public void clear(){

        first = last = null;
        size = 0;

    }

    public int size() {
        return size;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);

        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    @Override
    public String toString() {
        StringBuilder write = new StringBuilder();
        Node<E> node = first;
        if (node == null) {
            write.append("NULL");
        } else while (node != null) {
            write.append(node.item).append("\t");
            node = node.next;
        }
        return write.toString();
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element) {
            this.item = element;
        }

    }

}
