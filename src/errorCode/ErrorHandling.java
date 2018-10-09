package errorCode;

import java.sql.SQLException;

public class ErrorHandling {
	public static String getMessageForErrorCode(int errorCode, String prefix) {
		String code = "The object is bound in either the class HasStudied or Studies";
		//duplicated primary key
		if(errorCode == 2627) {
			code = prefix + " already registred";
		}

		if (errorCode == 18456) {
			code = "Log in to database failed";
		}
		
		if(errorCode == 8152) {
			code = "Too long variable";
			
		}
		if(errorCode == 0) {
			code = prefix + "has already read the course";
		
	}
	return code;
		
	}
		
}
		
	
	

