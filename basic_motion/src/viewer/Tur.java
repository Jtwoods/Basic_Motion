package viewer;

import processing.core.PApplet;
import processing.core.PImage;
import structure.Kinematic;
import structure.Skin;

/**
 * Turtle provides a wrapper for an image and 
 * allows the image to be moved around in the 
 * visible viewing area with the translate method
 * and allows the Processing API to provide 
 * rendering of the image.
 * @author James Woods
 *
 */
public class Tur implements Skin {

	private PApplet process;

	private PImage pixel;

	int x;
	int z;
	
	double theta;

	/**
	 * Turtle constructs a Turtle with PApplet 
	 * object that will allow it to perform 
	 * rendering using the processing API and
	 * sets z,x, and theta to default settings 
	 * of 0.
	 * @param processing
	 */
	public Tur(PApplet processing) {
		process = processing;
		pixel = process.loadImage("Turtle.gif");
		x = 0;
		z = 0;
		theta = 0;
	}

	@Override
	public void setRelation(Kinematic orientation) {
		x = orientation.getX();
		z = orientation.getZ();

		// Not sure this is correct. My math is broken right now.
		theta = orientation.getOrientation() - theta;
	}

	@Override
	public void update() {
		//not really sure this will work the way I want it to.
		process.translate(pixel.width / 2, pixel.height / 2);
		process.rotate((float) theta);
		process.translate(-pixel.width / 2, -pixel.height / 2);
		process.set(z, x, pixel);
	}

}
