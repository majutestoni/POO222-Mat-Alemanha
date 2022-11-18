package main;

import java.time.LocalDate;

public class PressOfficerContacts extends Person {

	private String email;
	private String telephones[] = new String[2];
	
	public PressOfficerContacts(String name, LocalDate birthdayDate, String nickname, String email,
			String[] telephones) {
		super(name, birthdayDate, nickname);
		this.setEmail(email);
		this.telephones = telephones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null && !email.isBlank()) {
			this.email = email;
		} else {
			throw new IllegalArgumentException("Invalid email");
		}
	}

	public String[] getTelephones() {
		return telephones;
	}

	public void setTelephones(String[] telephones) {
		this.telephones = telephones;
	}
	
	
		
}
