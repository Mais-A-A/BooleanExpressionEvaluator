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
public class Or extends BinaryOperator {
    int leftVariable,rightVariable;
    
    public Or(String expression) {
        super(expression);
    }

    public Or(String expression,int leftVariable, int rightVariable) {
        super(expression);
        this.leftVariable = leftVariable;
        this.rightVariable = rightVariable;
    }

    @Override
    public int evaluate() {
        return leftVariable|rightVariable;
    }
    
    
}

