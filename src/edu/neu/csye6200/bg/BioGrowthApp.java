package edu.neu.csye6200.bg;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane; //dialog box
import javax.swing.JPanel;

/**
 * A Test application for the  Biological Growth application
 * @author vaibhavi
 *
 */
public class BioGrowthApp extends BGApp{
	
	private static Logger log = Logger.getLogger(BioGrowthApp.class.getName());

	static boolean bStart=false;
	static boolean bStop=false;
	static boolean bPause = false;
	static String box="Rule1"; //default
	BGGeneration bg;//=new BGGeneration();
	private BGCanvas canvas=null;
	Thread thread=null;
	int gen=0;
	
    /**
     * Sample app constructor
     */
	public BioGrowthApp() {
		log.info("BioGrowth App started");
		initGui();
		showUI();
	}
	
	/**
   	 * method to initial GUI
   	 */
	public void initGui() {
		super.initGUI();
		
		  frame.setSize(900, 700);  //frame
		  frame.setTitle("Biological Growth");
		  frame.setResizable(true);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.addWindowListener(this); 
		  frame.setLayout(new BorderLayout());
		  frame.add(getNorthPanel(),BorderLayout.NORTH);
		  frame.add(getMainPanel(), BorderLayout.CENTER);
		  frame.setVisible(true);
	}
	
	/**
   	 * method to create northPanel
   	 */
	@Override
	public JPanel getNorthPanel() {
		super.getNorthPanel();
		
		//"Start" button
		startBtn.addActionListener(new ActionListener(){  //ActionListener for Start
			public void actionPerformed(ActionEvent e) {
				log.info("Start button pressed");
				
				
				//If thread is running and start was already pressed ,create a warning dialog
				if(Thread.currentThread().isAlive() && bStart) {
					JOptionPane.showMessageDialog(panel, "Please Stop before Start","WARNING", JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						
						//int gen=Integer.valueOf(textField.getText()).intValue();
						gen=Integer.parseInt(textField.getText());
	   					
	   					bg=new BGGeneration(gen);
						bg.addObserver(canvas);
						thread = new Thread(bg);
	   					
	   					//start the thread
	   					thread.start();
					}catch(NumberFormatException exc) {
						bStop=true;
						JOptionPane.showMessageDialog(panel, "Please input valid number", "WARNING", JOptionPane.WARNING_MESSAGE);
					}			
					bStart=true;
					bStop=false;
				}
			}
		});
		
		//"Pause" button
   		pauseBtn.addActionListener(new ActionListener(){	
  			 public void actionPerformed(ActionEvent e){
  				 log.info("Pause button pressed");
  				 //if Stop was not pressed let the thread wait
  				 /*if(!bStop) {
  					 bPause = true;*/
  				 if(thread.isAlive()) {
  					 thread.suspend();
  					 
  					 System.out.println("pause:"+thread.getState());
  				     System.out.println(thread.getState());
  				 //if not create a warning dialog
  				 }else{
  					JOptionPane.showMessageDialog(panel, "Please Restart ", "WARNING",JOptionPane.WARNING_MESSAGE);
  				 }
  			 }
  		 });
   		
   	   //"Resume" button
   	   resumeBtn.addActionListener(new ActionListener(){	
  			 public void actionPerformed(ActionEvent e){
  				log.info("Resume button pressed"); 
  				thread.resume();
  				System.out.println("resumed");
  			 }
   		});
		
		
		//"Stop" button
		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log.info("Stop button pressed");
				System.out.println("Stop:"+thread.getState());
				System.out.println(thread.getState());
				
				bStop=true;
				bStart=false; 
				bPause = false; 
				
  				 //wake up and stop the thread
				if(thread.isAlive()) {
					thread.stop();
 				 }	
				//clear the list
			     bg.list1.clear();
			    // mainPanel.repaint();
			     System.out.println(bg.list1);
			}
		});
		
		//comboBox
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log.info("Rule selected");			
				box=(String) comboBox.getSelectedItem();
			}
		});
		
		return northPanel;
		
	}
	
	
	@Override
	public JPanel getMainPanel() {
	
		mainPanel = new JPanel();
    	mainPanel.setLayout(new BorderLayout());
    
    	canvas = new BGCanvas();
    	mainPanel.add(BorderLayout.CENTER, canvas);
    	
    	return mainPanel;
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		log.info("Window opened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		log.info("Window closing");
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		log.info("Window closed");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		log.info("Window iconified");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		log.info("Window deiconified");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		log.info("Window activated");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		log.info("Window deactivated");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Sample application starting point
	 * @param args
	 */
	public static void main(String[]args) {
		BioGrowthApp bga=new BioGrowthApp();
	}
}