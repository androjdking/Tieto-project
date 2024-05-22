package org.game.actors;

import org.game.scene_manager.IScene;

public class SpawnEnemy {
    public int xpos;
    public int ypos;
    public char icon;

    public SpawnEnemy(){
        xpos = (int) (Math.random()* IScene.width);
        ypos = 0;
        setIcon();
    }

    public void setIcon() {
        char[] icons = {'V','G','H','T','Y','Q'};
        icon = icons[(int) (Math.random()* icons.length)];
    }
}
