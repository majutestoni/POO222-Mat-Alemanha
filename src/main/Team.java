package main;

import java.awt.Image;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

public class Team implements NationalTeamInfos {
	private ArrayList<Player> players = new ArrayList<>();
	// private ArrayList<> b1 = new ArrayList<>();
	// private ArrayList<> b2 = new ArrayList<>();
	private Integer consultas;

	private void addConsulta() { // metodo que deve ser chamado toda vez que acontecer uma consulta
		this.consultas++;
	}

	@Override
	public int getHowManyMembers() {
		addConsulta();
		return players.size(); // + b1.size() + b2.size()
	}

	@Override
	public int getOldestPlayer() {
		addConsulta();
		LocalDate a = LocalDate.now();
		Player b = new Player("", a, "", 00, 0.00, 0.00, "", "");
		for (Player player : players) {
			if (player.getBirthdayDate().isBefore(a)) {
				a = player.getBirthdayDate();
				b = player;
			}
		}
		return b.getNumero();

	}

	@Override
	public int getYoungestPlayer() {
		addConsulta();
		LocalDate a = LocalDate.of(1900, 01, 01);
		Player b = new Player("", a, "", 00, 0.00, 0.00, "", "");
		for (Player player : players) {
			if (player.getBirthdayDate().isAfter(a)) {
				a = player.getBirthdayDate();
				b = player;
			}
		}
		return b.getNumero();
	}

	@Override
	public double getAverageAge() {
		addConsulta();
		double contador = 0;
		for (Player player : players) {
			contador += player.getAge();
		}
		return contador / players.size();
	}

	@Override
	public String getPlayer(int number) {
		addConsulta();
		Player a = new Player();
		boolean achou = false;
		int i = 0;
		while (achou || i == players.size()) { // verificar consição do i
			if (players.get(i).getNumero() == number) {
				achou = true;
				a = players.get(i);
				players.get(i).setConsultasSobre();
			} else {
				i++;
			}

		}
		if (!achou) {
			// falar com Marcel
			return "não encontrado";// throw new IllegalArgumentException("Jogador não encontrado"); 
		}
		return a.mostrar();
	}

	@Override
	public String getPressOfficerContacts() {
		return null;
	}

	@Override
	public String getCountryName() {
		return "Alemanha";
	}

	@Override
	public Image getFlagImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Path getTechnicalCommittee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NationalTeamStats getStatsResponsible() {
		// TODO Auto-generated method stub
		return null;
	}

}
