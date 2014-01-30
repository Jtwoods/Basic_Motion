package basicmotion;

import processing.core.PApplet;
import structure.Character;
import structure.Skin;
import viewer.Spot;

public class Basic_Motion_Object extends Character{

	public Basic_Motion_Object(PApplet pApplet) {
		Skin skin = (Skin) new Spot(pApplet);
		super.setSkin(skin);
	}
	
}
