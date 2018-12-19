/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.House;

/**
 *
 * @author Dat Ngo
 */
public class IsLandUI extends JFrame{
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17;
    JButton btnWaveAttack, btnMenuSetting;
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12, txt13, txt14, txt15, txt16, txt17;
    JLabel lblIsLand;
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
        //
        menuSetting = new MenuSetting();
        addControls();
        addEvents();
    }
    
    public void addControls(){
        Container con = getContentPane();
        
        JPanel pnMain = new JPanel();
        pnMain.setLayout(null);
        con.add(pnMain);
        
        // Tạo MenuSetting
        
        btnMenuSetting = new MyJButtonMenuSetting();
        btnMenuSetting.setBounds(0, 0, 60, 60);
        pnMain.add(btnMenuSetting);
        
        // Tạo UI 17 vị trí để đặt nhà
        
        btn1 = new MyJButtonFlag();
        btn1.setBounds(175, 150, 30, 30);
        txt1 = new JTextField();
        txt1.setBounds(165, 180, 50, 12);
        txt1.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt1.setEditable(true);
        txt1.setVisible(false);
        txt1.setDocument(new JTextFieldLimit(20));
        txt1.setText(house[1].getName());
        checkInput(txt1);
        pnMain.add(btn1);
        pnMain.add(txt1);
        
        btn2 = new MyJButtonFlag();
        btn2.setBounds(360, 120, 30 ,30);
        txt2 = new JTextField();
        txt2.setBounds(350, 150, 50, 12);
        txt2.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt2.setEditable(true);
        txt2.setVisible(false);
        txt2.setDocument(new JTextFieldLimit(20));
        txt2.setText(house[2].getName());
        checkInput(txt2);
        pnMain.add(txt2);
        pnMain.add(btn2);
        
        btn3 = new MyJButtonFlag();
        btn3.setBounds(500, 190, 30 ,30);
        txt3 = new JTextField();
        txt3.setBounds(490, 220, 50, 12);
        txt3.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt3.setEditable(true);
        txt3.setVisible(false);
        txt3.setDocument(new JTextFieldLimit(20));
        txt3.setText(house[3].getName());
        checkInput(txt3);
        pnMain.add(txt3);
        pnMain.add(btn3);
        
        btn4 = new MyJButtonFlag();
        btn4.setBounds(820, 120, 30 ,30);
        txt4 = new JTextField();
        txt4.setBounds(810, 150, 50, 12);
        txt4.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt4.setEditable(true);
        txt4.setVisible(false);
        txt4.setDocument(new JTextFieldLimit(20));
        txt4.setText(house[4].getName());
        checkInput(txt4);
        pnMain.add(txt4);
        pnMain.add(btn4);
        
        btn5 = new MyJButtonFlag();
        btn5.setBounds(910, 240, 30 ,30);
        txt5 = new JTextField();
        txt5.setBounds(900, 270, 50, 12);
        txt5.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt5.setEditable(true);
        txt5.setVisible(false);
        txt5.setDocument(new JTextFieldLimit(20));
        txt5.setText(house[5].getName());
        checkInput(txt5);
        pnMain.add(txt5);
        pnMain.add(btn5);
        
        btn6 = new MyJButtonFlag();
        btn6.setBounds(1110, 260, 30 ,30);
        txt6 = new JTextField();
        txt6.setBounds(1100, 290, 50, 12);
        txt6.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt6.setEditable(true);
        txt6.setVisible(false);
        txt6.setDocument(new JTextFieldLimit(20));
        txt6.setText(house[6].getName());
        checkInput(txt6);
        pnMain.add(txt6);
        pnMain.add(btn6);
        
        btn7 = new MyJButtonFlag();
        btn7.setBounds(1220, 350, 30 ,30);
        txt7 = new JTextField();
        txt7.setBounds(1210, 380, 50, 12);
        txt7.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt7.setEditable(true);
        txt7.setVisible(false);
        txt7.setDocument(new JTextFieldLimit(20));
        txt7.setText(house[7].getName());
        checkInput(txt7);
        pnMain.add(txt7);
        pnMain.add(btn7);
        
        btn8 = new MyJButtonFlag();
        btn8.setBounds(1200, 475, 30 ,30);
        txt8 = new JTextField();
        txt8.setBounds(1190, 505, 50, 12);
        txt8.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt8.setEditable(true);
        txt8.setVisible(false);
        txt8.setDocument(new JTextFieldLimit(20));
        txt8.setText(house[8].getName());
        checkInput(txt8);
        pnMain.add(txt8);
        pnMain.add(btn8);
        
        btn9 = new MyJButtonFlag();
        btn9.setBounds(1070, 550, 30 ,30);
        txt9 = new JTextField();
        txt9.setBounds(1060, 580, 50, 12);
        txt9.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt9.setEditable(true);
        txt9.setVisible(false);
        txt9.setDocument(new JTextFieldLimit(20));
        txt9.setText(house[9].getName());
        checkInput(txt9);
        pnMain.add(txt9);
        pnMain.add(btn9);
        
        btn10 = new MyJButtonFlag();
        btn10.setBounds(910, 590, 30 ,30);
        txt10 = new JTextField();
        txt10.setBounds(900, 620, 50, 12);
        txt10.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt10.setEditable(true);
        txt10.setVisible(false);
        txt10.setDocument(new JTextFieldLimit(20));
        txt10.setText(house[10].getName());
        checkInput(txt10);
        pnMain.add(txt10);
        pnMain.add(btn10);
        
        btn11 = new MyJButtonFlag();
        btn11.setBounds(740, 670, 30 ,30);
        txt11 = new JTextField();
        txt11.setBounds(730, 700, 50, 12);
        txt11.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt11.setEditable(true);
        txt11.setVisible(false);
        txt11.setDocument(new JTextFieldLimit(20));
        txt11.setText(house[11].getName());
        checkInput(txt11);
        pnMain.add(txt11);
        pnMain.add(btn11);
        
        btn12 = new MyJButtonFlag();
        btn12.setBounds(550, 600, 30 ,30);
        txt12 = new JTextField();
        txt12.setBounds(540, 630, 50, 12);
        txt12.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt12.setEditable(true);
        txt12.setVisible(false);
        txt12.setDocument(new JTextFieldLimit(20));
        txt12.setText(house[12].getName());
        checkInput(txt12);
        pnMain.add(txt12);
        pnMain.add(btn12);
        
        btn13 = new MyJButtonFlag();
        btn13.setBounds(455, 490, 30 ,30);
        txt13 = new JTextField();
        txt13.setBounds(445, 520, 50, 12);
        txt13.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt13.setEditable(true);
        txt13.setVisible(false);
        txt13.setDocument(new JTextFieldLimit(20));
        txt13.setText(house[13].getName());
        checkInput(txt13);
        pnMain.add(txt13);
        pnMain.add(btn13);
        
        btn14 = new MyJButtonFlag();
        btn14.setBounds(275, 550, 30 ,30);
        txt14 = new JTextField();
        txt14.setBounds(265, 580, 50, 12);
        txt14.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt14.setEditable(true);
        txt14.setVisible(false);
        txt14.setDocument(new JTextFieldLimit(20));
        txt14.setText(house[14].getName());
        checkInput(txt14);
        pnMain.add(txt14);
        pnMain.add(btn14);
        
        btn15 = new MyJButtonFlag();
        btn15.setBounds(200, 450, 30 ,30);
        txt15 = new JTextField();
        txt15.setBounds(190, 480, 50, 12);
        txt15.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt15.setEditable(true);
        txt15.setVisible(false);
        txt15.setDocument(new JTextFieldLimit(20));
        txt15.setText(house[15].getName());
        checkInput(txt15);
        pnMain.add(txt15);
        pnMain.add(btn15);
        
        btn16 = new MyJButtonFlag();
        btn16.setBounds(350, 335, 30 ,30);
        txt16 = new JTextField();
        txt16.setBounds(340, 365, 50, 12);
        txt16.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt16.setEditable(true);
        txt16.setVisible(false);
        txt16.setDocument(new JTextFieldLimit(20));
        txt16.setText(house[16].getName());
        checkInput(txt16);
        pnMain.add(txt16);
        pnMain.add(btn16);
        
        btn17 = new MyJButtonFlag();
        btn17.setBounds(190, 260, 30 ,30);
        txt17 = new JTextField();
        txt17.setBounds(180, 290, 50, 12);
        txt17.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt17.setEditable(true);
        txt17.setVisible(false);
        txt17.setDocument(new JTextFieldLimit(20));
        txt17.setText(house[17].getName());
        checkInput(txt17);
        pnMain.add(txt17);
        pnMain.add(btn17);
        
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
                currentTextField = txt1;
                houseInfoUI.showWindow();
            }
        });
        
        
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[2];
                currentButton = btn2;
                currentTextField = txt2;
                houseInfoUI.showWindow();
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[3];
                currentButton = btn3;
                currentTextField = txt3;
                houseInfoUI.showWindow();
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[4];
                currentButton = btn4;
                currentTextField = txt4;
                houseInfoUI.showWindow();
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[5];
                currentButton = btn5;
                currentTextField = txt5;
                houseInfoUI.showWindow();
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[6];
                currentButton = btn6;
                currentTextField = txt6;
                houseInfoUI.showWindow();
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[7];
                currentButton = btn7;
                currentTextField = txt7;
                houseInfoUI.showWindow();
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[8];
                currentButton = btn8;
                currentTextField = txt8;
                houseInfoUI.showWindow();
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[9];
                currentButton = btn9;
                currentTextField = txt9;
                houseInfoUI.showWindow();
            }
        });
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[10];
                currentButton = btn10;
                currentTextField = txt10;
                houseInfoUI.showWindow();
            }
        });
        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[11];
                currentButton = btn11;
                currentTextField = txt11;
                houseInfoUI.showWindow();
            }
        });
        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[12];
                currentButton = btn12;
                currentTextField = txt12;
                houseInfoUI.showWindow();
            }
        });
        btn13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[13];
                currentButton = btn13;
                currentTextField = txt13;
                houseInfoUI.showWindow();
            }
        });
        btn14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[14];
                currentButton = btn14;
                currentTextField = txt14;
                houseInfoUI.showWindow();
            }
        });
        btn15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[15];
                currentButton = btn15;
                currentTextField = txt15;
                houseInfoUI.showWindow();
            }
        });
        btn16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[16];
                currentButton = btn16;
                currentTextField = txt16;
                houseInfoUI.showWindow();
            }
        });
        btn17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[17];
                currentButton = btn17;
                currentTextField = txt17;
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
