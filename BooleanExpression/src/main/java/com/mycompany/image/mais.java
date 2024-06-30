package com.mycompany.image;
import java.io.*;
import java.util.*;


public class mais {
    
            public int expressionAnalysis(String values,String exp){

                String vv=""; // values without spaces 
                for(int i=0;i<values.length();i++){
                    if(values.charAt(i)=='1'||values.charAt(i)=='0'){
                        vv+=values.charAt(i);
                    }
                }
                
                int cnt=0;
                String expression ="";// values with ~ . + and binary numbers 1, 0
                for(int i=0;i<exp.length();i++){
                    if(exp.charAt(i)>='a'&&exp.charAt(i)<='z'){
                        expression+=vv.charAt(cnt);
                        cnt++;
                    }else expression+=exp.charAt(i);// + . ~
                }
                //System.out.println(expression);
                
                Equation solve = new Equation(expression);
                return solve.evaluate();
            }

}
