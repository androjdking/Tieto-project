package org.game.scene_manager.scenes;
import java.util.Scanner;

import org.game.actors.Player;
import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneEnum;
import org.game.scene_manager.SceneManager;

public class SettingScene implements IScene {
    public static int diff=1;
    public static int cooldown=3;
    public static int enemyCooldown = 3;
    SceneManager manager;

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

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
                        System.out.println(space+"["+ diff +"] Choose difficulty (1-5)");
                        diff = Integer.parseInt(scan.nextLine());
                        if(diff<=5 && diff>=1) {
                            System.out.println(space+"Difficulty set to " + diff);
                            break;
                        } else System.out.println(space+"[" + diff + "] Invalid difficulty");
                    } catch (Exception e) {
                        System.out.println(space+"[" + diff + "] Invalid difficulty");
                    }
                }
                break;
            case "2":
                System.out.println();
                System.out.println(space+"["+Player.instance.getIcon()+"] Type character to be set as your space-ship: ");
                ship = scan.nextLine();
                Player.instance.setIcon(ship.charAt(0));
                //System.out.println(Player.instance.getIcon()); scanner test
                break;
            case "3":
                System.out.println();
                manager.setCurrentScene(SceneEnum.SETTINGS);
                while(true) {
                    try {
                        System.out.println(space+"Choose your ship's projectile cooldown (in rounds)");
                        cooldown = Integer.parseInt(scan.nextLine());
                        System.out.println(space+"Cooldown set to: " + cooldown);
                        break;
                    } catch (Exception e) {
                        System.out.println(space+"Cooldown must be number!");
                    }
                }
                break;
            case "4":
                System.out.println();
                manager.setCurrentScene(SceneEnum.SETTINGS);
                while(true){
                    try{
                        System.out.println(space+"Choose enemy spawn cooldown (0-10)");
                        enemyCooldown = Integer.parseInt(scan.nextLine());
                        System.out.println(space+"Enemy cooldown set to: " + enemyCooldown);
                        break;
                    }
                    catch (Exception e){
                        System.out.println(space+"Cooldown must be number!");
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
        System.out.println(ANSI_YELLOW+" ░▒▓███████▓▒░▒▓████████▓▒░▒▓████████▓▒░▒▓████████▓▒░▒▓█▓▒░▒▓███████▓▒░ ░▒▓██████▓▒░ ░▒▓███████▓▒░ \n" +
                "░▒▓█▓▒░      ░▒▓█▓▒░         ░▒▓█▓▒░      ░▒▓█▓▒░   ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░        \n" +
                "░▒▓█▓▒░      ░▒▓█▓▒░         ░▒▓█▓▒░      ░▒▓█▓▒░   ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░        \n" +
                " ░▒▓██████▓▒░░▒▓██████▓▒░    ░▒▓█▓▒░      ░▒▓█▓▒░   ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒▒▓███▓▒░░▒▓██████▓▒░  \n" +
                "       ░▒▓█▓▒░▒▓█▓▒░         ░▒▓█▓▒░      ░▒▓█▓▒░   ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░ \n" +
                "       ░▒▓█▓▒░▒▓█▓▒░         ░▒▓█▓▒░      ░▒▓█▓▒░   ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░ \n" +
                "░▒▓███████▓▒░░▒▓████████▓▒░  ░▒▓█▓▒░      ░▒▓█▓▒░   ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓███████▓▒░"+ANSI_RESET);
        System.out.println();
        System.out.println(space+"[1] Difficulty");
        System.out.println(space+"[2] Chose your ship");
        System.out.println(space+"[3] Choose projectile cooldown");
        System.out.println(space+"[4] Choose enemy spawn cooldown");
        System.out.println(space+"[5] Return");
    }
}
