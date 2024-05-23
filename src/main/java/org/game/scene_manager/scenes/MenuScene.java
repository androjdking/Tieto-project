package org.game.scene_manager.scenes;

import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneEnum;
import org.game.scene_manager.SceneManager;

public class MenuScene implements IScene {
    SceneManager manager;

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
        System.out.println("\n" +
                "\n" +
                "         ________   ________   ________   ________   _______                               \n" +
                "        |\\   ____\\ |\\   __  \\ |\\   __  \\ |\\   ____\\ |\\  ___ \\                              \n" +
                "        \\ \\  \\___|_\\ \\  \\|\\  \\\\ \\  \\|\\  \\\\ \\  \\___| \\ \\   __/|                             \n" +
                "         \\ \\_____  \\\\ \\   ____\\\\ \\   __  \\\\ \\  \\     \\ \\  \\_|/__                           \n" +
                "          \\|____|\\  \\\\ \\  \\___| \\ \\  \\ \\  \\\\ \\  \\____ \\ \\  \\_|\\ \\                          \n" +
                "            ____\\_\\  \\\\ \\__\\     \\ \\__\\ \\__\\\\ \\_______\\\\ \\_______\\                         \n" +
                "           |\\_________\\\\|__|      \\|__|\\|__| \\|_______| \\|_______|                         \n" +
                "           \\|_________|                                                                    \n" +
                "                                                                                           \n" +
                "                                                                                           \n" +
                " ___   ________    ___      ___  ________   ________   _______    ________   ________      \n" +
                "|\\  \\ |\\   ___  \\ |\\  \\    /  /||\\   __  \\ |\\   ___ \\ |\\  ___ \\  |\\   __  \\ |\\   ____\\     \n" +
                "\\ \\  \\\\ \\  \\\\ \\  \\\\ \\  \\  /  / /\\ \\  \\|\\  \\\\ \\  \\_|\\ \\\\ \\   __/| \\ \\  \\|\\  \\\\ \\  \\___|_    \n" +
                " \\ \\  \\\\ \\  \\\\ \\  \\\\ \\  \\/  / /  \\ \\   __  \\\\ \\  \\ \\\\ \\\\ \\  \\_|/__\\ \\   _  _\\\\ \\_____  \\   \n" +
                "  \\ \\  \\\\ \\  \\\\ \\  \\\\ \\    / /    \\ \\  \\ \\  \\\\ \\  \\_\\\\ \\\\ \\  \\_|\\ \\\\ \\  \\\\  \\|\\|____|\\  \\  \n" +
                "   \\ \\__\\\\ \\__\\\\ \\__\\\\ \\__/ /      \\ \\__\\ \\__\\\\ \\_______\\\\ \\_______\\\\ \\__\\\\ _\\  ____\\_\\  \\ \n" +
                "    \\|__| \\|__| \\|__| \\|__|/        \\|__|\\|__| \\|_______| \\|_______| \\|__|\\|__||\\_________\\\n" +
                "                                                                               \\|_________|\n" +
                "                                                                                           \n");
        System.out.println("Main Menu");
        System.out.println("[1] Play");
        System.out.println("[2] Show highscore");
        System.out.println("[3] Settings");
        System.out.println("[4] Credits");
        System.out.println("[5] Exit");
    }
}