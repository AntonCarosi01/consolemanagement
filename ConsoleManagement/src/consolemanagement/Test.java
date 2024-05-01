package consolemanagement;

import java.time.LocalDate;
import java.time.LocalTime;

public class Test {

	public static void main(String[] args) {
		// main

		final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_RESET = "\u001B[0m";

		System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED + "*** CONSOLE MANAGEMENT TEST ***\n" + ANSI_RESET);

		// Test Num
		ConsoleManagement cm1 = new ConsoleManagement();
		int[] cNumbers = new int[2];
		cNumbers = (cm1.giveInt("* Ins num: ", "Non è corretto!", "Ins num... ", 3));
		if (cNumbers[0] == 1) {
			int number = cNumbers[1];
			System.out.println("Ok, il numero inserito è: " + number);
		}

		// Test @email
		ConsoleManagement cm2 = new ConsoleManagement();
		String[] cMail = new String[2];
		cMail = (cm2.giveMail("\n* Inserisci email: ", "Email errata!", "Ins email... ", 3));
		if (cMail[0] == "1") {
			String mail = cMail[1];
			System.out.println("OK, email: " + mail);
		}

		// Test Date (?Format)
		ConsoleManagement cm3 = new ConsoleManagement();
		LocalDate[] cDate = new LocalDate[2];
		cDate = (cm3.giveDate("\n* Ins data [dd/mm/yyyy]: ", "Non è corretta!", "Error!", 3));
		if (cDate[0].equals(LocalDate.of(0002, 01, 01))) {
			LocalDate date = cDate[1];
			System.out.println("La data inserita è = " + date);
		}

		// Test Time
		ConsoleManagement cm4 = new ConsoleManagement();
		LocalTime[] cTime = new LocalTime[2];
		cTime = (cm4.giveTime("\n* Ins orario [hh:mm]: ", "Formato orario non corretto!", "Ins orario... ", 3));
		if (cTime[0].equals(LocalTime.of(00, 01))) {
			LocalTime time = cTime[1];
			System.out.println("Ok, orario inserito = " + time);
		}

		// CF
		ConsoleManagement cm5 = new ConsoleManagement();
		String[] cCf = new String[2];
		cCf = (cm5.giveCf("\n* Ins Codice Fiscale: ", "Non è valido!", "Ins CF... ", 3));
		if (cCf[0].equals("1")) {
			String cf = cCf[1];
			System.out.println("Il Codice Fiscale inserito è = " + cf);
		}
		
		System.out.println("\nX...");

	}

}
