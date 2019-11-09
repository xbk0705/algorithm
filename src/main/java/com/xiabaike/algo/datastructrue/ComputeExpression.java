package com.xiabaike.algo.datastructrue;

import java.util.Stack;

/**
 * 表达式计算
 *
 * @Author xiabaike
 * @Date 2019/4/14 16:15
 */
public class ComputeExpression {

    /**
     * 判断是否是操作符
     */
    private static boolean isOperator(char ch) {
        switch (ch) {
            case '#':
            case '+':
            case '-':
            case '*':
            case '/':
            case '(':
            case ')':
                return true;
            default:
                return false;
        }
    }

    /**
     * 各运算符优先级比较结果集
     * '+'、'-'、'*'、'/'、'('、')'、'#'
     */
    private static char[][] PRIORITY = {
            {'>', '>', '<', '<', '<', '>', '>'},
            {'>', '>', '<', '<', '<', '>', '>'},
            {'>', '>', '>', '>', '<', '>', '>'},
            {'>', '>', '>', '>', '<', '>', '>'},
            {'<', '<', '<', '<', '<', '=', 'E'},
            {'>', '>', '>', '>', 'E', '>', '>'},
            {'<', '<', '<', '<', '<', 'E', '='}
    };

    /**
     * 获得运算符下标
     */
    private static int getPriorityIndex(char operator) {
        int index = -1;
        switch (operator) {
            case '+':
                index = 0;
                break;
            case '-':
                index = 1;
                break;
            case '*':
                index = 2;
                break;
            case '/':
                index = 3;
                break;
            case '(':
                index = 4;
                break;
            case ')':
                index = 5;
                break;
            case '#':
                index = 6;
                break;
        }
        return index;
    }

    /**
     * 计算，根据给定的两个数及运算符
     */
    private static double compute(double num1, char operator, double num2) {
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        return result;
    }

    /**
     * 获取两个运算符的优先级
     */
    private static char getPriority(char operator1, char operator2) {
        int index1 = getPriorityIndex(operator1);
        int index2 = getPriorityIndex(operator2);
        if(index1 < 0 || index1 > 6 || index2 < 0 || index2 > 6) {
            return 'E';
        }
        return PRIORITY[index1][index2];
    }

    /**
     * 计算
     */
    public double computeExpression(char[] exp) {

        // 运算符栈
        Stack<Character> operatorStack = new Stack();
        // 操作数栈
        Stack<Double> numStack = new Stack<>();
        operatorStack.push('#');
        int i = 0;
        while (exp[i] != '#' || !operatorStack.peek().equals('#')) {
            // 判断当前字符是否为运算符
            if(!isOperator(exp[i])) {
                // 字符为操作数，则依次取得字符，构造double型数字，入操作数栈
                // 将字符转化为十进制数
                double tmp = exp[i] - '0';
                i++;
                while(!isOperator(exp[i]) && i < exp.length) {
                    tmp = tmp * 10 + exp[i] - '0';
                    i++;
                }
                numStack.push(tmp);
            } else {
                // 字符为运算符
                char operator = exp[i];
                // 判断栈顶运算符与当前运算符的优先级
                switch (getPriority(operatorStack.peek(), operator)) {
                    case '>':
                        // 栈顶优先级高，出栈，且将操作数栈出两次栈，计算结果并入操作数栈
                        char opr = operatorStack.pop();
                        double num1 = numStack.pop();
                        double num2 = numStack.pop();
                        numStack.push(compute(num2, opr, num1));
                        break;
                    case '<':
                        // 栈顶优先级低，当前运算符入栈
                        operatorStack.push(operator);
                        i++;
                        break;
                    case '=':
                        // 优先级相等，即左右括号相遇，操作数栈出栈
                        operatorStack.pop();
                        i++;
                        break;
                }
            }
        }
        return numStack.peek();
    }

    public static void main(String[] args) {

        ComputeExpression computeExpression = new ComputeExpression();
        String expression = "30*4+(8-10/5)*2#";
        char[] exps = expression.toCharArray();

        double result = computeExpression.computeExpression(exps);

        System.out.println(result);
    }

}
