package src.ua.com.hillel.kravchenko.homework9;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserRegistration {

    //Поскольку обговаривалось, что в реальной жизни Scanner не используется, то ради практики используется BufferedReader
    public void usersData (){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Please enter your login:");
            String login = reader.readLine();
            System.out.println("Please enter your password:");
            String pass1 = reader.readLine();
            System.out.println("Please enter your password again:");
            String pass2 = reader.readLine();

            if (pass1.equals(pass2)){
                String path = "src/ua/com/hillel/kravchenko/homework9/usersfolder/usersdata.txt";
                Path pathToFile = Paths.get(path);
                if (!Files.exists(pathToFile.getParent())) {
                    Files.createDirectories(pathToFile.getParent());
                    //Я понимаю что эта часть метода должна быть вынесена в отдельный метод, и в этом методе мы
                    //должны считывать с клавиатуры данные и вызывать другой метод что бы записывать в файл
                    //(тот самый момент, что через один метод должна проходить только
                    //одна "ось изменений", т.е.принцип единой ответственности, но я не могу понять как передать
                    //логин и пароль что бы не делать глобальных переменных.
                    //По этой логике я сделал класс LoginCheck где разбил на короткие методы с одной осью изменений
                    //Но по архитектуре я не понимаю какой подход лучше.
                } try (FileWriter fileWriter = new FileWriter(path, true)) {
                    fileWriter.write(login);
                    fileWriter.write('\n');
                    fileWriter.write(pass1);
                }
            }else{
                System.out.println("You entered wrong password \n" + "Exit from program");

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
