package supermarket.application.model.userclassDao;

public class PasswordValidation {
    public  boolean validatePassword(String password) {
        if (password.length() < 6) {
            return false;
        }
        boolean hasUppercase = !password.equals(password.toLowerCase());
        if (!hasUppercase) {
            return false;
        }
        String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        boolean hasSpecialChar = false;
        for (char c : specialChars.toCharArray()) {
            if (password.contains(String.valueOf(c))) {
                hasSpecialChar = true;
                break;
            }
        }
        if (!hasSpecialChar) {
            return false;
        }
        int digitCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        if (digitCount < 2) {
            return false;
        }
        return true;
    }
}
