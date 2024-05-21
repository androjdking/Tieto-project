package org.game;

import org.game.scenes.SceneManager;

public class Main {
    public static void main(String[] args) {
        SceneManager sm = new SceneManager();
        sm.loop();
    }
}
