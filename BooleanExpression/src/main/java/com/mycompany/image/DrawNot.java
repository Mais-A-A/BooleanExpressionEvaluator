/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.image;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import javax.swing.JComponent;

/**
 *
 * @author MAIS
 */
public class DrawNot extends JComponent{
    
    private int x,y;
    public DrawNot(int x,int y){
        this.x = x; 
        this.y = y;
    }
    
    protected void paintComponent(Graphics g) {
        Path2D.Double point = new Path2D.Double ();
        Graphics2D g2d = (Graphics2D) g;
        point.moveTo(x,y); // x,y
        point.lineTo(x,y+50 ); // x,y+50   triangle --> circule 
        point.lineTo(x+50,y+25); //x+50,x+25
        point.closePath(); 
        g2d.draw(point);
        Ellipse2D.Double el = new Ellipse2D.Double(x+50,y+25-5,10,10);
        g2d.draw(el);
    }
}
