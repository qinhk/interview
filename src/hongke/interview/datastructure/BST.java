package hongke.interview.datastructure;

import hongke.interview.common.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hongke on 10/26/14.
 */
public class BST<T extends Comparable<T>> {
    public class BSTNode<T> {
        T value;
        BSTNode<T> left;
        BSTNode<T> right;

        public BSTNode() {
            this(null, null, null);
        }

        public BSTNode(T value) {
            this(value, null, null);
        }

        public BSTNode(T value, BSTNode left, BSTNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public BSTNode<T> left() {
            return left;
        }

        public BSTNode<T> right() {
            return right;
        }

        public T value() {
            return value;
        }

        public void setLeft(BSTNode<T> left) {
            this.left = left;
        }

        public void setRight(BSTNode<T> right) {
            this.right = right;
        }

    }

    private BSTNode<T> root;

    private int size;

    public void put(T value) {
        if (value == null) {
            return;
        }
        if (root == null) {
            root = new BSTNode<T>(value);
        } else {
            search(value, root, true);
        }
        size += 1;

    }


    public boolean contains(T value) {
        return null == search(value, root, false);
    }

    private BSTNode search(T value, BSTNode<T> root, boolean insert) {
        if (root.value().compareTo(value) == 0) {
            return root;
        } else if (root.value().compareTo(value) > 0) {
            if (root.left() != null) {
                return search(value, root.left(), insert);
            } else if (insert) {
                root.setLeft(new BSTNode<T>(value));
                return root.left();
            } else {
                return null;
            }
        } else {
            if (root.right() != null) {
                return search(value, root.right(), insert);
            } else if (insert) {
                root.setRight(new BSTNode<T>(value));
                return root.right();
            } else {
                return null;
            }
        }
    }

    public boolean remove(T value) {
        BSTNode removed = new BSTNode();
        root = remove(value, root, removed);
        if (removed != null) {
            size -= 1;
        }
        return removed != null;
    }

    private BSTNode remove(T value, BSTNode<T> root, BSTNode<T> removed) {
        if (value == null || root == null) {
            return null;
        }

        int compare = value.compareTo(root.value());
        if (compare < 0) {
            root.left = remove(value, root.left(), removed);
        } else if (compare > 0) {
            root.right = remove(value, root.right(), removed);
        } else {
            // Single link, lean left
            if (root.right() == null) {
                return root.left();
            }
            // Single link, lean right
            if (root.left() == null) {
                return root.right();
            }

            BSTNode<T> node = root;
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            root.right = removeMin(node.right);
            root.left = node.left;
        }

        return root;
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        List<Integer> test = new ArrayList<Integer>();
        for (int i = 0; i < Constants.TEN; i++) {
            test.add(i);
        }
        Collections.shuffle(test);
        for (int i : test) {
            bst.put(i);
        }
        Collections.shuffle(test);
        for (int i : test) {
            bst.remove(i);
        }
    }

    private BSTNode<T> removeMin(BSTNode<T> root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = removeMin(root.left);
        return root;
    }


    public int size() {
        return size;
    }

    public BSTNode root() {
        return root;
    }

}
