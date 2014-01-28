package ai;

import structure.Kinematic;

/**
 * Movement provides some very basic Kinematic motion
 * for a Movable object
 * @author James Woods
 *
 */
public abstract class Movement {
	
	/**
	 * update updates a Kinematic variable 
	 * used by a Character to allow believable 
	 * Kinematic movement of a Character object.
	 * @param kin the current Kinematic relation.
	 * @param time the elapsed time since the previous 
	 * update.
	 */
	public abstract void update(Kinematic kin, double time);
	
}
