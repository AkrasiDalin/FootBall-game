package football_game.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FormationPanel extends JPanel {

	private ArrayList<PlayerView> playerViewList = new ArrayList<PlayerView>();
	private JPanel goalkeeperPanel = new JPanel();
	private JPanel defenderPanel = new JPanel();
	private JPanel midfielderPanel = new JPanel();
	private JPanel strikerPanel = new JPanel();
	private JPanel benchPanel = new JPanel();
	private Image image = Toolkit.getDefaultToolkit().createImage("src/dalinrazvan/Resources/animatedArena.gif");

	/**
	 * A constructor for this JPanel that sets the layout and adds the specific
	 * panels to the view.
	 */
	public FormationPanel() {
		setLayout(new GridBagLayout());

		setPreferredSize(new Dimension(560, 650));

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.insets = new Insets(30, 0, 0, 0);
		constraints.gridy = 0;
		goalkeeperPanel.setOpaque(false);
		add(goalkeeperPanel, constraints);

		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.gridy = 1;
		defenderPanel.setOpaque(false);
		add(defenderPanel, constraints);

		constraints.gridy = 2;
		midfielderPanel.setOpaque(false);
		add(midfielderPanel, constraints);

		constraints.gridy = 3;
		strikerPanel.setOpaque(false);
		add(strikerPanel, constraints);

		constraints.insets = new Insets(30, 0, 0, 0);
		constraints.gridy = 4;
		benchPanel.setOpaque(false);
		add(benchPanel, constraints);
	}

	/**
	 * Method to add a PlayerView into it's specific position.
	 * @param position A string to specify in which position the PlayerView should be placed into (position is given by it's specialisation).
	 * @param id An integer which represents the unique id of the Player.
	 * @param name A string which represents the name of the Player.
	 * @param imagePath A string which represents the path for the image of the Player.
	 */
	public void addPlayerInPosition(String position, int id, String name, String imagePath) {
		PlayerView tempPlayer = new PlayerView();
		tempPlayer.setPlayerName(name);
		tempPlayer.setID(id);
		tempPlayer.setImagePath(imagePath);

		if (playerViewList.size() < 15) {
			tempPlayer.setSpecialisation(name);
			playerViewList.add(tempPlayer);
		}

		switch (position) {
		case "Goalkeeper": {
			goalkeeperPanel.add(tempPlayer);
			goalkeeperPanel.revalidate();
			break;
		}
		case "Defender": {
			defenderPanel.add(tempPlayer);
			defenderPanel.revalidate();
			break;
		}
		case "Midfielder": {
			midfielderPanel.add(tempPlayer);
			midfielderPanel.revalidate();
			break;
		}
		case "Striker": {
			strikerPanel.add(tempPlayer);
			strikerPanel.revalidate();
			break;
		}
		}
	}

	/**
	 * A method to add players to the bench panel. It is used to place the Players remaining from the pitch.
	 * @param id An integer which represents the unique id of the Player.
	 * @param name A string which represents the name of the Player.
	 * @param imagePath A string which represents the path for the image of the Player.
	 */
	public void addPlayerToBenchPanel(int id, String name, String imagePath) {
		PlayerView tempPlayer = new PlayerView();
		tempPlayer.setPlayerName(name);
		tempPlayer.setID(id);
		tempPlayer.setImagePath(imagePath);

		if (playerViewList.size() < 15) {
			tempPlayer.setSpecialisation(name);
			playerViewList.add(tempPlayer);
		}

		benchPanel.add(tempPlayer);
		benchPanel.revalidate();
	}

	/**
	 * A method that removes everything inside the panels and the ArrayList of PlayerViews.
	 */
	public void removeAllPlayers() {

		playerViewList.clear();

		goalkeeperPanel.removeAll();
		defenderPanel.removeAll();
		midfielderPanel.removeAll();
		strikerPanel.removeAll();
		benchPanel.removeAll();
	}

	/**
	 * A method that updates the view searching for the id, setting the name and the imagePath for that specific PlayerView.
	 * @param id An integer which represents the unique id of the Player.
	 * @param name A string which represents the name of the Player.
	 * @param imagePath A string which represents the path for the image of the Player.
	 */
	public void updatePlayer(int id, String name, String imagePath) {
		for (PlayerView player : playerViewList) {
			if (player.getID() == id) {
				player.setPlayerName(name);
				player.setImagePath(imagePath);
				for (Component component : player.getComponents()) {
					if (component.getName().equals(String.valueOf(id))) {
						component.setEnabled(true);
					}
				}
			}
		}
	}

	/**
	 * A method that adds an ActionListener to all of the image buttons from the playerViewList.
	 * @param listenForPlayerImageButton An AnctionListener that manipulates the image buttons (the view) accordingly to the model.
	 */
	public void imagePrompt(ActionListener listenForPlayerImageButton) {
		for (PlayerView playerView : playerViewList) {
			playerView.getImageButton().addActionListener(listenForPlayerImageButton);
		}
	}

	/**
	 * A method that adds an ActionListener to all of the image buttons from the playerViewList.
	 * @param updatesInTextField An AnctionListener that manipulates the name text field (the view) accordingly to the model.
	 */
	public void textBoxChanges(ActionListener updatesInTextField) {
		for (PlayerView playerView : playerViewList) {
			playerView.getNameTextField().addActionListener(updatesInTextField);
		}
	}

	/**
	 * Overriding the paintComponent method in order to add and present the background.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, 0, 16, this);
	}


}
