package football_game;

import football_game.view.*;
import football_game.controller.*;
import football_game.model.Squad;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Fantasy fantasyFrame = new Fantasy();
		Squad squadModel = new Squad();

		FormationController formationController = new FormationController(fantasyFrame, squadModel);

		fantasyFrame.setVisible(true);

	}

}
