package org.game.actors;

public class Player {

    // player coordinations
    private int xpos;
    private int ypos;
    public int score;
    private char icon;

    // player can be played
    public boolean alive;


    public Player(int startXPos, int startYPos) {
        this.xpos = startXPos;
        this.ypos = startYPos;
        this.alive = true;
        this.score = 0;
        this.icon = 'A';
    }

    public void AddScore(int score) {
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

    public void Death() {
        this.alive = false;
    }

    public char getIcon() {
        return this.icon;
    }
}
