package day5HomeWork;

import java.util.Scanner;

public class EnterSystem {

	// Scanner İle
	public void enterSystem() {
		System.out.println("Log ın...");
		System.out.println("Please enter your mail and password!");

		Scanner mail = new Scanner(System.in);
		System.out.println("Please enter your mail:");
		String mail1 = mail.nextLine();

		Scanner password = new Scanner(System.in);
		System.out.println("Please enter your password:");
		String password1 = mail.nextLine();

		if (mail1 == "xxxxxxxxx@hotmail.com" || mail1 == "xasdasdasx@hotmail.com" || mail1 == "tttttttt@hotmail.com"
				|| mail1 == "xxxxxasdasdaxxxx@hotmail.com" || mail1 == "yyyyy@hotmail.com"
				|| mail1 == "xxssxxxxxxx@hotmail.com") {
			if (

			password1 == ("12-dadasdasd") && mail1 == "xxxxxxxxx@hotmail.com" ||

					password1 == ("24-dadasdasd") && mail1 == "xasdasdasx@hotmail.com" ||

					password1 == ("15-dadasdasd") && mail1 == "tttttttt@hotmail.com" ||

					password1 == ("32-dasdasda") && mail1 == "xxxxxasdasdaxxxx@hotmail.com" ||

					password1 == ("1asdasd2--sdasd") && mail1 == "yyyyy@hotmail.com" ||

					password1 == ("asdaas12asd-d") && mail1 == "xxssxxxxxxx@hotmail.com") {
				System.out.println("Your mail and password correct.Welcome!");
			}

		}

		else {
			System.out.println("You mail or password wrong . Please check it!");
		}
	}

	// Normal
	public void enterSystem1(BasisKnowledge basisKnowledge) {
		System.out.println("Log ın...");
		System.out.println("Please enter your mail and password!");

		if (basisKnowledge.getMail() == "xxxxxxxxx@hotmail.com" || basisKnowledge.getMail() == "xasdasdasx@hotmail.com"
				|| basisKnowledge.getMail() == "tttttttt@hotmail.com"
				|| basisKnowledge.getMail() == "xxxxxasdasdaxxxx@hotmail.com"
				|| basisKnowledge.getMail() == "yyyyy@hotmail.com"
				|| basisKnowledge.getMail() == "xxssxxxxxxx@hotmail.com") {
			if (

			basisKnowledge.getPassword() == "12-dadasdasd" && basisKnowledge.getMail() == "xxxxxxxxx@hotmail.com" ||

					basisKnowledge.getPassword() == "24-dadasdasd"
							&& basisKnowledge.getMail() == "xasdasdasx@hotmail.com"
					||

					basisKnowledge.getPassword() == "15-dadasdasd"
							&& basisKnowledge.getMail() == "tttttttt@hotmail.com"
					||

					basisKnowledge.getPassword() == "32-dasdasda"
							&& basisKnowledge.getMail() == "xxxxxasdasdaxxxx@hotmail.com"
					||

					basisKnowledge.getPassword() == "1asdasd2--sdasd"
							&& basisKnowledge.getMail() == "yyyyy@hotmail.com"
					||

					basisKnowledge.getPassword() == "asdaas12asd-d"
							&& basisKnowledge.getMail() == "xxssxxxxxxx@hotmail.com") {
				System.out.println("Your mail and password correct.Welcome!");
			}

		}

		else {
			System.out.println("You mail or password wrong . Please check it!");
		}
	}

}
