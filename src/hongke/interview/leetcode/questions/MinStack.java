package hongke.interview.leetcode.questions;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by hongke on 11/9/14.
 */
public class MinStack<T extends Comparable> {

    private Stack<T> stack;

    private Stack<T> min;

    public MinStack() {
        stack = new Stack<T>();
        min = new Stack<T>();
    }

    public void push(T t) {
        assert t != null;
        stack.push(t);
        if (min.isEmpty() || t.compareTo(min.peek()) <= 0) {
            min.push(t);
        }
    }

    public T pop() {
        if (stack.size() == 0) {
            throw new EmptyStackException();
        }
        T t = stack.pop();
        if (!min.isEmpty() && min.peek().compareTo(t) == 0) {
            min.pop();
        }
        return t;
    }

    public T getMin() {
        if (stack.size() == 0) {
            throw new EmptyStackException();
        }

        return min.peek();
    }

    public T top() {
        if (stack.size() == 0) {
            throw new EmptyStackException();
        }
        return stack.peek();
    }
}
