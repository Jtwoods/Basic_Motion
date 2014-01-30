package basicmotion;

import processing.core.PApplet;
import structure.Character;
import structure.Skin;
import viewer.Turtle;

/**
 * Basic_Motion_Character is the representation 
 * of the Turtle Character used in the Basic_Motion game.
 * @author James Woods
 *
 */
public class Basic_Motion_Character extends Character {
	
	/**
	 * Basic_Motion_Character constructs a Turtle and sets 
	 * the super class's Skin using setSkin.
	 * @param pApplet
	 */
	public Basic_Motion_Character(PApplet pApplet) {
		Skin skin = new Turtle(pApplet);
		super.setSkin(skin);
	}
	
}
