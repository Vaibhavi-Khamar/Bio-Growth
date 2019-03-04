package edu.neu.csye6200.bg;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;  
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


/**
 * A sample Biological Growth Abstract application class
 * @author vaibhavi
 *
 */
public abstract class BGApp implements ActionListener,WindowListener{
    protected JFrame frame=null;
    protected JPanel panel=null;
    static protected JPanel mainPanel = null;
	protected JPanel northPanel = null;
	protected JButton startBtn = null;
	protected JButton stopBtn = null;
	protected JButton pauseBtn = null;
	protected JButton resumeBtn = null;
	protected Label label1=null;
	protected Label label2=null;
	protected static JTextField textField=null;
	protected JComboBox comboBox=null;
    protected BGCanvas bgPanel = null;
    
    /**
	 * The Biological growth constructor
	 */
    /*
	public BGApp() {
		// TODO Auto-generated constructor stub
	}
	*/
    
    
    /**
	 * Initialize the Graphical User Interface
	 */
	public void initGUI() {
		frame= new JFrame(); //create a frame
		panel=new JPanel(); //create a panel		
	}
    
	/**
	 * method to create northPanel
	 */
	public JPanel getNorthPanel() {
	    	northPanel = new JPanel();
	    	northPanel.setLayout(new FlowLayout());
	    	
	    	startBtn = new JButton("Start");
	    	//startBtn.addActionListener(this); // Allow the app to hear about button pushes
	    	northPanel.add(startBtn);
	    	
	    	stopBtn = new JButton("Stop"); // Allow the app to hear about button pushes
	    	//stopBtn.addActionListener(this);
	    	northPanel.add(stopBtn);
	    	
	    	pauseBtn = new JButton("Pause");
	    	northPanel.add(pauseBtn);
	       	resumeBtn = new JButton("Resume");
	   		northPanel.add(resumeBtn);

	    	label1=new Label("Number of Generations : ");
	    	northPanel.add(label1);
	    	
	    	textField=new JTextField(10);
	    	northPanel.add(textField);
	    	
	    	label2=new Label("Select a rule : ");
	    	northPanel.add(label2);
	    	
	    	comboBox=new JComboBox();
	    	comboBox.addItem("Rule1");
	    	comboBox.addItem("Rule2");
	    	northPanel.add(comboBox);

	    	northPanel.setBackground(Color.GRAY);
	    	
	    	return northPanel;
	    }
	
	 /**
     * Override this method to provide the main content panel.
     * @return a JPanel, which contains the main content of of your application
     */
	public abstract JPanel getMainPanel();
	
	/**
     * A convenience method that uses the Swing dispatch threat to show the UI.
     * This prevents concurrency problems during component initialization.
     */
    public void showUI() {
    	
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	frame.setVisible(true); // The UI is built, so display it;
            }
        });  	
    }	
}