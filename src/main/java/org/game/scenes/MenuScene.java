package org.game.scenes;

public class MenuScene implements IScene {
    SceneManager manager;
    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        //set scene based on user input
        switch(line){
            case "1":
                manager.setCurrentScene(1);
                break;
            case "2":
                manager.setCurrentScene(2);
                break;
            case "3":
                manager.setCurrentScene(3);
                break;
            case "4":
                manager.setCurrentScene(4);
                break;
            case "5":
                System.exit(0);
        }
    }

    @Override
    public void render() {
        // printing menu
        System.out.println("Main Menu");
        System.out.println("[1] Play");
        System.out.println("[2] View Highscore");
        System.out.println("[3] Settings");
        System.out.println("[4] Credits");
        System.out.println("[5] Exit");

    }
}