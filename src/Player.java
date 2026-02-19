public class Player {
    private int score;
    private String name;
    private Level level;

    public Player(int score, String name, Level level) {
        this.score = score;
        this.name = name;
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

