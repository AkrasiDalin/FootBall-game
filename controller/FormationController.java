package football_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import dalinrazvan.model.Squad;
import dalinrazvan.view.Fantasy;
import dalinrazvan.view.FormationPanel;

public class FormationController {

	private Fantasy fantasyView;
	private FormationPanel formationView;
	private Squad squad;
	private boolean squadIsGenerated;

	/**
	 * Constructor of this "controller" class which serves as median between
	 * model classes and view classes
	 *
	 * @param fantasyView "Takes a Fantasy object"
	 * @param squad "Takes a Squad object"
	 */
	public FormationController(Fantasy fantasyView, Squad squad) {
		this.fantasyView = fantasyView;
		this.fantasyView.changeFormation(new changeFormationListener());
		this.squad = squad;

		fantasyView.addFormationToTheView();

		formationView = fantasyView.getFormationPanel();

		squadIsGenerated = false;
	}


	/**
	 * Serves to perform a conversion from string values to integers
	 * Therefore it generates sets of Player objects for the view
	 *
	 * @param formation "Takes a string and converts specified indexes of into integer values"
	 */
	public void generateSquad(String formation) {
		int numberOfDefenders = Integer.parseInt(formation.substring(0, 1));
		int numberOfMidfielders = Integer.parseInt(formation.substring(2, 3));
		int numberOfStrikers = Integer.parseInt(formation.substring(4));

		formationView.removeAllPlayers();

		if (!squadIsGenerated) {
			squad.generate();
			squadIsGenerated = true;
		}

		for (int i = 0; i < 15; i++) {

			// pitch panel
			if (i == 0) {
				formationView.addPlayerInPosition(squad.searchPlayer(i).getSpecialisation(),
						squad.searchPlayer(i).getId(), squad.searchPlayer(i).getName(),
						squad.searchPlayer(i).getPathForImage());
			}

			if (i >= 2 && i < 2 + numberOfDefenders) {
				formationView.addPlayerInPosition(squad.searchPlayer(i).getSpecialisation(),
						squad.searchPlayer(i).getId(), squad.searchPlayer(i).getName(),
						squad.searchPlayer(i).getPathForImage());
			}

			if (i >= 7 && i < 7 + numberOfMidfielders) {
				formationView.addPlayerInPosition(squad.searchPlayer(i).getSpecialisation(),
						squad.searchPlayer(i).getId(), squad.searchPlayer(i).getName(),
						squad.searchPlayer(i).getPathForImage());
			}

			if (i >= 12 && i < 12 + numberOfStrikers) {
				formationView.addPlayerInPosition(squad.searchPlayer(i).getSpecialisation(),
						squad.searchPlayer(i).getId(), squad.searchPlayer(i).getName(),
						squad.searchPlayer(i).getPathForImage());
			}

			// bench panel
			if (i == 1) {
				formationView.addPlayerToBenchPanel(squad.searchPlayer(i).getId(), squad.searchPlayer(i).getName(),
						squad.searchPlayer(i).getPathForImage());
			}

			if (i >= numberOfDefenders + 2 && i < 7 && numberOfDefenders < 5) {
				formationView.addPlayerToBenchPanel(squad.searchPlayer(i).getId(), squad.searchPlayer(i).getName(),
						squad.searchPlayer(i).getPathForImage());
			}

			if (i >= numberOfMidfielders + 7 && i < 12 && numberOfMidfielders < 5) {
				formationView.addPlayerToBenchPanel(squad.searchPlayer(i).getId(), squad.searchPlayer(i).getName(),
						squad.searchPlayer(i).getPathForImage());
			}

			if (i >= numberOfStrikers + 12 && i < 15 && numberOfStrikers < 3) {
				formationView.addPlayerToBenchPanel(squad.searchPlayer(i).getId(), squad.searchPlayer(i).getName(),
						squad.searchPlayer(i).getPathForImage());
			}
		}
	}


	/**
	 * Inner class changeFormationListener, implements and ActionListener
	 * and serves to modify the disposition of players in the view
	 * based on informations retrieved from the Formation Panel
	 */
	class changeFormationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String formation = "";

			formation = fantasyView.getFormation();
			if(!formation.equals("Select formation")){

			generateSquad(formation);

			formationView.imagePrompt(new listenForPlayerImageButton());

			formationView.textBoxChanges(new updatesInTextField());}

		}

	}


	/**
	 * Serves as reactor which runs every time the player button is pressed.
	 * The present class allows the user to select an image file from its local directories
	 * which will be set as profile picture of the player.
	 */
	class listenForPlayerImageButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser jFileChooser = new JFileChooser();
			FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files",
					ImageIO.getReaderFileSuffixes());
			jFileChooser.addChoosableFileFilter(imageFilter);
			jFileChooser.setAcceptAllFileFilterUsed(false);
			jFileChooser.setFileFilter(imageFilter);

			int returnVal = jFileChooser.showDialog(formationView, "Choose");

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = jFileChooser.getSelectedFile();
				JButton playerViewButton = (JButton) e.getSource();
				playerViewButton.setRolloverIcon(new ImageIcon("src/dalinrazvan/Resources/default.png"));
				playerViewButton.setEnabled(false);

				int id = Integer.parseInt(playerViewButton.getName());

				for (int i = 0; i < 15; i++) {
					if (squad.searchPlayer(i).getId() == id) {
						squad.searchPlayer(i).setPathForImage(file.getAbsolutePath());
						playerViewButton.setRolloverEnabled(false);
						String name = Character.toUpperCase(file.getName().charAt(0))
								+ file.getName().substring(1, file.getName().length() - 4);

						squad.searchPlayer(i).setName(name);
						formationView.updatePlayer(id, squad.searchPlayer(i).getName(),
								squad.searchPlayer(i).getPathForImage());

					}if (squad.searchPlayer(i).getId() != id
							&& squad.searchPlayer(i).getPathForImage().equals(file.getAbsolutePath())) {
						squad.searchPlayer(i).setPathForImage("src/dalinrazvan/Resources/defaultGrey.png");

						String name = squad.searchPlayer(i).getSpecialisation();

						squad.searchPlayer(i).setName(name);
						formationView.updatePlayer(squad.searchPlayer(i).getId(), squad.searchPlayer(i).getName(),
								squad.searchPlayer(i).getPathForImage());
					}
				}

			}

			jFileChooser.setSelectedFile(null);
		}

	}

	/**
	 * This class serves to retrieve the name of the selected file
	 * and to set it as name in the text field positioned under the player's button
	 */
	class updatesInTextField implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JTextField nameField = (JTextField) e.getSource();
			int id = Integer.parseInt(nameField.getName());

			for (int i = 0; i < 15; i++) {
				if (squad.searchPlayer(i).getId() == id) {
					squad.searchPlayer(i).setName(nameField.getText());
				}
			}

		}

	}

}
