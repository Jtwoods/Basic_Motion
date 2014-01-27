package basicmotion;

import skeleton.GameControl;
import skeleton.State;
import structure.Drawable;
import structure.Graphix;
import structure.Kinematic;
import processing.core.PApplet;
import structure.Movable;
import viewer.BackGround;

public class Basic_Motion_Control extends GameControl {
	
	private Level current;
	private int startX = 320;
	private int startZ = 320;
	private Drawable background;
	private Drawable[] sprites;
	
	private boolean running;
	
	/**
	 * Level is the only level for the basic-motion project.
	 * The level begins with the character in one corner. Then the
	 * character moves around the edge of the screen until it has 
	 * moved back to its original position. 
	 * @author James Woods
	 *
	 */
	private class Level implements State {

		@Override
		public void enter() {
			running = true;
		}

		@Override
		public void update() {
			if(((Basic_Motion_Character) sprites[0]).getPosition().getX() == startX &&
					((Basic_Motion_Character) sprites[0]).getPosition().getZ() == startZ) 
				this.leave();
		}

		@Override
		public void leave() {
			running = false;
		}
		
	}
	
	@Override
	public void setup(Graphix graphix) {
		//Instantiate the sprites array;
		sprites = new Drawable[1];
		//Create the turtle character and place it in the array of sprites.
		sprites[0] = new Basic_Motion_Character((PApplet) graphix.getGraphics());
		//Place the turtle in the start position.
		Kinematic startPosition = new Kinematic(startZ, startX, 0.0, 10, 10, 0.5);
		((Movable)((Basic_Motion_Character) sprites[0])).setPosition(startPosition);
		//Create the level.
		current = new Level();
		current.enter();
		//Set the background.
		background = new BackGround((PApplet) graphix.getGraphics());
		
	}

	@Override
	public boolean hasNextFrame() {
		return running;
	}

	@Override
	public Drawable[] getNextFrame() {
		current.update();
		return sprites;
	}

	@Override
	public Drawable getBackGround() {
		return background;
	}

}
