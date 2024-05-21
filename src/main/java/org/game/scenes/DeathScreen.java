package org.game.scenes;

public class DeathScreen implements IScene{
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
        //console "clear"
        for(int i =0; i < 20; i++){
            System.out.println();
        }

        //make message in center
        System.out.println("You are dead!");
        for(int i=0;i<(2)-1;i++){
            System.out.println();
        }
        System.out.println("[1] Retry");
        System.out.println("[2] Show highscore");
        System.out.println("[3] Exit");
    }
}
