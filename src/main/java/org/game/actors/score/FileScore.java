package org.game.actors.score;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileScore {
    File file = new File("scores.txt");
    public String text;

    public void readFile() {
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                text = myReader.nextLine();

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public void createFile() {
        try {
            if (file.createNewFile()) {
                System.out.println("File has been created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("File could not be created");
            e.printStackTrace();
        }
    }

    public void writeFile() {
        try {
            FileWriter file = new FileWriter("scores.txt");
            file.write(text);
            file.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
