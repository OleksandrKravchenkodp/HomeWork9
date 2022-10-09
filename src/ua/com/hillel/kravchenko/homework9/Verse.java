package src.ua.com.hillel.kravchenko.homework9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Verse {

    void writeVerse() throws IOException {
        String path = "src/ua/com/hillel/kravchenko/homework9/versefolder/verse.txt";
        Path pathToFile = Paths.get(path);
        if (!Files.exists(pathToFile.getParent())) {
            Files.createDirectories(pathToFile.getParent());
        }
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write("I am a boy\n");
            fileWriter.write("A little one.\n");
            fileWriter.write("I like to play,\n");
            fileWriter.write("I like to run.\n");
            //поток не закрываю, т.к. используется try with resources
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void readVerse() {
        try (FileReader fileReader = new FileReader("src/ua/com/hillel/kravchenko/homework9/versefolder/verse.txt");
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Error in readVerse method");
        }
    }

}
