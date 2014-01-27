package structure;

public abstract class Graphix {
	
	/**
	 * graphics is an API specific graphics object.
	 */
	private Object graphics;
	
	/**
	 * Graphix is the constructor for the Gaphix sub class
	 * and provides a wrapper for the specific API graphics 
	 * object.
	 * @param graphics the API specific graphics object.
	 */
	public Graphix(Object graphics) {
		this.graphics = graphics;
	}
	
	/**
	 * getGraphics returns the API specific 
	 * graphics object.
	 * @return the API specific graphics object.
	 */
	public Object getGraphics() {
		return graphics;
	}
}
