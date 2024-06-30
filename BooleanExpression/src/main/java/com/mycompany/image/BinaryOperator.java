/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.image;

import java.util.Map;
import java.util.Stack;

/**
 *
 * @author MAIS
 */
public abstract class BinaryOperator extends Equation{
    int leftVariable , rightVariable;  
    
    public BinaryOperator(String expression) {
        super(expression);
    }
    
    
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '.') && (op2 == '+' ))
            return false;
        else
            return true;
    }
    
    public static int applyOp(char op,int b, int a)
    {
            switch (op)
            {
            case '+': 
                Or or = new Or(Equation.expression,a,b);
                
                return or.evaluate();
            
            case '.':
                And and = new And(Equation.expression,a,b);
                return and.evaluate();

            }
            return 0;
    }
    public abstract int evaluate(); 
    
    public void setLeftVariable(int leftVariable) {
        this.leftVariable = leftVariable;
    }

    public void setRightVariable(int rightVariable) {
        this.rightVariable = rightVariable;
    }

    public int getLeftVariable() {
        return leftVariable;
    }

    public int getRightVariable() {
        return rightVariable;
    }
}

