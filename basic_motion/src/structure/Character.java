package structure;


/**
 * Character is a very basic implementation
 * of a 2d character and can be used as a 
 * platform for more complex types of Characters.
 * @author James Woods
 *
 */
public abstract class Character implements Drawable, Movable {
	
	/**
	 * relation is the Kinematic object that contains
	 * this Character's current location and direction.
	 */
	private Kinematic relation;

	/**
	 * skin is a handle to an Object that implements
	 * Skin and provides some graphical representation
	 * that can represent the Character.
	 */
	private Skin skin;
	
	/**
	 * Character is the default constructor for the Character object.
	 * Note: Although Character is not abstract and defines some 
	 * operations, it is meant to be extended to utilize API specific
	 * components.
	 */
	public Character() {
		
	}
	
	/**
	 * setSkin allows the Character
	 * to set a visible Skin component.
	 * @param skin the visible Skin component.
	 */
	public void setSkin(Skin skin) {
		this.skin = skin;
	}
	
	@Override
	public void render() {
		skin.update();
	}

	@Override
	public void setPosition(Kinematic position) {
		relation = position;
		skin.setRelation(position);
	}

	@Override
	public Kinematic getPosition() {
		return relation;
	}
	
}
