package main;

import java.time.LocalDate;
import java.time.Period;

public class Player extends Person {
	private int numero;
	private double height;
	private double weight;
	private String position;
	private String currentClub;
	private int consultasSobre;

	public Player() {
		super();
	}

	public Player(String name, LocalDate birthdayDate, String nickname, int numero, double height, double weight,
			String position, String currentClub) {
		super(name, birthdayDate, nickname);
		this.setNumero(numero);
		this.setHeight(height);
		this.setWeight(weight);
		this.setPosition(position);
		this.setCurrentClub(currentClub);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero > 0 && numero < 100) {
			this.numero = numero;
		} else {
			throw new IllegalArgumentException("Digite um número de 1 a 99");
		}
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height > 0) {
			this.height = height;
		} else {
			throw new IllegalArgumentException("Digite a altura do jogador");
		}
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if (weight > 0) {
			this.weight = weight;
		} else {
			throw new IllegalArgumentException("Digite o peso do jogador");
		}
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		if (position != null && position.equals("Goalkeeper") || position.equals("Central Back")
				|| position.equals("Right Back") || position.equals("Left Back")
				|| position.equals("Central Defensive Midfielder") || position.equals("Central Midfielder")
				|| position.equals("Right Midfielder") || position.equals("Left Midfielder")
				|| position.equals("Central Attacking Midfielder") || position.equals("Left Wing")
				|| position.equals("Right Wing") || position.equals("Center Forward") || position.equals("Striker")) {
			this.position = position; // fazer classe enum, me chama na sala que te ensino
		} else {
			throw new IllegalArgumentException("Digite a posição do jogador");
		}
	}

	public String getCurrentClub() {
		return currentClub;
	}

	public void setCurrentClub(String currentClub) {
		if (currentClub != null && !currentClub.isBlank()) {
			this.currentClub = currentClub;
		} else {
			throw new IllegalArgumentException("Digite o clube do jogador");
		}
	}

	@Override
	public String mostrar() {
		return "{" + "Number: " + this.getNumero() + "\n" + "Name: " + this.getName() + "\n" + "Nickname: "
				+ this.getNickname() + "\n" + "Height: " + this.getHeight() + "\n" + "Weight " + this.getWeight() + "\n"
				+ "BirthDate: " + this.getBirthdayDate() + "\n" + "Position: " + this.getPosition() + "\n"
				+ "CurrentClub: " + this.getCurrentClub() + "}";
	}

	public Integer getAge() {
		return Period.between(this.getBirthdayDate(), LocalDate.now()).getYears();
	}

	public int getConsultasSobre() {
		return consultasSobre;
	}

	public void setConsultasSobre() {
		this.consultasSobre++;
	}

}
