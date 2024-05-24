package org.game.scene_manager.scenes;

import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneEnum;
import org.game.scene_manager.SceneManager;

public class CreditScene implements IScene {
    SceneManager manager;
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
        System.out.println(" ");
        System.out.println("Tomáš Reimer a Patrik Rychtařík");
        System.out.println();
        System.out.println("[1] Return");
    }

}
