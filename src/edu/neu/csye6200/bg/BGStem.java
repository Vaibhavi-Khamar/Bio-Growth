package edu.neu.csye6200.bg;

/**
 * CSYE6200 Assignment 5a
 * @author vaibhavi
 * NUID:001400149
 * Filename:BGStem.java
 */

public class BGStem {
	
	public int x1,y1; //start
	public int x2,y2; //end
	public double length;
	public double angle; 
	public int id;
	
	//constructor
	public BGStem() {
		id=1;
		x1=0;
	    y1=0;
	    angle=90;
	    length=20;
	    x2=(int)(Math.cos(Math.toRadians(angle))*10.0);
	    y2=(int)(Math.sin(Math.toRadians(angle))*10.0);		
	}
	
	public String toStringBGStem(BGStem stem) {
		return String.format("%-5d  (%4d,%-4d)  (%4d,%-4d)    %5f     %5.2f ",stem.id,stem.x1,stem.y1,stem.x2,stem.y2,stem.length,stem.angle);
	}
}