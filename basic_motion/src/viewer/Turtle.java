package viewer;

import processing.core.PApplet;
import structure.Kinematic;
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
		//x and y are the coordinates for the point.
		protected int x;
		protected int y;
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
	
	//x is the x coordinate of the Turtle. 
	private int x;
	//y is the y coordinate of the Turtle.
	private int y;
	
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
		
		 x = 0;
		 y = 0;
		 
		 setTheta(0);
		
		a = new Point();
		b = new Point();
		c = new Point();
		
	}
	
	/**
	 * setLocation sets the y and x coordinates for the turtle.
	 * @param y the y coordinate.
	 * @param x the x coordinate.
	 */
	public void setLocation(int y, int x) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * setAngle sets the directional angle of the Turtle's head.
	 * @param theta the directional angle that the head is to be set to.
	 */
	public void setAngle(double theta) {
		
		//Limit the size of theta.
		if(theta > TWO_PI)
				theta -= TWO_PI;
		this.theta = theta;
		
		
		//set the position of the head point.
		a.x = (int)((HEAD_DISTANCE *  Math.sin(this.theta)) + x);
		a.y = (int)((HEAD_DISTANCE *  Math.cos(this.theta)) + y);
	
		//set the position of the left Point.
		b.x = (int)((RADIUS *  Math.sin(this.theta + PI_THIRDS)) + x);
		b.y = (int)((RADIUS *  Math.cos(this.theta + PI_THIRDS)) + y);
		
		//set the position of the right Point.
		c.x = (int)((RADIUS *  Math.sin(this.theta - PI_THIRDS)) + x);
		c.y = (int)((RADIUS *  Math.cos(this.theta - PI_THIRDS)) + y);
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	@Override
	public void setRelation(Kinematic orientation) {
		x = orientation.getX();
		y = orientation.getZ();
		setAngle(orientation.getOrientation());
	}

	@Override
	public void update() {
		parent.fill(0);
		parent.ellipse(x,y,DIAMETER,DIAMETER);
		parent.triangle(a.x,a.y,b.x,b.y,c.x,c.y);
	}

}
