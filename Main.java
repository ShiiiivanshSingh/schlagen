// Player.java
class Player {
    String name;
    int kills;
    int deaths;

    Player(String name) {
        this.name = name;
        this.kills = 0;
        this.deaths = 0;
    }

    void addKill() {
        this.kills++;
    }

    void addDeath() {
        this.deaths++;
    }

    void displayStats() {
        System.out.println(name + " - Kills: " + kills + ", Deaths: " + deaths);
    }
}

// Team.java
class Team {
    String name;
    Player[] players;

    Team(String name, Player[] players) {
        this.name = name;
        this.players = players;
    }

    void displayTeamStats() {
        System.out.println("Team: " + name);
        for (Player player : players) {
            player.displayStats();
        }
    }
}

// Match.java
class Match {
    Team team1;
    Team team2;

    Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    void simulateMatch() {
        System.out.println("Match between " + team1.name + " and " + team2.name);
        // Simulate kills and deaths for simplicity
        team1.players[0].addKill();
        team2.players[1].addDeath();

        team1.players[1].addKill();
        team2.players[0].addDeath();
        
        System.out.println("Match Result:");
        team1.displayTeamStats();
        team2.displayTeamStats();
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Player[] team1Players = {
            new Player("Player1_Team1"),
            new Player("Player2_Team1")
        };
        Player[] team2Players = {
            new Player("Player1_Team2"),
            new Player("Player2_Team2")
        };

        Team team1 = new Team("Team1", team1Players);
        Team team2 = new Team("Team2", team2Players);

        Match match = new Match(team1, team2);
        match.simulateMatch();
    }
}
