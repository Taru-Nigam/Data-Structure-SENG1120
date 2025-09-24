import java.util.Arrays;

public class Bag <T>{
    private T[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("Unchecked")
    public Bag(){
        elements = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        if (size == elements.length){
            grow();
        }
        elements[size++]  = element;
    }
    public boolean contains(T element){
        for (int i = 0; i<size; i++){
            if (elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    @SuppressWarnings("unchecked")
    private void grow(){
        int newCapacity = elements.length*2;
        T[] newElements = (T[]) new Object[newCapacity];
        System.arraycopy(elements,0, newElements, 0, size);
        elements = newElements;
    }
    @Override
    public String toString(){
        if (size == 0) return "Bag is empty";
        StringBuilder sb = new StringBuilder("Bag Elements: ");
        for (int i = 0; i < size; i++){
            sb.append((elements[i]));
            if (i<size - 1) sb.append(", ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        bag.add("banana");
        bag.add("apples");
        bag.add("pineapples");

        System.out.println(bag);
        System.out.println("Contains 'banana'? " + bag.contains("banana"));
        System.out.println("Contains 'apples'? " + bag.contains("apples"));
        System.out.println("Contains 'grapes'? " + bag.contains("grapes"));
        System.out.println("Size: " + bag.size());
        System.out.println("Is empty? " + bag.isEmpty());

        for (int i = 0; i < 20; i++){
            bag.add("item" + i);
        }
        System.out.println("Size after adding more items " + bag.size());

    }
}
