package org.game.scene_manager.scenes;

import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneEnum;
import org.game.scene_manager.SceneManager;

public class MenuScene implements IScene {
    SceneManager manager;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        //set scene based on user input
        switch (line) {
            case "1":
                manager.setCurrentScene(SceneEnum.GAME);
                break;
            case "2":
                manager.setCurrentScene(SceneEnum.HIGHSCORE);
                break;
            case "3":
                manager.setCurrentScene(SceneEnum.SETTINGS);
                break;
            case "4":
                manager.setCurrentScene(SceneEnum.CREDITS);
                break;
            case "5":{
                System.exit(0);
            }
        }
    }

    @Override
    public void render() {
        // printing menu
        System.out.println(ANSI_YELLOW+"\n" +
                "\n" +
                "     ________  ________  _________  ________  ________  ___                    \n" +
                "    |\\   __  \\|\\   ____\\|\\___   ___\\\\   __  \\|\\   __  \\|\\  \\                   \n" +
                "    \\ \\  \\|\\  \\ \\  \\___|\\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\                  \n" +
                "     \\ \\   __  \\ \\_____  \\   \\ \\  \\ \\ \\   _  _\\ \\   __  \\ \\  \\                 \n" +
                "      \\ \\  \\ \\  \\|____|\\  \\   \\ \\  \\ \\ \\  \\\\  \\\\ \\  \\ \\  \\ \\  \\____            \n" +
                "       \\ \\__\\ \\__\\____\\_\\  \\   \\ \\__\\ \\ \\__\\\\ _\\\\ \\__\\ \\__\\ \\_______\\          \n" +
                "        \\|__|\\|__|\\_________\\   \\|__|  \\|__|\\|__|\\|__|\\|__|\\|_______|          \n" +
                "                 \\|_________|                                                  \n" +
                "                                                                               \n" +
                "                                                                               \n" +
                " ________  ________  ________  ________  ________  ________  _____ ______      \n" +
                "|\\   __  \\|\\   __  \\|\\   __  \\|\\   ____\\|\\   __  \\|\\   __  \\|\\   _ \\  _   \\    \n" +
                "\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\___|\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\   \n" +
                " \\ \\   ____\\ \\   _  _\\ \\  \\\\\\  \\ \\  \\  __\\ \\   _  _\\ \\   __  \\ \\  \\\\|__| \\  \\  \n" +
                "  \\ \\  \\___|\\ \\  \\\\  \\\\ \\  \\\\\\  \\ \\  \\|\\  \\ \\  \\\\  \\\\ \\  \\ \\  \\ \\  \\    \\ \\  \\ \n" +
                "   \\ \\__\\    \\ \\__\\\\ _\\\\ \\_______\\ \\_______\\ \\__\\\\ _\\\\ \\__\\ \\__\\ \\__\\    \\ \\__\\\n" +
                "    \\|__|     \\|__|\\|__|\\|_______|\\|_______|\\|__|\\|__|\\|__|\\|__|\\|__|     \\|__|\n" +
                "                                                                               \n" + ANSI_RESET);
        System.out.println(space+"Main Menu");
        System.out.println(space+"[1] Play");
        System.out.println(space+"[2] Show highscore");
        System.out.println(space+"[3] Settings");
        System.out.println(space+"[4] Credits");
        System.out.println(space+"[5] Exit");
    }
}