import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class implements a binary search tree using linked nodes.
 *
 * @author <your name>
 * @version 1.0, <date>
 */
public class LinkedBinarySearchTree<K extends Comparable<K>, V> implements BinarySearchTreeADT<K, V> {

    /**
     * A node in a binary tree. This is a private inner class, which means it can only be
     * accessed from within the LinkedBinarySearchTree class.
     * Each node contains a key-value pair and references to its left and right children.
     */
    private class BinaryNode {
        KeyValueEntry<K, V> element; // The data in the node
        BinaryNode left; // Left child
        BinaryNode right; // Right child

        /**
         * Constructs a new BinaryNode with the given element.
         * The left and right children are initialised to null.
         * @param element the element to be stored in the node
         */
        BinaryNode(KeyValueEntry<K, V> element) {
            this.element = element;
            left = null;
            right = null;
        }
    }

    private BinaryNode root;
    private int size;

    public LinkedBinarySearchTree() {
        root = null;
        size = 0;
    }

    @Override
    public void insert(K key, V value) {
        root = insert(root, key, value);
        size++;
    }

    private BinaryNode insert(BinaryNode node, K key, V value) {
        if (node == null) {
            return new BinaryNode(new KeyValueEntry<>(key, value));
        }
        int cmp = key.compareTo(node.element.getKey());
        if (cmp < 0) {
            node.left = insert(node.left, key, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, key, value);
        } else {
            // Update value for existing key
            node.element = new KeyValueEntry<>(key, value);
            size--; // Don't increment size for updates
        }
        return node;
    }

    @Override
    public void remove(K key) {
        root = remove(root, key);
    }

    private BinaryNode remove(BinaryNode node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.element.getKey());
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            size--;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            // Two children: replace with min in right subtree
            BinaryNode minNode = findMinNode(node.right);
            node.element = minNode.element;
            node.right = remove(node.right, minNode.element.getKey());
        }
        return node;
    }

    @Override
    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(BinaryNode node, K key) {
        if (node == null) return false;
        int cmp = key.compareTo(node.element.getKey());
        if (cmp < 0) return contains(node.left, key);
        if (cmp > 0) return contains(node.right, key);
        return true;
    }

    @Override
    public V find(K key) {
        return find(root, key);
    }

    private V find(BinaryNode node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.element.getKey());
        if (cmp < 0) return find(node.left, key);
        if (cmp > 0) return find(node.right, key);
        return node.element.getValue();
    }

    @Override
    public V findMin() {
        if (root == null) return null;
        BinaryNode minNode = findMinNode(root);
        return minNode.element.getValue();
    }

    private BinaryNode findMinNode(BinaryNode node) {
        if (node.left == null) return node;
        return findMinNode(node.left);
    }

    @Override
    public V findMax() {
        if (root == null) return null;
        BinaryNode maxNode = findMaxNode(root);
        return maxNode.element.getValue();
    }

    private BinaryNode findMaxNode(BinaryNode node) {
        if (node.right == null) return node;
        return findMaxNode(node.right);
    }

    @Override
    public Iterator<V> iterator() {
        // Default to in-order
        return inorderIterator();
    }

    @Override
    public Iterator<V> inorderIterator() {
        List<V> list = new ArrayList<>();
        inorder(root, list);
        return list.iterator();
    }

    private void inorder(BinaryNode node, List<V> list) {
        if (node != null) {
            inorder(node.left, list);
            list.add(node.element.getValue());
            inorder(node.right, list);
        }
    }

    @Override
    public Iterator<V> preorderIterator() {
        List<V> list = new ArrayList<>();
        preorder(root, list);
        return list.iterator();
    }

    private void preorder(BinaryNode node, List<V> list) {
        if (node != null) {
            list.add(node.element.getValue());
            preorder(node.left, list);
            preorder(node.right, list);
        }
    }

    @Override
    public Iterator<V> postorderIterator() {
        List<V> list = new ArrayList<>();
        postorder(root, list);
        return list.iterator();
    }

    private void postorder(BinaryNode node, List<V> list) {
        if (node != null) {
            postorder(node.left, list);
            postorder(node.right, list);
            list.add(node.element.getValue());
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inorderToString(root, sb);
        return sb.toString().trim(); // Trim trailing space
    }

    private void inorderToString(BinaryNode node, StringBuilder sb) {
        if (node != null) {
            inorderToString(node.left, sb);
            sb.append(node.element.getValue()).append(" ");
            inorderToString(node.right, sb);
        }
    }
}