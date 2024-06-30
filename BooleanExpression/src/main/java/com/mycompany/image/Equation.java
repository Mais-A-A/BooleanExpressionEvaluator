

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.image;

//import static com.mycompany.maisarafeh.BinaryOperator.applyOp;
//import static com.mycompany.maisarafeh.BinaryOperator.hasPrecedence;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author MAIS
 */
public class  Equation {
    
    private static Stack<Integer> values = new Stack<Integer>();
    private static Stack<Character> ops = new Stack<Character>();
    private static char[] arr ;
    private static int num_of_expressions_in_file=0;
    public static String expression ;
           
    Equation(){
        num_of_expressions_in_file ++;
    }
    Equation(String expression){
        num_of_expressions_in_file++;
        this.expression = expression;
        arr = expression.toCharArray();
    }
    // here are the setters and getters :: 
    public static void setValues(Stack<Integer> values) {
        Equation.values = values;
    }

    public static void setOps(Stack<Character> ops) {
        Equation.ops = ops;
    }

    public static void setArr(char[] arr) {
        Equation.arr = arr;
    }

    public static Stack<Integer> getValues() {
        return values;
    }

    public static Stack<Character> getOps() {
        return ops;
    }

    public static char[] getArr() {
        return arr;
    }

    public static int getNum_of_expressions_in_file() {
        return num_of_expressions_in_file;
    }
    public  String getExpression(){
        return expression;
    }
    public  int evaluate(){
            
            // Stack for numbers  // Stack for Operators
            Stack<Integer> values = new Stack<Integer>();
            Stack<Character> ops = new Stack<Character>();

            for (int i = 0; i < arr.length; i++)
            {
                    if (arr[i] == ' ')
                            continue;
                    
                    if(arr[i]=='1'||arr[i]=='0'){
                        values.push(arr[i]-'0');
                    }
                    else if (arr[i] == '(')
                            ops.push(arr[i]);
                    else if (arr[i] == ')')
                    {
                            while (ops.peek() != '(')
                            values.push(BinaryOperator.applyOp(ops.pop(),values.pop(),values.pop()));
                            ops.pop();
                    } 
                    else if(arr[i]=='~'){
                            ++i;
                           int newValue = UnaryOperator.evaluate(arr[i]-'0');
                           values.push(newValue);
                    }
                    else if (arr[i] == '+' || arr[i] == '.' )
                    {
                            while (!ops.empty() && 
                                    BinaryOperator.hasPrecedence(arr[i], ops.peek()))
                            values.push(BinaryOperator.applyOp(ops.pop(),values.pop(),values.pop()));

                            ops.push(arr[i]);
                    }
            }
            while (!ops.empty())
                    values.push(BinaryOperator.applyOp(ops.pop(), values.pop(),values.pop()));
            return values.pop();
    }

    
}
