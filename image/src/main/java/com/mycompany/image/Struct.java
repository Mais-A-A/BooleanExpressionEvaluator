/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.image;

/**
 *
 * @author MAIS
 */
public class Struct {
    public int y;         
    public boolean colorFlag;  // if it is 0 then its false RED otherwise its GREEN
    
    public Struct(int y,boolean colorFlag){
        this.y = y ;
        this.colorFlag = colorFlag;
    }
}
