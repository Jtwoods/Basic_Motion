package structure;

/**
 * State provides an interface for state changes that are necessary at many
 * levels of a Game Engine.
 * 
 * @author James Woods
 * 
 */
public interface State {

	/**
	 * enter is the entrance point into the State.
	 */
	public void enter();

	/**
	 * update allows the state to perform checks that will determine if the
	 * State should be changed.
	 */
	public void update();

	/**
	 * leave is the exit point for the State.
	 */
	public void leave();

}
