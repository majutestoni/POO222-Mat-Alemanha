package module_alemanha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import fifa.NationalTeamStats;

public class StatedData implements NationalTeamStats {
	private ArrayList<Player> players;
	private int questions = 0;

	public StatedData(ArrayList<Player> players) {
		this.players = players;

	}

	public void setQuestions() {
		/*
		 * String nomeSaida = System.getProperty("user.home") +
		 * "\\Documents\\questions.txt"; FileWriter fileWriter = null; File file = null;
		 * try { file = new File(nomeSaida); fileWriter = new FileWriter(file);
		 * fileWriter.write(this.questions++); fileWriter.close();
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */

		File filePlayer = new File("mat_players_alemanha.txt");
		try {
			boolean isCreatedPlayers = filePlayer.createNewFile();
			System.out.println(isCreatedPlayers);
		} catch (IOException e) {
			e.printStackTrace();
		}

		File filePressOfficerContacts = new File("mat_press_officer_contacts_alemanha.txt");
		try {
			boolean isCreatedPressOfficerContacts = filePressOfficerContacts.createNewFile();
			System.out.println(isCreatedPressOfficerContacts);
		} catch (IOException e) {
			e.printStackTrace();
		}

		File fileTechnicalCommittee = new File("mat_technical_committee_alemanha.txt");
		try {
			boolean isCreatedTechnicalCommittee = fileTechnicalCommittee.createNewFile();
			System.out.println(isCreatedTechnicalCommittee);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int getQuestions() {
		/*
		 * try { FileReader fr = new FileReader("\\Documents\\questions.txt");
		 * BufferedReader br = new BufferedReader(fr); String linha; while ((linha =
		 * br.readLine()) != null) { System.out.print(linha); } br.close(); } catch
		 * (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */

		try {
			FileReader frPlayer = new FileReader("mat_players_alemanha.txt");
			BufferedReader brPlayer = new BufferedReader(frPlayer);
			String linha;
			while ((linha = brPlayer.readLine()) != null) {
				System.out.print(linha);
			}
			brPlayer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileReader frPressOfficerContacts = new FileReader("mat_press_officer_contacts_alemanha.txt");
			BufferedReader brPressOfficerContacts = new BufferedReader(frPressOfficerContacts);
			String linha;
			while ((linha = brPressOfficerContacts.readLine()) != null) {
				System.out.print(linha);
			}
			brPressOfficerContacts.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileReader frTechnicalCommittee = new FileReader("mat_technical_committee_alemanha.txt");
			BufferedReader brTechnicalCommittee = new BufferedReader(frTechnicalCommittee);
			String linha;
			while ((linha = brTechnicalCommittee.readLine()) != null) {
				System.out.print(linha);
			}
			brTechnicalCommittee.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return questions;
	}

	@Override
	public int getHowManyQuestions() {
		return getQuestions();
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
			return 0;
		}

		return ok;
	}

}
