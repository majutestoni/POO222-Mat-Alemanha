package module_alemanha;

import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

public class Alemanha implements NationalTeamInfos {
	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<PressOfficerContacts> pressOfficerContacts = new ArrayList<>();
	private ArrayList<TechnicalCommittee> technicalCommittees = new ArrayList<>();
	private StatedData statedData;
	// private Integer consultas;

	public Alemanha() {
		Player a = new Player("Martin", LocalDate.parse("2003-03-25"), "Martinho", 10, 1.83, 55, Position.Goalkeeper,
				"Bruscão");
		Player b = new Player("joao", LocalDate.parse("2002-10-25"), "jo", 12, 1.70, 60, Position.Striker, "Bruscão");
		PressOfficerContacts c = new PressOfficerContacts("Maju", LocalDate.parse("2003-03-25"), "Maju",
				"majuzinha@cbf.com", "47 8922-4224", "47 8922-4224");
		TechnicalCommittee d = new TechnicalCommittee("Jony", LocalDate.parse("2003-03-25"), "Jony", "massagista");

		players.add(a);
		players.add(b);
		pressOfficerContacts.add(c);
		technicalCommittees.add(d);
	}
	/*
	 * private void addConsulta() { // metodo que deve ser chamado toda vez que
	 * acontecer uma consulta - fazer // melhor quando integrar a outra interface
	 * this.consultas++; // talvez alterar para StatedData }
	 */

	@Override
	public int getHowManyMembers() {
		// addConsulta();
		return players.size() + pressOfficerContacts.size() + technicalCommittees.size();
	}

	@Override
	public int getOldestPlayer() {
		// addConsulta();
		LocalDate a = players.get(0).getBirthdayDate();
		Player b = players.get(0);
		for (Player player : players) {
			if (player.getBirthdayDate().isBefore(a)) {
				a = player.getBirthdayDate();
				b = player;
			}
		}
		return b.getNumber();

	}

	@Override
	public int getYoungestPlayer() {
		// addConsulta();
		LocalDate a = players.get(0).getBirthdayDate();
		Player b = players.get(0);
		for (Player player : players) {
			if (player.getBirthdayDate().isAfter(a)) {
				a = player.getBirthdayDate();
				b = player;
			}
		}
		return b.getNumber();
	}

	@Override
	public double getAverageAge() {
		// addConsulta();
		double contador = 0;
		for (Player player : players) {
			contador += player.getAge();
		}
		return contador / players.size();
	}

	@Override
	public String getPlayer(int number) {
		// addConsulta();
		Player a = new Player();
		boolean finded = false;
		int i = 0;

		for (int j = 0; j <= players.size();) {
			if (players.get(i).getNumber() == number) {
				a = players.get(j);
				j = players.size();
				finded = true;
			} else {
				j++;
			}
		}

		if (!finded) {
			throw new IllegalArgumentException("Jogador não encontrado");
		}
		return a.mostrar();
	}

	@Override
	public String getPressOfficerContacts() {
		String apresentar = "";
		for (PressOfficerContacts a : pressOfficerContacts) {
			apresentar += a.mostrar();
		}
		return apresentar; // precisa ser revisto
	}

	@Override
	public String getCountryName() {
		return "Alemanha";
	}

	@Override
	public Image getFlagImage() {
		return null;
	}

	// metodo precisa ser testado
	@Override
	public Path getTechnicalCommittee() {
		FileWriter fileWriter = null;
		File arquivo = new File("teste.txt");
		try {
			arquivo.createNewFile();
			fileWriter = new FileWriter(arquivo); 
			BufferedWriter writer = new BufferedWriter(fileWriter);
			for (TechnicalCommittee b : technicalCommittees) {
				fileWriter.write(b.mostrar());
				writer.write(b.mostrar());
				writer.newLine();
			}
			fileWriter.close();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// getAbsolutePath()
		return arquivo.toPath();
	}

	@Override
	public NationalTeamStats getStatsResponsible() {
		return statedData;
	}

}
