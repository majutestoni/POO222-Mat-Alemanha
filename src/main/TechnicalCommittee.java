package main;

import java.time.LocalDate;
import java.time.Period;

public class TechnicalCommittee extends Person {

	private String function;

	public TechnicalCommittee(String name, LocalDate birthdayDate, String nickname, String function) {
		super(name, birthdayDate, nickname);
		this.setFunction(function);
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		if (function != null && !function.isBlank()) {
			this.function = function;
		} else {
			throw new IllegalArgumentException("Invalid email");
		}
	}

	private int getAge(LocalDate birthdayDate) {
		return Period.between(this.getBirthdayDate(), LocalDate.now()).getYears();
	}

	@Override
	public String mostrar() {
		// TODO Auto-generated method stub
		return null;

	}
}
