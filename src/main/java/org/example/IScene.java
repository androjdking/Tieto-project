package org.example;

public interface IScene {
    public void init(SceneManager manager);
    public void update(String line);
    public void render();
}