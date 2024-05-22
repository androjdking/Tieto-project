package org.game.scene_manager;


import org.game.scene_manager.scenes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class SceneManager {
    public ArrayList<IScene> sceneArray;
    private int index;

    public IScene getCurrentScene() {
        return sceneArray.get(index);
    }

    public void setCurrentScene(SceneEnum scene) {
        int newIndex = scene.ordinal();
        if (newIndex >= sceneArray.size())
            return;

        index = newIndex;
    }

    public SceneManager() {
        sceneArray = new ArrayList<>();
        index = 0;

        // Adding scenes to array
        sceneArray.add(SceneEnum.MENU.ordinal(), new MenuScene());
        sceneArray.add(SceneEnum.SETTINGS.ordinal(), new SettingScene());
        //sceneArray.add(SceneEnum.HIGHSCORE.ordinal(), new ScoreScene());
        sceneArray.add(SceneEnum.GAME.ordinal(), new GameScreen());
        sceneArray.add(SceneEnum.DEATH.ordinal(), new DeathScreen());

        // Initializing all scenes
        for (IScene scene : sceneArray) {
            scene.init(this);
        }
    }

    public void loop() {
        //game pipeline
        String line = "";
        while (true) {
            getCurrentScene().update(line);
            getCurrentScene().render();
            Scanner scanner = new Scanner(System.in);
            line = scanner.next();
        }
    }
}
