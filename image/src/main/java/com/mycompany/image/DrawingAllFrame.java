/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.image;

// q+~s.~t+r.~l+m.n+~z
// 1 1 0 0 0 1 0 1

import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class DrawingAllFrame extends JFrame{
    ArrayList<Struct> y1 = new ArrayList<>();
    ArrayList<Struct> y2 = new ArrayList<>();
    ArrayList<Integer> values = new ArrayList<>();
    
    private String expressionText,binaryText;
    private static int idx = 0 ,i =0;
    private int orLevels = 0 ;
    private int widthForOrLevel = 310 ;
    private int finalAnswer ;
    
    private int x=50,y=100;
    private int no_of_or_gates = 0, no_of_and_gates = 0;
    private DrawAnd and;
    private DrawOr or;
    private DrawNot not;
    private DrawLine line;
    private DrawSimpleLine simpleLine;
    private AndConnectors andConnectors ;
    
    private JPanel redPanel;
    private JPanel infoPanel; 
    private JLabel infoLabel;
    private JLabel expLabel ,expressionL;
    private JLabel biLabel ,binaryL ;
    private JLabel answerLabel ,ans;
    private JLabel andGates;
    private JLabel orGates;
    private JLabel one,two;
    private int cnt=0;
    
    // READ ME :
    // i have drawing or levels by RECURSION 
    private void drawAllOrLevels(ArrayList<Struct> y1,ArrayList<Struct> y2){
        cnt++;
        //System.out.println(cnt+" "+y1.size()+" "+y2.size());
        // Base case 
        //if(y1.size()==0&&y2.size()==0){ // end of < expression drawing >
        if(no_of_or_gates == orLevels){
            //System.out.println(orLevels+" "+cnt);
            return ;
        }
        if(y1.size()==0){
            //orLevels++;
            widthForOrLevel += 140 ;
            ArrayList<Struct> yy = new ArrayList<>();
            drawAllOrLevels(y2, yy);
        }
        if(y1.size() == 1){
            // draw line for this variable 
            int yyy = y1.get(0).y;
            boolean ccc = y1.get(0).colorFlag;
            simpleLine = new DrawSimpleLine(widthForOrLevel,yyy,ccc);
            simpleLine.setSize(1200,1200);
            redPanel.add(simpleLine);
            // MY TRACING 
            //System.out.println("Hi Mais "+y1.get(0).y+" "+y1.get(0).colorFlag);
            // ++ end of another Or level 
            //orLevels++;
            widthForOrLevel += 140 ; // esure for this 
            
            // exchange y axis for the lists 
            // clear the y2 list
            
            y2.add(y1.get(0));
            ArrayList<Struct> yy = new ArrayList<>();
            //y1 = yy ;
            
            drawAllOrLevels(y2, yy); // back to or levels
        }
        if(y1.size()>=2){
            or = new DrawOr(widthForOrLevel,y1.get(0),y1.get(1));
            or.setSize(2000000000,2000000000);
            redPanel.add(or);
            orLevels++;
            Struct s = or.getStruct();
            //System.out.println("Or STRUCT "+s.y+" "+s.colorFlag);
            y2.add(s);
            y1.remove(0); 
            y1.remove(0);
            
            drawAllOrLevels(y1,y2);
        }
    }
    private void valueTextActionPerformed() {                                          
        String val = binaryText;
        String exp = expressionText;
        int index_for_values=0;
         // false>> 0 >> red otherwise it 1 blue
         
         // this loop is for drawing lines / not gates 
        int not_notations=0;
        for(int i=0;i<exp.length();i++){
            
            boolean colorFlag = false;
            char ch = exp.charAt(i);
            if(exp.charAt(i)=='.') no_of_and_gates++;
            if(exp.charAt(i)=='+') no_of_or_gates++;
            if(exp.charAt(i)=='~') not_notations++;
            
            if(ch>='a'&&ch<='z'){
                int value = Integer.parseInt(val.charAt(index_for_values)+"");
                index_for_values+=2;
                if(value==1){
                    colorFlag = true;
                }
                if(i-1>=0&&exp.charAt(i-1)=='~'){
                    colorFlag = !colorFlag;
                    not = new DrawNot(50,y-25);
                    not.setSize(2000000000,2000000000);
                    redPanel.add(not);
                    line = new DrawLine(true,colorFlag,true,exp.charAt(i),x,y);
                    line.setSize(1200,1200);
                    redPanel.add(line);
                }
                else {
                    line = new DrawLine(true,colorFlag,false,exp.charAt(i),x,y);
                    line.setSize(1200,1200);
                    redPanel.add(line);
                }
                if(i+1<exp.length()&&exp.charAt(i+1)=='.'){ // q. خط نازل 
                   andConnectors = new AndConnectors(170, y, colorFlag, true);
                   andConnectors.setSize(1200,1200);
                   redPanel.add(andConnectors);
                   
                   colorFlag=false;
                   if( colorFlag == true&&
                       i+2<=exp.length() &&
                       val.charAt(i+2-not_notations)==1){
                       colorFlag = true;
                   } 
                   if( colorFlag == true&&
                       i+2<=exp.length() &&
                       exp.charAt(i+2)=='~'&&
                       val.charAt(i+3-not_notations)=='1'){
                       colorFlag = false;
                   } 
                   Struct s = new Struct(y+28,colorFlag);
                   y1.add(s); // add y axis for (after and gates) 
                }
                else if((i-1>=0&&exp.charAt(i-1)=='.')||(i-2>=0&&exp.charAt(i-2)=='.')){ // .q
                    andConnectors = new AndConnectors(170, y, colorFlag, false);
                    andConnectors.setSize(1200,1200);
                    redPanel.add(andConnectors);
                    
//                    Struct s = new Struct(y+27,colorFlag);
//                   y1.add(s); // add y axis for (after and gates) 
                }
                else {
                    line = new DrawLine(false,colorFlag,false,exp.charAt(i),x,y);
                    line.setSize(2000000000,2000000000);
                    redPanel.add(line);
                    
                    Struct s = new Struct(y,colorFlag);
                    //sout
                    y1.add(s);
                }
                
                y+=60;
            }
        }
         //NOTE :- this loop for drawing AND gates
        int noVariablesBeforeAnd=0;
        not_notations=0;
        for(int i=0;i<exp.length();i++){
            if(exp.charAt(i)=='~'){ 
                not_notations++;
            }
            else if(exp.charAt(i)>='a'&&exp.charAt(i)<='z'){ 
                noVariablesBeforeAnd++;
            }
            else if(exp.charAt(i)=='.'){  // initially y =100  (border )
                boolean colorFlag = false;
                int leftOperand = Integer.parseInt(val.charAt(i-1-not_notations)+""),
                    rightOperand = Integer.parseInt(val.charAt(i+1-not_notations)+"");
                
                if((i-1)-1>=0&&exp.charAt((i-1)-1)=='~'){
                    leftOperand = 1-leftOperand;
                }
                if((i+1)>=0&&exp.charAt((i+1))=='~'){
                    rightOperand =1-rightOperand;
                }
                if(leftOperand == 1&&rightOperand == 1) {
                    colorFlag = true;
                } 
                // انتباه ل i  هل لازم اغيرها بناء على val لانه ممكن يكون عنا ~ 
                // حسب التجربه كل شي زبط لكن بالمنطق لا 
                // تحدييييييييث حسب التجربه بطلع غلط 
                // تم القضاء على المشكلة  ************************************************
                // المفروض انه x=230 
                
                // y from my calculations it must be 45 
                int yy = 45+noVariablesBeforeAnd*60;
                and = new DrawAnd(230,yy,colorFlag);
                and.setSize(2000000000,2000000000);
                redPanel.add(and);
                
            }
        }
        drawAllOrLevels(y1,y2);
    }
    
    public DrawingAllFrame(String expression,String binary){
        // first initialization of all variables i used 
        // 
        expressionText = expression;
        binaryText = binary;
        redPanel = new JPanel();
        redPanel.setLayout(null);
        valueTextActionPerformed();
        redPanel.setBackground(new Color(255,255,153));
        redPanel.setBounds(400,0,1400,1400);
        
        
        
        infoPanel = new javax.swing.JPanel();
        infoLabel = new javax.swing.JLabel();
        
        
        expressionL = new javax.swing.JLabel();
        expLabel = new javax.swing.JLabel();
        one = new javax.swing.JLabel();
        orGates = new javax.swing.JLabel();
        answerLabel = new javax.swing.JLabel();
        ans = new javax.swing.JLabel();
        andGates = new javax.swing.JLabel();
        two = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        infoPanel.setBackground(new java.awt.Color(255, 255, 153));

        infoLabel.setFont(new java.awt.Font("Gabriola", 1, 40)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(0, 0, 0));
        infoLabel.setText("Information :");

        expressionL.setFont(new java.awt.Font("Gabriola", 0, 30)); // NOI18N
        expressionL.setForeground(new java.awt.Color(0, 0, 0));
        expressionL.setText(expressionText);

        expLabel.setFont(new java.awt.Font("Gabriola", 0, 30)); // NOI18N
        expLabel.setForeground(new java.awt.Color(0, 0, 0));
        expLabel.setText("Expression with Variables :");

        one.setFont(new java.awt.Font("Gabriola", 0, 25)); // NOI18N
        one.setForeground(new java.awt.Color(0, 0, 0));
        one.setText(no_of_and_gates+"");

        orGates.setFont(new java.awt.Font("Gabriola", 0, 30)); // NOI18N
        orGates.setForeground(new java.awt.Color(204, 0, 0));
        orGates.setText("Number of OR gates \" + \"  = ");

        answerLabel.setFont(new java.awt.Font("Gabriola", 0, 30)); // NOI18N
        answerLabel.setForeground(new java.awt.Color(0, 0, 0));
        answerLabel.setText("Final Answer  = ");

        ans.setFont(new java.awt.Font("Gabriola", 0, 25)); // NOI18N
        ans.setForeground(new java.awt.Color(0, 0, 0));
        mais d = new mais();
        finalAnswer = d.expressionAnalysis(binaryText, expressionText);
        ans.setText(finalAnswer+"");

        andGates.setFont(new java.awt.Font("Gabriola", 0, 30)); // NOI18N
        andGates.setForeground(new java.awt.Color(0, 102, 0));
        andGates.setText("Number of AND gates \" . \"  = ");

        two.setFont(new java.awt.Font("Gabriola", 0, 25)); // NOI18N
        two.setForeground(new java.awt.Color(0, 0, 0));
        two.setText(no_of_or_gates+"");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(infoLabel)
                .addGap(113, 113, 113))
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(answerLabel)
                        .addGap(18, 18, 18)
                        .addComponent(ans))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(orGates)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(two))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(andGates)
                        .addGap(18, 18, 18)
                        .addComponent(one))
                    .addComponent(expLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(expressionL, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(infoLabel)
                .addGap(18, 18, 18)
                .addComponent(expLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expressionL, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerLabel)
                    .addComponent(ans))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(one)
                    .addComponent(andGates))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orGates)
                    .addComponent(two))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        infoLabel.setBounds(10,-45,200,200);
        infoLabel.setText("Drawing :");
        redPanel.add(infoLabel);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(750,750);
        this.setVisible(true);
        this.add(redPanel);
        this.add(infoPanel);
        JOptionPane.showMessageDialog(null, "Please maximize the window to show all work");

    }
          
    

}
