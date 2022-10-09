package src.ua.com.hillel.kravchenko.homework9;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LoginCheck {

    private String userLogin;
    private String userPassword;
    private boolean checkLogin = false;
    private boolean checkPassword = false;
    private int count = 1;

    public void enterUsersData() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter your login:");
            userLogin = scanner.nextLine();
            System.out.println("Please enter your password:");
            userPassword = scanner.nextLine();

            checkUsersData();
        }
    }

    void checkUsersData() {
        try (FileReader fileReader = new FileReader("src/ua/com/hillel/kravchenko/homework9/usersfolder/usersdata.txt");
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().equals(userLogin)) {
                    checkLogin = true;
                }
                if (scanner.nextLine().equals(userPassword)) {
                    checkPassword = true;
                }
            }
            serverAnswer();
        } catch (IOException exception) {
            System.err.println("Error processing user data");
        }
    }

    void serverAnswer() {
        if (count >= 3) {
            System.out.println("Too many attempts, try again later");
            return;
        }
        if (checkLogin == true && checkPassword == true) {
            System.out.println("Welcom beck! :)");
        } else {
            System.out.println("You entered incorrect data, please try again");
            count++;
            enterUsersData();
        }
    }
}
