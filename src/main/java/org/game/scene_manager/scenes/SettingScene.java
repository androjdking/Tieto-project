package org.game.scene_manager.scenes;

import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneManager;

public class SettingScene implements IScene {
    SceneManager manager;
    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }
    @Override
    public void update(String line) {

    }
    @Override
    public void render() {

    }
}
