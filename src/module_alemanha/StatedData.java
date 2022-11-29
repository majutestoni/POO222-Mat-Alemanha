package module_alemanha;

import java.util.ArrayList;

import fifa.NationalTeamStats;

public class StatedData implements NationalTeamStats {
	private ArrayList<Player> players;
	private int questions = 0;

	public StatedData(ArrayList<Player> players) {
		this.players = players;
	}

	public void setQuestions() {
		this.questions++;
	}

	public int getQuestions() {
		return questions;
	}

	@Override
	public int getHowManyQuestions() {
		return 0;
	}

	@Override
	public int getHowManyCallsToPlayer(int number) {
		int ok = 0;
		boolean finded = false;

		for (Player player : players) {
			if (player.getNumber() == number) {
				ok = player.getQueryAbout();
				finded = true;
			}
		}

		if (!finded) {
			throw new IllegalArgumentException("Jogador não encontrado");
		}

		return ok;
	}

}
