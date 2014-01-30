package viewer;

import java.util.ArrayList;

import basicmotion.Basic_Motion_Control;
import processing.core.PApplet;
import structure.Drawable;
import structure.GameControl;
import structure.Graphix;

/**
 * AnimationViewer is the graphic front end for the 
 * basic_motion project and displays a simulation of
 * the kinematic motion movement around the edge of the
 * screen.
 * @author James Woods
 *
 */
public class AnimationViewer extends PApplet {

		/**
		 * Default value.
		 */
		private static final long serialVersionUID = 1L;
		
		/**
		 * MAX_Z and MAX_X are the max height and width of the screen.
		 */
		private static final int MAX_Z = 800;
		private static final int MAX_X = 800;
		
		/**
		 * animations are the graphics objects that 
		 * will be displayed during a frame.
		 */
		private ArrayList<Drawable> animations;
		
		/**
		 * GameControl is an interface to an 
		 * object that will have control
		 * of the main processing loop
		 * of the game and will provide 
		 * updates to the pixels based on
		 * internal logic.
		 */
		private GameControl control;

		/**
		 * setup creates a GameControl
		 * and sets up the game.
		 */
		public void setup() {
			this.control = new Basic_Motion_Control(MAX_Z, MAX_X);
			size(MAX_Z, MAX_X);
			frameRate(40);
			//Set up the game.
			control.setup((Graphix) new ProGraph(this));
			animations = new ArrayList<Drawable>();
		}

		/**
		 * draw runs the animation loop, which is the 
		 * graphical control loop.
		 */
		public void draw() {

				//Get the list of animations that need to be displayed.
				animations = control.getNextFrame();
				
				//Get the background and update it.
				control.getBackGround().render();
				
				int stop = animations.size();
				//Update each of the graphics objects.
				for(int i = 0; i < stop; i++) {
					animations.get(i).render();
				}
			
		}
}
