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
                manager.setCurrentScene(SceneEnum.MENU);
                break;
            case "3":
                manager.setCurrentScene(SceneEnum.SETTINGS);
                break;
            case "4":
                manager.setCurrentScene(SceneEnum.CREDITS);
                break;
            case "5":
                System.exit(0);
        }
    }

    @Override
    public void render() {
        // printing menu
        System.out.println("Space-Invaders");
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("[1] Play");
        System.out.println("[2] Show highscore");
        System.out.println("[3] Settings");
        System.out.println("[4] Credits");
        System.out.println("[5] Exit");
        manager.setCurrentScene(SceneEnum.GAME);
    }
}