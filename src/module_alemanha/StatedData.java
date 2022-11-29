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

		for (Player player : players) {
			if (player.getNumber() == number) {
				ok = player.getConsultasSobre();
				finded = true;
			}
		}

		if (!finded) {
			throw new IllegalArgumentException("Jogador não encontrado");
		}

		return ok;
	}

}
