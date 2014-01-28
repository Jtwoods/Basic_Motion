package basicmotion;

import java.util.ArrayList;

import ai.AI_Controller;
import skeleton.GameControl;
import skeleton.State;
import structure.Drawable;
import structure.Graphix;
import structure.Kinematic;
import processing.core.PApplet;
import structure.Movable;
import viewer.BackGround;
import viewer.Spot;

public class Basic_Motion_Control extends GameControl {
	
	private Graphix graphics;
	private Level current;
	private int sizeX;
	private int sizeZ;
	private int startX;
	private int startZ;
	private Drawable background;
	private ArrayList<Drawable> sprites;
	private AI_Controller control;
	private Basic_Motion_Movement move;
	private boolean running;
	private int frames;
	
	
	public Basic_Motion_Control(int maxZ, int maxX) {
		sizeX = maxX;
		sizeZ = maxZ;
		startZ = maxZ - 70;
		startX = 70;
	}
	
	/**
	 * Level is the only level for the basic-motion project.
	 * The level begins with the character in one corner. Then the
	 * character moves around the edge of the screen until it has 
	 * moved back to its original position. 
	 * @author James Woods
	 *
	 */
	private class Level implements State {

		/**
		 * pass is a flag that denotes whether the state has performed the 
		 * minimum one iteration of the update method.
		 */
		private boolean pass;
		
		@Override
		public void enter() {
			running = true;
			pass = true;
		}
   
		@Override
		public void update() {
			if(!pass && ((Basic_Motion_Character) sprites.get(0)).getPosition().getX() == startX &&
					((Basic_Motion_Character) sprites.get(0)).getPosition().getZ() == startZ) 
				this.leave();
			else {
				//Update all the sprites.
				for(int i = 0; i < sprites.size(); i++) {
					if(sprites.get(i) instanceof Movable)
						control.update(((Movable)sprites.get(i)).getPosition());
				}
			}
		
		}

		@Override
		public void leave() {
			running = false;
		}
		
	}
	

	@Override
	public void setup(Graphix graphix) {
		this.graphics = graphix;
		//Set frames to zero
		frames = 0;
		//Instantiate the sprites array list;
		sprites = new ArrayList<Drawable>();
		//Instantiate the control
		control = new AI_Controller();
		
		//Instantiate the movement object.
		move = new Basic_Motion_Movement(sizeZ, sizeX);
		
		//Set the movement of the AI_Controller.
		control.setMovement(move);
		//Create the turtle character and place it in the array of sprites.
		sprites.add(new Basic_Motion_Character((PApplet) graphix.getGraphics()));
		//Place the turtle in the start position.
		Kinematic startPosition = new Kinematic(startX, startZ, 0, 2, 0, 0.5);
		((Movable)((Basic_Motion_Character) sprites.get(0))).setPosition(startPosition);
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
	public ArrayList<Drawable> getNextFrame() {
		//If this is the 60th frame create a new dot
		//and place it in the ArrayList of drawables.
		if(frames == 30) {
			//Get the x and y for the Turtle.
			Kinematic position = ((Basic_Motion_Character)sprites.get(0)).getPosition();
			int x = position.getX();
			int z = position.getZ();
			Kinematic dotSpot = new Kinematic(x,z,0.0,0,0,0.0);
			Basic_Motion_Object spot = new Basic_Motion_Object(((PApplet) graphics.getGraphics()));
			spot.setPosition(dotSpot);
			sprites.add(spot);
			frames = 0;
		}
		frames++;
		current.update();
		return sprites;
	}

	@Override
	public Drawable getBackGround() {
		return background;
	}

}
