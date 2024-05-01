package consolemanagement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/*
 * 
 * CONSOLE MANAGEMENT
 * 1/05/24
 * 
 */

public class ConsoleManagement {

	// Scanner
	private Scanner myScan = new Scanner(System.in);
	// ?Regex
	private String sIntRegex = "[0-9]+";
	private String sMailRegex = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}";
	private String sYearRegex = "\\d{4}";
	private String sMonthRegex = "(0[1-9]|1[012])";
	private String sDayRegex = "(0[1-9]|[12][1-9]|3[01])";
	private String sHourRegex = "([01]?[0-9]|2[0-3])";
	private String sMinuteRegex = "[0-5][0-9]";
	private String sCfRegex = "^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$";
	// Colors
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BLUE = "\u001B[34m";

	// *** *** ***

	// String
	public String[] giveString(String sRequestMsg, String sRetryMsg, String errorMsg, int iNumTry) {
		int n = 0;
		String[] rString = new String[2];
		while (true) {
			System.out.println(sRequestMsg);
			String sString = myScan.nextLine();
			if (sString.equals("")) {
				n++;
				if (n == iNumTry) {
					System.out.println(errorMsg);
					rString[0] = "0";
					break;
				}
				System.out.println(sRetryMsg);
			} else {
				rString[0] = "1";
				rString[1] = sString;
				break;
			}
		}
		return rString;
	}

	// Num int
	public int[] giveInt(String sRequestMsg, String sRetryMsg, String errorMsg, int iNumTry) {
		int n = 0;
		int[] rNumber = new int[2];
		while (true) {
			System.out.println(ANSI_GREEN + sRequestMsg + ANSI_RESET);
			String number = myScan.nextLine();
			if (!number.matches(sIntRegex)) {
				n++;
				if (n == iNumTry) {
					System.out.println(ANSI_RED + errorMsg + ANSI_RESET);
					rNumber[0] = 0;
					break;
				}
				System.out.println(ANSI_RED + sRetryMsg + ANSI_RESET);
			} else {
				rNumber[0] = 1;
				rNumber[1] = Integer.parseInt(number);
				break;
			}
		}
		return rNumber;
	}

	// @email
	public String[] giveMail(String sRequestMsg, String sRetryMsg, String errorMsg, int iNumTry) {
		int n = 0;
		String[] rMail = new String[2];
		while (true) {
			System.out.println(sRequestMsg);
			String sMail = myScan.nextLine();
			if (!sMail.toUpperCase().matches(sMailRegex)) {
				n++;
				if (n == iNumTry) {
					System.out.println(errorMsg);
					rMail[0] = "0";
					break;
				}
				System.out.println(sRetryMsg);
			} else {
				rMail[0] = "1";
				rMail[1] = sMail.toLowerCase();
				break;
			}
		}
		return rMail;
	}

	// Date
	public LocalDate[] giveDate(String sRequestMsg, String sRetryMsg, String errorMsg, int iNumTry) {
		int n = 0;
		LocalDate[] rDate = new LocalDate[2];
		while (true) {
			System.out.println(sRequestMsg);
			String sDate = myScan.nextLine();
			String splitDate[] = sDate.split("/");
			if (splitDate.length == 3) {
				if (!splitDate[0].matches(sDayRegex) || !splitDate[1].matches(sMonthRegex)
						|| !splitDate[2].matches(sYearRegex)) {
					n++;
					if (n == iNumTry) {
						System.out.println(errorMsg);
						rDate[0] = LocalDate.of(0001, 01, 01);
						break;
					}
					System.out.println(sRetryMsg);
				} else {
					rDate[0] = LocalDate.of(0002, 01, 01);
					rDate[1] = LocalDate.of(Integer.parseInt(splitDate[2]), Integer.parseInt(splitDate[1]),
							Integer.parseInt(splitDate[0]));
					break;
				}
			} else if (splitDate.length != 3) {
				n++;
				if (n == iNumTry) {
					System.out.println(errorMsg);
					rDate[0] = LocalDate.of(0001, 01, 01);
					break;
				}
				System.out.println(sRetryMsg);
			}
		}
		return rDate;
	}

	// Time (+Colors...)
	public LocalTime[] giveTime(String sRequestMsg, String sRetryMsg, String errorMsg, int iNumTry) {
		int n = 0;
		LocalTime[] rTime = new LocalTime[2];
		while (true) {
			System.out.println(ANSI_GREEN + sRequestMsg + ANSI_RESET);
			String sTime = myScan.nextLine();
			String splitTime[] = sTime.split(":");
			if (splitTime.length == 2) {
				if (!splitTime[0].matches(sHourRegex) || !splitTime[1].matches(sMinuteRegex)) {
					n++;
					if (n == iNumTry) {
						System.out.println(ANSI_RED + errorMsg + ANSI_RESET);
						rTime[0] = LocalTime.of(00, 00);
						break;
					}
					System.out.println(ANSI_RED + sRetryMsg + ANSI_RESET);
				} else {
					rTime[0] = LocalTime.of(00, 01);
					rTime[1] = LocalTime.of(Integer.parseInt(splitTime[0]), Integer.parseInt(splitTime[1]));
					break;
				}
			} else if (splitTime.length != 2) {
				n++;
				if (n == iNumTry) {
					System.out.println(ANSI_RED + errorMsg + ANSI_RESET);
					rTime[0] = LocalTime.of(00, 00);
					break;
				}
				System.out.println(ANSI_RED + sRetryMsg + ANSI_RESET);
			}
		}
		return rTime;
	}

	// CF
	public String[] giveCf(String sRequestMsg, String sRetryMsg, String errorMsg, int iNumTry) {
		int n = 0;
		String[] rCf = new String[2];
		while (true) {
			System.out.println(sRequestMsg);
			String sCf = myScan.nextLine();
			if (!sCf.toUpperCase().matches(sCfRegex)) {
				n++;
				if (n == iNumTry) {
					System.out.println(errorMsg);
					rCf[0] = "0";
					break;
				}
				System.out.println(sRetryMsg);
			} else {
				rCf[0] = "1";
				rCf[1] = sCf.toUpperCase();
				break;
			}
		}
		return rCf;
	}

}

// Work In Progress...
