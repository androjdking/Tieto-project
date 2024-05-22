package org.game.scene_manager.scenes;

import org.game.actors.Player;
import org.game.actors.SpawnEnemy;
import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneEnum;
import org.game.scene_manager.SceneManager;

import java.util.ArrayList;

public class GameScreen implements IScene {
    SceneManager manager;

    //create player object
    Player player = new Player(width / 2, height - 1);

    //variables for enemies
    ArrayList<SpawnEnemy> enemies = new ArrayList<>();
    int spawnRate = (int) (width * Math.random());
    int pauseForSpawn = 3;

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        player.alive = true;
        // spawn algorithm
        if (pauseForSpawn == 3) {
            pauseForSpawn = 0;
            for (int i = 0; i < spawnRate; i++) {
                SpawnEnemy enemy = new SpawnEnemy();
                if(!enemies.isEmpty()){
                    for(SpawnEnemy checkEnemy : enemies){
                        if(enemy.xpos == checkEnemy.xpos && enemy.ypos == checkEnemy.ypos){
                            enemy = null;
                            break;
                        }
                    }
                }
                if(enemy!=null){
                    enemies.add(enemy);
                }
                if (enemies.get(i).ypos == height) enemies.remove(i);
            }
        }
        // moves enemies forward
        for(SpawnEnemy enemy : enemies){
            enemy.ypos++;
        }
        pauseForSpawn++;
        //changing position of player
        switch (line) {
            case "a":
                if (!(player.getPos()[0] - 1 < 0) && player.alive) {
                    player.setPos(player.getPos()[0] - 1, player.getPos()[1]);
                }
                break;
            case "d":
                if (!(player.getPos()[0] + 1 > width - 1) && player.alive) {
                    player.setPos(player.getPos()[0] + 1, player.getPos()[1]);
                }
                break;
            case "e":
                player.Death();
                manager.setCurrentScene(SceneEnum.DEATH);
                break;
        }
        for (SpawnEnemy enemy : enemies) {
            if (enemy.xpos == player.getPos()[0] && enemy.ypos == player.getPos()[1]) {
                player.Death();
                enemies.clear();
                manager.setCurrentScene(SceneEnum.DEATH);
                break;
            }
        }
        player.AddScore();
    }

    @Override
    public void render() {
        boolean enemiesPresent = false;
        //console "clear"
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        // display graphics
        for (int rows = 0; rows < height; rows++) {
            System.out.print("|");
            for (int columns = 0; columns < width; columns++) {
                //check if current position matches player's position
                if (columns == player.getPos()[0] && rows == player.getPos()[1]) {
                    System.out.print("A");
                    continue;
                }

                for (SpawnEnemy enemy : enemies) {
                    if (enemy.xpos == columns && enemy.ypos == rows) {
                        System.out.print(enemy.icon);
                        enemiesPresent=true;
                    }
                }

                if(!enemiesPresent){
                    System.out.print(' ');
                }
                enemiesPresent=false;
            }
            System.out.println("|");
        }
    }
}