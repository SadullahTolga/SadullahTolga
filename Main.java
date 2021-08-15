package day5HomeWork;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	// enter System
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		EnterSystem enterSystem = new EnterSystem();
		BasisKnowledge basisKnowledge = new BasisKnowledge();
		BasisKnowledgeService basisKnowledgeService = new BasisKnowledgeService();
		EmailValidator emailValidator = new EmailValidator();
		SignInClass sıgnInClass = new SignInClass();

		// enterSystem.enterSystem();

		BasisKnowledge personNew = new BasisKnowledge();
		personNew.setMail("xxxxxxxxx@hotmail.com");
		personNew.setPassword("12-dadasdasd");

		enterSystem.enterSystem1(personNew);

		basisKnowledgeService.getKnowledge();
		for (String i[] : basisKnowledgeService.getKnowledge()) {
			System.out.println(Arrays.toString(i));

			BasisKnowledge personNewII = new BasisKnowledge();
			personNewII.setName("Mert");
			personNewII.setSurname("Bızdıkpırt");
			personNewII.setPassword("1523");
			personNewII.setMail("aşdskmlasdaölas@hotmail.com");

			basisKnowledgeService.add(personNewII);
		}
	}

}
