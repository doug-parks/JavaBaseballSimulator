import java.util.ArrayList;

/**
 * Created by djp4830 on 4/22/17.
 */
public class Team {

    public Team(String teamName, Boolean home, int score) {
        this.teamName = teamName;
        this.home = home;
        this.score = score;
    }

    String teamName;
    Boolean home;
    int score;

    public void setBatterIndex(int batterIndex) {
        this.batterIndex = batterIndex;
    }

    int batterIndex = 0; //used to pull a batter from the next spot in the array

    ArrayList<Player> players = new ArrayList<Player>();  //creates an ArrayList for storing players

    public Player getNextBatter() { //this method is used to pull a batter from the roster.
        if (this.batterIndex >= this.players.size()) {
            this.batterIndex = 0; //goes back to the front of the line when it reaches the end
        }
        Player newBatter = this.players.get(this.batterIndex);
        this.batterIndex++;
        return newBatter;
    }
}
