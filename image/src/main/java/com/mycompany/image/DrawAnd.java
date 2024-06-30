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
public class DrawAnd extends JComponent{
    private int x;
    private int y;
    private boolean colorFlag;
    
    public DrawAnd(int x,int y,boolean colorFlag){
        this.x = x;
        this.y = y;
        this.colorFlag = colorFlag;
    }

    @Override
//    protected 
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        
        Path2D.Double point = new Path2D.Double ();
        point.moveTo(x,y); // x,y  
        point.lineTo(x,y+50+10); //x+50,x+25
        g2d.draw(point);
        
        Path2D.Double curve = new Path2D.Double ();
        curve.moveTo(x,y); // x,y
        curve.curveTo(x+55+10,y+10,x+55+10,y+40+10,x,y+50+10); // x,y+50   
        g2d.draw(curve);
        
        if(colorFlag == false) g2d.setColor(Color.red);
        else g2d.setColor(new Color(76,153,0));
        
        g2d.drawLine(x+50,y+23,x+50+10+20,y+23);
    }
}
