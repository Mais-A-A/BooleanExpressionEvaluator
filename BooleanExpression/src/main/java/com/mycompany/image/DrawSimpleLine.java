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
public class DrawSimpleLine extends JComponent {
    private int x,y;
    private boolean colorFlag;
    
    public DrawSimpleLine(int x, int y ,boolean colorFlag){
        this.x = x;
        this.y = y;
        this.colorFlag = colorFlag;
    }
    @Override
    protected void paintComponent(Graphics g) {
        if(colorFlag == false) g.setColor(Color.red);
        else g.setColor(new Color(76,153,0));
        g.drawLine(x, y, x+50+60+30, y);
    }
    
}
