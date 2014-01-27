package viewer;

import processing.core.PApplet;
import structure.Graphix;

/**
 * ProGraph extends Graphics to allow for
 * the use of the Processing API throughout the 
 * game engine.
 * @author James Woods
 *
 */
public class ProGraph extends Graphix {
	
	/**
	 * ProGraph simply passes the PApplet to the 
	 * super object.
	 * @param object
	 */
	public ProGraph(PApplet object) {
		super(object);
	}
}
