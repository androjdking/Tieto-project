package org.game;

public class Player {
    // player coordinations
    private int xpos;
    private int ypos;
    //players statistics
    public String Name;
    public int HP;
    public static int score;
    // player can be played
    public boolean alive;


    public Player(int startXPos, int startYPos) {
        xpos=startXPos;
        ypos=startYPos;
        Name="";
        HP=3;
        score=0;
        alive = true;
    }

    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public static int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public boolean getAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int[] getPos() {
        return new int[]{xpos, ypos};
    }

    public void setPos(int XPos, int YPos) {
        xpos=XPos;
        ypos=YPos;
    }

    public void Death(){
        alive=false;
    }
}
