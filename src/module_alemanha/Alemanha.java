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
			return "0";
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
	
public Alemanha() {
		
		statedData = new StatedData(players);
		
		// ADD PLAYERS
		Player p1 = new Player("Manuel Peter Neuer", LocalDate.parse("1986-3-27"), "Neuer", 1, 193, 93, "goalkeeper", "FC Bayern München");
		players.add(p1);
		Player p2 = new Player("Marc-André ter Stegen", LocalDate.parse("1992-4-30"), "Ter Stegen", 22, 187, 85, "goalkeeper", "FC Barcelona");
		players.add(p2);
		Player p3 = new Player("Kevin Trapp", LocalDate.parse("1990-7-8"), "Trapp", 12, 189, 88, "goalkeeper", "Eintracht Frankfurt");
		players.add(p3);
		Player p4 = new Player("Armel Bella-Kotchap", LocalDate.parse("2001-12-11"), "Bella-Kotchap", 25, 190, 87, "centre-back", "Southampton F.C.");
		players.add(p4);
		Player p5 = new Player("Matthias Lukas Ginter", LocalDate.parse("1994-1-19"), "Ginter", 4, 191, 86, "centre-back", "SC Freiburg");
		players.add(p5);
		Player p6 = new Player("Christian Günter", LocalDate.parse("1993-2-28"), "Günter", 20, 184, 83, "left-back", "SC Freiburg");
		players.add(p6);
		Player p7 = new Player("Jan Thilo Kehrer", LocalDate.parse("1996-9-21"), "Kehrer", 5, 186, 76, "centre-back", "West Ham United FC");
		players.add(p7);
		Player p8 = new Player("Lukas Manuel Klostermann", LocalDate.parse("1996-6-3"), "Klostermann", 16, 189, 88, "centre-back", "RB Leipzig");
		players.add(p8);
		Player p9 = new Player("David Raum", LocalDate.parse("1998-4-22"), "Raum", 3, 180, 75, "left-back", "RB Leipzig");
		players.add(p9);
		Player p10 = new Player("Antonio Rüdiger", LocalDate.parse("1993-3-3"), "Rüdiger", 2, 190, 85, "centre-back", "Real Madrid CF");
		players.add(p10);		
		Player p11 = new Player("Nico Schlotterbeck", LocalDate.parse("1999-12-1"), "N.Schlotterbeck", 23, 191, 86, "centre-back", "Borussia Dortmund");
		players.add(p11);		
		Player p12 = new Player("Niklas Süle", LocalDate.parse("1995-9-3"), "Süle", 15, 195, 99, "centre-back", "Borussia Dortmund");
		players.add(p12);		
		Player p13 = new Player("Karim-David Adeyemi", LocalDate.parse("2002-1-18"), "Adeyemi", 24, 180, 69, "right-wing", "Borussia Dortmund");
		players.add(p13);		
		Player p14 = new Player("Julian Brandt", LocalDate.parse("1996-5-2"), "Brandt", 17, 185, 83, "center attacking middlefielder", "Borussia Dortmund");
		players.add(p14);
		Player p15 = new Player("Niclas Füllkrug", LocalDate.parse("1993-2-9"), "Brandt", 9, 189, 83, "striker", "Werder Bremen");
		players.add(p15);
		Player p16 = new Player("Serge David Gnabry", LocalDate.parse("1995-7-14"), "Gnabry", 10, 176, 77, "right-wing", "FC Bayern München");
		players.add(p16);
		Player p17 = new Player("İlkay Gündoğan", LocalDate.parse("1990-10-24"), "Gündoğan", 8, 180, 80, "central midfielder", "Manchester City FC");
		players.add(p17);
		Player p18 = new Player("Kai Lukas Havertz", LocalDate.parse("1999-6-11"), "Havertz", 7, 190, 83, "center attacking middlefielder", "Chelsea FC");
		players.add(p18);
		Player p19 = new Player("Jonas Hofmann", LocalDate.parse("1992-7-14"), "Hofmann", 18, 176, 73, "right-wing", "Borussia Mönchengladbach");
		players.add(p19);
		Player p20 = new Player("Joshua Walter Kimmich", LocalDate.parse("1995-2-8"), "Kimmich", 6, 177, 75, "central defensive midfielder", "FC Bayern München");
		players.add(p20);
		Player p21 = new Player("Youssoufa Moukoko", LocalDate.parse("2004-11-20"), "Moukoko", 26, 179, 72, "striker", "Borussia Dortmund");
		players.add(p21);
		Player p22 = new Player("Thomas Müller", LocalDate.parse("1989-9-13"), "Müller", 13, 185, 76, "center forward", "FC Bayern München");
		players.add(p22);
		Player p23 = new Player("Jamal Musiala", LocalDate.parse("2003-2-26"), "Musiala", 14, 184, 70, "center attacking middlefielder", "FC Bayern München");
		players.add(p23);
		Player p24 = new Player("Leroy Aziz Sané", LocalDate.parse("1996-1-11"), "Sané", 19, 183, 70, "left-wing", "FC Bayern München");
		players.add(p24);

		// ADD PRESSOFFICERCONTACTS
		PressOfficerContacts poc1 = new PressOfficerContacts("Maju", LocalDate.parse("2003-03-25"), "Maju",
				"majuzinha@cbf.com", "47 8922-4224", "47 8922-4224");
		pressOfficerContacts.add(poc1);
		PressOfficerContacts poc2 = new PressOfficerContacts("Franziska Wülle", LocalDate.parse("1985-02-09"), "Wülle",
				"+49 957489334", "+49 957243734", "franwulle@dfb.de");
		pressOfficerContacts.add(poc2);
		PressOfficerContacts poc3 = new PressOfficerContacts("Arne Leyenberg", LocalDate.parse("1978-07-25"),
				"Leyenberg", "+49 956295632", "+49 994733732", "leyen@dfb.d");
		pressOfficerContacts.add(poc3);

		// ADD TECHNICALCOMMITTEE
		TechnicalCommittee td1 = new TechnicalCommittee("Jony", LocalDate.parse("2003-03-25"), "Jony", "massagista");
		technicalCommittees.add(td1);
		TechnicalCommittee td2 = new TechnicalCommittee("Hans-Dieter Flick", LocalDate.parse("1965-02-24"),
				"Hansi Flick", "Main coach");
		technicalCommittees.add(td2);
		TechnicalCommittee td3 = new TechnicalCommittee("Marcus Sorg", LocalDate.parse("1965-12-24"), "Marcus Sorg",
				"Assistant coach");
		technicalCommittees.add(td3);
		TechnicalCommittee td4 = new TechnicalCommittee("Danny Röhl", LocalDate.parse("1989-04-28"), "Danny Röhl",
				"Assistant coach");
		technicalCommittees.add(td4);
		TechnicalCommittee td5 = new TechnicalCommittee("Andreas Kronenberg", LocalDate.parse("1974-09-10"),
				"Andreas Kronenberg", "Goalkeeper coach");
		technicalCommittees.add(td5);
		TechnicalCommittee td6 = new TechnicalCommittee("Michael Fuchs", LocalDate.parse("1970-01-04"), "Michael Fuchs",
				"Goalkeeper coach");
		technicalCommittees.add(td6);
		TechnicalCommittee td7 = new TechnicalCommittee("Mads Buttgereit", LocalDate.parse("1985-06-03"),
				"Mads Buttgereit", "Standard Coach");
		technicalCommittees.add(td7);
		TechnicalCommittee td8 = new TechnicalCommittee("Nicklas Dietrich", LocalDate.parse("1982-12-13"),
				"Nicklas Dietrich", "Athletic Trainer");
		technicalCommittees.add(td8);
		TechnicalCommittee td9 = new TechnicalCommittee("Krunoslav Banovcic", LocalDate.parse("1974-09-10"),
				"Krunoslav Banovcic", "Athletic Trainer");
		technicalCommittees.add(td9);
		TechnicalCommittee td10 = new TechnicalCommittee("Dr. Stephan Nopp", LocalDate.parse("1979-08-24"),
				"Stephan Nopp", "Co-Trainer Match Analysis");
		technicalCommittees.add(td10);
		TechnicalCommittee td11 = new TechnicalCommittee("Oliver Bierhoff", LocalDate.parse("1968-05-01"),
				"Oliver Bierhoff", "Managing Director National Teams and Academy");
		technicalCommittees.add(td11);
	}


}
