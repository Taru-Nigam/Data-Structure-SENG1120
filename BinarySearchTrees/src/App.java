import java.util.Iterator;

/**
 * This class demonstrates the use of a binary search tree with student records.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 01 May 2025
 */
public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTreeADT<Integer, Student> tree = new LinkedBinarySearchTree<>();
        initialise(tree);

        // Print the tree using different traversal methods/iterators
        // Inorder 
        System.out.print("Inorder Traversal: ");
        Iterator<Student> iterator = tree.inorderIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.print(student + " ");
        }

        // Preorder
        System.out.println();
        System.out.print("Preorder Traversal: ");
        iterator = tree.preorderIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.print(student + " ");
        }

        // Postorder
        System.out.println();
        System.out.print("Postorder Traversal: ");
        iterator = tree.postorderIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.print(student + " ");
        }

        // Perform some other operations
        System.out.println();
        System.out.println();
        System.out.println("Size: " + tree.size());
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());

        // Check if a key exists
        System.out.println();
        System.out.println("Contains 178: " + tree.contains(542));
        System.out.println("Contains 999: " + tree.contains(999));

        // Remove some elements, then print the tree
        System.out.println();
        tree.remove(542);
        System.out.println("Tree (542 removed): " + tree);

        tree.remove(713);
        System.out.println("Tree (713 removed): " + tree);

        tree.remove(178);
        System.out.println("Tree (178 removed): " + tree);

        tree.remove(456);
        System.out.println("Tree (456 removed): " + tree);

        tree.remove(206);
        System.out.println("Tree (206 removed): " + tree);
        System.out.println();

        System.out.println("Min (empty tree): " + tree.findMin());
        System.out.println("Max (empty tree): " + tree.findMin());

    }

    /**
     * Initialises the binary search tree with some student records.
     * @param tree the binary search tree to initialise
     */
    private static void initialise(BinarySearchTreeADT<Integer, Student> tree){
        Student s = new Student(456, "Malik");
        tree.insert(s.getId(), s);

        s = new Student(713, "Mei");
        tree.insert(s.getId(), s);

        s = new Student(178, "Leila");
        tree.insert(s.getId(), s);

        s = new Student(542, "Raj");
        tree.insert(s.getId(), s);

        s = new Student(206, "Amir");
        tree.insert(s.getId(), s);
    }
}
