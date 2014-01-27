package ai;

import structure.Kinematic;

/**
 * AI_Controller provides a handle and template for 
 * AI_Controllers.
 * @author James Woods
 *
 */
public class AI_Controller {
	
	/**
	 * movement is an object that controls
	 * the movement of a character.
	 */
	private Movement movement;
	
	/**
	 * AI_Controller is the default constructor for the class.
	 */
	public AI_Controller() {
		
	}
	
	/**
	 * setMovement sets the Movement object.
	 * @param move the Movement object to be set.
	 */
	public void setMovement(Movement move) {
		this.movement = move;
	}
	
	/**
	 * update takes a Kinematic and an int (time that the game
	 * has been running) and produces a new location for the 
	 * Kinematic object, sets the Kinematic to the new position.
	 * @param kin the Kinematic to be updated.
	 * @param time the elapsed time in millisoconds.
	 */
	public void update(Kinematic kin, int time) {
		movement.update(kin, time);
	}
	
	//More functionality will be added here 
	//as we learn about strategy and decisions.
	
}
