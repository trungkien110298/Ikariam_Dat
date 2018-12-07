package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.BattleField;
import model.BattleFieldFighting;
import model.RealArmy;
import model.Wall;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.House;

import java.util.concurrent.TimeUnit;
import java.util.*;
import java.text.*;


/**
*
* @author QuangLinh
*/
public class ForgeUI extends JDialog {
	 JPanel pnMain, pnTitle,pnAttackArmy,pnDefenseArmy;
	 JLabel lblImgTitle, lblTitle, lblAttackArmy,lblDefenseArmy;
	 JComboBox<String> forgeLevelAttack,forgeLevelDefense;
	 JButton btnDispose, btnOK;
	 long d1,d2;
	
	

	 public ForgeUI() {
		 
		 addControls();
	      addEvents();
	      
	    }
	 public void addControls(){
		 Container con = getContentPane();
	     con.setLayout(null);
	     lblImgTitle = new JLabel();
	     lblImgTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/forge.PNG")));
	     lblImgTitle.setBounds(70, 0, 60, 60);
	     con.add(lblImgTitle);
	     
	     pnMain = new JPanel(null);
	     pnMain.setBounds(0, 20, 600, 300);
	     pnMain.setBackground(new Color(253, 247, 221));
	     
	     pnTitle = new JPanel(null);
	     pnTitle.setBounds(0, 0, 600, 20);
	     pnTitle.setBackground(new Color(215, 172, 116));
	     con.add(pnTitle);
	     lblTitle = new JLabel("Hephaistos' Forge");
	     lblTitle.setBounds(250, 0, 125, 15);
	     pnTitle.add(lblTitle);
	     btnDispose = new JButton(new ImageIcon(getClass().getResource("/Image/xButton.PNG")));
	     btnDispose.setBounds(580, 0, 20, 20);
	     pnTitle.add(btnDispose);
	     
	   
	     
	     pnDefenseArmy = new JPanel(null);
	     pnDefenseArmy.setBounds(0,110, 600, 50);
	     pnDefenseArmy.setBackground(new Color(251, 232, 193));
	     pnMain.add(pnDefenseArmy);
	     lblDefenseArmy = new JLabel("Defense Army");
	     lblDefenseArmy.setBounds(50, 15, 90, 20);
	     pnDefenseArmy.add(lblDefenseArmy);
	     forgeLevelDefense = new JComboBox<>();
	     forgeLevelDefense.setBounds(200, 15, 200, 20);
	     forgeLevelDefense.addItem("0");
	     forgeLevelDefense.addItem("1");
	     forgeLevelDefense.addItem("2");
	     forgeLevelDefense.addItem("3");
	     forgeLevelDefense.addItem("4");
	     forgeLevelDefense.addItem("5");
	     pnDefenseArmy.add(forgeLevelDefense);
	   
	     pnAttackArmy = new JPanel(null);
	     pnAttackArmy.setBounds(0, 50, 600, 50);
	     pnAttackArmy.setBackground(new Color(251, 232, 193));
	     pnMain.add(pnAttackArmy);
	     lblAttackArmy = new JLabel("Attack Army");
	     lblAttackArmy.setBounds(50, 15, 90, 20);
	     pnAttackArmy.add(lblAttackArmy);
	     forgeLevelAttack = new JComboBox<>();
	     forgeLevelAttack.setBounds(200, 15, 200, 20);
	     forgeLevelAttack.addItem("0");
	     forgeLevelAttack.addItem("1");
	     forgeLevelAttack.addItem("2");
	     forgeLevelAttack.addItem("3");
	     forgeLevelAttack.addItem("4");
	     forgeLevelAttack.addItem("5");
	     pnAttackArmy.add(forgeLevelAttack);
	     
	     btnOK = new JButton("OK");
	     btnOK.setBounds(250, 210, 110, 30);
	     btnOK.setBackground(new Color(248, 222, 164));
	     pnMain.add(btnOK);
	     
	     con.add(pnMain);
	     
	 }
	 public void addEvents(){
		 btnDispose.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	            }
	        });
		
		 btnOK.addActionListener(new ActionListener() {
			//  Integer.parseInt(txtLevelHouse.getText())
			 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	             Date startDate1;
		          startDate1=null;
		       	  if ( IsLandUI.currentHouse.getStartDate()==null){
		       		  String startDateString = "18/01/2018";
		       		  DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
	       	     
		       		  try {
		       			  startDate1 = df.parse(startDateString);
		       			  String newDateString = df.format(startDate1); 
		       		  } catch (ParseException e1) {
		       			  e1.printStackTrace();
		       		  }
	       	   
		       		  if (forgeLevelAttack.getSelectedIndex()!=0)
		       			  JOptionPane.showMessageDialog(null, "Quân tấn công đã kích hoạt lò lever "+ forgeLevelAttack.getSelectedIndex());	
		       		  if (forgeLevelDefense.getSelectedIndex()!=0)
		       			  JOptionPane.showMessageDialog(null, "Quân phòng thủ đã kích hoạt lò lever "+ forgeLevelDefense.getSelectedIndex());
	   			  
		       		  java.util.Date dateNew=new java.util.Date();
		              IsLandUI.currentHouse.setStartDate(dateNew);
		              getInstance().dispose();
	       	      } else {
	       	    	  	java.util.Date dateNew=new java.util.Date();  
	       	    	  	long getDiff = dateNew.getTime() - IsLandUI.currentHouse.getStartDate().getTime();
	       	    	  	
	       	    	  	if (getDiff<(7*60*1000))  
	       	    	  		{ long tg=7*60*1000-getDiff;
	       	    	  		JOptionPane.showMessageDialog(null, "Sau "+tg/1000+" giây mới có thể kích lò lần tiếp theo" );
	       	    	  		}	       	    	  	
	       	    	  	else {
	       	    	 
	       	    	 
	       	    	  		if (forgeLevelAttack.getSelectedIndex()!=0){
	       	    	  			JOptionPane.showMessageDialog(null, "Quân tấn công  đã kích hoạt lò lever "+ forgeLevelAttack.getSelectedIndex());
	       	    	  			}	
	       	    	  		if (forgeLevelDefense.getSelectedIndex()!=0){
	       	    	  			JOptionPane.showMessageDialog(null, "Quân phòng thủ đã kích hoạt lò lever "+ forgeLevelDefense.getSelectedIndex());
	       	    	  			}
	       	    	  		java.util.Date dateNew1=new java.util.Date();  	
	       	    	  		IsLandUI.currentHouse.setStartDate(dateNew1);
	            	
	            	 
	            	 
	            	  }
	           
	            	getInstance().dispose();
	         	      }
	               
	            }
	        });
	 }
	 protected void setArmyDame() {
		// Integer.parseInt(forgeLevelAttack.getText());
		// String type = forgeLevelAttack.getSelectedItem().toString();
		  
		 this.dispose();
	 }
	 private ForgeUI getInstance() {
	        return this;
	    }
	 public void showWindow() {
	        this.setSize(600,300);
	        setUndecorated(true);
	        this.setBackground(new Color(0, 0, 0, 0));
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	   	    this.setLocationRelativeTo(null);
	        this.setModal(true);
	        this.setVisible(true);
	    }


	
	
}
