package viewer;

import ai.Kinematic;
import processing.core.PApplet;
import structure.Skin;

/**
 * Turtle is a simple animation that portrays location and
 * directionality.
 * @author James Woods
 *
 */
public class Turtle implements Skin{
	
	
	/**
	 * Point is used to mark the points of a triangle.
	 * @author James Woods
	 *
	 */
	private class Point {
		//z and x are the coordinates for the point.
		protected int z;
		protected int x;
	}

	/**
	 * HEAD_DISTANCE is the distance from the 
	 * center of the Turtle to the tip of the head.
	 */
	private static final int HEAD_DISTANCE = 22;
	
	/**
	 * RADIUS is the radius of the body of the Turtle.
	 */
	private static final int RADIUS = 9;
	
	/**
	 * DIAMETER is the diameter of the body of the turtle 
	 * used to calculate the distance between the corners of the 
	 * head.
	 */
	private static final int DIAMETER = 19;
	
	/**
	 * PI_THIRDS is pi divided by three.
	 */
	private static final double PI_THIRDS = Math.PI / 3;
	
	/**
	 * TWO_PI is two times pi.
	 */
	private static final double TWO_PI = Math.PI * 2;
	
	private Kinematic kin;
	
	/**
	 * parent is the PApplet that will render the turtle
	 * on the PApplet.
	 */
	private PApplet parent;
	
	//a is the outer point of the triangle used for the Turtle's head.
	private Point a;
	
	//b is the left point of the triangle used for the Turtle's head.
	private Point b;
	
	//c is the right point of the triangle used for the Turtle's head.
	private Point c;

	//theta is the current direction of the turtle.
	private double theta;
	
	
	/**
	 * Turtle is the constructor for the Turtle class
	 * @param p the PApplet that will draw the Turtle
	 */
	public Turtle(PApplet p) {
		parent = p;
		
		kin = new Kinematic(0,0,0.0,0,0,0.0);
		setTheta(0);
		
		a = new Point();
		b = new Point();
		c = new Point();
		
	}
	
	
	private void setTheta(double i) {
		theta = i;
	}


	/**
	 * setAngle sets the directional angle of the Turtle's head.
	 * @param theta the directional angle that the head is to be set to.
	 */
	public void setAngle(double theta) {
		
		int x = kin.getX();
		int z = kin.getZ();
		//Limit the size of theta.
		if(theta > TWO_PI)
				theta -= TWO_PI;
		this.theta = theta;
		
		
		//set the position of the head point.
		a.z = (int)((HEAD_DISTANCE *  Math.sin(this.theta)) + z);
		a.x = (int)((HEAD_DISTANCE *  Math.cos(this.theta)) + x);
	
		//set the position of the left Point.
		b.z = (int)((RADIUS *  Math.sin(this.theta + PI_THIRDS)) + z);
		b.x = (int)((RADIUS *  Math.cos(this.theta + PI_THIRDS)) + x);
		
		//set the position of the right Point.
		c.z = (int)((RADIUS *  Math.sin(this.theta - PI_THIRDS)) + z);
		c.x = (int)((RADIUS *  Math.cos(this.theta - PI_THIRDS)) + x);
		
	}

	@Override
	public void setRelation(Kinematic orientation) {
		kin = orientation;
	}

	@Override
	public void update() {
		setAngle(kin.getOrientation());
		parent.fill(0);
		parent.ellipse(kin.getX(),kin.getZ(),DIAMETER,DIAMETER);
		parent.triangle(a.x,a.z,b.x,b.z,c.x,c.z);
	}

}
