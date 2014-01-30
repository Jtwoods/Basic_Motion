package structure;
import ai.Kinematic;

/**
 * Movable is a basic interface that 
 * provides a game object with the ability 
 * to be moved by an AI_Engine.
 * @author James Woods
 *
 */
public interface Movable {
	
	/**
	 * setPosition takes a Kinematic object and 
	 * sets this as the new position of the Movable 
	 * object.
	 * @param position the new position of the object.
	 */
	public void setPosition(Kinematic position);
	
	/**
	 * getPosition returns the current position of the object.
	 * @return the current position of the object.
	 */
	public Kinematic getPosition();

}
