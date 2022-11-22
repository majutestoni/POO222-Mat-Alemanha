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

	private void addConsulta() { // metodo que deve ser chamado toda vez que acontecer uma consulta - fazer melhor quando integrar a outra interface
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
		LocalDate a = players.get(0).getBirthdayDate();
		Player b = players.get(0);
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
		LocalDate a = players.get(0).getBirthdayDate();
		Player b = players.get(0);
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
		boolean finded = false;
		int i = 0;
		while (finded || i == players.size()) { // verificar se while está correto
			if (players.get(i).getNumero() == number) {
				finded = true;
				a = players.get(i);
			} else {
				i++;
			}

		}
		if (!finded) {
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
