package hongke.interview.misc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by hongke on 2/1/15.
 *
 *
     EXPRESSION = VALUE_EXPRESSION |
     BINARY_EXPRESSION |
     PARENTHESIZED_EXPRESSION

     VALUE_EXPRESSION = number

     BINARY_EXPRESSION = EXPRESSION BINARY_OPERATOR EXPRESSION

     BINARY_OPERATOR = "+" | "-"

     PARENTHESIZED_EXPRESSION = "(" EXPRESSION ")"
 */
public class SimpleParser {
    private static class Tokenizer {

        public static Deque<String> tokenize(String input) {
            return new ArrayDeque<String>(Arrays.asList(input.replace("\\ +", " ").split(" ")));
        }

    }

    interface Expression {
        int evaluate();
    }

    private static class Operand implements Expression {
        int value;

        Operand(int value) {this.value = value;}

        public int evaluate() {
            return value;
        }
    }

    private static class Operator implements Expression {
        Expression left;
        Expression right;
        char op;

        Operator (Expression left, Expression right, char op) {
            this.left = left;
            this.right = right;
            this.op = op;
        }

        public int evaluate() {
            switch (op) {
                case '+':
                    return left.evaluate() + right.evaluate();
                case '-':
                    return left.evaluate() - right.evaluate();
                default:
                    throw new IllegalStateException();
            }
        }
    }

    private static class ParenthesizedExpression implements Expression {
        Expression expr;
        ParenthesizedExpression (Expression expr) {this.expr = expr;}
        public int evaluate() {
            return expr.evaluate();
        }
    }

    public static Expression parse(String s) {
        Deque<String> tokens = Tokenizer.tokenize(s);
        Expression expr = parse(tokens);
        if (!tokens.isEmpty())
            throw new IllegalStateException();
        return expr;
    }

    private static Expression parse(Deque<String> tokens) {
        if (tokens.isEmpty())
            throw new IllegalStateException();

        Expression expr = null;
        if (tokens.peekFirst().equals("(")) {
            expr = parenthesis(tokens);
        } else {
            expr = number(eat(tokens));
        }

        if (!tokens.isEmpty()) {
            if (tokens.peekFirst().equals("+")) {
                expr = plus(expr, tokens);
            } else if (tokens.peekFirst().equals("-")) {
                expr = minus(expr, tokens);
            }
        }
        return expr;
    }

    private static Expression number(String num) {
        return new Operand(Integer.parseInt(num));
    }

    private static Expression plus (Expression left, Deque<String> tokens) {
        if (!"+".equals(eat(tokens))) {throw new IllegalStateException();}
        return new Operator(left, parse(tokens), '+');
    }

    private static Expression minus (Expression left, Deque<String> tokens) {
        if (!"-".equals(eat(tokens))) {throw new IllegalStateException();}
        return new Operator(left, parse(tokens), '-');
    }

    private static Expression parenthesis (Deque<String> tokens) {
        if (!"(".equals(eat(tokens))) {throw new IllegalStateException();}
        Expression expr = parse(tokens);
        if (expr == null || !")".equals(eat(tokens))) {throw new IllegalStateException();}
        return new ParenthesizedExpression(expr);
    }

    private static String eat(Deque<String> tokens) {
        return tokens.removeFirst();
    }

    public static void main(String[] args) {
        Expression expr = SimpleParser.parse("( 20 - 15 ) + 25");
        System.out.println(expr.evaluate());
        expr = SimpleParser.parse("( 25 )");
        System.out.println(expr.evaluate());
        expr = SimpleParser.parse("( ( 20 - 15 ) + 25 )");
        System.out.println(expr.evaluate());
    }

}
