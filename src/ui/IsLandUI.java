/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.House;

/**
 *
 * @author Dat Ngo
 */
public class IsLandUI extends JFrame implements Serializable{
	
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17;
    JButton btnWaveAttack, btnMenuSetting;
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12, txt13, txt14, txt15, txt16, txt17;
    JLabel lblIsLand, lblIco, lblIconH1,lblIconH2,lblIconH3,lblIconH4,lblIconH5,lblIconH6,lblIconH7,lblIconH8,lblIconH9,lblIconH10,lblIconH11,lblIconH12,lblIconH13,lblIconH14,lblIconH15,lblIconH16,lblIconH17;
    
    public static JLabel currentLabel;
    public static JButton currentButton;
    public static House currentHouse;
    public static JTextField currentTextField;
    public HouseInfoUI houseInfoUI;
    public MenuSetting menuSetting;
    public static House[] house;
    public static House myHouse;
    public static BattleFieldFightingUI bffUI;
    public static int timeSpeed = 10;
    
    public IsLandUI(String title){
        super(title);
        
        //Tạo 17 nhà từ 1 đến 17 (không tính nhà số 0);
        
        house = new House[18];
        currentHouse = new House();
        currentButton = new JButton();
        for(int i=1; i<18; i++){
            house[i] = new House();
            house[i].setName("Ikariam"+i);
            house[i].setId(i);
        }
            
        houseInfoUI = new HouseInfoUI();
        //Menu
        menuSetting = new MenuSetting();
        addControls();
        addEvents();
    }
 
    
    public void addControls(){
        Container con = getContentPane();
        
        JPanel pnMain = new JPanel();
        pnMain.setLayout(null);
        con.add(pnMain);
        
        //Logo
        lblIconH1 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH2 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH3 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH4 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH5 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH6 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH7 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH8 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH9 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH10 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH11 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH12 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH13 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH14 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH15 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH16 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));
        lblIconH17 = new JLabel(new ImageIcon(getClass().getResource("/Image/text_field-01.PNG")));

        lblIco = new JLabel(new ImageIcon(getClass().getResource("/Image/ikariam-01.PNG")));
        lblIco.setBounds(550, 0, 320, 80);
        pnMain.add(lblIco);
        
        // Tạo MenuSetting
        
        btnMenuSetting = new MyJButtonMenuSetting();
        btnMenuSetting.setBounds(10, 0, 100, 40);
        pnMain.add(btnMenuSetting);
        
        // Tạo UI 17 vị trí để đặt nhà
        
        btn1 = new MyJButtonFlag();
        btn1.setBounds(155, 120, 70, 70);
        txt1 = new JTextField();
        txt1.setBounds(156, 190, 60, 15);
        txt1.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt1.setEditable(true);
        txt1.setVisible(false);      
        txt1.setDocument(new JTextFieldLimit(20));
        txt1.setText(house[1].getName());
        txt1.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt1);     
        pnMain.add(btn1);
        pnMain.add(txt1);
        lblIconH1.setVisible(false);
        lblIconH1.setBounds(145, 187,80 , 20);
        txt1.setOpaque(false); // added by OP
        txt1.setBorder(BorderFactory.createEmptyBorder());
        txt1.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH1);
        
        btn2 = new MyJButtonFlag();
        btn2.setBounds(340, 95, 70, 70);
        txt2 = new JTextField();
        txt2.setBounds(341, 165, 60, 15);
        txt2.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt2.setEditable(true);
        txt2.setVisible(false);
        txt2.setDocument(new JTextFieldLimit(20));
        txt2.setText(house[2].getName());
        txt2.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt2);
        pnMain.add(txt2);
        pnMain.add(btn2);
        lblIconH2.setVisible(false);
        lblIconH2.setBounds(330, 162,80 , 20);
        txt2.setOpaque(false); // added by OP
        txt2.setBorder(BorderFactory.createEmptyBorder());
        txt2.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH2);
        
        btn3 = new MyJButtonFlag();
        btn3.setBounds(480, 160, 70, 70);
        txt3 = new JTextField();
        txt3.setBounds(481, 230, 60, 15);
        txt3.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt3.setEditable(true);
        txt3.setVisible(false);
        txt3.setDocument(new JTextFieldLimit(20));
        txt3.setText(house[3].getName()); txt3.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt3);
        pnMain.add(txt3);
        pnMain.add(btn3);
        lblIconH3.setVisible(false);
        lblIconH3.setBounds(470, 227,80 , 20);
        txt3.setOpaque(false); // added by OP
        txt3.setBorder(BorderFactory.createEmptyBorder());
        txt3.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH3);
        
        btn4 = new MyJButtonFlag();
        btn4.setBounds(800, 90, 70, 70);
        txt4 = new JTextField();
        txt4.setBounds(801, 160, 60, 15);
        txt4.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt4.setEditable(true);
        txt4.setVisible(false);
        txt4.setDocument(new JTextFieldLimit(20));
        txt4.setText(house[4].getName()); txt4.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt4);
        pnMain.add(txt4);
        pnMain.add(btn4);
        lblIconH4.setVisible(false);
        lblIconH4.setBounds(790, 157,80 , 20);
        txt4.setOpaque(false); // added by OP
        txt4.setBorder(BorderFactory.createEmptyBorder());
        txt4.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH4);
        
        btn5 = new MyJButtonFlag();
        btn5.setBounds(890, 220, 70, 70);
        txt5 = new JTextField();
        txt5.setBounds(891, 290, 60, 15);
        txt5.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt5.setEditable(true);
        txt5.setVisible(false);
        txt5.setDocument(new JTextFieldLimit(20));
        txt5.setText(house[5].getName()); txt5.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt5);
        pnMain.add(txt5);
        pnMain.add(btn5);
        lblIconH5.setVisible(false);
        lblIconH5.setBounds(880, 287,80 , 20);
        txt5.setOpaque(false); // added by OP
        txt5.setBorder(BorderFactory.createEmptyBorder());
        txt5.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH5);
        
        btn6 = new MyJButtonFlag();
        btn6.setBounds(1090, 240, 70, 70);
        txt6 = new JTextField();
        txt6.setBounds(1091, 310, 60, 15);
        txt6.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt6.setEditable(true);
        txt6.setVisible(false);
        txt6.setDocument(new JTextFieldLimit(20));
        txt6.setText(house[6].getName()); txt6.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt6);
        pnMain.add(txt6);
        pnMain.add(btn6);
        lblIconH6.setVisible(false);
        lblIconH6.setBounds(1080, 307,80 , 20);
        txt6.setOpaque(false); // added by OP
        txt6.setBorder(BorderFactory.createEmptyBorder());
        txt6.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH6);
        
        btn7 = new MyJButtonFlag();
        btn7.setBounds(1200, 330, 70, 70);
        txt7 = new JTextField();
        txt7.setBounds(1201, 400, 60, 15);
        txt7.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt7.setEditable(true);
        txt7.setVisible(false);
        txt7.setDocument(new JTextFieldLimit(20));
        txt7.setText(house[7].getName()); txt7.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt7);
        pnMain.add(txt7);
        pnMain.add(btn7);
        lblIconH7.setVisible(false);
        lblIconH7.setBounds(1190, 397,80 , 20);
        txt7.setOpaque(false); // added by OP
        txt7.setBorder(BorderFactory.createEmptyBorder());
        txt7.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH7);
        
        btn8 = new MyJButtonFlag();
        btn8.setBounds(1180, 455, 70, 70);
        txt8 = new JTextField();
        txt8.setBounds(1181, 525, 60, 15);
        txt8.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt8.setEditable(true);
        txt8.setVisible(false);
        txt8.setDocument(new JTextFieldLimit(20));
        txt8.setText(house[8].getName()); txt8.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt8);
        pnMain.add(txt8);
        pnMain.add(btn8);
        lblIconH8.setVisible(false);
        lblIconH8.setBounds(1170,523,80 , 20);
        txt8.setOpaque(false); // added by OP
        txt8.setBorder(BorderFactory.createEmptyBorder());
        txt8.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH8);
        
        btn9 = new MyJButtonFlag();
        btn9.setBounds(1050, 530, 70, 70);
        txt9 = new JTextField();
        txt9.setBounds(1051,600, 60, 15);
        txt9.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt9.setEditable(true);
        txt9.setVisible(false);
        txt9.setDocument(new JTextFieldLimit(20));
        txt9.setText(house[9].getName()); txt9.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt9);
        pnMain.add(txt9);
        pnMain.add(btn9);
        lblIconH9.setVisible(false);
        lblIconH9.setBounds(1040,597,80 , 20);
        txt9.setOpaque(false); // added by OP
        txt9.setBorder(BorderFactory.createEmptyBorder());
        txt9.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH9);
        
        btn10 = new MyJButtonFlag();
        btn10.setBounds(890, 570, 70, 70);
        txt10 = new JTextField();
        txt10.setBounds(891, 640, 60, 15);
        txt10.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt10.setEditable(true);
        txt10.setVisible(false);
        txt10.setDocument(new JTextFieldLimit(20));
        txt10.setText(house[10].getName()); txt10.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt10);
        pnMain.add(txt10);
        pnMain.add(btn10);
        lblIconH10.setVisible(false);
        lblIconH10.setBounds(880, 637,80 , 20);
        txt10.setOpaque(false); // added by OP
        txt10.setBorder(BorderFactory.createEmptyBorder());
        txt10.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH10);
        
        btn11 = new MyJButtonFlag();
        btn11.setBounds(720, 650, 70, 70);
        txt11 = new JTextField();
        txt11.setBounds(721, 720, 60, 15);
        txt11.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt11.setEditable(true);
        txt11.setVisible(false);
        txt11.setDocument(new JTextFieldLimit(20));
        txt11.setText(house[11].getName()); txt11.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt11);
        pnMain.add(txt11);
        pnMain.add(btn11);
        lblIconH11.setVisible(false);
        lblIconH11.setBounds(710, 717,80 , 20);
        txt11.setOpaque(false); // added by OP
        txt11.setBorder(BorderFactory.createEmptyBorder());
        txt11.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH11);
        
        btn12 = new MyJButtonFlag();
        btn12.setBounds(530, 580, 70, 70);
        txt12 = new JTextField();
        txt12.setBounds(531, 650, 60, 15);
        txt12.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt12.setEditable(true);
        txt12.setVisible(false);
        txt12.setDocument(new JTextFieldLimit(20));
        txt12.setText(house[12].getName()); txt12.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt12);
        pnMain.add(txt12);
        pnMain.add(btn12);
        lblIconH12.setVisible(false);
        lblIconH12.setBounds(520, 647,80 , 20);
        txt12.setOpaque(false); // added by OP
        txt12.setBorder(BorderFactory.createEmptyBorder());
        txt12.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH12);
        
        btn13 = new MyJButtonFlag();
        btn13.setBounds(435, 470, 70, 70);
        txt13 = new JTextField();
        txt13.setBounds(436, 540, 60, 15);
        txt13.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt13.setEditable(true);
        txt13.setVisible(false);
        txt13.setDocument(new JTextFieldLimit(20));
        txt13.setText(house[13].getName()); txt13.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt13);
        pnMain.add(txt13);
        pnMain.add(btn13);
        lblIconH13.setVisible(false);
        lblIconH13.setBounds(425,537,80 , 20);
        txt13.setOpaque(false); // added by OP
        txt13.setBorder(BorderFactory.createEmptyBorder());
        txt13.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH13);
        
        btn14 = new MyJButtonFlag();
        btn14.setBounds(255, 530, 70, 70);
        txt14 = new JTextField();
        txt14.setBounds(256, 600, 60, 15);
        txt14.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt14.setEditable(true);
        txt14.setVisible(false);
        txt14.setDocument(new JTextFieldLimit(20));
        txt14.setText(house[14].getName()); txt14.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt14);
        pnMain.add(txt14);
        pnMain.add(btn14);
        lblIconH14.setVisible(false);
        lblIconH14.setBounds(245,597,80 , 20);
        txt14.setOpaque(false); // added by OP
        txt14.setBorder(BorderFactory.createEmptyBorder());
        txt14.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH14);
        
        btn15 = new MyJButtonFlag();
        btn15.setBounds(180, 430, 70, 70);
        txt15 = new JTextField();
        txt15.setBounds(181, 500, 60, 15);
        txt15.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt15.setEditable(true);
        txt15.setVisible(false);
        txt15.setDocument(new JTextFieldLimit(20));
        txt15.setText(house[15].getName()); txt15.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt15);
        pnMain.add(txt15);
        pnMain.add(btn15);
        lblIconH15.setVisible(false);
        lblIconH15.setBounds(170,497,80 , 20);
        txt15.setOpaque(false); // added by OP
        txt15.setBorder(BorderFactory.createEmptyBorder());
        txt15.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH15);
        
        btn16 = new MyJButtonFlag();
        btn16.setBounds(330, 315, 70, 70);
        txt16 = new JTextField();
        txt16.setBounds(331, 385, 60, 15);
        txt16.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt16.setEditable(true);
        txt16.setVisible(false);
        txt16.setDocument(new JTextFieldLimit(20));
        txt16.setText(house[16].getName()); txt16.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt16);
        pnMain.add(txt16);
        pnMain.add(btn16);
        lblIconH16.setVisible(false);
        lblIconH16.setBounds(320, 382,80 , 20);
        txt16.setOpaque(false); // added by OP
        txt16.setBorder(BorderFactory.createEmptyBorder());
        txt16.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH16);
        
        btn17 = new MyJButtonFlag();
        btn17.setBounds(180, 230, 70, 70);
        txt17 = new JTextField();
        txt17.setBounds(181, 300, 60, 15);
        txt17.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        txt17.setEditable(true);
        txt17.setVisible(false);
        txt17.setDocument(new JTextFieldLimit(20));
        txt17.setText(house[17].getName()); txt17.setHorizontalAlignment(JTextField.CENTER);
        checkInput(txt17);
        pnMain.add(txt17);
        pnMain.add(btn17);
        lblIconH17.setVisible(false);
        lblIconH17.setBounds(170,297,80 , 20);
        txt17.setOpaque(false); // added by OP
        txt17.setBorder(BorderFactory.createEmptyBorder());
        txt17.setBackground(new Color(0,0,0,0));
        pnMain.add(lblIconH17);
        
        // Tạo UI xem WaveAttack
        
        btnWaveAttack = new JButton("");
        btnWaveAttack.setBounds(1165, 10, 70, 100);
        btnWaveAttack.setOpaque(false);
        btnWaveAttack.setContentAreaFilled(false);
        btnWaveAttack.setBorder(null);
        pnMain.add(btnWaveAttack);
        
        //Hiển thị Background
        lblIsLand = new JLabel();
        lblIsLand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/island.jpg")));
        pnMain.add(lblIsLand);
        lblIsLand.setBounds(0, 0, 1366, 768);
        
    }
    
    public void addEvents(){
    	//Event click vào xem thông tin WaveAttack
        btnWaveAttack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(myHouse!=null)
                    new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy()).setVisible(true);
            }
        });
        
        btnMenuSetting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSetting.showWindow();
            }
        });
        
        //Event click vào các nhà
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[1];
                currentButton = btn1;
                currentLabel = lblIconH1;
                currentTextField = txt1;
                currentHouse.setName(txt1.getText());
 
                houseInfoUI.showWindow();
            }
        });
        
        
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[2];
                currentButton = btn2;
                currentTextField = txt2;
                currentLabel = lblIconH2;
                currentHouse.setName(txt2.getText());
                houseInfoUI.showWindow();
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[3];
                currentButton = btn3;
                currentTextField = txt3;
                currentLabel = lblIconH3;
                currentHouse.setName(txt3.getText());
                houseInfoUI.showWindow();
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[4];
                currentButton = btn4;
                currentTextField = txt4;
                currentLabel = lblIconH4;
                currentHouse.setName(txt4.getText());
                houseInfoUI.showWindow();
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[5];
                currentButton = btn5;
                currentTextField = txt5;
                currentHouse.setName(txt5.getText());
                currentLabel = lblIconH5;
                houseInfoUI.showWindow();
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[6];
                currentButton = btn6;
                currentTextField = txt6;
                currentLabel = lblIconH6;currentHouse.setName(txt6.getText());
                houseInfoUI.showWindow();
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[7];
                currentButton = btn7;
                currentTextField = txt7;
                currentLabel = lblIconH7;currentHouse.setName(txt7.getText());
                houseInfoUI.showWindow();
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[8];
                currentButton = btn8;
                currentTextField = txt8;
                currentLabel = lblIconH8;currentHouse.setName(txt8.getText());
                houseInfoUI.showWindow();
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[9];
                currentButton = btn9;
                currentTextField = txt9;
                currentLabel = lblIconH9;currentHouse.setName(txt9.getText());
                houseInfoUI.showWindow();
            }
        });
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[10];
                currentButton = btn10;
                currentTextField = txt10;
                currentLabel = lblIconH10;currentHouse.setName(txt10.getText());
                houseInfoUI.showWindow();
            }
        });
        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[11];
                currentButton = btn11;
                currentTextField = txt11;
                currentLabel = lblIconH11;currentHouse.setName(txt11.getText());
                houseInfoUI.showWindow();
            }
        });
        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[12];
                currentButton = btn12;
                currentTextField = txt12;
                currentLabel = lblIconH12;currentHouse.setName(txt12.getText());
                houseInfoUI.showWindow();
            }
        });
        btn13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[13];
                currentButton = btn13;
                currentTextField = txt13;
                currentLabel = lblIconH13;currentHouse.setName(txt13.getText());
                houseInfoUI.showWindow();
            }
        });
        btn14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[14];
                currentButton = btn14;
                currentTextField = txt14;
                currentLabel = lblIconH14;currentHouse.setName(txt14.getText());
                houseInfoUI.showWindow();
            }
        });
        btn15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[15];
                currentButton = btn15;
                currentTextField = txt15;
                currentLabel = lblIconH15;currentHouse.setName(txt15.getText());
                houseInfoUI.showWindow();
            }
        });
        btn16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[16];
                currentButton = btn16;
                currentTextField = txt16;
                currentLabel = lblIconH16;currentHouse.setName(txt16.getText());
                houseInfoUI.showWindow();
            }
        });
        btn17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[17];
                currentButton = btn17;
                currentTextField = txt17;
                currentLabel = lblIconH17;currentHouse.setName(txt17.getText());
                houseInfoUI.showWindow();
            }
        });
    }
    public void checkInput(JTextField txt){
        txt.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e){
       		 char input = e.getKeyChar();
       		 int j = Character.getNumericValue(input);
       		// if(60<j<95)||((j>=97)&(j<122))||(j==32))
       		 //if(((input=='\t'||input<'a'|| input >'z')&(input<'A'|| input >'Z')))
       		if(!(Character.isAlphabetic(input) ||  (input==KeyEvent.VK_SPACE)||  input==KeyEvent.VK_DELETE ))
       			{
       			 e.consume();
       		 }
       	 }
		});
    }
	
    
    public void showWindow(){
        setSize(1500, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }          
}
