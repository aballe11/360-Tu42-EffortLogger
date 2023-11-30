package application;

public class InputValidation {
	
    private static final int MAX_USERNAME_LENGTH = 30;
    private static final int MIN_USERNAME_LENGTH = 8;
    private static final int MAX_EMAIL_LENGTH = 254;
    private static final int MAX_PASSWORD_LENGTH = 64;
    private static final int MIN_PASSWORD_LENGTH = 8;
	
	public static boolean isUsernameValid(String username) {
		//Valid pattern for username
		String usernamePattern = "^[a-zA-Z0-9]*$";
		//Returns true if username input meets all specifications
		return username != null && 
				!username.trim().isEmpty() &&
				username.length() <= MAX_USERNAME_LENGTH && 
				username.length() >= MIN_USERNAME_LENGTH && 
				username.matches(usernamePattern);
	}
	
	public static boolean isPasswordValid(String password) {
		//Valid pattern for password
		String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
		//Returns true if password input meets all specifications
        return password != null && 
        	   password.length() >= MIN_PASSWORD_LENGTH &&
               password.length() <= MAX_PASSWORD_LENGTH && 
               password.matches(passwordPattern);
	}
	
	public static boolean isEmailValid(String email) {
		//Valid pattern for email
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		//Returns true if email input meets all specifications
        return email != null && 
               !email.trim().isEmpty() && 
               email.length() <= MAX_EMAIL_LENGTH && 
               email.matches(emailPattern);
	}
}
