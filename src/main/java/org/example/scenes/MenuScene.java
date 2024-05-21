package org.example.scenes;

public class MenuScene implements IScene {
    SceneManager manager;
    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
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
                System.exit(0);
        }
    }

    @Override
    public void render() {
        System.out.println("Main Menu");
        System.out.println("[1] Hrat");
        System.out.println("[2] nastaveni");
        System.out.println("[3] Credits");
        System.out.println("[4] Exit");

    }
}