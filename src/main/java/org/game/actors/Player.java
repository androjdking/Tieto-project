package org.game.actors;

public class Player {

    // player coordinations
    private int xpos;
    private int ypos;
    public int score;

    // player can be played
    public boolean alive;


    public Player(int startXPos, int startYPos) {
        this.xpos=startXPos;
        this.ypos=startYPos;
        this.alive = true;
        this.score = 0;
    }
    public int[] getPos() {
        return new int[]{xpos, ypos};
    }

    public void AddScore(){
        this.score++;
    }

    public void setPos(int XPos, int YPos) {
        this.xpos=XPos;
        this.ypos=YPos;
    }

    public void Death(){
        this.alive=false;
        this.score = 0;
    }
}
