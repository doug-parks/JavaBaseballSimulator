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

    int batterIndex = 0;

    public Player getPlayer(int position) {
        return players.get(position);
    }

    //creates an ArrayList for storing players
    ArrayList<Player> players = new ArrayList<Player>();

    public Player getNextBatter() {
        if (this.batterIndex >= this.players.size()) {
            this.batterIndex = 0;
        }
        Player newBatter = this.players.get(this.batterIndex);
        this.batterIndex++;
        return newBatter;
    }


}
