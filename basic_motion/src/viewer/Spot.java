package viewer;

import ai.Kinematic;
import processing.core.PApplet;
import structure.Skin;

/**
 * Spot is a very simple class of viewable object
 * implementing the Skin interface to provide
 * a circle with radius 2.5.
 * @author James Woods
 *
 */
public class Spot implements Skin{
	
	/**
	 * DIAMETER is the diameter used for the Spot.
	 */
	private static final int DIAMETER = 5; 
	
	/**
	 * relation is the position of this Spot.
	 */
	private Kinematic relation;
	
	/**
	 * process is an instance of the PApplet viewer.
	 */
	private PApplet process;
	
	/**
	 * Spot is the simple constructor for the SPot.
	 * @param process the graphics object used to display the Spot.
	 */
	public Spot(PApplet process) {
		this.process = process;
	}
	

	@Override
	public void setRelation(Kinematic orientation) {
		this.relation = orientation;
	}

	@Override
	public void update() {
		process.fill(211);
		process.ellipse(relation.getX(), relation.getZ(), DIAMETER, DIAMETER);
	}
	
}
