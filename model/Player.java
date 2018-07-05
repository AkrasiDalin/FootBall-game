package football_game.model;

public class Player {
	private String name;
	private static int counter;
	private int id = 0;
	private String pathForImage;
	private String specialisation;

	/**
	 * A constructor for the Player with name (as default the name of the class
	 * which is also the name of specialisation) a unique id and a path for an
	 * image which is set to "None".
	 */
	public Player() {
		name = getClass().getSimpleName().toString();
		id = counter++;
		pathForImage = "None";
		specialisation = getClass().getSimpleName().toString();
	}

	/**
	 * Method to get the specialisation of the Player.
	 * @return A string as the specialisation of the Player.
	 */
	public String getSpecialisation() {
		return specialisation;
	}

	/**
	 * Method to get the path for the image associated to the Player.
	 * @return A string as the path for the image.
	 */
	public String getPathForImage() {
		return pathForImage;
	}

	/**
	 * A method to set the path for an image of a Player.
	 * @param pathForImage A string for the path for the image of the Player.
	 */
	public void setPathForImage(String pathForImage) {
		this.pathForImage = pathForImage;
	}

	/**
	 * Method to get the unique id of the Player.
	 * @return An integer which represents the unique id of the Player.
	 */
	public int getId() {
		return id;
	}

	/**
	 * A method to get the name of the Player.
	 * @return A string which represent the name of the Player.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set the name of the Player.
	 * @param name A string to be passed into Player's name field.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Overriding toString() method to give more specific data about this object.
	 * If the player has the default name then the specialisation will not be printed (as they are the same).
	 * If the player has another name than the default one then everything is going the be printed.
	 */
	@Override
	public String toString() {
		if (!name.equals(getClass().getSimpleName().toString())) {
			return "Player (id=" + id + ") is a " + specialisation + " with the name: " + name;
		}
		return "Player (id=" + id + ") is a " + getClass().getSimpleName().toString();
	}

}
