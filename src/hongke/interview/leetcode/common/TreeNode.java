package hongke.interview.leetcode.common;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by hongke on 3/8/14.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public void setLeft(TreeNode t) {
        left = t;
    }

    public void setRight(TreeNode t) {
        right = t;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    // Search for the deepest part of the tree
    private static int maxHeight(TreeNode t) {
        if (t == null) return 0;
        int leftHeight = maxHeight(t.getLeft());
        int rightHeight = maxHeight(t.getRight());
        return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
    }

    public static void printPretty(TreeNode tree) {
        printPretty(tree, 2, 0, new PaddedWriter(System.out));
    }

    // Pretty formatting of a binary tree to the output stream
    public static void printPretty(TreeNode tree, int level, int indentSpace, PaddedWriter out) {
        int h = maxHeight(tree);
        int nodesInThisLevel = 1;
        int branchLen = 2 * ((int) Math.pow(2.0, h) - 1) - (3 - level) * (int) Math.pow(2.0, h - 1);
        int nodeSpaceLen = 2 + (level + 1) * (int) Math.pow(2.0, h);
        int startLen = branchLen + (3 - level) + indentSpace;

        Deque<TreeNode> nodesQueue = new LinkedList<TreeNode>();
        nodesQueue.offerLast(tree);
        for (int r = 1; r < h; r++) {
            printBranches(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue, out);
            branchLen = branchLen / 2 - 1;
            nodeSpaceLen = nodeSpaceLen / 2 + 1;
            startLen = branchLen + (3 - level) + indentSpace;
            printNodes(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue, out);

            for (int i = 0; i < nodesInThisLevel; i++) {
                TreeNode currNode = nodesQueue.pollFirst();
                if (currNode != null) {
                    nodesQueue.offerLast(currNode.getLeft());
                    nodesQueue.offerLast(currNode.getRight());
                } else {
                    nodesQueue.offerLast(null);
                    nodesQueue.offerLast(null);
                }
            }
            nodesInThisLevel *= 2;
        }
        printBranches(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue, out);
        printLeaves(indentSpace, level, nodesInThisLevel, nodesQueue, out);
    }

    private static void printBranches(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, Deque<TreeNode> nodesQueue, PaddedWriter out) {
        Iterator<TreeNode> iterator = nodesQueue.iterator();
        for (int i = 0; i < nodesInThisLevel / 2; i++) {
            if (i == 0) {
                out.setw(startLen - 1);
            } else {
                out.setw(nodeSpaceLen - 2);
            }
            out.write();
            TreeNode next = iterator.next();
            if (next != null) {
                out.write("/");
            } else {
                out.write(" ");
            }
            out.setw(2 * branchLen + 2);
            out.write();
            next = iterator.next();
            if (next != null) {
                out.write("\\");
            } else {
                out.write(" ");
            }
        }
        out.endl();
    }

    // Print the branches and node (eg, ___10___ )
    private static void printNodes(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, Deque<TreeNode> nodesQueue, PaddedWriter out) {
        Iterator<TreeNode> iterator = nodesQueue.iterator();
        TreeNode currentNode;
        for (int i = 0; i < nodesInThisLevel; i++) {
            currentNode = iterator.next();
            if (i == 0) {
                out.setw(startLen);
            } else {
                out.setw(nodeSpaceLen);
            }
            out.write();
            if (currentNode != null && currentNode.getLeft() != null) {
                out.setfill('_');
            } else {
                out.setfill(' ');
            }
            out.setw(branchLen + 2);
            if (currentNode != null) {
                out.write(currentNode.toString());
            } else {
                out.write();
            }
            if (currentNode != null && currentNode.getRight() != null) {
                out.setfill('_');
            } else {
                out.setfill(' ');
            }
            out.setw(branchLen);
            out.write();
            out.setfill(' ');
        }
        out.endl();
    }

    // Print the leaves only (just for the bottom row)
    private static void printLeaves(int indentSpace, int level, int nodesInThisLevel, Deque<TreeNode> nodesQueue, PaddedWriter out) {
        Iterator<TreeNode> iterator = nodesQueue.iterator();
        TreeNode currentNode;
        for (int i = 0; i < nodesInThisLevel; i++) {
            currentNode = iterator.next();
            if (i == 0) {
                out.setw(indentSpace + 2);
            } else {
                out.setw(2 * level + 2);
            }
            if (currentNode != null) {
                out.write(currentNode.toString());
            } else {
                out.write();
            }
        }
        out.endl();
    }

    static class PaddedWriter {
        private int width = 0;
        private char fillChar = ' ';
        private final PrintStream writer;

        public PaddedWriter(PrintStream writer) {
            this.writer = writer;
        }

        void setw(int i) {
            width = i;
        }

        void setfill(char c) {
            fillChar = c;
        }

        void write(String str) {
            write(str.toCharArray());
        }

        void write(char[] buf) {
            if (buf.length < width) {
                char[] pad = new char[width - buf.length];
                Arrays.fill(pad, fillChar);
                writer.print(pad);
            }
            writer.print(buf);
            setw(0);
        }

        void write() {
            char[] pad = new char[width];
            Arrays.fill(pad, fillChar);
            writer.print(pad);
            setw(0);
        }

        void endl() {
            writer.println();
            setw(0);
        }
    }

}
