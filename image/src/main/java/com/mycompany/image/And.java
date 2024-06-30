/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.image;

import java.util.Map;

/**
 *
 * @author MAIS
 */
public class And extends BinaryOperator {
    int leftVariable,rightVariable;
    
    public And(String expression) {
        super(expression);
    }

    public And(String expression,int leftVariable, int rightVariable) {
        super(expression);
        this.leftVariable = leftVariable;
        this.rightVariable = rightVariable;
    }

    @Override
    public int evaluate() {
        return leftVariable&rightVariable;
    }

    public int getLeftVariable() {
        return leftVariable;
    }

    public void setLeftVariable(int leftVariable) {
        this.leftVariable = leftVariable;
    }

    public int getRightVariable() {
        return rightVariable;
    }

    public void setRightVariable(int rightVariable) {
        this.rightVariable = rightVariable;
    }
    
}
