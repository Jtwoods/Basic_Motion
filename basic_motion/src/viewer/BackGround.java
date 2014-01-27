package viewer;

import processing.core.PApplet;
import structure.Drawable;

/**
 * BackGround implements Drawable using the Processing API
 * and provides a simple grey background.
 * @author James Woods
 *
 */
public class BackGround implements Drawable {

	/**
	 * process is the instance of PApplet used to refresh the background.
	 */
	private PApplet process;
	
	/**
	 * BackGround sets process to the provided PApplet instance.
	 * @param process is an instance of a PApplet used to set the
	 * background.
	 */
	public BackGround(PApplet process) {
		this.process = process;
	}
	
	@Override
	public void render() {
		process.background(240);
	}

}
