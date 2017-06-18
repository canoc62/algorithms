public class Main {

    public static void main(String[] args) {
	// write your code here

        Team<FootballPlayer> Seahawks = new Team<>("Seahawks");
        Team<FootballPlayer> Rams = new Team<>("Rams");
        Team<FootballPlayer> FortyNiners = new Team<>("FortyNiners");
        Team<FootballPlayer> Cardinals = new Team<>("Cardinals");
        Team<BasketballPlayer> Lakers = new Team<>("Lakers");
        Team<BasketballPlayer> Clippers = new Team<>("Clippers");
        Team<BasketballPlayer> Warriors = new Team<>("Warriors");
        Team<BasketballPlayer> Kings = new Team<>("Kings");

        Seahawks.setWins(14);
        Seahawks.setLosses(1);
        Seahawks.setDraws(1);

        Rams.setWins(2);
        Rams.setLosses(14);
        Rams.setDraws(0);

        FortyNiners.setWins(8);
        FortyNiners.setLosses(7);
        FortyNiners.setDraws(1);

        Cardinals.setWins(13);
        Cardinals.setLosses(2);
        Cardinals.setDraws(1);

        Clippers.setWins(14);
        Clippers.setLosses(1);
        Clippers.setDraws(1);

        Kings.setWins(2);
        Kings.setLosses(14);
        Kings.setDraws(0);

        Lakers.setWins(8);
        Lakers.setLosses(7);
        Lakers.setDraws(1);

        Warriors.setWins(13);
        Warriors.setLosses(2);
        Warriors.setDraws(1);

        LeagueTable<Team<FootballPlayer>> Football = new LeagueTable<>("NFL");
        LeagueTable<Team<BasketballPlayer>> Basketball = new LeagueTable<>("NBA");

        Football.addTeam(Rams);
        Football.addTeam(Seahawks);
        Football.addTeam(FortyNiners);
        Football.addTeam(Cardinals);

        Basketball.addTeam(Lakers);
        Basketball.addTeam(Clippers);
        Basketball.addTeam(Warriors);
        Basketball.addTeam(Kings);

        Football.printTeams();
        Basketball.printTeams();
    }
}
