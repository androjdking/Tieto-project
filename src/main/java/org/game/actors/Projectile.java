package org.game.actors;

public class Projectile {
    private int xpos;
    private int ypos;
    private char icon;

    public Projectile(int xpos, int ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.icon = '*';
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public char getIcon() {
        return icon;
    }
}
