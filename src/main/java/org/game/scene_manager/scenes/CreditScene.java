package org.game.scene_manager.scenes;

import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneEnum;
import org.game.scene_manager.SceneManager;

public class CreditScene implements IScene {
    SceneManager manager;

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        switch (line) {
            case "1":
                manager.setCurrentScene(SceneEnum.MENU);
                break;
        }
    }

    @Override
    public void render() {
        System.out.println(ANSI_CYAN+"""
                 ░▒▓██████▓▒░░▒▓███████▓▒░░▒▓████████▓▒░▒▓███████▓▒░░▒▓█▓▒░▒▓████████▓▒░▒▓███████▓▒░\s
                ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░  ░▒▓█▓▒░  ░▒▓█▓▒░       \s
                ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░  ░▒▓█▓▒░  ░▒▓█▓▒░       \s
                ░▒▓█▓▒░      ░▒▓███████▓▒░░▒▓██████▓▒░ ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░  ░▒▓█▓▒░   ░▒▓██████▓▒░ \s
                ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░  ░▒▓█▓▒░         ░▒▓█▓▒░\s
                ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░  ░▒▓█▓▒░         ░▒▓█▓▒░\s
                 ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓████████▓▒░▒▓███████▓▒░░▒▓█▓▒░  ░▒▓█▓▒░  ░▒▓███████▓▒░ \s
                                                                                                    \s
                """+ANSI_RESET);
        System.out.println("""
                        _____ ___  __  __   _   ___   ___ ___ ___ __  __ ___ ___       \s
                       |_   _/ _ \\|  \\/  | /_\\ / __| | _ | __|_ _|  \\/  | __| _ \\      \s
                         | || (_) | |\\/| |/ _ \\\\__ \\ |   | _| | || |\\/| | _||   /      \s
                  ___  _ |_|_\\___/|_|_ |_/_/ \\_|___/ |_|_|___|___|_|__|_|___|_|_\\_ _  __
                 | _ \\/_|_   _| _ |_ _| |/ / | _ \\ \\ / / __| || |_   _/_\\ | _ |_ _| |/ /
                 |  _/ _ \\| | |   /| || ' <  |   /\\ V | (__| __ | | |/ _ \\|   /| || ' <\s
                 |_|/_/ \\_|_| |_|_|___|_|\\_\\ |_|_\\ |_| \\___|_||_| |_/_/ \\_|_|_|___|_|\\_\\
                                                                                       \s
                """);
        System.out.println();
        System.out.println(space+"[1] Return");
    }

}
