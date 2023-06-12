package HW_1.Task6;

public class Main {
    public static void main(String[] args) {

        try {
            FormValidator.checkName("Alizee");
            System.out.println("Valid name");
            FormValidator.checkName("A");
            System.out.println("Valid name");
        } catch (CheckException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            FormValidator.checkName("Ёлка");
            System.out.println("Valid name");
            FormValidator.checkName("Ёёёёёёёёёёёёёёёёёёлка");
            System.out.println("Valid name");
        } catch (CheckException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            FormValidator.checkName("УМКА");
            System.out.println("Valid name");
            FormValidator.checkName("умка");
            System.out.println("Valid name");
        } catch (CheckException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            FormValidator.checkBirthdate("31.07.1991");
            System.out.println("Valid birthdate");
            FormValidator.checkBirthdate("31-07-1991");
            System.out.println("Valid birthdate");
        } catch (CheckException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            FormValidator.checkBirthdate("01.01.1900");
            System.out.println("Valid birthdate");
            FormValidator.checkBirthdate("31.12.1899");
            System.out.println("Valid birthdate");
        } catch (CheckException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            FormValidator.checkBirthdate("23.09.2022");
            System.out.println("Valid birthdate");
            FormValidator.checkBirthdate("24.09.2022");
            System.out.println("Valid birthdate");
        } catch (CheckException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            FormValidator.checkGender("Male");
            System.out.println("Valid gender");
            FormValidator.checkGender("Males");
            System.out.println("Valid gender");
        } catch (CheckException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            FormValidator.checkGender("female");
            System.out.println("Valid gender");
            FormValidator.checkGender("fem");
            System.out.println("Valid gender");
        } catch (CheckException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            FormValidator.checkHeight("1.60");
            System.out.println("Valid height");
            FormValidator.checkHeight("meter");
            System.out.println("Valid height");
        } catch (CheckException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            FormValidator.checkHeight("160");
            System.out.println("Valid height");
            FormValidator.checkHeight("0");
            System.out.println("Valid height");
        } catch (CheckException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            FormValidator.checkHeight("+160");
            System.out.println("Valid height");
            FormValidator.checkHeight("-160");
            System.out.println("Valid height");
        } catch (CheckException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
