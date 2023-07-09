package W02ExerciseEncapsulation.P05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {


    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }
    // setName(String) : void
    //getName(): String
    //addPlayer(Player) : void
    //removePlayer(String) : void
    //getRating() : double


    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player){
        players.add(player);

    }
    public void removePlayer(String playerName){
//        Друг начин за премахване на играча
//        boolean isRemoved = players.removeIf(p -> p.getName().equals(playerName));
//        if(!isRemoved){
//            String errorMessage = String.format("Player %s is not in %s team.", playerName, this.name);
//            throw new IllegalArgumentException(errorMessage);
//        }
        boolean isContain = false;
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                players.remove(player);
                isContain = true;
                break;
            }
        }
            if (!isContain){
                throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
            }

    }

    public double getRating(){
        return players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .average()
                .orElse(0);
    }
}