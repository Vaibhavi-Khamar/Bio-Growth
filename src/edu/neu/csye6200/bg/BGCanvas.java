package edu.neu.csye6200.bg;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import java.util.Iterator;
 
/**
 * class to create a thread to draw the picture
 * @author vaibhavi
 *
 */
public class BGCanvas extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(BGCanvas.class.getName());
    static int gen=0; //generations to display
    private long counter = 0L;
    private Color col = null;
    ArrayList<BGStem>list1=new ArrayList<>();
    BGGeneration bggen=new BGGeneration();
    BGStem stem=new BGStem();
    
    
    /**
     * Canvas constructor
     */
	public BGCanvas() {
		col = Color.WHITE;
	}

	/**
	 * The UI thread calls this method when the screen changes, or in response
	 * to a user initiated call to repaint();
	 */
	public void paint(Graphics g) {
		drawBG(g); // Our Added-on drawing
    }
	
	/**
	 * Draw the BG graphics panel
	 * @param g
	 */  
    public void drawBG(Graphics g) {
    	log.info("Drawing BG " + counter++);
    	Graphics2D g2d=(Graphics2D)g;
    	Dimension size=getSize();
    	
    	if(bggen!=null)
    	System.out.println("size : "+bggen.list1.size());
    	g2d.setColor(Color.lightGray);
		g2d.fillRect(0, 0, size.width, size.height);
		Iterator<BGStem> iterator=bggen.list1.iterator();
		while(iterator.hasNext()) {	
			
			  stem=(iterator.next());
			  
			  if(BioGrowthApp.box=="Rule1") {
			     g.setColor(Color.BLACK);
			  }
			  if(BioGrowthApp.box=="Rule2") {
				  g.setColor(Color.YELLOW);
			  }
			  
			  int width=size.width/2;
			  int height=size.height;
			  g.drawLine(width+stem.x1, height-stem.y1, width+stem.x2, height-stem.y2);
		}
    }	
    
    /**
	 *method to receive data from BioGrowthApp
	 */
	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("Update method");
		if(arg !=null) {
			bggen=(BGGeneration)arg;
			System.out.println("Data: "+bggen.list1.size());
		}
	
		System.out.println(arg);
		this.revalidate();
		this.repaint();	
	}
}
