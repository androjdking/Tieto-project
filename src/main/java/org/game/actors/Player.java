package org.game.actors;

import static org.game.scene_manager.IScene.height;
import static org.game.scene_manager.IScene.width;

public class Player {

    // player coordinations
    public static Player instance = new Player(width/2,height-1);

    private int xpos;
    private int ypos;
    private int score;
    private char icon;


    public Player(int startXPos, int startYPos) {
        this.xpos = startXPos;
        this.ypos = startYPos;
        this.score = 0;
        this.icon = 'A';
    }
    public int getScore(){
        return this.score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getXpos() {
        return this.xpos;
    }

    public void setXpos(int XPos) {
        this.xpos = XPos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public int getYpos() {
        return this.ypos;
    }

    public char getIcon() {
        return this.icon;
    }

    public void setIcon(char icon) {
        this.icon = icon;
    }

}