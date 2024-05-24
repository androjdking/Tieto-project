package org.game.scene_manager.scenes;
import org.game.actors.Player;
import org.game.actors.Projectile;
import org.game.actors.SpawnEnemy;
import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneEnum;
import org.game.scene_manager.SceneManager;
import java.util.ArrayList;

public class GameScreen implements IScene {
    SceneManager manager;

    //variables for enemies
    ArrayList<SpawnEnemy> enemies = new ArrayList<>();
    ArrayList<Projectile> projectiles = new ArrayList<>();
    int spawnRate = (int) (width * Math.random() ); //+ SettingScene.diff
    int pauseForSpawn =3;
    boolean first = true;
    int projectileCooldown = 3;
    int countDown = 0;

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        Player player = Player.instance;

        //Spawnrate based on difficulty
        if(first) {
            player.alive = true;
            if (SettingScene.diff == 1) spawnRate -= 1;
            if (SettingScene.diff == 3) spawnRate += 1;
            if (SettingScene.diff == 5) spawnRate += 2;
            projectileCooldown = SettingScene.cooldown;
            pauseForSpawn = SettingScene.enemyCooldown;
            first = false;
        }

        // spawn algorithm
        if (pauseForSpawn == 3) {
            pauseForSpawn = 0;
            for (int i = 0; i < spawnRate; i++) {
                SpawnEnemy enemy = new SpawnEnemy();
                if (!enemies.isEmpty()) {
                    for (SpawnEnemy checkEnemy : enemies) {
                        if (enemy.getXpos() == checkEnemy.getXpos() && enemy.getYpos() == checkEnemy.getYpos()) {
                            enemy = null;
                            break;
                        }
                    }
                }
                if (enemy != null) enemies.add(enemy);
            }
        }
        //removes projectiles if projectile reaches y position = 0
        //also moves projectiles forward
        if (!projectiles.isEmpty()) {
            for (int i = 0; i < projectiles.size(); i++) {
                if (projectiles.get(i).getYpos() == 0) {
                    projectiles.remove(i);
                    i--;
                    continue;
                }
                projectiles.get(i).setYpos(projectiles.get(i).getYpos() - 1);
            }
        }
        //changing position of player;
        switch (line) {
            case "a":
                if (!(player.getXpos() - 1 < 0) && player.alive) {
                    player.setXpos(player.getXpos() - 1);
                }
                break;
            case "d":
                if (!(player.getXpos() + 1 > width - 1) && player.alive) {
                    player.setXpos(player.getXpos() + 1);
                }
                break;
            case "e": {
                enemies.clear();
                projectiles.clear();
                first = true;
                manager.setCurrentScene(SceneEnum.DEATH);
                break;
            }
            case "w":
                if(countDown == 0){
                    Projectile projectile = new Projectile(player.getXpos(), player.getYpos()-1);
                    projectiles.add(projectile);
                    countDown=projectileCooldown;
                }
                break;
        }
        // moves enemies forward
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).setYpos(enemies.get(i).getYpos() + 1);
            if (enemies.get(i).getYpos() == height) {
                enemies.remove(i);
                i--;
            }
        }

        //checks for collision between projectile and enemies and removes them
        boolean deleteProjectile = false;
        for (int i = 0; i < projectiles.size(); i++) {
            for (int j = 0; j < enemies.size(); j++) {
                if (projectiles.get(i).getXpos() == enemies.get(j).getXpos() && (projectiles.get(i).getYpos() == enemies.get(j).getYpos() || projectiles.get(i).getYpos()+1 == enemies.get(j).getYpos())) {
                    player.addScore(enemies.get(j).getScore());
                    enemies.remove(j);
                    j++;
                    deleteProjectile=true;
                }
            }
            if(deleteProjectile){
                projectiles.remove(i);
                i--;
                deleteProjectile=false;
            }
        }

        //checks for collision with player and kills them
        for (SpawnEnemy enemy : enemies) {
            if (enemy.getXpos() == player.getXpos() && enemy.getYpos() == player.getYpos()) {
                player.death();
                enemies.clear();
                projectiles.clear();
                player.setXpos(width / 2);
                player.setYpos(height - 1);
                first = true;
                manager.setCurrentScene(SceneEnum.DEATH);
                break;
            }
        }
        //adds one point after every turn
        pauseForSpawn++;
        if(countDown>0) countDown--;
        player.addScore(1);
    }

    @Override
    public void render() {
        Player player = Player.instance;
        for (int i=0;i<10;i++){
            System.out.println();
        }
        // display graphics
        for (int rows = 0; rows < height; rows++) {
            StringBuilder row = new StringBuilder("|");
            row.append(" ".repeat(width));
            if(player.getYpos()== rows){
                row.setCharAt(player.getXpos()+1, player.getIcon());
            }
            for (SpawnEnemy enemy :enemies){
                if(enemy.getYpos()==rows){
                    row.setCharAt(enemy.getXpos()+1,enemy.getIcon());
                }
            }
            for(Projectile projectile :projectiles){
                if(projectile.getYpos()==rows){
                    row.setCharAt(projectile.getXpos()+1, projectile.getIcon());
                }
            }
            row.append("|");
            System.out.println(row);
        }
        //System.out.println("Current score: "+org.game.actors.score.Score.getScore());
        if(countDown==0) {
            System.out.println("Laser: READY");
        }else{
        System.out.println("Laser: on cooldown "+countDown);
        }
    }
}