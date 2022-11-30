package module_alemanha;

import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

public class Alemanha implements NationalTeamInfos {
	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<PressOfficerContacts> pressOfficerContacts = new ArrayList<>();
	private ArrayList<TechnicalCommittee> technicalCommittees = new ArrayList<>();
	private StatedData statedData = null;
	private Image flagImage;

	public Alemanha() {
		Player a = new Player("Martin", LocalDate.parse("2003-03-25"), "Martinho", 10, 1.83, 55, "Striker", "Bruscão");
		Player b = new Player("joao", LocalDate.parse("2002-10-25"), "jo", 1, 1.70, 60, "Striker", "Bruscão");

		PressOfficerContacts c = new PressOfficerContacts("Maju", LocalDate.parse("2003-03-25"), "Maju",
				"majuzinha@cbf.com", "47 8922-4224", "47 8922-4224");
		TechnicalCommittee d = new TechnicalCommittee("Jony", LocalDate.parse("2003-03-25"), "Jony", "massagista");

		players.add(a);
		players.add(b);
		pressOfficerContacts.add(c);
		technicalCommittees.add(d);
		statedData = new StatedData(players);
	}

	@Override
	public int getHowManyMembers() {
		statedData.setQuestions();
		return players.size() + pressOfficerContacts.size() + technicalCommittees.size();
	}

	@Override
	public int getOldestPlayer() {
		statedData.setQuestions();
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
		statedData.setQuestions();
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
		statedData.setQuestions();
		double contador = 0;
		for (Player player : players) {
			contador += player.getAge();
		}
		return contador / players.size();
	}

	@Override
	public String getPlayer(int number) {
		number = 10;
		statedData.setQuestions();
		Player a = new Player();
		boolean finded = false;

		for (Player player : players) {
			if (player.getNumber() == number) {
				a = player;
				player.setQueryAbout();
				finded = true;
			}
		}

		if (!finded) {
			throw new IllegalArgumentException("Jogador não encontrado");
		}
		return a.mostrar();
	}

	@Override
	public String getPressOfficerContacts() {
		statedData.setQuestions();
		String apresentar = "";
		for (PressOfficerContacts a : pressOfficerContacts) {
			apresentar += a.mostrar();
		}
		return apresentar;
	}

	@Override
	public String getCountryName() {
		statedData.setQuestions();
		return "Alemanha";
	}

	@Override
	public Image getFlagImage() {
		statedData.setQuestions();
		try {
			BufferedImage image = ImageIO.read(getClass().getResource("image/bandeira-alemanha.png"));
			flagImage = image;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flagImage;
	}

	@Override
	public Path getTechnicalCommittee() {
		statedData.setQuestions();
		String nomeSaida = System.getProperty("user.home") + "\\Documents\\dados.txt";
		FileWriter fileWriter = null;
		File file = null;
		try {
			file = new File(nomeSaida);
			fileWriter = new FileWriter(file);

			for (TechnicalCommittee b : technicalCommittees) {
				fileWriter.write(b.mostrar());
				fileWriter.write("\n");
			}
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return file.toPath();
	}

	@Override
	public NationalTeamStats getStatsResponsible() {
		return statedData;
	}

}
