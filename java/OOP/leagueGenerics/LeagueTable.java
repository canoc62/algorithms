import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by canoc on 6/17/17.
 */
public class LeagueTable<T extends Team> {
    private ArrayList<T> teams = new ArrayList<>();
    private String name;

    public LeagueTable(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTeam(T team) {
        this.teams.add(team);
    }

    public void printTeams() {
        Collections.sort(this.teams);

        for(T team: this.teams) {
            System.out.println("Team: " + team.getName() + "\n" +
                    "Wins: " + team.getWins() + "\n" +
                    "Losses: " + team.getLosses() + "\n" +
                    "Draws: " + team.getWins() + "\n");
        }
    }
 }
