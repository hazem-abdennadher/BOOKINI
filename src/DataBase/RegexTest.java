package DataBase;

public class RegexTest {

	public static boolean TestAge(String age) {
		if(age.matches("[0-9]{0,2}")) {
			return true;
		}
		return false;
	}
	public static boolean TestEmail(String age) {
		if(age.matches("([a-zA-Z0-9]+)([.{1}])?([a-zA-Z0-9]+)@([a-zA-Z]+)([.])com")) {
			return true;
		}
		return false;
	}

}
