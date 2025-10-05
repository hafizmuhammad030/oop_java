import java.util.ArrayList;

class Player {
    private String playerID;
    private String name;
    private String position;


    public Player(String tlayerID, String name, String position)
    {
        this.playerID = tlayerID;
        this.name = name;
        this.position = position;
    }
    public String getPlayerID() {
        return playerID;
    }


    @Override
    public String toString() {
        return "Player [ID" + playerID + ", Name" + name + ", Position=" + position + "]";
    }
}


class Team {
    private String teamID;
    private String name;
    private ArrayList<Player> players;


    public Team(String teamID, String name) {
        this.teamID = teamID;
        this.name = name;
        this.players = new ArrayList<>();
    }




    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerID) {
        Player playerToRemove = null;
        for (Player player : players) {
            if (playerID.equals(player.getPlayerID())) {
                playerToRemove = player;
                break;
            }
        }
        if (playerToRemove != null) {
            players.remove(playerToRemove);
        } else {
            System.out.println("Player with ID " + playerID + " not found.");
        }
    }



    public void displayPlayers() {
        System.out.println("Team: " + name + " Players:");
        for (Player player : players) {
            System.out.println(player);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        // Create a team
        Team team = new Team("T001", "Dream Team");


        Player player1 = new Player("P001", "C. Ronaldo", "Forward");
        Player player2 = new Player("P002", "Tony Kroos", "Midfielder");

        team.addPlayer(player1);
        team.addPlayer(player2);


        team.displayPlayers();
    }
}
