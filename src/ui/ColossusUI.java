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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
/**
*
* @author QuangLinh
*/
public class ColossusUI extends JDialog {
	JPanel pnMain, pnTitle,pnColossus;
	JLabel lblImgTitle, lblTitle,lblColossus;
	JComboBox<String> levlelColossus;
	JButton btnDispose, btnOK;
	public ColossusUI(){
		addControls();
		addEvents();
		
	}
	public void addControls(){
		Container con = getContentPane();
	    con.setLayout(null);
	    lblImgTitle = new JLabel();
	    lblImgTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/colossus.PNG")));
	    lblImgTitle.setBounds(70, 0, 60, 60);
	    con.add(lblImgTitle);
		
	    pnMain = new JPanel(null);
	    pnMain.setBounds(0, 20, 600, 300);
	    pnMain.setBackground(new Color(253, 247, 221));
	    
	    pnTitle = new JPanel(null);
	    pnTitle.setBounds(0, 0, 600, 20);
	    pnTitle.setBackground(new Color(215, 172, 116));
	    con.add(pnTitle);
	    
	    lblTitle = new JLabel("Colossus");
	    lblTitle.setBounds(250, 0, 125, 15);
	    pnTitle.add(lblTitle);
	    btnDispose = new JButton(new ImageIcon(getClass().getResource("/Image/xButton.PNG")));
	    btnDispose.setBounds(580, 0, 20, 20);
	    pnTitle.add(btnDispose);
	    
	    pnColossus = new JPanel(null);
	    pnColossus.setBounds(0,110, 600, 50);
	    pnColossus.setBackground(new Color(251, 232, 193));
	    pnMain.add(pnColossus);
	    lblColossus= new JLabel("Colossus Defense");
	    lblColossus.setBounds(50, 15, 150, 20);
	    pnColossus.add(lblColossus);
	    levlelColossus = new JComboBox<>();
	    levlelColossus.setBounds(200, 15, 200, 20);
	    levlelColossus.addItem("0");
	    levlelColossus.addItem("1");
	    levlelColossus.addItem("2");
	    levlelColossus.addItem("3");
	    levlelColossus.addItem("4");
	    levlelColossus.addItem("5");
	    pnColossus.add(levlelColossus);
	    
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

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	Date startDate1;
			        startDate1=null; 
	            	if ( IsLandUI.currentHouse.getTimeColossus()==null){
			       		  String startDateString = "18/01/2018";
			       		  DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		       	     
			       		  try {
			       			  startDate1 = df.parse(startDateString);
			       			  String newDateString = df.format(startDate1); 
			       		  } catch (ParseException e1) {
			       			  e1.printStackTrace();
			       		  }
			       			  if ( levlelColossus.getSelectedIndex()!=0)
			       			  JOptionPane.showMessageDialog(null, "Quân phòng thủ đã kích hoạt Colossus lever "+  levlelColossus.getSelectedIndex());
		   			  
			       		  java.util.Date dateNew=new java.util.Date();
			              IsLandUI.currentHouse.setTimeColossus(dateNew);
			              
		       	      } else {
		       	    	  		java.util.Date dateNew=new java.util.Date();  
		       	    	  		long getDiff = dateNew.getTime() - IsLandUI.currentHouse.getTimeColossus().getTime();
		       	    	  		
		       	    	  		if (getDiff<(7*60*1000))  
		       	    	  		{ long tg=7*60*1000-getDiff;
		       	    	  		JOptionPane.showMessageDialog(null, "Sau "+tg/1000+" giây mới có thể kích hoạt Colossus lần tiếp theo" );
		       	    	  		}else {
		       	    	  				if ( levlelColossus.getSelectedIndex()!=0)
		       	    	  					JOptionPane.showMessageDialog(null, "Quân phòng thủ đã kích hoạt Colossus lever "+  levlelColossus.getSelectedIndex());
				   			  
		       	    	  				java.util.Date dateNew1=new java.util.Date();
		       	    	  				IsLandUI.currentHouse.setTimeColossus(dateNew1);
		       	    	  		}
		       	    
		       	      }
	            	
	              
	            	 setColossus();
	            	 dispose();
	            }
	        });
		
	}
	protected void setColossus() {
		 this.dispose();
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