package org.game.scene_manager.scenes;

import org.game.actors.Player;
import org.game.actors.score.FileScore;
import org.game.actors.score.Score;
import org.game.scene_manager.IScene;
import org.game.scene_manager.SceneManager;

import java.util.ArrayList;

public class HighscoreScreen implements IScene {
    SceneManager manager;
    Score score = new Score(Player.instance.getScore());
    FileScore fileScore = new FileScore();
    ArrayList<Score> playerScore = new ArrayList<>();

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        score.setScore(Player.instance.getScore());
        if (fileScore.text.isEmpty()) {
            fileScore.createFile();
        }
        for (int i = 0; i < fileScore.text.length(); i++) {
            if (fileScore.text.charAt(i) == '\n') {
                continue;
            }
            System.out.print(playerScore.get(i) + "\n");
        }

    }

    @Override
    public void render() {
        //console "clear"
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
}
