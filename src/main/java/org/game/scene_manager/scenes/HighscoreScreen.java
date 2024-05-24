package org.game.scene_manager.scenes;

import org.game.actors.Player;
import org.game.actors.score.ScoreLoader;
import org.game.actors.score.Score;
import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneEnum;
import org.game.scene_manager.SceneManager;

import java.util.*;


public class HighscoreScreen implements IScene {
    SceneManager manager;

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    String space = IScene.space + "          ";

    Score playerscore = new Score(0, "");
    ScoreLoader scoreLoader = new ScoreLoader();
    ArrayList<Score> scores = new ArrayList<>();
    ArrayList<String> loadedText = new ArrayList<>();
    boolean fileReadable = true;
    boolean isLoaded = false;

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        isLoaded = true;
        //gets player score and resets score counter to 0
        //playerscore needs additional update to load correct score
        playerscore.setScore(Player.instance.getScore());
        //loads score data
        loadedText = scoreLoader.readFile();
        if (!loadedText.isEmpty()) {
            fileReadable = true;
        }

        //loads scores from file
        if (fileReadable) {
            for (String s : loadedText) {
                String[] splitText = scoreLoader.splitByColumn(s);
                Score score = new Score(Integer.parseInt(splitText[1]), splitText[0]);
                scores.add(score);
                //removes scores from list that are longer than one
                for (int i = 0; i < scores.size(); i++) {
                    if (i > 10) {
                        scores.remove(i);
                        i--;
                    }
                }
            }
        } else {
            System.out.println(space+"Couldn't get any score!");
        }
        Collections.sort(scores);
        switch (line) {
            case "1":
                while(true){
                    System.out.print(space+"Enter nickname:");
                    Scanner scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    if(name.length()>3){
                        System.out.println(space+"Nickname should be 3 characters long!");
                    }
                    else{
                        playerscore.setName(name.toUpperCase());
                        break;
                    }
                }
                scores = scoreLoader.overwriteScore(scores, playerscore);
                scoreLoader.writeFile(scores);
                break;
            case "2":
                loadedText.clear();
                Player.instance.setScore(0);
                manager.setCurrentScene(SceneEnum.MENU);
                break;
        }
        //removes scores from list that are longer than one
        for (int i = 0; i < scores.size(); i++) {
            if (i > 10) {
                scores.remove(i);
                i--;
            }
        }
    }

    @Override
    public void render() {
        if(!isLoaded){
            update("");
        }
        //console "clear"
        System.out.println("\n\n\n\n\n\n");
        System.out.println(ANSI_BLUE+"""


                ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓███████▓▒░░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓███████▓▒░░▒▓████████▓▒░\s
                ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░       \s
                ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░       \s
                ░▒▓████████▓▒░▒▓█▓▒░▒▓█▓▒▒▓███▓▒░▒▓████████▓▒░░▒▓██████▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░░▒▓██████▓▒░  \s
                ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░       \s
                ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░       \s
                ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░ ░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓████████▓▒░\s
                                                                                                                               \s
                                                                                                                               \s

                """+ANSI_RESET);
        System.out.println(space+"     NAME | SCORE");
        for (int i = 1; i < scores.size(); i++) {
            if (i < 10) {
                System.out.println(space+"{ " + i + "} " + scores.get(i).getName() + "     " + scores.get(i).getScore());
            } else {
                System.out.println(space+"{" + i + "} " + scores.get(i).getName() + "     " + scores.get(i).getScore());
            }
        }
        System.out.println();
        System.out.print(space+"Your current score: ");
        System.out.println(Player.instance.getScore());
        System.out.println(space+"[1] Save your score");
        System.out.println(space+"[2] Return to menu");
    }
}
