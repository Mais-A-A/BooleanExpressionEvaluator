/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import javax.swing.JComponent;

/**
 *
 * @author MAIS
 */
public class DrawOr extends JComponent{
    private int x ,y ;
    private int y1, y2;
    private boolean LeftcolorFlag,rightcolorFlag; 
     
    public DrawOr(int x,Struct s1,Struct s2){
        this.x = x+50;
        this.y1 = s1.y;   this.LeftcolorFlag = s1.colorFlag;
        this.y2 = s2.y;   this.rightcolorFlag = s2.colorFlag;
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        
        y = (y2-y1)/2 - 25+y1;
        
        if(LeftcolorFlag == false)g2d.setColor(Color.red);
        else g2d.setColor(new Color(76,153,0));
        g.drawLine(x-50,y1,x-50+60,y+23);
        
        if(rightcolorFlag == false)g2d.setColor(Color.red);
        else g2d.setColor(new Color(76,153,0));
        g.drawLine(x-50,y2,x-50+60,y+28);
         
        Path2D.Double curve = new Path2D.Double ();
        //x+=50;  // ensure fron this
        
        g2d.setColor(Color.black);
        curve.moveTo(x,y); // x,y
        curve.curveTo(x+15,y+10,x+15,y+40,x,y+50); // x,y+50   
        g2d.draw(curve);
        Path2D.Double point = new Path2D.Double ();
        point.moveTo(x,y); // x,y  
        point.lineTo(x+50,y+25); //x+50,x+25
        point.lineTo(x,y+50); //x+50,x+25
        g2d.draw(point);
        
        if(LeftcolorFlag == false && rightcolorFlag == false){
            g2d.setColor(Color.red);
        } else g2d.setColor(new Color(76,153,0));
        
        g.drawLine(x+50,y+25,x+60+30,y+25);
        
        
        /*
        ----
                    *
                         *

                         *
                    *
        ----
        
        */
    }
    public Struct getStruct(){
        boolean color ;
        y = (y2-y1)/2 - 25+y1;
        if(LeftcolorFlag == false && rightcolorFlag == false) color = false;
        else color = true;
        Struct s = new Struct(this.y+25,color);
        return s;
    }
    
}
