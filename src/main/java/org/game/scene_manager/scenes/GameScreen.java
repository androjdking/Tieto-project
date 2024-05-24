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
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

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
        if(spawnRate==0)spawnRate=1;

        //Spawnrate based on difficulty
        if (first) {
            spawnRate = (int) (width * Math.random() * SettingScene.diff);
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
                        if(enemy.getYpos()==checkEnemy.getYpos()){
                            if (enemy.getXpos() == checkEnemy.getXpos()) {
                                enemy = null;
                                break;
                            }
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
                if (!(player.getXpos() - 1 < 0)) {
                    player.setXpos(player.getXpos() - 1);
                }
                break;
            case "d":
                if (!(player.getXpos() + 1 > width - 1)) {
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
                if (countDown == 0) {
                    Projectile projectile = new Projectile(player.getXpos(), player.getYpos() - 1);
                    projectiles.add(projectile);
                    countDown = projectileCooldown;
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
                if (projectiles.get(i).getYpos() == enemies.get(j).getYpos() || projectiles.get(i).getYpos() + 1 == enemies.get(j).getYpos()) {
                    if (projectiles.get(i).getXpos() == enemies.get(j).getXpos()) {
                        player.addScore(enemies.get(j).getScore());
                        enemies.remove(j);
                        j--;
                        deleteProjectile = true;
                    }
                }
            }
            if (deleteProjectile) {
                projectiles.remove(i);
                i--;
                deleteProjectile = false;
            }
        }

        //checks for collision with player and kills them
        for (SpawnEnemy enemy : enemies) {
            if (enemy.getXpos() == player.getXpos() && enemy.getYpos() == player.getYpos()) {
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
        System.out.println("\n\n\n\n\n\n\n\n\n");
        // display graphics
        String[] screenBuild = {"|" + " ".repeat(width) + "|", "|" + " ".repeat(width) + "|", "|" + " ".repeat(width) + "|", "|" + " ".repeat(width) + "|", "|" + " ".repeat(width) + "|", "|" + " ".repeat(width) + "|", "|" + " ".repeat(width) + "|", "|" + " ".repeat(width) + "|", "|" + " ".repeat(width) + "|", "|" + " ".repeat(width) + "|"};
        screenBuild[player.getYpos()] = screenBuild[player.getYpos()].substring(0, player.getXpos() + 1) + player.getIcon() + screenBuild[player.getYpos()].substring(player.getXpos() + 2);
        for (SpawnEnemy enemy : enemies) {
            screenBuild[enemy.getYpos()] = screenBuild[enemy.getYpos()].substring(0, enemy.getXpos() + 1) + enemy.getIcon() + screenBuild[enemy.getYpos()].substring(enemy.getXpos() + 2);
        }
        for (Projectile projectile : projectiles) {
            screenBuild[projectile.getYpos()] = screenBuild[projectile.getYpos()].substring(0, projectile.getXpos() + 1) + projectile.getIcon() + screenBuild[projectile.getYpos()].substring(projectile.getXpos() + 2);
        }
        for (String screen : screenBuild) {
            System.out.println(space+screen);
        }

        if (countDown == 0) {
            System.out.println(space+ANSI_GREEN+"Laser: READY"+ANSI_RESET);
        } else {
            System.out.println(space+ANSI_RED+"Laser: on cooldown " + countDown + ANSI_RESET);
        }
        System.out.println("\n[w] Shoot laser\n[a] Move left\n[d] Move right\n[s] Stay still");
    }
}