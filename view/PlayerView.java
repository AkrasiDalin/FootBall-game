package football_game.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PlayerView extends JPanel {

	private String imagePath;
	private String name;
	private String specialisation;
	private JTextField nameTextField;
	private JButton imageButton;
	private int id;

	/**
	 * Constructor for the PlayerView that sets the layout and triggers the
	 * method to create and add the widgets.
	 */
	public PlayerView() {
		setLayout(new BorderLayout());
		setOpaque(false);
		createWidgets();
	}

	/**
	 * Adding a JButton (the imageButton) and a JTextField (nameTextField).
	 */
	public void createWidgets() {
		imageButton = new JButton();
		imageButton.setPreferredSize(new Dimension(92, 77));
		imageButton.setBorderPainted(false);
		imageButton.setRolloverIcon(new ImageIcon("src/dalinrazvan/Resources/default.png"));
		add(imageButton, BorderLayout.CENTER);

		nameTextField = new JTextField(name);
		nameTextField.setHorizontalAlignment(0);
		nameTextField.setOpaque(false);
		add(nameTextField, BorderLayout.SOUTH);
	}

	/**
	 * Method to retrieve the specialisation of the Player from the view.
	 *
	 * @return A String which represents the specialisation of the Player stored
	 *         inside the Player View.
	 */
	public String getSpecialisation() {
		return specialisation;
	}

	/**
	 * A method to set the specialisation of the Player View.
	 *
	 * @param specialisation
	 *            A string to pass to the specialisation field from the Player
	 *            View.
	 */
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	/**
	 * A method to set the name of the Player View.
	 *
	 * @param name
	 *            A string to pass to the name field from the Player View.
	 */
	public void setPlayerName(String name) {
		this.name = name;
		nameTextField.setText(name);
	}

	/**
	 * Method to retrieve the name of the Player from the view.
	 *
	 * @return A String which represents the name of the Player stored inside
	 *         the Player View.
	 */
	public String getPlayerName() {
		return name;
	}

	/**
	 * Method to retrieve the imageButton of the Player from the view.
	 *
	 * @return A JButton which represents the imageButton of the Player stored
	 *         inside the Player View.
	 */
	public JButton getImageButton() {
		return imageButton;
	}

	/**
	 * Method to retrieve the nameTextField of the Player from the view.
	 *
	 * @return A JTextField which represents the nameTextField of the Player
	 *         stored inside the Player View.
	 */
	public JTextField getNameTextField() {
		return nameTextField;
	}

	/**
	 * Method to retrieve the imagePath of the Player from the view.
	 *
	 * @return A String which represents the imagePath of the Player stored
	 *         inside the Player View.
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * A method to set the imagePath of the imageButton of the Player View. When
	 * the button is initiated the ImageIcon is set to the default image.
	 *
	 * @param imagePath
	 *            A string to pass to set the path for the imageButton of the
	 *            Player View.
	 */
	public void setImagePath(String imagePath) {
		ImageIcon picture;
		if (!imagePath.equals("None")) {
			this.imagePath = imagePath;
			picture = new ImageIcon(imagePath);
		} else {
			picture = new ImageIcon("src/dalinrazvan/Resources/defaultGrey.png");
			imageButton.setRolloverEnabled(true);

		}
		imageButton.setIcon(picture);
	}


	/**
	 * A method to return the unique id of the PlayerView.
	 *
	 * @return An integer which represents the unique id of the PlayerView.
	 */
	public int getID() {
		return id;
	}

	/**
	 * A method to set the id of the PlayerView (this must be unique). The
	 * imageButton and the nameTextField name are set to the id.
	 *
	 * @param id An integer to set the id of the PlayerView object.
	 */
	public void setID(int id) {
		this.id = id;
		imageButton.setName(Integer.toString(id));
		nameTextField.setName(Integer.toString(id));
	}

}
