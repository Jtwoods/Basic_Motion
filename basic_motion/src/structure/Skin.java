package structure;

import ai.Kinematic;

/**
 * Skin provides a handle for an
 * image or pixel animation allowing
 * for complex motion through a simple
 * interface.
 * @author James Woods
 *
 */
public interface Skin {
	
	/**
	 * setRelation takes a Kinematic variable
	 * and performs operations on the object to
	 * represent the given orientation graphically.
	 * @param orientation the new orientation.
	 */
	public void setRelation(Kinematic orientation);
	
	/**
	 * update uses the Graphics API of the Character to perform the
	 * action of updating the graphics.
	 */
	void update();
	
}
