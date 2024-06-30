/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.image;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author MAIS
 */
public class AndConnectors extends JComponent{ // color --> 0 stands for RED 
    private int x;
    private int y;
    private boolean colorFlag;
    private boolean left ; 
    
    public AndConnectors(int x,int y,boolean colorFlag,boolean left){
        this.x=x;
        this.y=y;
        this.colorFlag=colorFlag;
        this.left=left; // if left == true الخط نازل
    }
    @Override
    protected void paintComponent(Graphics g) {
        if(colorFlag==false){
            g.setColor(Color.red);
        } else{
            g.setColor(new Color(76,153,0));
        }
        g.setFont(new java.awt.Font("Arial", 1, 17));
        if(left == true ){ // خط نازل
            g.drawLine(x, y, x+60, y+25);
        } else{
            g.drawLine(x, y, x+60, y-25);
        }
    }
}
