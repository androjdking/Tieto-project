package org.example;

public class Player {
    // player coordinations
    private int xpos;
    private int ypos;

    // jump mechanic
    public int maxJump;
    public boolean isJumping;

    public boolean alive;
    public Player(int startXPos, int startYPos) {
        xpos=startXPos;
        ypos=startYPos;
        alive = true;
        maxJump = 3;
        isJumping = false;
    }
    public int[] getPos() {
        return new int[]{xpos, ypos};
    }
    public void setPos(int XPos, int YPos) {
        xpos=XPos;
        ypos=YPos;
    }
    public int jumping(){
        isJumping=true;
        return maxJump;
    }
}
