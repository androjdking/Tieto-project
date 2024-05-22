package org.game.actors;

import org.game.scene_manager.IScene;

public class SpawnEnemy {
    private int xpos;
    private int ypos;
    private char icon;
    private int score;

    public SpawnEnemy() {
        xpos = (int) (Math.random() * IScene.width);
        ypos = 0;
        setIcon();
    }

    public void setIcon() {
        char[] icons = {'V', 'G', 'H', 'T', 'Y', 'Q'};
        int index = (int) (Math.random() * icons.length);
        icon = icons[index];
        score = index * 10;
    }

    public int getScore() {
        return score;
    }

    public int getXpos() {
        return this.xpos;
    }

    public int getYpos() {
        return this.ypos;
    }

    public char getIcon() {
        return this.icon;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }
}
