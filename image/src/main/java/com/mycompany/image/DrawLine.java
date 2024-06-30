/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import javax.swing.JComponent;

/**
 *
 * @author MAIS
 */
public class DrawLine extends JComponent{ // color --> 0 stands for RED 
    
    private int x;
    private int y;
    private char ch;
    private boolean notFlag= false;
    private boolean colorFlag;  // 0 >> RED // 1 >> BLUE
    private boolean initialLine;
    public DrawLine(boolean initialLine,boolean colorFlag,boolean notFlag ,char ch,int x,int y){
        //System.out.println("Mais ");
        this.x = x;
        this.y = y;
        this.ch = ch;
        this.notFlag = notFlag;
        this.colorFlag = colorFlag;
        this.initialLine=initialLine;
    }
    @Override
    protected void paintComponent(Graphics g) {
        //System.out.println("Mais Arafeh 99");
        g.setFont(new java.awt.Font("Arial", 1, 17));
        if(colorFlag==true) g.setColor(new Color(76,153,0));
        else g.setColor(Color.red);
        if(initialLine == true){
            if(notFlag==true){
                //System.out.println(this.y);
                g.drawString("~"+ch+"", 20, y);
                g.drawLine(50+60,y,110+60,y);
            }
            else if(ch>='a'&&ch<='z'){
                //System.out.println(this.y);
                g.drawString(ch+"", 27, y);
                g.drawLine(50,y,110+60,y);
            }
        }else {
            g.drawLine(170,y,170+60+70+10,y); // this coordinates from my calculations
        }
    }
      
}
