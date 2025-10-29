/**
 * This class implements a basic hash table using an array of KeyValueEntry objects.
 * There is no collision resolution strategy implemented, so this hash table will not handle collisions.
 * The hash table uses a simple hash function that computes the index based on the hash code of the key.
 * 
 * @param <K> The type of keys in the hash table, which must be comparable to itself.
 * @param <V> The type of values in the hash table.
 * 
 * @author <your name here>
 * @version 1.0, <insert date here>
 */
public class BasicHashTable<K extends Comparable<K>,V> implements HashTableADT<K,V>{

    private KeyValueEntry<K, V>[] table;
    private int capacity;
    private int size;

    public BasicHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new KeyValueEntry[capacity];
        this.size = size();
    }

    @Override
    public boolean insert(K key, V value) {
        int index = Math.abs(key.hashcode()) % capacity;
        if (table[index] == null){
            table[index] == new KeyValueEntry<>(key, value);
            size++;
            return true;
        }
        return false;
    }

    @Override
    public V remove(K key) {
        int index = Math.abs(key.hashcode()) % capacity;
        if (table[index] !=null && table[index].getkey().equals(key)){
            V value = table[index].getValue();
            table[index] = null;
            size--;
            return value;
        }
        return null;
    }

    @Override
    public V get(K key) {
        int index = Math.abs(key.hashcode()) % capacity;
        if (table[index] !=null && null table[index].getkey().equals(key)){
            return table[index].getValue();
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        int index = Math.abs(key.hashcode()) % capacity;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i<capacity;i++){
            table[i]=null;
        }
        size=0;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            sb.append(i).append(": ");
            if (table[i] != null) {
                sb.append(table[i].toString());
            } else {
                sb.append("(empty)");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
