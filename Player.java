public class Player {
    Player player1;
    Player player2;
    Player player3;
    int chips;
    int score;
    public Player(){
        Player player1 = null;
        Player player2 = null;
        Player player3 = null;
        chips = 100;
        score = 0;
    }


    public int getChips() {
        return chips;
    }

    public int getScore(){
        return score;
    }
    public void setScore(int points){
        score = points;
    }


    public void addChips(int added){
        chips += added;
    }


    public void loseChips(int loss){
        chips -= loss;
    }
}
