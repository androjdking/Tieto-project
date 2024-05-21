package org.example.scenes;

import org.example.Player;

public class GameScreen implements IScene {
    SceneManager manager;
    Player player =  new Player((int)width/2,height-1);
    int[] position= new int[2];
    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        switch (line) {
            case "a":
                if(!(player.getPos()[0]-1 < 0)) {
                    player.setPos(player.getPos()[0]-1, player.getPos()[1]);
                }
                break;
            case "d":
                if(!(player.getPos()[0]+1 > width-1)) {
                    player.setPos(player.getPos()[0]+1, player.getPos()[1]);
                }
                break;
        }
    }
    @Override
    public void render() {
        for(int i =0; i < 20; i++){
            System.out.println();
        }
        System.out.println("Pos x:" + player.getPos()[0] + " y:" + player.getPos()[1]);
        for (int rows = 0; rows < height; rows++) {
            for (int columns = 0; columns < width; columns++) {
                if (columns == player.getPos()[0] && rows == player.getPos()[1]) {
                    System.out.print("#");
                    continue;
                }
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}