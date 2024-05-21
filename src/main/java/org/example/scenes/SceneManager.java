package org.example.scenes;


import java.util.ArrayList;
import java.util.Scanner;

public class SceneManager {
    public ArrayList<IScene> sceneArray;
    private int index;

    public IScene getCurrentScene() {
        return sceneArray.get(index);
    }

    public void setCurrentScene(int newIndex) {
        if (newIndex >= sceneArray.size())
            return;

        index = newIndex;
    }

    public SceneManager() {
        sceneArray = new ArrayList<>();
        index = 0;


        // Adding scenes to array
        sceneArray.add(new MenuScene());
        sceneArray.add(new GameScreen());

        // Initializing all scenes
        for (IScene scene : sceneArray) {
            scene.init(this);
        }
    }

    public void loop() {
        String line = "";
        while (true) {
            getCurrentScene().update(line);
            getCurrentScene().render();
            Scanner scanner = new Scanner(System.in);
            line = scanner.next();
        }
    }
}