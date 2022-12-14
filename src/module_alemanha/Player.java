package module_alemanha;

import java.time.LocalDate;
import java.time.Period;

public class Player extends Person {
	private int number;
	private double height;
	private double weight;
	private String position;
	private String currentClub;
	private int queryAbout;

	public Player() {
		super();
	}

	public Player(String name, LocalDate birthdayDate, String nickname, int number, double height, double weight,
			String position, String currentClub) {
		super(name, birthdayDate, nickname);
		this.setNumber(number);
		this.setHeight(height);
		this.setWeight(weight);
		this.setPosition(position);
		this.setCurrentClub(currentClub);
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if (number > 0 && number < 100) {
			this.number = number;
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
		if (position != null && position.equals("goalkeeper") || position.equals("central back")
				|| position.equals("right back") || position.equals("left back")
				|| position.equals("central defensive midfielder") || position.equals("central midfielder")
				|| position.equals("right midfielder") || position.equals("left midfielder")
				|| position.equals("central attacking midfielder") || position.equals("left wing")
				|| position.equals("right wing") || position.equals("center forward") || position.equals("striker")) {
			this.position = position;
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
		return "\n" + "{" + "\n" + "     \"Number\" " + ": " + this.getNumber() + ", " + "\n" + "     \"Name\" " + ": " + this.getName() + ", " + "\n"
				+ "     \"Nickname\" " + ": " + this.getNickname() + ", " + "\n" + "     \"Height\" " + ": " + this.getHeight() + ", "
				+ "\n" + "     \"Weight\" " + ": " + this.getWeight() + ", " + "\n" + "     \"BirthDate\" " + ": " + this.getBirthdayDate()
				+ ", " + "\n" + "     \"Position\" " + ": " + this.getPosition() + ", " + "\n" + "     \"CurrentClub\" " + ": "
				+ this.getCurrentClub() + "\n" + "}" + "\n";
	}

	public Integer getAge() {
		return Period.between(this.getBirthdayDate(), LocalDate.now()).getYears();
	}

	public int getQueryAbout() {
		return queryAbout;
	}

	public void setQueryAbout() {
		this.queryAbout++;
	}

}
