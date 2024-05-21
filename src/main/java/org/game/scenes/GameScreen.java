package org.game.scenes;

import org.game.Player;

public class GameScreen implements IScene {
    SceneManager manager;
    Player player =  new Player(width/2,height-1);

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }
    @Override
    public void update(String line) {
        //changing position of player
        switch (line) {
            case "a":
                if(!(player.getPos()[0]-1 < 0) && player.alive){
                    player.setPos(player.getPos()[0]-1, player.getPos()[1]);
                }
                break;
            case "d":
                if(!(player.getPos()[0]+1 > width-1) && player.alive) {
                    player.setPos(player.getPos()[0]+1, player.getPos()[1]);
                }
                break;
            case "e":
                player.Death();
                manager.setCurrentScene(2);
                break;
        }
    }

    @Override
    public void render() {
        new Thread(() -> {
            //console "clear"
            for(int i =0; i < 20; i++){
                System.out.println();
            }
            // display graphics
            for (int rows = 0; rows < height; rows++) {
                for (int columns = 0; columns < width; columns++) {
                    //check if current position matches player's position
                    if (columns == player.getPos()[0] && rows == player.getPos()[1]) {
                        System.out.print("#");
                        continue;
                    }
                    System.out.print(' ');
                }
                System.out.println();
            }
        }).start();
    }
}