package day5HomeWork;

	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	public class EmailValidator {

		 
		    private static Pattern emailNamePtrn = Pattern.compile(
		    "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		     
		    public static boolean validateEmailAddress(String userName){
		         
		        Matcher mtch = emailNamePtrn.matcher(userName);
		        if(mtch.matches()){
		            return true;
		        }
		        return false;
		    }
	}
		     
