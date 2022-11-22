package module_alemanha;

import java.time.LocalDate;

public abstract class Person {
	private String name;
	private LocalDate birthdayDate;
	private String nickname;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, LocalDate birthdayDate, String nickname) {
		super();
		this.setName(name);
		this.setBirthdayDate(birthdayDate);
		this.setNickname(nickname);
	}
	
	
	public abstract String mostrar();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.isBlank()) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Digite um nome.");
		}
	}

	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(LocalDate birthdayDate) {
		if (birthdayDate != null) {
			this.birthdayDate = birthdayDate;
		} else {
			throw new IllegalArgumentException("Digite uma data válida.");
		}
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		if (nickname != null && !nickname.isBlank()) {
			this.nickname = nickname;
		} else {
			throw new IllegalArgumentException("Digite o apelido ou o número do camisa.");
		}
	}

}
