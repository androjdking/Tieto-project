package org.game.scene_manager.scenes;
import java.util.Scanner;

import org.game.actors.Player;
import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneEnum;
import org.game.scene_manager.SceneManager;

public class SettingScene implements IScene {
    public static int diff=3;
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
                System.out.println("["+ diff +"] Choose difficulty (1-3-5)");
                diff = Integer.parseInt(scan.nextLine());
                System.out.println("Difficulty set to "+diff);
                break;
            case "2":
                System.out.println("["+Player.instance.getIcon()+"] Type character to be set as your space-ship: ");
                ship = scan.nextLine();
                Player.instance.setIcon(ship.charAt(0));
                //System.out.println(Player.instance.getIcon()); scanner test
                break;
            case "3":
                System.out.println("_");
                break;
            case "4":
                System.out.println("...");
                break;
            case "5":{
                manager.setCurrentScene(SceneEnum.MENU);
                break;
            }
        }
    }

    @Override
    public void render() {
        System.out.println("Settings");
        System.out.println("[1] Difficulty");
        System.out.println("[2] Chose your ship");
        System.out.println("[3] ");
        System.out.println("[4] ");
        System.out.println("[5] Return");


    }
}
