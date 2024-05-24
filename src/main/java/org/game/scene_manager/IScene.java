package org.game.scene_manager;

public interface IScene {
    int width = 12;
    int height = 10;
    String space = "                                ";

    void init(SceneManager manager);

    void update(String line);

    void render();
}