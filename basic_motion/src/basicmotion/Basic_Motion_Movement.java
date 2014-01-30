package basicmotion;

import ai.Kinematic;
import ai.Movement;

public class Basic_Motion_Movement extends Movement{

	//X and Z Boundaries are the limits for the characters
	//movement at the edges of the viewable area.
	private int XBoundary;
	private int ZBoundary;
	
	//zAxis keeps track of which axis is being observed 
	//for out of bound conditions in update.
    private boolean zAxis;
    
    //radiusOfSatisfaction is the distance the
    //center of the Kinematic should be from the edge of the screen
    //before turning.
	private int radiusOfSatisfaction = 50;
	
	//frames is the number of "frames" or chunks of time that
	//have elapsed with movement of the Kinematic orientaton
	//taking place.
	private int frames;
	
	//MAX_VELOCITY is the velocity of the Kinematic.
	private static final int MAX_VELOCITY = 2;
	
	//PI_OVER_TWO is pretty self explanatory.
	private static final double PI_OVER_TWO = Math.PI/2;
	//So is PI.
	private static final double PI = Math.PI;
	
	//CHUNKS_OF_ROTATION is the number of chunks 
	//of time that must elapse before the orientation
	//will match the direction of movement for the 
	//Kinematic.
	private static final int CHUNKS_OF_ROTATION = 6;
	
	
	
	/**
	 * Basic_Motion_Movement is the constructor for the 
	 * class and initializes the X and Z Boundaries.
	 * @param z the limit for character movement in the Z direction.
	 * @param x the limit for character movement in the X direction.
	 */
	public Basic_Motion_Movement(int z, int x) {
		this.XBoundary = x;
		this.ZBoundary = z;
		zAxis = false;
	}
	
	@Override
	public void update(Kinematic kin, double time) {
		double xVel = kin.getVelocityX();
		double zVel = kin.getVelocityZ(); 
		int x = (int)(kin.getX() + xVel*time);
		int z = (int)(kin.getZ() + zVel*time);
		
		

		//If we reach the XBoundary or ZBoundary or zero.
		if(zAxis && ((z + radiusOfSatisfaction > (ZBoundary)) || z < zVel + radiusOfSatisfaction)){
			//Turn 90 degrees left.
			double direction = kin.getVelocityDirection() - PI_OVER_TWO;
			//Set the new direction for the velocity.
			kin.setVelocityDirection(direction);
			
			//Get the x and z components.
			x = (int) (MAX_VELOCITY*kin.getVelocityX());
			z = (int) (MAX_VELOCITY*kin.getVelocityZ());
			
			//set the magnitude of the velocity.
			kin.setMagnitude(MAX_VELOCITY);

			zAxis = false;
		} else if(!zAxis && ((x + radiusOfSatisfaction > (XBoundary)) || x < xVel + radiusOfSatisfaction)){
			//Turn 90 degrees left.
			double direction = kin.getVelocityDirection() - PI_OVER_TWO;
			//Set the new direction for the velocity.
			kin.setVelocityDirection(direction);
			
			//Get the x and z components.
			x = (int) (MAX_VELOCITY*Math.cos(direction));
			z = (int) (MAX_VELOCITY*Math.sin(direction));
			
			//set the magnitude of the velocity.
			kin.setMagnitude(MAX_VELOCITY);
			
			zAxis = true;
		}
		
		x = kin.getX() + (int)(kin.getVelocityX()*time);
		z = kin.getZ() + (int)(kin.getVelocityZ()*time);
		
		//Update the orientation.
		updateOrientation(kin, time);
		kin.setX(x);
		kin.setZ(z);
	}
	
	/**
	 * updateOrientation changes the orientation of the Character gradually
	 * and smoothly from its current direction to the direction of motion.
	 * @param kin the Kinematic variable that contains information about the orientation and
	 * direction of motion.
	 */
	private void updateOrientation(Kinematic kin, double time) {
		//We assume that the amount of elapsed time will be relatively consistent 
		//from frame to frame. We want the transition from current to the direction of motion 
		//to take about 5 chunks of time.
		
		//If there is no difference in orientation and direction set frames to 5;
		if(kin.getOrientation() - kin.getVelocityDirection() < .1)
			frames = 1;
		else {
			double oldTheta = kin.getOrientation();
			double newTheta = mapToRange(kin.getVelocityDirection() - oldTheta);
			newTheta = (newTheta/CHUNKS_OF_ROTATION)*frames;
			frames++;
			if(frames > CHUNKS_OF_ROTATION)
				frames = 1;
			kin.setOrientation(oldTheta + newTheta);
		}
			
		
	}
	
	/**
	 * mapToRange reduces a range of theta in radians to a range of
	 * pi to -pi.
	 * @param theta the theta to map to pi to -pi.
	 * @return the mapped theta.
	 */
	private double mapToRange(double theta) {
		
		//If we in the range of pi and -pi return what we have.
		if(Math.abs(theta) <= PI) {
			return theta;
		}
		else {
			//If theta > pi cut it back.
			if(theta > PI) 
				return theta - PI;
			else
				return theta + PI;
		}
	}

}
