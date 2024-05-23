package org.game.actors.score;

public class Score implements Comparable<Score>{
    private int score;
    private String name;

    public Score(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Score score) {
        int comparescore = ((Score)score).getScore();
        return comparescore - this.score;
    }
}
