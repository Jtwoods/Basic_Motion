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
		 * velocityX is the velocity in the x direction.
		 */
		private int x;

		/**
		 * celocityY is the velocity in the y direction.
		 */
		private int z;

		public Vector2D(int z, int x) {
			this.x = x;
			this.z = z;
		}

		/**
		 * getVelocityX returns the current velocity in the x direction.
		 * 
		 * @return the x velocity.
		 */
		public int getX() {
			return x;
		}

		/**
		 * setX sets the x direction.
		 * 
		 * @param x the x direction.
		 */
		public void setX(int x) {
			this.x = x;
		}

		/**
		 * getZ returns the current z direction.
		 * 
		 * @return the z direction.
		 */
		public int getZ() {
			return z;
		}

		/**
		 * setZ sets the z direction.
		 * 
		 * @param z the new z direction.
		 */
		public void setZ(int z) {
			this.z = z;
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
	 * @param velocityX
	 *            the initial velocity in the x direction.
	 * @param velocityZ
	 *            the initial velocity in the y direction.
	 * @param rotationalV
	 *            the initial rotational velocity.
	 */
	public Kinematic(int x, int z, double orientation, int velocityX,
			int velocityZ, double rotationalV) {
		super();
		this.x = x;
		this.z = z;
		this.orientation = orientation;
		velocity = new Vector2D(velocityZ, velocityX);
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
	 * @param orientation
	 *            the new orientation in radians.
	 */
	public void setOrientation(float orientation) {
		this.orientation = orientation;
	}

	/**
	 * getVelocityX returns the current velocity in the x direction.
	 * 
	 * @return the x velocity.
	 */
	public int getVelocityX() {
		return velocity.getX();
	}

	/**
	 * setVelocityX sets the velocity in the x direction.
	 * 
	 * @param velocityX
	 *            the velocity in the x direction.
	 */
	public void setVelocityX(int velocityX) {
		this.velocity.setX(velocityX);
	}

	/**
	 * getVelocityZ returns the current velocity in the z direction.
	 * 
	 * @return the z velocity.
	 */
	public int getVelocityZ() {
		return velocity.getZ();
	}

	/**
	 * setVelocityZ sets the velocity in the z direction.
	 * 
	 * @param velocityZ
	 *            the new z velocity.
	 */
	public void setVelocityZ(int velocityZ) {
		this.velocity.setZ(velocityZ);
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
	public void setRotationalV(float rotationalV) {
		this.rotationalV = rotationalV;
	}

	/**
	 * asVector returns the current heading as a vector.
	 * 
	 * @return the directional vector.
	 */
	public double asMagnitude() {
		return Math.sqrt((double) ((x * x) + (z * z)));
	}

	/**
	 * returns a Vector2D representation that is the normalized 
	 * x and z for the velocity of this object.
	 * @return the Vector2D representation of the normalized velocity.
	 */
	public Vector2D velocityAsNormVector() {
		
		int velocityX = velocity.getX();
		int velocityZ = velocity.getZ();
		
		velocityX = (int) (velocityX / asMagnitude());
		velocityZ = (int) (velocityZ / asMagnitude());
		
		return new Vector2D(velocityZ, velocityX);
	}

}
