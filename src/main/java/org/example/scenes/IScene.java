package org.example.scenes;

public interface IScene {
    int width = 12;
    int height = 12;
    void init(SceneManager manager);
    void update(String line);
    void render();

}