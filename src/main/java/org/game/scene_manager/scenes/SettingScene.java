package org.game.scene_manager.scenes;
import java.util.Scanner;

import org.game.actors.Player;
import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneEnum;
import org.game.scene_manager.SceneManager;

public class SettingScene implements IScene {
    public static int diff=3;
    public static int cooldown=3;
    public static int enemyCooldown = 3;
    SceneManager manager;
    Scanner scan = new Scanner(System.in);
    String ship;
    @Override
    public void init(SceneManager manager) {
        this.manager = manager;

    }
    @Override
    public void update(String line) {
        switch (line) {
            case "1":
                System.out.println();
                while(true) {
                    try {
                        System.out.println("["+ diff +"] Choose difficulty (1-3-5)");
                        diff = Integer.parseInt(scan.nextLine());
                        if(diff<=5 && diff>=1) {
                            System.out.println("Difficulty set to " + diff);
                            break;
                        } else System.out.println("[" + diff + "] Invalid difficulty");
                    } catch (Exception e) {
                        System.out.println("[" + diff + "] Invalid difficulty");
                    }
                }
                break;
            case "2":
                System.out.println();
                System.out.println("["+Player.instance.getIcon()+"] Type character to be set as your space-ship: ");
                ship = scan.nextLine();
                Player.instance.setIcon(ship.charAt(0));
                //System.out.println(Player.instance.getIcon()); scanner test
                break;
            case "3":
                System.out.println();
                manager.setCurrentScene(SceneEnum.SETTINGS);
                while(true) {
                    try {
                        System.out.println("Choose your ship's projectile cooldown (in rounds)");
                        cooldown = Integer.parseInt(scan.nextLine());
                        System.out.println("Cooldown set to: " + cooldown);
                        break;
                    } catch (Exception e) {
                        System.out.println("Cooldown must be number!");
                    }
                }
                break;
            case "4":
                System.out.println();
                manager.setCurrentScene(SceneEnum.MENU);
                while(true){
                    try{
                        System.out.println("Choose enemy spawn cooldown (0-10)");
                        enemyCooldown = Integer.parseInt(scan.nextLine());
                        System.out.println("Enemy cooldown set to: " + enemyCooldown);
                        break;
                    }
                    catch (Exception e){
                        System.out.println("Cooldown must be number!");
                    }
                }
                break;
            case "5":{
                manager.setCurrentScene(SceneEnum.MENU);
                break;
            }
        }
    }

    @Override
    public void render() {
        System.out.println();
        System.out.println("Settings");
        System.out.println("[1] Difficulty");
        System.out.println("[2] Chose your ship");
        System.out.println("[3] Choose projectile cooldown");
        System.out.println("[4] Choose enemy spawn cooldown");
        System.out.println("[5] Return");


    }
}
