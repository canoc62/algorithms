import java.util.ArrayList;

/**
 * Created by canoc on 6/17/17.
 */
public class Team<T extends Player> implements Comparable<Team<T>> {
    private ArrayList<T> players = new ArrayList<>();
    private String name;
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int ranking() {
        return ((this.wins * 2) - this.losses) + this.draws;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return 1;
        } else if (this.ranking() < team.ranking()) {
            return -1;
        } else {
            return 0;
        }
    }
}
