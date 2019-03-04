package edu.neu.csye6200.bg;

import java.util.*;

/**
 * CSYE6200 Assignment 5a
 * @author vaibhavi
 * NUID:001400149
 * Filename:BGGeneration.java
 * class to create and grow generation
 */

public class BGGeneration extends Observable implements Runnable{
	
	ArrayList<BGStem> list1=new ArrayList<BGStem>(); //ArrayList to save the new generation
	
	/*
	 * constructor
	 */
	public BGGeneration() {
		
	}
	Thread thread;
	
	int gen;
	/*
	 * constructor
	 */
	public BGGeneration(int gen) {
		this.n=gen;	
	}

	BGStem s1=new BGStem();
	BGStem c1=new BGStem();
	BGStem c2=new BGStem();
	BGStem c3=new BGStem();
	
	BGRule bgr=new BGRule();
	
	
    int stemid; //id for each stem
    int n=gen;   //Levels of tree
    static int i=0; 
    

	@Override
	public void run() {
        
		list1.clear();
		
		System.out.println(" ");
		System.out.println("Id \t(x1,y1) \t(x2,y2)  \tLength \t  Angle  \t ");
		System.out.println(" ");
		
		s1 = bgr.rule(stemid,s1.x2, s1.y2, 90,20);
		list1.add(s1);
		
		//rule 1:two children
		if(BioGrowthApp.box=="Rule1") { 
			
		    for(int level=1;level<n;level++) {
			   for(int n=0;n<Math.pow(2,level-1);n++) {
				   
			      s1=list1.get(i); 
			      i++;
			      stemid++;
			
			      c1=bgr.rule(stemid,s1.x2, s1.y2,s1.angle+20, s1.length);
			      list1.add(c1); 
			      stemid++;
			
			      c2=bgr.rule(stemid,s1.x2, s1.y2,s1.angle-20,s1.length);
			      list1.add(c2); 
			   }
	
			   try {
			      Thread.sleep(2000);		
		       }catch(InterruptedException e) {
			      e.printStackTrace();
		       }
			
			setChanged();
			notifyObservers(this);
		   }
		//BGGenerationSet.glist.add(bgg);
		    
		   Iterator<BGStem> iterator = list1.iterator();
		   while (iterator.hasNext()) {
				System.out.println(s1.toStringBGStem(iterator.next()));  //Returns the next element until hasNext() returns true 
		   }
	   }
	    //rule 2:three children
		if(BioGrowthApp.box=="Rule2") {
		
			 for(int level=1;level<n;level++) {
				for(int n=0;n<Math.pow(3,level-1);n++) {
					
				   s1=list1.get(i); 
				   i++;
				   stemid++;
				
				   c1=bgr.rule(stemid,s1.x2, s1.y2,s1.angle+12,s1.length);
				   list1.add(c1); 
				   stemid++;
				
				   c2=bgr.rule(stemid,s1.x2, s1.y2,s1.angle-12,s1.length);
				   list1.add(c2); 
				   stemid++;
				   
				   c3=bgr.rule(stemid,s1.x2, s1.y2,s1.angle,s1.length);
				   list1.add(c3); 
				}
		
				try {
				    Thread.sleep(2000);		
			    }catch(InterruptedException e) {
				    e.printStackTrace();
			    }
				
				setChanged();
				notifyObservers(this);
			}
			 
			Iterator<BGStem> iterator = list1.iterator();
			while (iterator.hasNext()) {
					System.out.println(s1.toStringBGStem(iterator.next()));  //Returns the next element until hasNext() returns true 
			}
		}
    }	
}