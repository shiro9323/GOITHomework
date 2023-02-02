package module9;
import java.util.StringJoiner;

public class MyHashMap<K, V> {

    private int size;
    private Node<K, V> firstNode;
    private Node<K, V> lastNode;

    private void setNullFirstLastNodes(){
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    private Node<K, V> getNodeByKey(K key){
        Node<K, V> node = firstNode;
        while (node!=null){
            if(node.key.equals(key)){
                return node;
            }
            node = node.next;
        }
        return node;
    }

    private Node<K, V> getNodeByNext(Node<K, V> searchNode){
        if (searchNode==null){
            return null;
        }
        Node<K, V> node = firstNode;
        while (node!=null){

            if (node.next==null){
                return null;
            }

            if(node.next.equals(searchNode)){
                return node;
            }
            node = node.next;
        }
        return node;
    }



    public void put(K key, V value) {
        if (get(key) == null) {
            int hash = key.hashCode();
            Node<K, V> node = new Node<>(hash, key, value);

            if (size == 0) {
                firstNode = node;
            } else {
                lastNode.next = node;
            }
            lastNode = node;

            size++;
        }
    }

    public void remove(K key) {
        if (size == 0){
            return;
        }

        if (size==1){
            setNullFirstLastNodes();
            return;
        }

        Node<K, V> findNode = getNodeByKey(key);
        if (findNode == null){
            return;
        }

        Node<K, V> prevNode = getNodeByNext(findNode);

        if (prevNode==null){
            firstNode = findNode.next;
        } else if (findNode.next==null){
            prevNode.next = null;
            lastNode = prevNode;
        } else {
            prevNode.next = findNode.next;
        }

        size--;
    }

    public void clear() {
        if (size==0){
            return;
        }

        Node<K, V> currentNode = firstNode;

        while (currentNode!=null){

            currentNode.key = null;
            currentNode.value = null;
            currentNode = currentNode.next;
        }

        setNullFirstLastNodes();
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        Node<K, V> node = getNodeByKey(key);
        if (node == null) {
            return null;
        }
        return node.value;

    }


    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }

        StringJoiner res = new StringJoiner(",");
        res.add(firstNode.toString());

        Node<K, V> node = firstNode.next;
        while (node != null) {
            res.add(node.toString());
            node = node.next;
        }
        return "{" + res + "}";
    }


    private static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }


        Node(K element) {
            this.key = element;
        }

        @Override
        public String toString() {
            return "[key-" + key + ", value-" + value + "]";
        }
    }
}
