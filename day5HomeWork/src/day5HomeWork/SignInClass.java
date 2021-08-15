package day5HomeWork;

import java.util.Scanner;

public class SignInClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome , İf you want sign it with google.Please enter your information!");
		EmailValidator emailValidator=new EmailValidator();
		
		  
	    boolean dogruMu1= false;
	    while(dogruMu1=true) {
	    Scanner mail=new Scanner(System.in);
		System.out.println("Please enter your mail:");
		String myObj5=mail.nextLine();
		
		
		System.out.println("This email a valid email adress : "+ emailValidator.validateEmailAddress(myObj5));
		boolean dogruMu=emailValidator.validateEmailAddress(myObj5);
		if(dogruMu=true) {
			System.out.println("This mail accepted!");	
			break;
			}
		else {
			System.out.println("Please check your information!");
		}
		
		
	    }
	}
	
	public void control(BasisKnowledge basisKnowledge) {
		EmailValidator emailValidator=new EmailValidator();
	
		System.out.println("This email a valid email adress?" + emailValidator.validateEmailAddress(basisKnowledge.getMail()));
		boolean dogruMu=emailValidator.validateEmailAddress(basisKnowledge.getMail());
		if(dogruMu=true) {
			System.out.println("This mail accepted!");
			if(basisKnowledge.getMail()=="xxxxxxxxx@hotmail.com"||basisKnowledge.getMail()=="xasdasdasx@hotmail.com"||basisKnowledge.getMail()=="tttttttt@hotmail.com"||
					basisKnowledge.getMail()=="xxxxxasdasdaxxxx@hotmail.com"||basisKnowledge.getMail()=="yyyyy@hotmail.com"||
					basisKnowledge.getMail()=="xxssxxxxxxx@hotmail.com") {
				System.out.println("This mail is used.Please try again!");
				
			}
			else {
				System.out.println("Wonderful!!");
			}
			
	}
		else {
			System.out.println("Please check your information!");
		}

}
}
