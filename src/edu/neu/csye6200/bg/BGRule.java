package edu.neu.csye6200.bg;

/**
 * CSYE6200 Assignment 5a
 * @author vaibhavi
 * NUID:001400149
 * Filename:BGRule.java
 * class to apply rule to grow a tree
 */

public class BGRule {
	public BGStem rule(int id,int x1,int y1,double angle,double length) {
		
		BGStem stemm=new BGStem();
		
		//rule 1
		if(BioGrowthApp.box=="Rule1") {
		      id++;
	          stemm.id=id;
	          stemm.x1=x1;
	          stemm.y1=y1;
	          stemm.x2=x1+(int)(Math.cos(Math.toRadians(angle)) * 30);
	          stemm.y2=y1+(int)(Math.sin(Math.toRadians(angle)) * 30);
	          stemm.length=length-1; //length decreases at every level
	          stemm.angle=angle;   
		}

		//rule 2
		if(BioGrowthApp.box=="Rule2") {
			  id++;
		      stemm.id=id;
		      stemm.x1=x1;
		      stemm.y1=y1;
		      stemm.x2=x1+(int)(Math.cos(Math.toRadians(angle)) * 50);
		      stemm.y2=y1+(int)(Math.sin(Math.toRadians(angle)) * 50);
		      stemm.length=length-4; //length decreases at every level
		      stemm.angle=angle;   
		}
		return stemm;
	}
}