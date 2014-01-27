package viewer;

import basicmotion.Basic_Motion_Control;
import processing.core.PApplet;
import skeleton.GameControl;
import structure.Drawable;
import structure.Graphix;
import structure.Character;

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
		 * animations are the graphics objects that 
		 * will be displayed during a frame.
		 */
		private Drawable[] animations;
		
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
			this.control = new Basic_Motion_Control();
			size(400, 400);
			frameRate(5);
			//Set up the game.
			control.setup((Graphix) new ProGraph(this));
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
				
				//Update each of the graphics objects.
				for(int i = 0; i < animations.length; i++) {
					if(animations[i] instanceof Character) {
						
					}
					animations[i].render();
				}
			
		}
}
