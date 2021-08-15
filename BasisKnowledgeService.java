package day5HomeWork;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class BasisKnowledgeService {
	// Scanner Sınıfı ile Bilgi Alımı!!
	public void enterInformation(BasisKnowledge basisKnowledge) {
		System.out.println("Welcome! Please enter your information");
		Scanner name = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String myObj1 = name.nextLine();

		if (myObj1.length() < 2) {
			System.out.println("You name is short!");
		}

		Scanner surname = new Scanner(System.in);
		System.out.println("Enter your surname ");
		String myObj2 = surname.nextLine();
		if (myObj2.length() < 2) {
			System.out.println("You surname is short!");
		}

		EmailValidator emailValidator = new EmailValidator();

		boolean dogruMu1 = false;
		while (dogruMu1 = true) {
			Scanner mail = new Scanner(System.in);
			System.out.println("Please enter your mail:");
			String myObj5 = mail.nextLine();

			System.out.println("This email a valid email adress?" + emailValidator.validateEmailAddress(myObj5));
			boolean dogruMu = emailValidator.validateEmailAddress(myObj5);
			if (dogruMu = true) {
				System.out.println("This mail accepted!");
				if (basisKnowledge.getMail() == "xxxxxxxxx@hotmail.com"
						|| basisKnowledge.getMail() == "xasdasdasx@hotmail.com"
						|| basisKnowledge.getMail() == "tttttttt@hotmail.com"
						|| basisKnowledge.getMail() == "xxxxxasdasdaxxxx@hotmail.com"
						|| basisKnowledge.getMail() == "yyyyy@hotmail.com"
						|| basisKnowledge.getMail() == "xxssxxxxxxx@hotmail.com") {
					System.out.println("This mail is used.Please try again!");

				} else {
					System.out.println("Wonderful!!");
					break;
				}

			}
		}
		Scanner password = new Scanner(System.in);
		System.out.println("Enter your surname ");
		String myObj3 = password.nextLine();
		while (myObj3.length() > 6) {
			if (myObj3.length() < 6) {
				System.out.println("Password must be at least 6 characters.");
			}
		}

		if (myObj3.length() > 6) {

			if (myObj3.contains("1") || myObj3.contains("2") || myObj3.contains("3") || myObj3.contains("4")
					|| myObj3.contains("5") || myObj3.contains("6") || myObj3.contains("7") || myObj3.contains("8")
					|| myObj3.contains("9")) {
				System.out.println("Accepted");
			} else {
				System.out.println("Password must contain at least one number!");
			}

			if (myObj3.contains(".") || myObj3.contains("-") || myObj3.contains("+") || myObj3.contains("*")) {
				System.out.println("Accepted");
			} else {
				System.out.println("Password must contain at least one special character!");
			}

		}
	}

	// Olan Bilgilere Erişim
	public ArrayList<String[]> getKnowledge() {

		ArrayList<String[]> list = new ArrayList<String[]>();

		BasisKnowledge person1 = new BasisKnowledge();
		person1.setName("Sadullah Tolga");
		person1.setSurname("ÖZBAY");
		person1.setMail("xxssxxxxxxx@hotmail.com");
		person1.setPassword("12-dadasdasd");

		BasisKnowledge person2 = new BasisKnowledge();
		person2.setName("Engin");
		person2.setSurname("Demirog");
		person2.setMail("yyyyy@hotmail.com");
		person2.setPassword("24-dadasdasd");

		BasisKnowledge person3 = new BasisKnowledge();
		person3.setName("Mina");
		person3.setSurname("MİNA");
		person3.setMail("xxxxxasdasdaxxxx@hotmail.com");
		person3.setPassword("15-dadasdasd");

		BasisKnowledge person4 = new BasisKnowledge();
		person4.setName("Gülay");
		person4.setSurname("GÜLAY");
		person4.setMail("tttttttt@hotmail.com");
		person4.setPassword("32-dasdasda");

		BasisKnowledge person5 = new BasisKnowledge();
		person5.setName("Veysel");
		person5.setSurname("VEYSEL");
		person5.setMail("xasdasdasx@hotmail.com");
		person5.setPassword("1asdasd2--sdasd");

		BasisKnowledge person6 = new BasisKnowledge();
		person6.setName("Atacan");
		person6.setSurname("ATACAN");
		person6.setMail("xxxxxxxxx@hotmail.com");
		person6.setPassword("asdaas12asd-d");

		String name[] = { person1.getName(), person2.getName(), person3.getName(), person4.getName(), person5.getName(),
				person6.getName() };

		String surname[] = { person1.getSurname(), person2.getSurname(), person3.getSurname(), person4.getSurname(),
				person5.getSurname(), person6.getSurname() };

		String mails[] = { person1.getMail(), person2.getMail(), person3.getMail(), person4.getMail(),
				person5.getMail(), person6.getMail(), };

		String password[] = { person1.getPassword(), person2.getPassword(), person3.getPassword(),
				person4.getPassword(), person5.getPassword(), person6.getPassword() };

		list.add(name);
		list.add(surname);
		list.add(mails);
		list.add(password);

		return list;

	}

	// Kontroller ve eklemek
	public void add(BasisKnowledge basisKnowledge) {
		if (basisKnowledge.getPassword().length() < 6) {
			System.out.println("Your password is so short!");
			
		}
		if (basisKnowledge.getName().length() < 2 || basisKnowledge.getSurname().length() < 2) {
			System.out.println("Your name or surname must to be long 2 characters");

		}

		EmailValidator emailValidator = new EmailValidator();

		System.out.println(
				"This email a valid email adress?" + emailValidator.validateEmailAddress(basisKnowledge.getMail()));
		boolean dogruMu = emailValidator.validateEmailAddress(basisKnowledge.getMail());
		if (dogruMu = true) {
			System.out.println("This mail accepted!");

			if (basisKnowledge.getMail() == "xxxxxxxxx@hotmail.com"
					|| basisKnowledge.getMail() == "xasdasdasx@hotmail.com"
					|| basisKnowledge.getMail() == "tttttttt@hotmail.com"
					|| basisKnowledge.getMail() == "xxxxxasdasdaxxxx@hotmail.com"
					|| basisKnowledge.getMail() == "yyyyy@hotmail.com"
					|| basisKnowledge.getMail() == "xxssxxxxxxx@hotmail.com") {
				System.out.println("This mail is used.Please try again!");
					

			} else {
				System.out.println("Wonderful!!");
			}
		}

	}

	public void check(BasisKnowledge basisKnowledge) {
		System.out.println("We have sent a verification link to your email,please confirm the verification link.");
		Scanner checkIt = new Scanner(System.in);
		System.out.println("Check it!");
		String myObj7 = checkIt.nextLine();
		if (myObj7 == "Check") {
			System.out.println("Welcome");

		} else {
			System.out.println("Please , control you email");
		}

	}
}
