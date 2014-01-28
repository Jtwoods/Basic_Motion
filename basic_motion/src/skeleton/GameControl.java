package skeleton;

import java.util.ArrayList;

import structure.Drawable;
import structure.Graphix;

/**
 * GameControl provides an interface that allows
 * an object to provide methods that support 
 * a logical control for a video game.
 * @author James Woods
 *
 */
public abstract class GameControl {

	/**
	 * setup passes a Graphix object on to the
	 * GameControl allowing the GameControl
	 * to make use of the graphics API and
	 * creates the logical structures needed for 
	 * a game.
	 * @param graphix a graphical object for the 
	 * graphics API.
	 */
	public abstract void setup(Graphix graphix);

	/**
	 * hasNextFrame returns true if there are more 
	 * frames to render by using internal logical structures.
	 * @return true if there are more frames to render
	 * false if not.
	 */
	public abstract boolean hasNextFrame();

	/**
	 * getNextFrame returns an array of Drawable
	 * objects that can be rendered by the graphics API.
	 * @return
	 */
	public abstract ArrayList<Drawable> getNextFrame();

	/**
	 * getBackGround returns a Drawable background. 
	 * @return
	 */
	public abstract Drawable getBackGround();
	
}
