public class Player {
    Player player1;
    Player player2;
    Player player3;

    String name;
    int chips;
    int score;

    public Player(String name){
        this.name = name;
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
