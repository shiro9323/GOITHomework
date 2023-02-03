package module9;
import java.util.Objects;
import java.util.StringJoiner;

public class MyHashMap<K, V> {

    private int size;
    private Node<K, V> firstNode;

    Node<K,V>[] table = new Node[10];

    private void setNullFirstLastNodes(){
        firstNode = null;
        size = 0;
    }

    public void put(K key, V value) {
        /*if (get(key) == null) {
            int hash = hash(key);
            Node<K, V> node = new Node<>(hash, key, value, null);

            if (size == 0) {
                firstNode = node;
            } else {
                lastNode.next = node;
            }
            lastNode = node;

            size++;
        }*/
        int hash = hash(key);
        Node<K, V>[] tab = table;
        int n = table.length;
        int i = (n - 1) & hash;
        Node<K, V> node, e;
        node = tab[i];
        if (tab[i] == null) {
            tab[i] = new Node<>(hash, key, value, null);
            size++;
        } else {
            for (int count = 0; ; ++count) {
                if (node.hash == hash && Objects.equals(node.key, key)) {
                    node.value = value;
                    break;
                }
                if ((e = node.next) == null) {
                    node.next = new Node<>(hash, key, value, null);
                    size++;
                    break;
                }
                node = e;
            }


        }
    }

    public void remove(K key) {
        /*if (size == 0){
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

        size--;*/
        int hash=hash(key);

        if(table[hash] == null){
            return;
        }

        Node<K,V> previous = null;
        Node<K,V> current = table[hash];

        while(current != null){
            if(current.key.equals(key)){
                if(previous==null){
                    table[hash]=table[hash].next;
                    return;
                }
                    else{
                        previous.next=current.next;
                        return;
                    }
            }
            previous = current;
            current = current.next;
            size--;
        }
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
        /*Node<K, V> node = getNodeByKey(key);
        if (node == null) {
            return null;
        }
        return node.value;*/

        int hash = hash(key);
        if(table[hash] == null){
            return null;
        }else{
            Node<K,V> temp = table[hash];
            while(temp!= null){
                if(temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }

    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % 10;
    }


    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }

        StringJoiner res = new StringJoiner(",");

        for (Node<K, V> str : table) {
            if (str != null) {
                Node<K, V> current = str;
                res.add(current.toString());
                while (current.next != null) {
                    res.add(current.next.toString());
                    current = current.next;
                }
            }
        }
        return "{" + res + "}";
    }


    private static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[key-" + key + ", value-" + value + "]";
        }
    }
}
