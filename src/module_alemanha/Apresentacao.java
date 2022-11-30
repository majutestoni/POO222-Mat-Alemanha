package module_alemanha;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Apresentacao {
	public static void main(String[] args) throws IOException {
		try (FileReader player = new FileReader("player-alemanha.txt")) {
			BufferedReader bfPlayer = new BufferedReader(player);
			String p = bfPlayer.readLine();

			while (p != null) {
				System.out.println(p);
				p = bfPlayer.readLine();
			}
			bfPlayer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileReader technical = new FileReader("technicalCommittee-alemanha.txt")) {
			BufferedReader bfTechnical = new BufferedReader(technical);
			String t = bfTechnical.readLine();

			while (t != null) {
				System.out.println(t);
				t = bfTechnical.readLine();
			}
			bfTechnical.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileReader pressOfficer = new FileReader("pressOfficerContacts-alemanha.txt")) {
			BufferedReader bfPressOfficer = new BufferedReader(pressOfficer);
			String o = bfPressOfficer.readLine();

			while (o != null) {
				System.out.println(o);
				o = bfPressOfficer.readLine();
			}
			bfPressOfficer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
