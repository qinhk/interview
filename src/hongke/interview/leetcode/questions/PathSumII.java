package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hongke on 8/24/14.
 */
public class PathSumII {
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        if (root == null) {
            return null;
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root, last = null;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode current = stack.peek();
                if (current.right != null && last != current.right) {
                    node = current.right;
                } else {
                    if (stack.peek().left == null && stack.peek().right == null) {
                        int pathSum = 0;
                        for (TreeNode t : stack) {
                            pathSum += t.val;
                        }
                        if (sum == pathSum) {
                            List result = new ArrayList();
                            for (TreeNode t : stack) {
                                result.add(t.val);
                            }
                            results.add(result);
                        }
                    }

                    last = stack.pop();
                }
            }
        }
        return results;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                root = root.left;
            } else {
                if (stack.peek().right != null && stack.peek().right != prev) {
                    root = stack.peek().right;
                } else {
                    if (stack.peek().right == null
                            && stack.peek().left == null
                            && sum(stack) == sum) {
                        List<Integer> path = new ArrayList<Integer>();
                        for (TreeNode node : stack) {
                            path.add(node.val);
                        }
                        result.add(path);
                    }
                    prev = stack.pop();
                }
            }
        }
        return result;
    }

    private int sum(Stack<TreeNode> stack) {
        int sum = 0;
        for (TreeNode node : stack) {
            sum += node.val;
        }
        return sum;
    }

    public static void main (String[] args) {
        PathSumII test = new PathSumII();
        TreeNode input;
        input = new TreeNode(1);
//        input.left = null;
//        input.right = new TreeNode(-1);
        System.out.println(test.pathSum(input, 1));
    }
}
