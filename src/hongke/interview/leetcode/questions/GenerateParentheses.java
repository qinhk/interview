package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.Stack;

/*
 *
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class GenerateParentheses {
	
	ArrayList<String> results = new ArrayList<String>();
	
    public ArrayList<String> generateParenthesis(int n) {
    	if (n <= 0) {
    		return results;
    	}
    	
    	Stack<String> s = new Stack<String>();
    	generate(n, n, s);
        return results;
    }
    
    private void generate(int open, int close, Stack<String> s) {
    	if (open == 0 && close == 0) {
    		StringBuilder sb = new StringBuilder();
    		for (String p : s) {
    			sb.append(p);
    		}
    		results.add(sb.toString());
    	}
    	else {
    		if (open > 0) {
    			s.push("(");
    			generate(open - 1, close, s);
    			s.pop();
    		}
    		
    		if (open < close && close > 0) {
    			s.push(")");
    			generate(open, close - 1, s);
    			s.pop();
    		}
    	}
    }
    
	public static void main(String[] args) {
		GenerateParentheses test = new GenerateParentheses();
		System.out.println(test.generateParenthesis(-1));
		System.out.println(test.generateParenthesis(0));
		System.out.println(test.generateParenthesis(3));
		System.out.println(test.generateParenthesis(10));
	}

}
