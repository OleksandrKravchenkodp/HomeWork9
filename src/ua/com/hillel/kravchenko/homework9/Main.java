package src.ua.com.hillel.kravchenko.homework9;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Verse verse = new Verse();
        try {
            verse.writeVerse();
            System.out.println("Recording successful)");
        } catch (IOException e) {
            System.err.println("Error in writeVerse method");
        }

        verse.readVerse();

        UserRegistration userRegistration = new UserRegistration();
        userRegistration.usersData();

        LoginCheck loginCheck = new LoginCheck();
        loginCheck.enterUsersData();

    }

}
