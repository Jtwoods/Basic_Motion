package basicmotion;

import structure.Kinematic;
import ai.Movement;

public class Basic_Motion_Movement extends Movement{

	//X and Z Boundaries are the limits for the characters
	//movement at the edges of the viewable area.
	private int XBoundary;
	private int ZBoundary;
	
	private static final int MAX_VELOCITY = 14;
	
	/**
	 * Basic_Motion_Movement is the constructor for the 
	 * class and initializes the X and Z Boundaries.
	 * @param z the limit for character movement in the Z direction.
	 * @param x the limit for character movement in the X direction.
	 */
	public Basic_Motion_Movement(int z, int x) {
		this.XBoundary = x;
		this.ZBoundary = z;
	}
	
	@Override
	public void update(Kinematic kin, int time) {
		int x = kin.getX() + kin.getVelocityX();
		int z = kin.getZ() + kin.getVelocityZ();
		//If we reach the XBoundary or ZBoundary or zero.
		if(x > (XBoundary - 34) || x == 34 ||
				z > (ZBoundary - 34) || z == 34) {
			//Turn 90 degrees left.
			kin.se
			
		}
		
	}

}
