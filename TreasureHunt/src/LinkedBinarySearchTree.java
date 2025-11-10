import java.util.Iterator;
import java.util.LinkedList;

/**
 * Implementation of a binary search tree using linked nodes.
 * Supports insertion, removal, search, and various traversals.
 *
 * @author Taru Nigam
 * @studentNo c3509116
 * @date 11 Nov 2025
 * @description Implements BinarySearchTreeADT with recursive operations and iterators for traversals.
 */
public class LinkedBinarySearchTree<K extends Comparable<K>, V> implements BinarySearchTreeADT<K, V> {
    private BinaryNode root;
    private int size;

    /**
     * Nested class for tree nodes.
     */
    private class BinaryNode {
        K key;
        V value;
        BinaryNode left, right;

        BinaryNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Inserts a key-value pair into the tree.
     * If key exists, updates the value.
     */
    @Override
    public void insert(K key, V value) {
        root = insertRec(root, key, value);
        size++;
    }

    private BinaryNode insertRec(BinaryNode node, K key, V value) {
        if (node == null) return new BinaryNode(key, value);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = insertRec(node.left, key, value);
        else if (cmp > 0) node.right = insertRec(node.right, key, value);
        else node.value = value; // Update value if key exists
        return node;
    }

    /**
     * Removes the key-value pair with the given key.
     */
    @Override
    public void remove(K key) {
        root = removeRec(root, key);
        if (root != null) size--;
    }

    private BinaryNode removeRec(BinaryNode node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = removeRec(node.left, key);
        else if (cmp > 0) node.right = removeRec(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            BinaryNode successor = findMinNode(node.right);
            node.key = successor.key;
            node.value = successor.value;
            node.right = removeRec(node.right, successor.key);
        }
        return node;
    }

    private BinaryNode findMinNode(BinaryNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    /**
     * Checks if the tree contains the key.
     */
    @Override
    public boolean contains(K key) {
        return find(key) != null;
    }

    /**
     * Finds the value for the given key.
     */
    @Override
    public V find(K key) {
        return findRec(root, key);
    }

    private V findRec(BinaryNode node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return findRec(node.left, key);
        else if (cmp > 0) return findRec(node.right, key);
        else return node.value;
    }

    /**
     * Finds the minimum value.
     */
    @Override
    public V findMin() {
        if (root == null) return null;
        BinaryNode min = findMinNode(root);
        return min.value;
    }

    /**
     * Finds the maximum value.
     */
    @Override
    public V findMax() {
        if (root == null) return null;
        BinaryNode node = root;
        while (node.right != null) node = node.right;
        return node.value;
    }

    /**
     * Returns inorder iterator (default).
     */
    @Override
    public Iterator<V> iterator() {
        return inorderIterator();
    }

    /**
     * Returns inorder iterator.
     */
    @Override
    public Iterator<V> inorderIterator() {
        LinkedList<V> list = new LinkedList<>();
        inorderRec(root, list);
        return new TreeIterator(list.iterator());
    }

    private void inorderRec(BinaryNode node, LinkedList<V> list) {
        if (node != null) {
            inorderRec(node.left, list);
            list.add(node.value);
            inorderRec(node.right, list);
        }
    }

    /**
     * Returns preorder iterator.
     */
    @Override
    public Iterator<V> preorderIterator() {
        LinkedList<V> list = new LinkedList<>();
        preorderRec(root, list);
        return new TreeIterator(list.iterator());
    }

    private void preorderRec(BinaryNode node, LinkedList<V> list) {
        if (node != null) {
            list.add(node.value);
            preorderRec(node.left, list);
            preorderRec(node.right, list);
        }
    }

    /**
     * Returns postorder iterator.
     */
    @Override
    public Iterator<V> postorderIterator() {
        LinkedList<V> list = new LinkedList<>();
        postorderRec(root, list);
        return new TreeIterator(list.iterator());
    }

    private void postorderRec(BinaryNode node, LinkedList<V> list) {
        if (node != null) {
            postorderRec(node.left, list);
            postorderRec(node.right, list);
            list.add(node.value);
        }
    }

    /**
     * Checks if tree is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns size of tree.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Clears the tree.
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Nested iterator class.
     */
    private class TreeIterator implements Iterator<V> {
        private Iterator<V> iter;

        TreeIterator(Iterator<V> iter) {
            this.iter = iter;
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public V next() {
            return iter.next();
        }
    }
}