import java.io.FileWriter;
import java.util.Scanner;

public class DataRequest {

    private String firstName;
    private String lastName;
    private String middleName;
    private String dataOfBirth;
    private String numberPhone;
    private char gender;
    private final Scanner scan = new Scanner(System.in);

    private void EnterFirstName() {
        System.out.println("Введите имя:");
        firstName = scan.nextLine();
        if (firstName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\n попробуйте снова!");
        }
    }

    private void EnterLastName() {
        System.out.println("Введите фамилию:");
        lastName = scan.nextLine();
        if (lastName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\n попробуйте снова!");
        }
    }

    private void EnterMiddleName() {
        System.out.println("Введите отчество:");
        middleName = scan.nextLine();
        if (middleName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\n попробуйте снова!");
        }
    }

    private void EnterDataOfBirth() {
        System.out.println("Введите дату рождения:");
        dataOfBirth = scan.nextLine();
        if (dataOfBirth.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\n попробуйте снова!");
        }
    }

    private void EnterNumberPhone() {
        try {
            System.out.println("Введите телефон:");
            String number = scan.nextLine();
            if (number.equals("")) {
                throw new RuntimeException("Вводимое значение не может быть пустым,\n попробуйте снова!");
            }
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Не верный формат,\n попробуйте снова!");
        }
    }

    private void EnterGender() {
        System.out.println("Введите пол (f, m):");
        String gen;
        String f = "f";
        String m = "m";
        gen = scan.nextLine();
        if (gen.length() > 1) {
            throw new RuntimeException("Вы ввели слишком много символов, \n попробуйте снова!");
        }
        if (gen.equals(f) || gen.equals(m)) {
            gender = gen.charAt(0);
        } else {
            throw new RuntimeException("Вы ввели не тот символ!");
        }
    }

    private void OutPutData() {
        System.out.println("\nFirst name \t- \t" + firstName + "\n" + "Last name \t- \t" + lastName + "\n"
                + "Middle name \t- \t" + middleName + "\n" + "Data of birth \t- \t" + dataOfBirth + "\n"
                + "Number phone \t- \t" + numberPhone + "\n" + "Gender   \t- \t" + gender);
    }

    private void DataEnter() {
        EnterFirstName();
        EnterLastName();
        EnterMiddleName();
        EnterDataOfBirth();
        EnterNumberPhone();
        EnterGender();
        OutPutData();
    }

    /**
     * 
     */
    public void SaveDataEnter() {

        DataEnter();
        String fileName = "data/" + lastName + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("<" + firstName + "> " + "<" + lastName + "> " + "<" + middleName + "> " + "<" + dataOfBirth
                    + "> " + "<" + numberPhone + "> " + "<" + gender + ">\n");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так!");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public char getGender() {
        return gender;
    }
}