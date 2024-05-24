package org.game.actors.score;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ScoreLoader {
    File file = new File("scores.txt");
    private String text = "";

    public ArrayList<String> readFile() {
        //tries to read file
        try {
            ArrayList<String> list = new ArrayList<>();
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                text = myReader.nextLine();
                list.add(text);
            }
            myReader.close();
            return list;
        } //if not then creates file and returns nothing
        catch (FileNotFoundException e) {
            createFile();
            return new ArrayList<>();
        }
    }

    public void createFile() {
        //tries to create file
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Score> overwriteScore(ArrayList<Score> list, Score player) {
        for(int i = 0; i < list.size(); i++) {
            if(player.getScore() > list.get(i).getScore()){
                list.add(i ,player);
                break;
            }
        }
        return list;
    }

    public void writeFile(ArrayList<Score> list) {
        StringBuilder text = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            text.append(list.get(i).getName()).append(":").append(list.get(i).getScore()).append("\n");
        }
        try {
            FileWriter file = new FileWriter("scores.txt",false);
            file.write(text.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String[] splitByColumn(String text){
        return text.split(":");
    }
}
