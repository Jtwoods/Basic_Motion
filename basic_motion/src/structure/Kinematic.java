package structure;

/**
 * Kinematic provides Kinematic data relevant to a 2D environment and can be
 * extended to provide 3D data and data for Steering if needed.
 * 
 * @author James Woods
 * 
 */
public class Kinematic {

	/**
	 * x is the position in the x axis.
	 */
	private int x;

	/**
	 * z is the position in the z axis.
	 */
	private int z;

	/**
	 * orientation is the direction that the object is facing (radians).
	 */
	private double orientation;

	protected class Vector2D {

		/**
		 * magnitude is the magnitude of the vector.
		 */
		private int magnitude;
		
		/**
		 * theta is the direction of the vector in radians.
		 */
		private double theta;
		
		/**
		 * Vector2D is a vector with magnitude and direction.
		 * @param magnitude the magnitude of the vector.
		 * @param theta the direction of the vector in rdians.
		 */
		public Vector2D(int magnitude, double theta) {
			this.magnitude = magnitude;
			this.theta = theta;
		}
		
		/**
		 * setMagnitude sets the magnitude of the vector.
		 * @param mag the new magnitude.
		 */
		public void setMagnitude(int mag) {
			this.magnitude = mag;
		}
		
		/**
		 * setDirection sets the direction of the vector.
		 * @param theta
		 */
		public void setDirection(double theta) {
			this.theta = theta;
		}
		
		/**
		 * getTheta returns the current direction of the vector.
		 * @return the direction of the vector.
		 */
		public double getTheta() {
			return theta;
		}
		
		/**
		 * getMagnitude returns the current magnitude of the vector.
		 * @return the magnitude.
		 */
		public int getMagnitude() {
			return magnitude;
		}

		/**
		 * getX returns the current velocity in the x direction.
		 * 
		 * @return the x velocity.
		 */
		public double getX() {
			return magnitude*Math.cos(theta);
		}


		/**
		 * getZ returns the current z direction.
		 * 
		 * @return the z direction.
		 */double getZ() {
			return  magnitude*Math.sin(theta);
		}

	}

	/**
	 * velocity is the vector representation of the velocity of this object.
	 */
	private Vector2D velocity;
	

	/**
	 * rotationlV is the rotational velocity (radians/units of movement).
	 */
	private double rotationalV;

	/**
	 * Kinematic is the constructor for the kinematic variable.
	 * 
	 * @param x
	 *            the initial x position.
	 * @param z
	 *            the initial y position.
	 * @param orientation
	 *            the initial orientation.
	 * @param velocity
	 *            the initial magnitude of the velocity.
	 * @param direction 
	 *            the initial direction of the velocity.
	 * @param rotationalV
	 *            the initial rotational velocity.
	 */
	public Kinematic(int x, int z, double orientation, int velocity,
			double direction, double rotationalV) {
		super();
		this.x = x;
		this.z = z;
		this.orientation = orientation;
		this.velocity = new Vector2D(velocity, direction);
		this.rotationalV = rotationalV;
	}

	/**
	 * getX returns the current x position.
	 * 
	 * @return the current x position.
	 */
	public int getX() {
		return x;
	}

	/**
	 * setX sets the current x position.
	 * 
	 * @param x
	 *            the new x position.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * getZ returns the current z position.
	 * 
	 * @return the current z position.
	 */
	public int getZ() {
		return z;
	}

	/**
	 * setZ sets the current z position.
	 * 
	 * @param z
	 *            the new z position.
	 */
	public void setZ(int z) {
		this.z = z;
	}

	/**
	 * getOrientation returns the current orientation in radians.
	 * 
	 * @return the current orientation in radians.
	 */
	public double getOrientation() {
		return orientation;
	}

	/**
	 * setOrientation sets the current orientation.
	 * 
	 * @param d
	 *            the new orientation in radians.
	 */
	public void setOrientation(double d) {
		this.orientation = d;
	}

	/**
	 * getVelocityX returns the current velocity in the x direction.
	 * 
	 * @return the x velocity.
	 */
	public double getVelocityX() {
		return velocity.getX();
	}

	/**
	 * setMagnitude sets the velocity.
	 * 
	 * @param velocity
	 *            the new magnitude for the velocity.
	 */
	public void setMagnitude(int velocity) {
		this.velocity.setMagnitude(velocity);
	}
	
	/**
	 * setVelocityDirection sets the direction of the velocity.
	 * @param direction is the new direction of the velocity.
	 */
	public void setVelocityDirection(double direction) {
		this.velocity.setDirection(direction);
	}

	/**
	 * getVelocityZ returns the current velocity in the z direction.
	 * 
	 * @return the z velocity.
	 */
	public double getVelocityZ() {
		return velocity.getZ();
	}


	/**
	 * getRotationalV returns the current rotational velocity.
	 * 
	 * @return the rotational velocity.
	 */
	public double getRotationalV() {
		return rotationalV;
	}

	/**
	 * setRotationalV sets the rotational velocity.
	 * 
	 * @param rotationalV
	 *            the new rotational velocity.
	 */
	public void setRotationalV(double rotationalV) {
		this.rotationalV = rotationalV;
	}
	
	/**
	 * getVelocityDirection returns the angle created by the velocity vectors.
	 * @return the angle created by the velocity vectors.
	 */
	public double getVelocityDirection() {
		return velocity.getTheta();
	}

}
