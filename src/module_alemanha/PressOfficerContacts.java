package module_alemanha;

import java.time.LocalDate;

public class PressOfficerContacts extends Person {
	private String email;
	private String tel1;
	private String tel2;

	public PressOfficerContacts(String name, LocalDate birthdayDate, String nickname, String email, String tel1,
			String tel2) {
		super(name, birthdayDate, nickname);
		this.setEmail(email);
		this.setTel1(tel1);
		this.setTel2(tel2);
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

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		if (tel1 != null && !tel1.isBlank()) {
			this.tel1 = tel1;
		} else {
			throw new IllegalArgumentException("Invalid number");
		}
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		if (tel2 != null && !tel2.isBlank()) {
			this.tel2 = tel2;
		} else {
			throw new IllegalArgumentException("Invalid number");
		}
	}

	@Override
	public String mostrar() {
		return "\n" + "{" + "\n" + "     \"Name\" " + ": " + this.getName() + ", " + "\n" + "     \"Tel1\" " + ": " + this.getTel1() + ", " + "\n"
				+ "     \"Tel2\" " + ": " + this.getTel2() + ", " + "\n" + "     \"EmailAccount\" " + ": " + this.getEmail() + "\n" + "}" + "\n";
	}

}
