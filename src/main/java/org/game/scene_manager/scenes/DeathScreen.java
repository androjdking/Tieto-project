package org.game.scene_manager.scenes;

import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneEnum;
import org.game.scene_manager.SceneManager;
import org.game.actors.Player;

public class DeathScreen implements IScene {
    SceneManager manager;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

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
                break;
        }
    }


    @Override
    public void render() {
        //console "clear"
        for(int i =0; i < 20; i++){
            System.out.println();
        }

        //make message in center
        System.out.println(ANSI_RED+"\n" +
                "\n" +
                "  ▄████  ▄▄▄       ███▄ ▄███▓▓█████     ▒█████   ██▒   █▓▓█████  ██▀███  \n" +
                " ██▒ ▀█▒▒████▄    ▓██▒▀█▀ ██▒▓█   ▀    ▒██▒  ██▒▓██░   █▒▓█   ▀ ▓██ ▒ ██▒\n" +
                "▒██░▄▄▄░▒██  ▀█▄  ▓██    ▓██░▒███      ▒██░  ██▒ ▓██  █▒░▒███   ▓██ ░▄█ ▒\n" +
                "░▓█  ██▓░██▄▄▄▄██ ▒██    ▒██ ▒▓█  ▄    ▒██   ██░  ▒██ █░░▒▓█  ▄ ▒██▀▀█▄  \n" +
                "░▒▓███▀▒ ▓█   ▓██▒▒██▒   ░██▒░▒████▒   ░ ████▓▒░   ▒▀█░  ░▒████▒░██▓ ▒██▒\n" +
                " ░▒   ▒  ▒▒   ▓▒█░░ ▒░   ░  ░░░ ▒░ ░   ░ ▒░▒░▒░    ░ ▐░  ░░ ▒░ ░░ ▒▓ ░▒▓░\n" +
                "  ░   ░   ▒   ▒▒ ░░  ░      ░ ░ ░  ░     ░ ▒ ▒░    ░ ░░   ░ ░  ░  ░▒ ░ ▒░\n" +
                "░ ░   ░   ░   ▒   ░      ░      ░      ░ ░ ░ ▒       ░░     ░     ░░   ░ \n" +
                "      ░       ░  ░       ░      ░  ░       ░ ░        ░     ░  ░   ░     \n" +
                "                                                     ░                   \n" +
                "\n"+ANSI_RESET);
        System.out.println(space+"You are dead!");
        System.out.println(space+"Your score: " + Player.instance.getScore());
        for(int i=0;i<(2)-1;i++){
            System.out.println();
        }
        System.out.println(space+"[1] Retry");
        System.out.println(space+"[2] Show highscore");
        System.out.println(space+"[3] Return to menu");
    }
}
