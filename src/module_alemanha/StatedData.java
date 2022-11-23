package module_alemanha;

import java.util.ArrayList;

import fifa.NationalTeamStats;

public class StatedData implements NationalTeamStats {
	private ArrayList<Player> players = new ArrayList<>();

	@Override
	public int getHowManyQuestions() {
		return 0;
	}

	@Override
	public String getHowManyCallsToPlayer(int number) {
		String ok = "";
		boolean finded = false;
		int i = 0;

		for (int j = 0; j <= players.size();) {
			if (players.get(i).getNumber() == number) {
				ok = players.get(j).getNumber().toString();
				j = players.size();
				finded = true;
			} else {
				j++;
			}
		}

		if (!finded) {
			throw new IllegalArgumentException("Jogador não encontrado");
		}

		return ok;
	}

}
