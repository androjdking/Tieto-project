package org.game.scene_manager.scenes;

import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneEnum;
import org.game.scene_manager.SceneManager;
import org.game.actors.Player;

public class DeathScreen implements IScene {
    SceneManager manager;
    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        switch(line){
            case "1":
                Player.instance.setScore(0);
                manager.setCurrentScene(SceneEnum.GAME);
                break;
            case "2":
                manager.setCurrentScene(SceneEnum.HIGHSCORE);
                break;
            case "3":
                manager.setCurrentScene(SceneEnum.MENU);

        }
    }


    @Override
    public void render() {
        //console "clear"
        for(int i =0; i < 20; i++){
            System.out.println();
        }

        //make message in center
        System.out.println("You are dead!");
        System.out.println("Game over");
        System.out.println("Your score: " + Player.instance.getScore());
        for(int i=0;i<(2)-1;i++){
            System.out.println();
        }
        System.out.println("[1] Retry");
        System.out.println("[2] Show highscore");
        System.out.println("[3] Exit");
    }
}
