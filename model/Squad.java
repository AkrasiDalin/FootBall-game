package football_game.model;

import java.util.ArrayList;

public class Squad {

	// TODO: Constructor?

	private ArrayList<Player> squadTeam = new ArrayList<Player>();

	/**
	 * A method that generates a squad and stores it in an ArrayList of Players.
	 * @param numberOfDefenders The number of the Defenders to be generated in the squad.
	 * @param numberOfMidfielders The number of the Midfielders to be generated in the squad.
	 * @param numberOfStrikers The number of the Strikers to be generated in the squad.
	 */
	public void generate() {

		squadTeam.clear();

		for (int i = 0; i < 15; i++) {
			if (i < 2) {
				squadTeam.add(new Goalkeeper());
			}
			if (i >= 2 && i < 7) {
				squadTeam.add(new Defender());
			}
			if (i >= 7 && i < 12) {
				squadTeam.add(new Midfielder());
			}
			if (i >= 12) {
				squadTeam.add(new Striker());
			}
		}
	}

	/**
	 * A method to search a Player by id.
	 * @param id The id of the Player that is to be searched.
	 */
	public Player searchPlayer(int id) {
		if (id < squadTeam.size() && squadTeam.get(id) != null) {
			return squadTeam.get(id);
		} else {
			System.out.println("No player found!");
		}
		return null;
	}

	/**
	 * A method to get the squad team.
	 * @return An ArrayList of Players.
	 */
	public ArrayList<Player> getSquadTeam() {
		return squadTeam;
	}

}
