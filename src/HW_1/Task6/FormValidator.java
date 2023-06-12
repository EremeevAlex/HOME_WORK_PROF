package HW_1.Task6;
import java.text.SimpleDateFormat;
import java.util.Date;
public class FormValidator {
    public static void checkName(String str) throws CheckException {
        if (str.length() < 2 || str.length() > 20 || str.substring(0, 1).matches("[^A-ZА-ЯЁ]")) {
            throw new CheckException("Invalid name");
        }
    }

    public static void checkBirthdate(String str) throws CheckException {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date startDate = format.parse("01.01.1900");
            Date inputDate = format.parse(str);
            Date currentDate = new Date();
            if (inputDate.before(startDate) || inputDate.after(currentDate)) {
                throw new CheckException("Date is not valid");
            }
        } catch (Exception ex) {
            throw new CheckException("Invalid birthdate");
        }
    }

    public static void checkGender(String str) throws CheckException {
        try {
            Gender.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new CheckException("Invalid gender");
        }
    }

    public static void checkHeight(String str) throws CheckException {
        try {
            if (Double.parseDouble(str) <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (RuntimeException ex) {
            throw new CheckException("Invalid height");
        }
    }

}

