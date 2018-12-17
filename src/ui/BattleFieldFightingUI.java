/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.BattleFieldFighting;

/**
 *
 * @author GBlue
 */
public class BattleFieldFightingUI extends JDialog{
    
    public static JTabbedPane pnTab;
    
    JPanel pnMain, pnTitle, pnButton, pnContent;
    JLabel lblImg, lblTitle, lblImgTitle;
    //JTextField forgeAttack;
    JButton btnDispose,btnForge,btnColossus;
    PnBattleFieldFighting pnAttack, pnDefence;
    BattleFieldFighting battleFieldFighting; 
    
    public BattleFieldFightingUI(BattleFieldFighting battleFieldFighting) {
        this.battleFieldFighting = battleFieldFighting;
        addControls();
        addEvents();
    }
    
    public void addControls() {
        Container con = getContentPane();
        con.setLayout(null);
        
        lblImgTitle = new JLabel();
        lblImgTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblHouTitle.png")));
        lblImgTitle.setBounds(210, 0, 60, 60);
        con.add(lblImgTitle);
        
        pnTitle = new JPanel(null);
        con.add(pnTitle);
        pnTitle.setBounds(0, 30, 980, 20);
        pnTitle.setBackground(new Color(215, 172, 116));
        
        lblTitle = new JLabel("Battle Field");
        lblTitle.setBounds(420, 0, 125, 15);
        pnTitle.add(lblTitle);
        btnDispose = new JButton(new ImageIcon(getClass().getResource("/Image/xButton.PNG")));
        btnDispose.setBounds(960, 0, 20, 20);
        pnTitle.add(btnDispose);
        //forge
        btnForge= new JButton();
        btnForge.setBounds(800,0,60,60);
        btnForge.setIcon(new ImageIcon(getClass().getResource("/Image/forge.PNG")));
        con.add(btnForge);
       //Colossus
        btnColossus= new JButton();
        btnColossus.setBounds(730,0,60,60);
        btnColossus.setIcon(new ImageIcon(getClass().getResource("/Image/colossus.PNG")));
        con.add(btnColossus);
        
        
        pnMain = new JPanel();
        pnMain.setLayout(null);
        pnMain.setBounds(0, 50, 980, 480);
        pnMain.setBackground(new Color(253, 247, 221));
        con.add(pnMain);
       
        
        pnAttack = new PnBattleFieldFighting(battleFieldFighting.getAttackBattleField());
        pnDefence = new PnBattleFieldFighting(battleFieldFighting.getDefenceBattleField());
        pnAttack.setBounds(10, 50, 946, 179);
        pnDefence.setBounds(10, 235, 946, 179);
        pnAttack.addToReserves();
        pnDefence.addToReserves();
        pnMain.add(pnAttack);
        pnMain.add(pnDefence);
        
      
    }
    
    public void addEvents() {

//         for(Army.Unit unit: Army.Unit.values()){
    	 // Bảng foger 
    	btnForge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                ForgeUI forge = new ForgeUI();
              //  forgeAttack
                forge.showWindow();
            }
        });
    	//Bảng Colossus
    	btnColossus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                ColossusUI colossus = new ColossusUI();
                colossus.showWindow();
            }
        });
        
        btnDispose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
     
    }
    public void showWindow() {
        setSize(980, 530);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setModal(true);
        setVisible(true);
    }

    public BattleFieldFighting getBattleFieldFighting() {
        return battleFieldFighting;
    }

    public void setBattleFieldFighting(BattleFieldFighting battleFieldFighting) {
        this.battleFieldFighting = battleFieldFighting;
    }
    
    public void resetBattleFieldFightingUI(BattleFieldFighting battleFieldFighting){
        pnMain.removeAll();
       this.battleFieldFighting = battleFieldFighting;
       pnAttack = new PnBattleFieldFighting(battleFieldFighting.getAttackBattleField());
       pnDefence = new PnBattleFieldFighting(battleFieldFighting.getDefenceBattleField());
        pnAttack.setBounds(10, 50, 946, 179);
        pnDefence.setBounds(10, 235, 946, 179);
      pnAttack.addToReserves();
        pnDefence.addToReserves();
        pnMain.add(pnAttack);
        pnMain.add(pnDefence);
        pnMain.updateUI();
    }
    
}
     


    //Show the HouseInfoUI dialog
    

