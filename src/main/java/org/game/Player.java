package org.game;

public class Player {
    // player coordinations
    private int xpos;
    private int ypos;

    // player can be played
    public boolean alive;


    public Player(int startXPos, int startYPos) {
        xpos=startXPos;
        ypos=startYPos;
        alive = true;
    }
    public int[] getPos() {
        return new int[]{xpos, ypos};
    }
    public void setPos(int XPos, int YPos) {
        xpos=XPos;
        ypos=YPos;
    }
}
